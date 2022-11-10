/*
 *  사원 테이블에서 SALARY 정보가 3,000 이하인 사원의 사번(EMPLOYEE_ID)
 *  이름(FIRDT_NAME + LAST_NAME)을 조회하세요
 */


SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
  FROM EMPLOYEES
 WHERE SALARY <= 3000;

/*
 *  사원 테이블에서 DEPARTMENT_ID가 50인 사원의 사번(EMPLOYEE_ID)
 *  이름(FIRDT_NAME + LAST_NAME), 직무(JOB_ID)를 조회하세요
 */

SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , JOB_ID
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 50;


/*
 *  부서 테이블에서 DEPARTMENT_NAME의 값이 IT가 포함된 결과를 조회하세요.
 *  부서ID(DEPARTMENT_ID), 부서명(DEPARTMENT_NAME) 컬럼만 Record Set에 반환하세요
 */

SELECT DEPARTMENT_ID
     , DEPARTMENT_NAME
  FROM DEPARTMENTS
 WHERE DEPARTMENT_NAME LIKE '%IT%';

/*
 *  직무 테이블에서 JOB_TITLE의 값에 Manager가 포함된 결과를 조회하세요
 *  직무 ID(JOB_ID), 직무명(JOB_TITLE) 컬럼만 Record Set에 반환하세요
 */

SELECT JOB_ID
     , JOB_TITLE
  FROM JOBS
 WHERE JOB_TITLE LIKE '%Manager%';


/*
 *  사원 테이블에서 MANAGER_ID 컬럼만을 조회할 때 중복된 결과값이 나오지 않게 하세요.
 */

SELECT DISTINCT MANAGER_ID
           FROM EMPLOYEES;
