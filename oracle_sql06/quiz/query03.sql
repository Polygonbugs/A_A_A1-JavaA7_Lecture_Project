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
  , pROWS IN NUMBER)
IS
    vROWS NUMBER;
BEGIN
    SELECT COUNT(*)
      INTO VROWS
      FROM JOBS
     WHERE JOB_ID = PJOB_ID;

    pROWS := vROWS;

    UPDATE JOBS
       SET MIN_SALARY = MIN_SALARY * (1 + pPERCENT)
         , MAX_SALARY = MAX_SALARY * (1 + pPERCENT)
     WHERE JOB_ID = pJOB_ID;

    pROWS := pROWS + vROWS;

    UPDATE EMPLOYEES
       SET SALARY = SALARY * (1 + pPERCENT)
     WHERE JOB_ID = pJOB_ID;
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
      USERNAME VARCHAR2(30) CONSTRAINT USERNAMES_COL_PK PRIMARY KEY
    , PASSWORD VARCHAR2(30)
    , TRY_CNT NUMBER DEFAULT(0)
    , LOGIN_LOCK NUMBER CONSTRAINT LOGIN_LOCK_COL_CK CHECK(LOGIN_LOCK IN (1,0))
    , LOCK_DATE DATE
);

DROP TABLE LOGIN;

CREATE TABLE LOGIN_LOG(
      USERNAME VARCHAR2(30) REFERENCES LOGIN(USERNAME)
    , LOCK_DATE DATE
);

DROP TABLE LOGIN_LOG;

CREATE OR REPLACE PROCEDURE LOGIN_PROC(
      USERNAME VARCHAR2
    , PASSWORD VARCHAR2
)
IS
    tUSERNAME VARCHAR2(50);
    tPASSWORD VARCHAR2(50);
    tCOUNT NUMBER;
    cLOCK NUMBER;
BEGIN
    SELECT LOGIN.USERNAME
      INTO tUSERNAME
      FROM LOGIN
     WHERE LOGIN.USERNAME = USERNAME AND LOGIN.PASSWORD = PASSWORD;

    SELECT LOGIN.PASSWORD
      INTO TPASSWORD
      FROM LOGIN
     WHERE LOGIN.USERNAME = USERNAME AND LOGIN.PASSWORD = PASSWORD;


    SELECT LOGIN.TRY_CNT
      INTO tCOUNT
      FROM LOGIN
     WHERE LOGIN.USERNAME = USERNAME;

    SELECT LOGIN_LOCK
      INTO cLOCK
      FROM LOGIN
     WHERE LOGIN.USERNAME = USERNAME;

    IF(tUSERNAME IS NOT NULL AND cLOCK != 1) THEN
        DBMS_OUTPUT.PUT_LINE('로그인 성공');

        INSERT INTO LOGIN_LOG VALUES(tUSERNAME, SYSDATE);

        UPDATE LOGIN SET LOGIN_LOCK = 0 WHERE LOGIN.USERNAME = USERNAME;
    ELSIF(cLOCK = 1) THEN
        DBMS_OUTPUT.PUT_LINE('계정 잠금으로 접속 불가');
    ELSE
        DBMS_OUTPUT.PUT_LINE('로그인 실패');

        INSERT INTO LOGIN_LOG VALUES(tUSERNAME, SYSDATE);

        IF(tCOUNT <= 3) THEN
             UPDATE LOGIN
               SET TRY_CNT = TRY_CNT + 1
             WHERE LOGIN.USERNAME = USERNAME;
        ELSE
            DBMS_OUTPUT.PUT_LINE('접속 4번 실패로 계정이 잠금 상태가 되었습니다');

            UPDATE LOGIN
               SET LOGIN_LOCK = 1
             WHERE LOGIN.USERNAME = USERNAME;
        END IF;
    END IF;

    COMMIT;
END;

INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES('홍길동', '1a2b');
INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES('김길동', '2a3b');
INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES('서길동', '3a4b');
INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES('진길동', '4a5b');


SELECT * FROM LOGIN;

BEGIN
    LOGIN_PROC('홍길동', '1a2b');
END;
