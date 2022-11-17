/*
 * 부서별 평균, 최대, 최소 급여를 집계한 DEPT_SALARY_STATIS 테이블을 만들어
 * 데이터를 추가하시오.
 */

CREATE TABLE DEPT_SALARY_STATIS(
    DEPT_ID NUMBER
   ,AVG_SALARY NUMBER DEFAULT(0)
   ,MAX_SALARY NUMBER DEFAULT(0)
   ,MIN_SALARY NUMBER DEFAULT(0)
);

INSERT INTO DEPT_SALARY_STATIS(SELECT DEPARTMENT_ID
                                    , ROUND(AVG(SALARY), 2) AS AVG_SALARY
                                    , MAX(SALARY)           AS MAX_SALARY
                                    , MIN(SALARY)           AS MIN_SALARY
                               FROM EMPLOYEES
                               WHERE DEPARTMENT_ID IS NOT NULL
                               GROUP BY DEPARTMENT_ID
);

SELECT * FROM DEPT_SALARY_STATIS;
/*
 * 직급별 평균, 최대, 최소 급여를 집계한 JOB_SALARY_STATIS 테이블을 만들어
 * 데이터를 추가하시오.
 */

 CREATE TABLE JOB_SALARY_STATIS(
             JOB_ID VARCHAR2(10)
           , AVG_SALARY NUMBER DEFAULT(0)
           , MAX_SALARY NUMBER DEFAULT(0)
           , MIN_SALARY NUMBER DEFAULT(0)
 );

INSERT INTO JOB_SALARY_STATIS(SELECT JOB_ID
                                   , ROUND(AVG(SALARY), 2) AS AVG_SALARY
                                   , MAX(SALARY)           AS MAX_SALARY
                                   , MIN(SALARY)           AS MIN_SALARY
                              FROM EMPLOYEES
                              WHERE DEPARTMENT_ID IS NOT NULL
                              GROUP BY JOB_ID
);

SELECT * FROM JOB_SALARY_STATIS;

/*
 * 직급 ID에 'MGR' 이 접두사로 붙은 JOB_SALARY_STATIS 에 평균, 최대, 최소 급여를 +500
 * 하세요.
 */

UPDATE JOB_SALARY_STATIS
   SET AVG_SALARY = AVG_SALARY + 500
     , MAX_SALARY = MAX_SALARY + 500
     , MIN_SALARY = MIN_SALARY + 500
WHERE JOB_ID LIKE '%MGR';

SELECT *
  FROM JOB_SALARY_STATIS
 WHERE JOB_ID LIKE '%MGR';

/*
 * 년도별 입사 인원을 파악하기 위한 HIRE_FOR_YEAR 테이블을 만들어 데이터를 추가
 * 하시오.(인원 파악이 주 목적이기 때문에 년도와 인원수만 저장할 수 있으면 됨)
 */

CREATE TABLE HIRE_FOR_YEAR(
         YEAR NUMBER(4)
       , CNT NUMBER
);

INSERT INTO HIRE_FOR_YEAR(SELECT EXTRACT(YEAR FROM HIRE_DATE)
                               , COUNT(*)
                          FROM EMPLOYEES
                          GROUP BY EXTRACT(YEAR FROM HIRE_DATE)
);

/*
 * 부서별 / 직급별 평균, 최대, 최소 급여를 저장한 테이블에 COMMISSION_PCT 까지 반영한
 * 데이터가 저장될 수 있도록 기존 정보를 수정하시오.
 */
UPDATE DEPT_SALARY_STATIS
   SET (AVG_SALARY, MAX_SALARY, MIN_SALARY)
             = (SELECT ROUND(AVG(SALARY * (1 + NVL(COMMISSION_PCT, 1))), 2) AS AVG_SALARY
                     , MAX(SALARY * (1 + NVL(COMMISSION_PCT, 1)))           AS MAX_SALARY
                     , MIN(SALARY * (1 + NVL(COMMISSION_PCT, 1)))        AS MIN_SALARY
                    FROM EMPLOYEES
                    WHERE DEPARTMENT_ID IS NOT NULL
                         AND DEPARTMENT_ID = DEPT_ID
                    GROUP BY DEPARTMENT_ID
);

UPDATE JOB_SALARY_STATIS
   SET (AVG_SALARY, MAX_SALARY, MIN_SALARY)
             = (SELECT ROUND(AVG(SALARY * (1 + NVL(COMMISSION_PCT, 1))), 2) AS AVG_SALARY
                     , MAX(SALARY * (1 + NVL(COMMISSION_PCT, 1)))           AS MAX_SALARY
                     , MIN(SALARY * (1 + NVL(COMMISSION_PCT, 1)))        AS MIN_SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID IS NOT NULL
                          AND JOB_ID = JOB_SALARY_STATIS.JOB_ID
                    GROUP BY JOB_ID
);


SELECT * FROM DEPT_SALARY_STATIS;
SELECT * FROM JOB_SALARY_STATIS;
