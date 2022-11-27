/*
 *      JOIN
 *          - 하나 이상의 테이블에서 데이터를 조회하기 위해 사용하는 구문
 *          - 결과는 하나의 Record Set으로 반환된다.
 *          - UNION, UNION ALL 등과 같은 집합 연산과는 다르게 열에 대한
 *            결합으로 결과가 나오게 된다.
 *          - JOIN을 사용하는 테이블에 공통 열 값에 대해 결합을 수행하게 된다.
 */

/*
 *  INNER JOIN
 *      - JOIN 구문의 가장 기본이 되는 조인 방법
 *      - JOIN 결합 조건에 해당하는 행에 대해서만 결합을 수행하고
 *        결합 조건에 해당하지 않는 경우 결합을 하지 않는다.
 */

SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;

/* 표준 JOIN 구문 */
/* 컬럼을 붙인다*/
SELECT *
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID;

/* USING을 쓸 경우 결합 컬럼을 맨 앞으로 빠진다. 컬럼을 하나로 통합해서 합친다. */
SELECT *
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEPT
 USING (DEPARTMENT_ID);

/* 가시성을 위해 SELECT의 TABLE을 명시한다*/
/* INNER JOIN의 경우 기준열(겹치는 부분)은 EMP 또는 DEPT로 잡을 수 있다. 강사님은 EMP로 보는 것이다*/
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

/*  OUTER JOIN : INNER JOIN과 다르게 결합 조건에 해당하지 않는 경우에도 Record Set에 포함
 *      - LEFT, RIGHT, FULL OUTER JOIN이 존재한다
 *      - LEFT OUTER JOIN
 *          왼쪽 테이블의 데이터에 해당하는 값이 없어도
 *          왼쪽 테이블의 데이터는 전부 Record Set에 포함된다.
*/
SELECT E.EMPLOYEE_ID
     , E.FIRST_NAME
     , E.LAST_NAME
     , E.DEPARTMENT_ID
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  LEFT OUTER JOIN DEPARTMENTS D
    ON E.EMPLOYEE_ID = D.MANAGER_ID;

/*      - RIGHT OUTER JOIN
 *          결합 조건에 해당하는 값이 없어도 오른쪽 테이블의 데이터는 전부 Record Set에 포함된다.
 */
SELECT E.EMPLOYEE_ID
     , E.FIRST_NAME
     , E.LAST_NAME
     , D.DEPARTMENT_ID
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  RIGHT OUTER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

/*      - FULL OUTER JOIN
 *          LEFT OUTER JOIN과 RIGHT OUTER JOIN이 결합된 형태
 */
SELECT E.EMPLOYEE_ID
     , E.FIRST_NAME
     , E.LAST_NAME
     , D.DEPARTMENT_ID
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  FULL OUTER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;


/*
 *  CROSS JOIN
 *      - 카테시안 곱(Cartesian Product)이라고도 한다.
 *      - JOIN 하는 모든 테이블의 행들이 맵핑된 데이터의 결과로 반환한다.
 *      - A 테이블 10행, B 테이블 5행 -> A * B = 50 행
 */

SELECT COUNT(*) FROM DEPARTMENTS;

SELECT *
  FROM EMPLOYEES E
 CROSS JOIN DEPARTMENTS D;

/*
 *  NON_EQU JOIN
 *      - 지정한 범위에 포함되는 데이터를 결합하는 형식의 JOIN
 */
SELECT E.EMPLOYEE_ID
     , E.FIRST_NAME
     , E.LAST_NAME
     , E.JOB_ID
     , E.SALARY
     , J.MIN_SALARY
     , J.MAX_SALARY
  FROM EMPLOYEES E
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID
   AND E.SALARY BETWEEN J.MIN_SALARY AND J.MAX_SALARY
 WHERE E.EMPLOYEE_ID = 207;

/*
 *  SELF JOIN
 *      - 동일(같은)한 테이블을 결합하는 것
 *      - 테이블안에 자기 자신을 참조할 수 있는 테이블을 찾기 위한 용도로 사용됩니다.
 */

SELECT E1.EMPLOYEE_ID
     , E1.FIRST_NAME
     , E1.LAST_NAME
     , E1.MANAGER_ID
     , E2.FIRST_NAME
     , E2.LAST_NAME
  FROM EMPLOYEES E1
  JOIN EMPLOYEES E2
    ON E1.MANAGER_ID = E2.EMPLOYEE_ID;

SELECT * FROM EMPLOYEES;


SELECT sd_name 학생명
     , l_name 과목명
     , to_char(t_date, 'YYYY.MM.DD') 수강신청일
  FROM trainee tr
  JOIN student st
    ON tr.no = st.no
  JOIN lesson le
    ON tr.no = le.no
 WHERE tr.l_abbre = le.l_abbre;