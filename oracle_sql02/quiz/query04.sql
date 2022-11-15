CREATE TABLE EMP_SAMPLE
AS
SELECT EMPLOYEE_ID AS EMP_ID
     , FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME
     , EMAIL || '@emp.co.kr' AS EMAIL
     , HIRE_DATE
     , SALARY
     , COMMISSION_PCT
     , DEPARTMENT_ID AS DEPT_ID
     , REPLACE(PHONE_NUMBER, '.', '-') AS PHONE
  FROM EMPLOYEES;

SELECT * FROM EMP_SAMPLE;

/*
 *  홍길동 사원 정보를 추가한다.
 *  홍길동 사원의 EMP_ID는 기존 EMP_ID의 값 중 가장 큰 EMP_ID + 1 한 값이 저장되게 한다.
 *  홍길동 사원의 입사일은 2022년 03월 05일 이다.
 *  홍길동 사원의 부서 ID는 80이다.
 *  홍길동 사원의 급여는 2800이며 보너스(COMMISSION_PCT)는 없다.
 *  위에서 제시한 상항을 참고하여 데이터를 추가하며 없는 정보는 NULL로 채워 넣는다.
 */

SELECT * FROM EMP_SAMPLE;

INSERT INTO EMP_SAMPLE(EMP_NAME, EMP_ID, HIRE_DATE, DEPT_ID, SALARY, COMMISSION_PCT) VALUES('홍길동', 207, '20220305', 80, 2800, 0);

DELETE FROM EMP_SAMPLE WHERE EMP_ID = 207;
/*
 *   홍길동 사원의 직무코드를 'IT_PROG'로 수정하세요
 *   홍길동 사원의 EMAIL 주소는 영문이름으로 만들어서 수정해주세요
 *   홍길동 사원의 전화번호는 590-423-4561으로 수정해주세요,
 *
 */
SELECT * FROM JOBS;
ALTER TABLE EMP_SAMPLE ADD JOB_ID VARCHAR2(30);

--UPDATE EMP_SAMPLE SET JOB_ID;

UPDATE EMP_SAMPLE SET JOB_ID = 'IT_PROG', EMAIL = 'HONGGIL@emp.co.kr', PHONE = '590-423-4561'
 WHERE EMP_NAME = '홍길동';

/*
 *  1990년 이전 입사자들의 퇴직신청을 위해 관련된 사원의 리스트르 조회하고
 *  조회된 정보 중에서 급여가 10000 이상인 사원의 급여를 25% 삭감하세요.
 */

SELECT SALARY
     , HIRE_DATE
  FROM EMP_SAMPLE
 WHERE SALARY >= 10000 and HIRE_DATE < '1990-01-01';

UPDATE EMP_SAMPLE SET SALARY = SALARY * 0.75 WHERE SALARY >= 10000 and HIRE_DATE < '1990-01-01';

 /*
  *  부서 ID가 50, 60, 70인 사원들에 대해 기존 급여에 10% 인상한 급여로 수정하세요.
  */

SELECT DEPT_ID
     , SALARY
  FROM EMP_SAMPLE
 WHERE DEPT_ID IN (50, 60, 70);

UPDATE EMP_SAMPLE SET SALARY = SALARY * 1.1 WHERE DEPT_ID IN (50, 60, 70);

DROP TABLE EMP_SAMPLE;