/*
 *  PL/SQL
 *      - Procedural Language extension to SQL
 *      - SQL 문장에서 변수의 정의, 조건문, 반복ㅁ누 등의 프로그래밍 언어에서
 *        지원하는 기능을 일부 지원하는 것
 *
 * PL/SQL 구조
 * DECLARE
 *      변수 정의 영역(생략 가능)
 * BEGIN
 *      실행 영역
 * EXCEPTION
 *      예외처리 영역(생략 가능)
 * END;
 * / --> PL/SQL의 끝을 의미한다(sqlplus에서는 /를 꼭 작성해야 한다. Datagrip 또는 DBeaver에서는 제외)
 */

 /* DBeaver에서는 적용 안됨. SQLPlus에서 출력기능을 사용하기 위해 필요함 */
-- SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
END;

/*
 *  기본 변수 사용방법
 */
 DECLARE
     x NUMBER := 10;
     y NUMBER := 20;
 BEGIN
     DBMS_OUTPUT.PUT_LINE(x+Y);
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
  * 조회 구문 사용하기
  * 유의사항 : 띄어쓰기를 하면 안된다.
  */
  DECLARE
      EMP_ID NUMBER;
      FNAME VARCHAR2(30);
      LNAME VARCHAR2(30);
  BEGIN
      SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME
        INTO EMP_ID, FNAME, LNAME
        FROM WEB_ADMIN.EMPLOYEES
          WHERE EMPLOYEE_ID = :ID;

      DBMS_OUTPUT.PUT_LINE(EMP_ID || ' | ' || FNAME || ' | ' || LNAME);
  END;

