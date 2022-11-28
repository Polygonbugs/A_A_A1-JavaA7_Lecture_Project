/*
 *  PL/SQL
 *      - Procedural Language extension to SQL
 *      - SQL 문장에서 변수의 정의, 조건문, 반복문 등의 프로그래밍 언어에서
 *        지원하는 기능을 일부 지원하는 것
 *
 *  - PL/SQL 구조
 *
 *  DECLARE
 *      변수 정의 영역(생략 가능)
 *  BEGIN
 *      실행 영역
 *  END;
 *
 *  EXCEPTION
 *      예외처리 영역(생략 가능)
 *  END;
 *  / --> PL/SQL의 끝을 의미한다 (sqlplus에서는 /를 꼭 작성해줘야 한다. Datagrip 또는 DBeaver에서는 제외)
 *
 */

/* DBeaver 에서는 적용 안됨 SQLPLUS에서 출력기능을 사용하기 위해 필요함 */
-- SET SERVEROUTPUT ON;

 BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
 END;

/*
 *   기본 변수 사용방법
 */
DECLARE
    x NUMBER := 10;
    y NUMBER := 20;
BEGIN
    DBMS_OUTPUT.PUT_LINE(x + y);
END;

DECLARE
    s1 VARCHAR2(10) := 'Hello';
    s2 CHAR(10) := 'PL/SQL';
BEGIN
    DBMS_OUTPUT.PUT_LINE(s1 || ' ' || s2);
END;

DECLARE
    n1 NUMBER;
    n2 NUMBER;
BEGIN
    n1 := 10;
    n2 := 20;
    DBMS_OUTPUT.PUT_LINE(n1 || ' ' || n2);
END;

/*
 *  조회 구문 사용하기
 *  유의사항 : 띄어 쓰기를 하면 안된다.
 *
 */
DECLARE
    EMP_ID NUMBER;
    FNAME VARCHAR2(30);
    LNAME VARCHAR2(30);
BEGIN
    SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME
      INTO EMP_ID, FNAME, LNAME /* 조회된 값을 변수에 저장하기 위한 INTO 절*/
      FROM WEB_ADMIN.EMPLOYEES
     WHERE EMPLOYEE_ID = :ID;   /* SQLplus에서는 &ID 형식으로 사용해야 함*/
    DBMS_OUTPUT.PUT_LINE(EMP_ID || ' | ' || FNAME || ' | ' || LNAME);
END;

/*
 *  IF 문 사용하기
 */
DECLARE
    NUM NUMBER;
BEGIN
    NUM := :NUM;
    IF(NUM > 10) THEN
        DBMS_OUTPUT.PUT_LINE('변수 NUM에 저장된 값은 10보다 큽니다');
    ELSIF(NUM = 10) THEN
        DBMS_OUTPUT.PUT_LINE('변수 NUM에 저장된 값은 10 입니다');
    ELSE
        DBMS_OUTPUT.PUT_LINE('변수 NUM에 저장된 값은 10보다 작습니다.');
    END IF;
END;

/*
 *  반복문 사용하기
 */

BEGIN
    FOR N IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;

BEGIN
    FOR N IN REVERSE 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;

DECLARE
    NUM NUMBER := 0;
BEGIN
    LOOP
        NUM := NUM + 1;
        DBMS_OUTPUT.PUT_LINE(NUM);
        IF NUM >= 5 THEN
            EXIT;
        END IF;
    END LOOP;
END;

DECLARE
    NUM NUMBER := 0;
    BEGIN
    WHILE NUM < 5 LOOP
        DBMS_OUTPUT.PUT_LINE(NUM);
        NUM := NUM + 1;
    END LOOP;
END;

/*
 *  테스트용 테이블을 생성 후 데이터 추가 / 수정 / 삭제하기
 */

 CREATE TABLE TEST1(
    ID NUMBER PRIMARY KEY
  , NAME VARCHAR2(30)
  , AGE NUMBER
);

DECLARE
    VID NUMBER;
    NAME VARCHAR2(30);
    AGE NUMBER;
    CNT NUMBER;
BEGIN
    VID := :ID;
    NAME := :NAME;   /* 작은 따옴표를 입력 창에 직접 입력할 것. PLSQL에서는 '&NAME'이 되기 때문에 필요 없음 */
    AGE := :AGE;
    SELECT COUNT(ID)
      INTO CNT
      FROM TEST1
     WHERE ID = VID; /* 행이 반드시 한개가 나와야 한다.*/
    IF(CNT = 1) THEN
        DBMS_OUTPUT.PUT_LINE('동일한 ID가 존재합니다.');
    ELSE
        INSERT INTO TEST1 VALUES(VID, NAME, AGE);
        COMMIT;
    END IF;
END;

DECLARE
    VID NUMBER;
    NAME VARCHAR2(30);
    AGE NUMBER;
    CNT NUMBER;
BEGIN
    VID := :ID;
    NAME := :NAME;   /* 작은 따옴표를 입력 창에 직접 입력할 것. PLSQL에서는 '&NAME'이 되기 때문에 필요 없음 */
    AGE := :AGE;
    INSERT INTO TEST1 VALUES(VID, NAME, AGE);
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX /*https://docs.oracle.com/en/database/oracle/oracle-database/21/lnpls/plsql-error-handling.html#GUID-8C327B4A-71FA-4CFB-8BC9-4550A23734D6 참고*/
        THEN DBMS_OUTPUT.PUT_LINE('중복값이 있습니다.');
    ROLLBACK;
END;

DECLARE
    VID NUMBER;
    VNAME VARCHAR2(30);
    VAGE NUMBER;
BEGIN
    VID := :ID;
    VNAME := :NAME;   /* 작은 따옴표를 입력 창에 직접 입력할 것. PLSQL에서는 '&NAME'이 되기 때문에 필요 없음 */
    VAGE := :AGE;
    INSERT INTO TEST1 VALUES(VID, VNAME, VAGE);
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX
        THEN
            UPDATE TEST1
               SET NAME = VNAME
                ,  AGE = VAGE
               WHERE ID = VID;
    COMMIT;
END;

SELECT * FROM TEST1;

INSERT INTO TEST1 VALUES(10, '홍길동', 21);
