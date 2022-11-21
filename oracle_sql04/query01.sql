/*
 *      JOIN
 *          - 하나 이상의 테이블에서 데이터를 조회하기 위해 사용하는 구문
 *          - 결과는 하나의 Record Set으로 반환된다.
 *          - UNION, UNION ALL 등과 같은 집합 연산과는 다르게 열에 대한
 *            결합으로 결과가 나오게 된다.
 *          - JOIN을 사용하는 테이블에 공통 열 값에 대해 결합을 수행하게 된다.
 */

SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;

/* 표준 JOIN 구문 */
/* 컬럼을 붙인다*/
SELECT *
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID;

/* 결합 컬럼을 맨 앞으로 빠진다. 컬럼을 하나로 통합해서 합친다. */
SELECT *
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEPT
 USING (DEPARTMENT_ID);

/* 가시성을 위해 SELECT의 TABLE을 명시한다*/
/* 기준열(겹치는 부분)은 EMP 또는 DEPT로 잡을 수 있다. 강사님은 EMP로 보는 것이다*/
SELECT EMP.EMPLOYEE_ID
     , EMP.FIRST_NAME
     , EMP.LAST_NAME
     , EMP.DEPARTMENT_ID
     , DEPT.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID
 WHERE DEPT.DEPARTMENT_NAME LIKE '%IT%';


/* ORACLE 전용 JOIN 구문 */
-- 같은 컬럼의 경우 테이블명을 구분지어서 사용해야 한다.
-- 다른 컬럼의 경우 테이블명을 구분지어서 사용하지 않아도 된다.
SELECT *
  FROM EMPLOYEES E, DEPARTMENTS D
 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID;


SELECT *
  FROM EMPLOYEES E
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID;

SELECT E.EMPLOYEE_ID
     , E.FIRST_NAME
     , E.LAST_NAME
     , E.JOB_ID
     , J.JOB_TITLE
  FROM EMPLOYEES E
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID;

/* JOIN의 순서는 상관이 없다.*/
/* INNER JOIN의 경우에는 컬럼의 행의 값이 일치해야 값이 나온다 */
SELECT E.EMPLOYEE_ID
     , E.FIRST_NAME
     , E.LAST_NAME
     , E.JOB_ID
     , J.JOB_TITLE
     , E.DEPARTMENT_ID
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
 JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID
 WHERE E.EMPLOYEE_ID = 178;

/*
 *  INNER JOIN
 *      - JOIN 구문의 가장 기본이 되는 조인 방법
 *      - JOIN 결합 조건에 해당하는 행에 대해서만 결합을 수행하고
 *        결합 조건에 해당하지 않는 경우 결합을 하지 않는다.
 *
 *  OUTER JOIN : INNER JOIN과 다르게 결합 조건에 해당하지 않는 경우에도 Record Set에 포함
 *      - LEFT OUTER JOIN
 *      - RIGHT OUTER JOIN
 *      - FULL OUTER JOIN
 *
 *  CROSS JOIN
 *
 *  NON_EQU JOIN
 *
 *
 */