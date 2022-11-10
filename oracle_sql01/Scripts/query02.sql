/*
 *  DQL : SELECT 구문
 *        데이터 베이스의 테이블에 저장된 데이터를 조회하기 위해 사용
 *        조회 결과로 Record Set을 반환받게 된다.
 *        Record Set에는 Record가 0개 이상 포함되어 있다.
 */

SELECT * FROM EMPLOYEES;

/*
 *     SELECT 구문에는 FROM절, WHERE절 ORDER BY절 등이 추가로 사용된다.
 *     FROM 절에는 조회할 테이블 명을 작성하게 된다.
 *     WHERE 절에는 FROM에 명시한 테이블에서 데이터를 조회하기 위한 조건을 작성하게 된다.
 *     ORDER BY 절에는 조회 결과에 대한 정렬 기준을 작성하게 된다.
 *     SELECT 절에는 FROM 절에 명시한 테이블의 컬럼을 작성하게 된다. 이 때 작성된 컬럼의
 *     데이터들만 Record Set으로 반환이 된다.
 */

SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES;

SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE LAST_NAME = 'Grant';

SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME = 'Grant'
ORDER BY EMPLOYEE_ID DESC;

/*
 *     SELECT 절에 사용하는 컬럼명이 Record Set으로 반환될 때 그대로 출력되지만
 *     이를 변경하고 싶으면 별칭를 부여하여 Record Set으로 출력하는 컬럼명을 변경
 *     할 수 있다.
 */

SELECT EMPLOYEE_ID AS "사원 번호"
    ,  EMPLOYEE_ID AS 이름
    ,  LAST_NAME AS 성
FROM EMPLOYEES;

/*
 *  SELECT 절에 컬럼명과 리터럴 값('' - 작은 따옴표로 묶어야 한다)을 혼합하여 Record Set으로 반환되는
 *  결과값을 변경할 수 있다.
 *  || 연산을 통해 두개의 문자열을 붙일 수 있다.
 */
SELECT 'No. ' || EMPLOYEE_ID AS "사원 번호"
    , FIRST_NAME
    , LAST_NAME
FROM EMPLOYEES;

/*
 *  SELECT 절에 컬럼과 컬럼을 결합하여 하나의 컬럼으로 만들어 Record Set을
 *  반환할 수 있다.
 */

SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
FROM EMPLOYEES;

/*
 *  숫자 데이터가 저장된 컬럼에는 사칙연산을 수행한 결과로 Record Set을
 *  반환할 수 있다.
 */

SELECT FIRST_NAME
    , LAST_NAME
    , (SALARY + 1000) / 12
    FROM EMPLOYEES;

/*
 *  Record Set의 결과가 중복된 결과로 나오는 경우 중복을 제거할 수 있다.
 */
SELECT DISTINCT DEPARTMENT_ID
    FROM EMPLOYEES;
