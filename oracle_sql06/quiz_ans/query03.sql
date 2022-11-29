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

/*
 *  LOGIN 테이블을 생성한다.
 *      USERNAME : 사용자 ID가 저장될 컬럼
 *      PASSWORD : 패스워드가 저장될 컬럼
 *      TRY_CNT : 시도 횟수가 저장될 컬럼
 *      LOGIN_LOCK : 로그인 잠김 유무가 저장될 컬럼
 *      LOCK_DATE : 로그인 잠김이 활성화된 날짜가 저장될 컬럼
 *
 * USERNAME과 PASSWORD를 입력 받을 수 있는 PROCEDURE를 작성하여 올바른 정보를 입력한 경우 '로그인 성공'을 출력하고
 * 별도의 LOGIN_LOG 테이블에 USERNAME, 로그인 성공 날짜 정보가 기록될 수 있게 한다.
 *
 * 만약 올바른 정보를 입력하지 않은 경우 '로그인 실패'를 출력하고 로그인 시도 횟수가 저장되는 컬럼에 값을 +1 증가시킨다.
 * (로그인 실패를 했을 때에도 LOGIN_LOG 테이블에 USERNAME, 로그인 실패 날짜 정보가 기록되게 한다.)
 *
 * 로그인 시도 횟수는 최대 3번이며, 3번째에서 실패를 한 경우 계정은 잠금상태가 되어 5분간 로그인 시도를 할 수 없게 한다.
 * (5분이 자난 후에는 다시 로그인을 시도할 수 있다.)
 *
 * 로그인 시도 횟수는 로그인이 성공했을 때 다시 0으로 초기화 되어야 한다.
 */

 CREATE TABLE LOGIN(
     USERNAME VARCHAR2(25) PRIMARY KEY
   , PASSWORD VARCHAR2(25)
   , TRY_CNT NUMBER DEFAULT(0)
   , LOGIN_LOCK CHAR(4)
   , LOCK_DATE DATE
 );

CREATE TABLE LOGIN_LOG(
    LOG_ID NUMBER PRIMARY KEY
  , USERNAME VARCHAR2(25) REFERENCES LOGIN(USERNAME)
  , LOG_TYPE VARCHAR2(10)
  , LOGGING_DATE DATE
);

CREATE SEQUENCE SEQ_LOGIN_LOG NOCACHE;

CREATE OR REPLACE PROCEDURE PROC_LOGIN(
        IN_USERNAME IN VARCHAR2
      , IN_PASSWORD IN VARCHAR2
)
IS
    EXISTS_USER NUMBER;
    VAR_PASSWORD VARCHAR2(25);
    VAR_TRY_CNT NUMBER;
    VAR_LOGIN_LOCK CHAR(4);
    VAR_LOCK_DATE DATE;
BEGIN
    SELECT COUNT(*)
      INTO EXISTS_USER
      FROM LOGIN
     WHERE USERNAME = IN_USERNAME;

    IF EXISTS_USER = 0 THEN
        DBMS_OUTPUT.PUT_LINE('해당 계정이 존재하지 않습니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('해당 계정이 존재합니다');

        SELECT USERNAME, PASSWORD, TRY_CNT, LOGIN_LOCK, LOCK_DATE
           INTO VAR_PASSWORD, VAR_TRY_CNT, VAR_LOGIN_LOCK, VAR_LOCK_DATE
           FROM LOGIN
          WHERE USERNAME = IN_USERNAME;

        IF VAR_LOGIN_LOCK = 'LOCK' AND SYSDATE < (VAR_LOCK_DATE + INTERVAL '5' MINUTE) THEN
            DBMS_OUTPUT.PUT_LINE('계정이 잠겨 있습니다.'
                                     || (VAR_LOCK_DATE + INTERVAL '5' MINUTE)
                                     || ' 에 다시 시도하세요');
        ELSE
            IF VAR_PASSWORD = IN_PASSWORD THEN
                DBMS_OUTPUT.PUT_LINE('패스워드가 일치합니다. - 로그인 성공');
            ELSE
                DBMS_OUTPUT.PUT_LINE('패스워드가 일치하지 않습니다. - 로그인 실패');

            IF(VAR_TRY_CNT + 1 = 3) THEN
                DBMS_OUTPUT.PUT_LINE('로그인 시도 3회 실패하였습니다. 계정이 5분간 잠깁니다.');
                UPDATE LOGIN
                   SET TRY_CNT = 3
                     , LOGIN_LOCK = 'LOCK'
                     , LOCK_DATE = SYSDATE
                 WHERE USERNAME = IN_USERNAME;
            ELSE
                DBMS_OUTPUT.PUT_LINE('로그인 시도' || TO_CHAR(3 - (1 + VAR_TRY_CNT)) || '회 남았습니다');
                UPDATE LOGIN
                   SET TRY_CNT = TRY_CNT + 1
                 WHERE USERNAME = IN_USERNAME;
                END IF;
            END IF;
        END IF;
    END IF;
END;

SELECT * FROM USER_ERRORS;

BEGIN
    PROC_LOGIN('test', 'test1');
END;

SELECT * FROM LOGIN;