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
    GROUP BY EXTRACT(YEAR FROM HIRE_DATE)
    ORDER BY EXTRACT(YEAR FROM HIRE_DATE);

/*
 *  JOB_ID 별 최고급여액, 최저급여액을 구하시오
 *  COMMISSION_PCT가 있는 경우 COMMISSION_PCT를 포함한 급여액으로 구하세요
 */