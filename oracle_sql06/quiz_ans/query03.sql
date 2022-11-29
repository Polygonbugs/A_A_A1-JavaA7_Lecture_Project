/*
 * 특정 직무에 대한 급여 테이블을 일정 퍼센트 상승 및 감소를 시킨 경우
 * JOBS 테이블의 MIN_SALARY, MAX_SALARY 컬럼의 값과
 * EMPLOYEES 테이블에 동일 직무를 부여 받은 사원의 SALARY 컬럼의 값을
 * 변경하는 PROCEDURE를 생성한다.
 *
 * 프로시저의 실행 결과로 몇개의 행이 반영되었는지 반환할 수 있게 한다.
 *
 * 매개변수는 재할당이 가능하지 않다. 매개변수의 문자형의 크기는 따로 지정해주지 않아도 된다.
 */

 CREATE OR REPLACE PROCEDURE PROC_INC_JOB_SALARY(
          pJOB_ID IN VARCHAR2
        , pPERCENT IN NUMBER
        , pUPDATE_ROWS OUT NUMBER
 )
IS
     R_COUNT NUMBER;
     UPPER_JOB_ID VARCHAR2(20);
BEGIN
    UPPER_JOB_ID := UPPER(pJOB_ID);
    pUPDATE_ROWS := 0;

    IF(pPERCENT > -1.0 AND pPERCENT < 1.0) THEN
        SELECT COUNT(*)
          INTO R_COUNT
          FROM JOBS
         WHERE JOB_ID = UPPER_JOB_ID;

        pUPDATE_ROWS := R_COUNT;

        UPDATE JOBS
            SET MIN_SALARY = MIN_SALARY * (1 + pPERCENT)
              , MAX_SALARY = MAX_SALARY * (1 + pPERCENT)
          WHERE JOB_ID = UPPER_JOB_ID;

        SELECT COUNT(*)
          INTO R_COUNT
          FROM EMPLOYEES
         WHERE JOB_ID = UPPER_JOB_ID;

        pUPDATE_ROWS := pUPDATE_ROWS + R_COUNT;

        UPDATE EMPLOYEES
           SET SALARY = SALARY * (1 + pPERCENT)
         WHERE JOB_ID = UPPER_JOB_ID;
    END IF;

    COMMIT;
END;

SELECT * FROM USER_ERRORS;



DECLARE
    ROW_COUNT NUMBER;
BEGIN
    PROC_INC_JOB_SALARY('IT_PROG', 0.1, ROW_COUNT); /* 양수는 증가 */
    DBMS_OUTPUT.PUT_LINE(ROW_COUNT || ' 개 행이 반영되었습니다');
END;

DECLARE
    ROW_COUNT NUMBER;
BEGIN
    PROC_INC_JOB_SALARY('IT_PROG', -0.1, ROW_COUNT); /* 음수는 감소 */
    DBMS_OUTPUT.PUT_LINE(ROW_COUNT || ' 개 행이 반영되었습니다');
END;

DECLARE
    ROW_COUNT NUMBER;
BEGIN
    PROC_INC_JOB_SALARY('it_prog', 0.1, ROW_COUNT); /* 소문자도 처리 가능 */
    DBMS_OUTPUT.PUT_LINE(ROW_COUNT || ' 개 행이 반영되었습니다');
END;


DECLARE
    ROW_COUNT NUMBER;
BEGIN
    PROC_INC_JOB_SALARY('it', 0.1, ROW_COUNT); /* 잘못된 JOB_ID는 오류 없이 0개행 반영으로 종료 */
    DBMS_OUTPUT.PUT_LINE(ROW_COUNT || ' 개 행이 반영되었습니다');
END;

DECLARE
    ROW_COUNT NUMBER;
BEGIN
    PROC_INC_JOB_SALARY('IT_PROG', 10, ROW_COUNT); /* -1.0 초과 ~ 1.0 미만의 범위만 처리, 그 외 범위는 0개행 반영으로 종료 */
    DBMS_OUTPUT.PUT_LINE(ROW_COUNT || ' 개 행이 반영되었습니다');
END;