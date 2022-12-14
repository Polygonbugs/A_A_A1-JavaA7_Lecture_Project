/*
 *  PROCEDURE
 *      - PL/SQL 구문을 PROCEDURE 객체로 만들어 재사용할 수 있도록 한다.
 *      - EXEC 명령어로 함수와 비슷하게 사용할 수 있다.
 *      - 외부 값을 프로시저 내부에 전달하거나 프로시저 내부에서 생성된 값을
 *        외부에 반환하는 형식을 작성할 수 있다.
 */

 /*
  * 프로시저 생성 및 실행
  */
CREATE OR REPLACE PROCEDURE PROC_SAMPLE1
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('프로시저 동작!!!');
END;

BEGIN
    PROC_SAMPLE1;
END;

SELECT * FROM USER_PROCEDURES;
/* 프로시저 에러 메시지 확인은 이 명령어로 할 것! */
SELECT * FROM USER_ERRORS;

DROP PROCEDURE PROC_SAMPLE1;

/* SQLPlus에서 실행하는 방법*/
-- SET SERVEROUTPUT ON (SQLPlus에서 DBMS_OUTPUT 로그 켜기)
-- EXEC PROC_SAMPLE1;

/*
 *  SQLPlus외의 DBMS Client 도구에서 실행하는 방법
 */
BEGIN
    PROC_SAMPLE1();
END;

/*
 * 프로시저에서 변수 선언
 */
CREATE OR REPLACE PROCEDURE PROC_SAMPLE2
IS
    NUM NUMBER := 10;
BEGIN
    DBMS_OUTPUT.PUT_LINE(NUM);
END;

SELECT * FROM USER_ERRORS;
SELECT * FROM USER_PROCEDURES;

BEGIN
    PROC_SAMPLE2;
END;

DROP PROCEDURE PROC_SAMPLE2;

/*
 *  외부에서 값 전달받기
 */
CREATE OR REPLACE PROCEDURE PROC_SAMPLE3(X IN NUMBER)
IS
    NUM NUMBER := 10;
BEGIN
    DBMS_OUTPUT.PUT_LINE(NUM + X);
END;

SELECT * FROM USER_PROCEDURES;

BEGIN
    PROC_SAMPLE3(15);
END;

DROP PROCEDURE PROC_SAMPLE3;

/*
 *  외부로 값 내보내기
 */
 CREATE OR REPLACE PROCEDURE PROC_SAMPLE4(X OUT NUMBER)
 IS
 BEGIN
    x := 10;
    DBMS_OUTPUT.PUT_LINE('내보낼 값을 변수에 저장');
 END;

SELECT * FROM USER_ERRORS;

DECLARE
    NUM NUMBER;
BEGIN
    PROC_SAMPLE4(NUM);
    DBMS_OUTPUT.PUT_LINE('값 : ' || NUM);
END;

/*
 *  SQLPlus에서 외부로 값을 내보내는 명령을 실행할 때는 다음의 방법을 사용한다.
 *      1. 프로시저를 통해 받을 변수지정 : VARIABLE X NUMBER;
 *      2. 값을 내보내는 프로시저 실행 : EXEC PROC_SAMPLE4(:X)
 *      3. SQLPlus에서 받을 값을 출력 : PRINT X;
 */

CREATE OR REPLACE PROCEDURE PROC_SAMPLE5(
          NUM1 IN NUMBER
        , NUM2 IN NUMBER
        , RES OUT NUMBER)
IS
BEGIN
    RES := NUM1 + NUM2;
    DBMS_OUTPUT.PUT_LINE('실행이 완료되었습니다');
END;

DECLARE
    RES NUMBER;
BEGIN
    PROC_SAMPLE5(10, 20, RES);
    DBMS_OUTPUT.PUT_LINE('실행결과 : ' || RES);
END;

DROP PROCEDURE PROC_SAMPLE5;
