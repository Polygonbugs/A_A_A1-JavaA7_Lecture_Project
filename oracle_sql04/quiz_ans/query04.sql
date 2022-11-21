/*
 *  가장 많은 사원수를 가지는 부서 TOP3를 구하세요
 */

WITH EMP_COUNT
  AS (SELECT DEPARTMENT_ID
           , COUNT(*) AS 인원수
       FROM EMPLOYEES
      WHERE DEPARTMENT_ID IS NOT NULL
      GROUP BY DEPARTMENT_ID
      ORDER BY 인원수 DESC)
SELECT ROWNUM
     , DEPARTMENT_ID
     , 인원수
  FROM EMP_COUNT
 WHERE ROWNUM <= 3;

 /*
  * 평균 급여가 가장 높은 부서 TOP3를 구하세요. (부서 ID와 부서명이 같이 조회될 수 있게 하세요.)
  */

SELECT RNK
     , DEPTARTMENT_ID AS DEPT_ID
     , ROUND(평균급여, 2) AS 평균급여
  FROM(SELECT RANK() OVER(ORDER BY AVG(SALARY) DESC) AS RNK
             , DEPARTMENT_ID
             , AVG(SALARY) AS 평균급여
         FROM EMPLOYEES
        WHERE DEPARTMENT_ID IS NOT NULL
        GROUP BY DEPARTMENT_ID)
 WHERE RNK <= 3;

/*
 *  가장 최근에 입사한 사원 5명이 소속되어 있는 부서를 찾으세요.
 */
SELECT *
  FROM DEPARTMENTS
 WHERE DEPARTMENT_ID IN (SELECT DISTINCT DEPARTMENT_ID
                           FROM (SELECT *
                                   FROM EMPLOYEES
                                  ORDER BY HIRE_DATE DESC)
                            WHERE ROWNUM <= 5);

/*
 *  1990 ~ 1999년도에 입사한 사원들 중 가장 많은 급여를 받는 사원 5명을 찾으세요.
 */
SELECT *
FROM(SELECT EMPLOYEE_ID
          , FIRST_NAME
          , LAST_NAME
          , SALARY
          , HIRE_DATE
       FROM EMPLOYEES
      WHERE HIRE_DATE BETWEEN TO_DATE('19900101') AND TO_DATE('19991231')
      ORDER BY SALARY DESC)
 WHERE ROWNUM <= 5;

SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
