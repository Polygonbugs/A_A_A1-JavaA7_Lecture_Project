/*
 *      Sub Query
 *          - SQL 구문에 SELECT 구문이 포함되어 실행되는 형태
 *          - 서브쿼리는 반드시 소괄호로 묶여야 함.
 *          - 서브쿼리와 비교하는 항목은 반드시 서브쿼리의 SELECT 절의 항목 갯수와
 *            자료형을 일치시켜야 한다.
 */

SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , (SELECT JOB_TITLE FROM JOBS WHERE JOBS.JOB_ID = E.JOB_ID) AS JOB_TITLE
     , (SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_ID = E.DEPARTMENT_ID) AS DEPT_NAME
     , MANAGER_ID
  FROM EMPLOYEES E;

SELECT *
  FROM (SELECT EMPLOYEE_ID
             , FIRST_NAME
             , LAST_NAME
         FROM EMPLOYEES);

/*
 *  80인 값이 사용된다.
 */
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , SALARY
     , COMMISSION_PCT
     , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DISTINCT DEPARTMENT_ID
                           FROM EMPLOYEES
                          WHERE COMMISSION_PCT IS NOT NULL
                            AND COMMISSION_PCT > 0);

/*
 *  INSERT, UPDATE, DELETE 구문에서도 서브쿼리 사용됨.
 */
INSERT INTO 테이블명(
    SELECT * FROM 테이블명
);

UPDATE 테이블명
    SET 컬럼명 = (SELECT 컬럼명 FROM 테이블명);

DELETE FROM 테이블명
 WHERE 컬럼명 = (SELECT 컬럼명 FROM 테이블명);

/*
 *  서브 쿼리의 Result Set의 Record 수와 Column 수에 따라서 에러가 발생할 수 있다.
 */
-- SELECT에서는 1개 열에는 1개 값이 리턴되야 한다. FROM절의 sub query 값은 아무렇게나 넣어도 된다.
-- 단일행 서브쿼리
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , (SELECT JOB_TITLE FROM JOBS WHERE JOB_ID LIKE '%MGR%') AS JOB_TITLE
     , (SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_ID = E.DEPARTMENT_ID) AS DEPT_NAME
     , MANAGER_ID
  FROM EMPLOYEES E;

-- 비교 연산을 할 경우 1개의 값만 가능하다
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = (SELECT DISTINCT EMPLOYEE_ID
                          FROM EMPLOYEES
                        WHERE MANAGER_ID IS NOT NULL);

SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DISTINCT EMPLOYEE_ID
                          FROM EMPLOYEES
                        WHERE MANAGER_ID IS NOT NULL);

-- 행 1개, 열 n개 / sub query where 절 지워보기
-- 열수, 행수 고려하기
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
  FROM EMPLOYEES
 WHERE (JOB_ID, DEPARTMENT_ID) = (SELECT DISTINCT JOB_ID, DEPARTMENT_ID
                                    FROM EMPLOYEES
                                   WHERE EMPLOYEE_ID = 104);

/*
 *  단일행
 *      서브 쿼리의 결과값이 1개 인 것
 *  다중행
 *      서브 쿼리의 결과값이 n개 인 것
 *  다중열
 *      서브 쿼리의 결과 열이 n개 인 것
 *  다중행/다중열
 *      서브쿼리의 결과 열과 값이 n개 인 것
 */

 /*
  * SELECT 절에 사용하는 서브쿼리는 반드시 단일행/단일열의 결과가 나와야 한다.
  * WHERE 절에 사용하는 서브쿼리는 왼쪽 컬럼 수에 따라 단일열 또는 다중열이 사용될 수 있다.
  * WHERE 절에 사용하는 서브쿼리는 연산자 종류에 따라 단일행 또는 다중열이 사용될 수 있다.
  * (1개 값을 비교하는 형태면 단일행, 여러 값을 비교하는 형태면 다중열)
  * FROM 절에 사용하는 서브쿼리는 어떠한 형태이든 사용 가능하다.
  * FROM 절에 사용하는 서브쿼리는 INLINE VIEW 라고 한다.
  */