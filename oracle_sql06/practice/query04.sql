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

SELECT