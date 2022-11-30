/*
 *   FUNCTION 객체
 *      - PL/SQL 구문을 사용하여 생성할 수 있는 객체
 *      - 프로시저와 유사하며, 일반 프로그래밍 언어의 함수와 같이 값을 리턴(반환)한다.
 *      - FUNCTION은 PROCEDURE와 다르게 SQL 구문에 같이 사용할 수 있다.
 */

CREATE OR REPLACE FUNCTION FUNC_SAMPLE1(
      NUM1 NUMBER
    , NUM2 NUMBER
) RETURN NUMBER
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('함수가 실행됩니다.');
    RETURN NUM1 + NUM2;
END;

SELECT * FROM USER_ERRORS;

/*
 * SQL 프로그래밍 문법적 측면에서 작동하는 원리
 *      1. 매개변수 SALARY, COMMISSION 이라는 값을 받아서
 *      2. RETURN 문에서 계산을 해서
 *      3. NUMBER 형식의 FIELD로 반환한다.
 */
SELECT FUNC_SAMPLE1(10, 20) FROM DUAL;

CREATE OR REPLACE FUNCTION FUNC_SAMPLE2(
          SALARY NUMBER
        , COMMISSION NUMBER
) RETURN NUMBER
IS
BEGIN
    RETURN FLOOR(SALARY * (1 + NVL(COMMISSION, 0)));
END;

SELECT EMPLOYEE_ID
     , FUNC_SAMPLE2(SALARY, COMMISSION_PCT)
  FROM EMPLOYEES;