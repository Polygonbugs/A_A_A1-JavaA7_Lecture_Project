/*
 *  SELECT 구문에서 사용하는 절
 *  1. SELECT 절
 *  2. FROM 절
 *  3. WHERE 절
 *  4. GROUP BY 절
 *  5. HAVING 절
 *  6. ORDER BY 절
 */
-- 각 절이 사용되는 순서가 있음.(위에 명시한 순서)
-- SELECT, FROM을 제외한 모든 절은 생략할 수 있다.

-- 실행 순서는 다음과 같다.
-- FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY

/*
 *  GROUP BY 절
 *      - 그룹 함수를 사용하여 특정 그룹에 대한 집계를 나타낼 때 전체 그룹이 아닌
 *        특정 그룹에 대한 집계가 이루어 질 수 있도록 그룹을 묶어주는 역할 수행
 *      - 기준 컬럼이외는 써서는 안된다
 */

-- NUll 값은 빠진다고 한다.
SELECT COUNT(DEPARTMENT_ID)
    FROM EMPLOYEES;

SELECT DEPARTMENT_ID
     , COUNT(DEPARTMENT_ID) 부서별총원
     , MAX(SALARY)  부서별최고급여
     , MIN(SALARY)  부서별최저급여
     , ROUND(AVG(SALARY), 2)    부서별평균급여액
    FROM EMPLOYEES
    GROUP BY DEPARTMENT_ID;

SELECT SUBSTR(PHONE_NUMBER, 1, 3) AS 전화번호앞자리
     , COUNT(*)
    FROM EMPLOYEES
    GROUP BY SUBSTR(PHONE_NUMBER, 1, 3);

/*
 *  년도별 입사자 수를 구하시오
 */

SELECT EXTRACT(YEAR FROM HIRE_DATE) AS 년도
     , COUNT(*) AS 입사자수
  FROM EMPLOYEES
 GROUP BY EXTRACT(YEAR FROM HIRE_DATE);

/*
 *  JOB_ID 별 최고급여액, 최저급여액을 구하시오
 *  COMMISSION_PCT가 있는 경우 COMMISSION_PCT를 포함한 급여액으로 구하세요
 */

SELECT JOB_ID
     , MAX(SALARY * (1 + NVL(COMMISSION_PCT, 0))) 직무별최고급여액
     , MIN(SALARY * (1 + NVL(COMMISSION_PCT, 0))) 직무별최저급여액
  FROM EMPLOYEES
 GROUP BY JOB_ID;

/*
 *  HAVING 절
 *      - 그룹에 대한 조건절로 사용
 *      - WHERE 절에서 사용하는 조건은 GROUP으로 묶이기 전의 조건으로 사용됨.
 */

SELECT DEPARTMENT_ID
     , COUNT(DEPARTMENT_ID) 부서별총원
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
HAVING COUNT(DEPARTMENT_ID) < 5;


SELECT SUBSTR(PHONE_NUMBER, 1, 3) AS 전화번호앞자리
     , COUNT(*) AS 수량
  FROM EMPLOYEES
 GROUP BY SUBSTR(PHONE_NUMBER, 1, 3)
HAVING COUNT(*) >= 20;

/*
 *  30명 이상이 근무하는 부서의 전화번호 앞자리 사용 회선수 집계
 */

SELECT DEPARTMENT_ID
, SUBSTR(PHONE_NUMBER, 1, 3) AS 전화번호앞자리
, COUNT(PHONE_NUMBER) AS 회선수
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID, SUBSTR(PHONE_NUMBER, 1, 3)
 HAVING COUNT(DEPARTMENT_ID) >= 30;

/*
 *  커미션을 지급 받는 사원의 직무 분포 현황
 */
SELECT JOB_ID
     , COMMISSION_PCT AS "수수료 퍼센트"
     , COUNT(JOB_ID) AS 수
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
 GROUP BY JOB_ID, COMMISSION_PCT;

/*
 *   ROLLUP : 그룹별 집계를 위한 함수
 *            그룹으로 묶기 위한 조건이 1개 이상인 경우에 사용하여
 *            ROLLUP에 작성된 컬럼 순서대로 그룹을 1개씩 추가하여 묶어가며 집계에 사용한다.
 *
 *            예시)
 *            단일 그룹별(JOB_ID) 집계 / 복수개의 그룹별 집계 (JOB_ID, COMMISSION_PCT)/ 총 집계 (전체 / NULL로 되어 있음)
 *            까지 나타낸다.
 */

 SELECT JOB_ID
     , COMMISSION_PCT AS "수수료 퍼센트"
     , COUNT(JOB_ID) AS 수
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
 GROUP BY ROLLUP(JOB_ID, COMMISSION_PCT);


/*
 *   CUBE : 그룹별 집계를 위한 함수
 *          그룹으로 묶기 위한 조건이 1개 이상인 경우에 사용하여
 *          조합 가능한 모든 그룹에 대한 집계와 총 집계를 나타낸다.
 */

 SELECT JOB_ID
     , COMMISSION_PCT AS "수수료 퍼센트"
     , COUNT(JOB_ID) AS 수
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
 GROUP BY CUBE(JOB_ID, COMMISSION_PCT)
 ORDER BY JOB_ID NULLS FIRST, COMMISSION_PCT NULLS LAST;


 SELECT JOB_ID
     , COMMISSION_PCT AS "수수료 퍼센트"
     , COUNT(JOB_ID) AS 수
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
 GROUP BY CUBE(JOB_ID, COMMISSION_PCT)
 ORDER BY 1 NULLS FIRST, 2 NULLS LAST;

/*
 *  GROUPING : ROLLUP, CUBE로 집계한 결과에 대해 어떠한 조합으로 그룹을
 *             묶었는지 알 수 있도록 도와주는 함수(SELECT 절에 사용)
 *             함수의 반환값이 0이면 그룹에 포홤된 것이며, 1이면 포함이 안된 것이다.
 */

SELECT JOB_ID
     , COMMISSION_PCT AS "수수료 퍼센트"
     , COUNT(JOB_ID) AS 수
     , CASE WHEN GROUPING(JOB_ID) = 0 AND GROUPING(COMMISSION_PCT) = 1 THEN '직무그룹'
            WHEN GROUPING(JOB_ID) = 0 AND GROUPING(COMMISSION_PCT) = 0 THEN '직무/커미션그룹'
            ELSE '총계'
        END AS 그룹구분
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
 GROUP BY ROLLUP(JOB_ID, COMMISSION_PCT);

SELECT JOB_ID
     , COMMISSION_PCT AS "수수료 퍼센트"
     , COUNT(JOB_ID) AS 수
     , CASE WHEN GROUPING(JOB_ID) = 0 AND GROUPING(COMMISSION_PCT) = 1 THEN '직무그룹'
            WHEN GROUPING(JOB_ID) = 1 AND GROUPING(COMMISSION_PCT) = 0 THEN '커미션그룹'
            WHEN GROUPING(JOB_ID) = 0 AND GROUPING(COMMISSION_PCT) = 0 THEN '직무/커미션그룹'
            ELSE '총계'
        END AS 그룹구분
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
 GROUP BY CUBE(JOB_ID, COMMISSION_PCT);