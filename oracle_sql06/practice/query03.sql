/*
 *  특정 직무에 대한 급여 테이블을 일정 퍼센트 상승 및 감소를 시킨 경우
 *  JOBS 테이블의 MIN_SALARY, MAX_SALARY 컬럼의 값과
 *  EMPLOYEES 테이블에 동일 직무를 부여 받은 사원의 SALARY 컬럼의 값을
 *  변경하는 PROCEDURE를 생성한다.
 *
 * 프로시저의 실행 결과로 몇개의 행이 반영되었는지 반환할 수 있게 된다.
 */

CREATE OR REPLACE PROCEDURE PROC_INC_JOB_SALARY2(
      pJOBID IN VARCHAR2
    , pPERCENT IN NUMBER
    , pRECORDS OUT NUMBER
)
IS
    vRECORDS NUMBER := 0;
    vJOBID VARCHAR2(30) := UPPER(pJOBID);
BEGIN

    IF(pPERCENT > -100 AND pPERCENT < 100) THEN
        SELECT COUNT(*)
          INTO vRECORDS
          FROM JOBS
         WHERE JOB_ID = vJOBID;

        pRECORDS := pRECORDS + vRECORDS;

        UPDATE JOBS
           SET MIN_SALARY = MIN_SALARY * (1 + 0.01 * pPERCENT)
             , MAX_SALARY = MAX_SALARY * (1 + 0.01 * pPERCENT)
         WHERE JOB_ID = vJOBID;

        SELECT COUNT(*)
          INTO vRECORDS
          FROM EMPLOYEES
         WHERE JOB_ID = pJOBID;

        pRECORDS := pRECORDS + vRECORDS;

        UPDATE EMPLOYEES
           SET SALARY = SALARY * (1 + 0.01 * pPERCENT)
         WHERE JOB_ID = vJOBID;
    END IF;

    COMMIT;
END;

SELECT * FROM USER_ERRORS;

BEGIN
    PROC_INC_JOB_SALARY2('IT_PORG');
END;

DECLARE
    ROW_COUNT NUMBER;
BEGIN
    PROC_INC_JOB_SALARY2('IT_PROG', 20, ROW_COUNT);  /* 양수는 증가 */
    DBMS_OUTPUT.PUT_LINE(ROW_COUNT || ' 개 행이 반영되었습니다.');
END;

PROC_INC_JOB_SALARY2('IT_PROG', -10, ROW_COUNT); /* 음수는 감소 */
    PROC_INC_JOB_SALARY2('it_prog', 10, ROW_COUNT);  /* 소문자도 처리 가능 */
    PROC_INC_JOB_SALARY2('it', 10, ROW_COUNT);       /* 잘못된 JOB_ID 는 오류 없이 0개행 반영으로 종료 */
    PROC_INC_JOB_SALARY2('IT_PROG', 250, ROW_COUNT);   /* -1.0 초과 ~ 1.0 미만 의 범위만 처리, 그 외 범위는 0개행 반영으로 종료 */

