/*
 * 다음의 테이블을 생성한다.
 *  - 회원 테이블 : 회원으로 가입된 사용자의 정보가 기록되는 테이블
 *  - 회원 요청 테이블 : 회원 가입을 위해 가입 요청을 한 사용자의 정보가 기록되는 테이블
 *  - 접속 이력 테이블 : 로그인 및 로그아웃한 회원의 접속 시간을 기록하기 위한 테이블
 *
 *  1. 회원 가입 요청에는 최소한 "닉네임"과 "이메일" 정보가 필요합니다.
 *  2. 관리자가 회원 가입을 승낙하면, 회원 가입 요청 테이블의 데이터를 기반으로 회원 테이블의
 *     데이터가 생성됩니다.
 *  3. 회원 테이블의 데이터가 생성될 때 초기 패스워드로 "samplepassword"가 저장되야 합니다.
 *  4. 회원은 닉네임과 패스워드를 사용하여 로그인을 할 수 있으며 로그인 기록은 접속 이력 테이블에
 *    저장되야 합니다. (로그아웃도 접속 이력 테이블에 저장되야 합니다.)
 *  5. 접속 이력 정보는 최소한 누가, 언제 접속했는지 기록될 수 있어야 합니다.
 *  6. 회원 테이블에 최근 로그인 날짜를 기록하여 로그인을 할 때 마다 "n일 만에 다시 접속하셨습니다."
 *     또는 "n 개월 만에 다시 접속하셨습니다." 와 같은 정보가 생성될 수 있게 합니다.
 */

CREATE TABLE 회원테이블 (
      NICKNAME VARCHAR2(50) CONSTRAINT NICKNAME_COL_PK PRIMARY KEY
    , EMAIL VARCHAR2(50)
    , PASSWORD VARCHAR2(50) DEFAULT('samplepassword')
    , LOGIN_STATE NUMBER DEFAULT(0) CONSTRAINT LOGIN_STATE_COL_CK CHECK (LOGIN_STATE IN (0, 1))
    , LOGIN_SEQ NUMBER DEFAULT(0)
);

CREATE TABLE 회원요청테이블 (
      NICK VARCHAR2(50)
    , EMA VARCHAR2(50)
);

CREATE TABLE 접속이력테이블 (
      NICKNAME VARCHAR2(50) REFERENCES 회원테이블(NICKNAME)
    , LOGIN_LOG VARCHAR2(50)
    , LOGIN_DATE DATE
    , LOGIN_COUNT NUMBER DEFAULT(0)
);

CREATE SEQUENCE 로그인시퀀스 NOCACHE;

DELETE FROM 회원테이블;
DROP TABLE 회원테이블;
DELETE FROM 회원요청테이블;
DROP TABLE 회원요청테이블;
DELETE FROM 접속이력테이블;
DROP TABLE 접속이력테이블;




-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------

CREATE OR REPLACE PROCEDURE 회원가입(
      IN_NICKNAME IN VARCHAR2
    , IN_EMAIL IN VARCHAR2
)
IS
isAccountExist NUMBER;
BEGIN
/* 회원 가입 요청 데이터 저장 */
INSERT INTO 회원요청테이블 VALUES(IN_NICKNAME, IN_EMAIL);

/* 회원 가입 승낙을 위한 회원 요청 데이터 조회 */
/* COUNT로 해야한다고 한다. 표현을 다르개*/
SELECT COUNT(*)
  INTO isAccountExist
  FROM 회원테이블
 WHERE NICKNAME = (SELECT NICK
                     FROM 회원요청테이블
                    WHERE 회원요청테이블.NICK = IN_NICKNAME);

/* 회원 정보를 추가. 가입 후 바로 로그인*/
IF(ISACCOUNTEXIST = 0) THEN
    INSERT INTO 회원테이블(NICKNAME, EMAIL, LOGIN_STATE, LOGIN_SEQ) VALUES(IN_NICKNAME, IN_EMAIL, 1, 로그인시퀀스.NEXTVAL);
    DBMS_OUTPUT.PUT_LINE(IN_NICKNAME || '님 가입을 축하드립니다. 로그인 되었습니다');
ELSE
    DBMS_OUTPUT.PUT_LINE(IN_NICKNAME || '은 이미 존재하는 계정입니다. 다시 입력하세요');
END IF;

DELETE FROM 회원요청테이블 WHERE NICK = IN_NICKNAME;
END;

SELECT * FROM USER_ERRORS;

BEGIN
    회원가입('rnjs1', 'RNJS1@gmail.com');
END;

INSERT INTO 회원테이블(NICKNAME, EMAIL, LOGIN_STATE) VALUES('rnjs1', 'RNJS1@gmail.com', 0);
DELETE FROM 회원테이블;
SELECT * FROM 회원테이블;

-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------


SELECT NICKNAME, EMAIL
  FROM 회원테이블
 WHERE NICKNAME = 'rnjs1';

CREATE OR REPLACE PROCEDURE 로그인(
      IN_NICKNAME IN VARCHAR2
    , IN_PASSWORD IN VARCHAR2
)
IS
    isAccountExist NUMBER;
    isAccountMatch NUMBER;
    isAccountLogined NUMBER := 2;
    pLOGIN_DATE DATE;
BEGIN
    /* 회원 테이블에서 로그인 정보 대조 */
    SELECT COUNT(*)
      INTO isAccountExist
      FROM 회원테이블
     WHERE NICKNAME = IN_NICKNAME;

    IF(ISACCOUNTEXIST = 1) THEN
        SELECT COUNT(*)
          INTO ISACCOUNTMATCH
          FROM 회원테이블
         WHERE NICKNAME = IN_NICKNAME AND PASSWORD = IN_PASSWORD
         GROUP BY NICKNAME;

        SELECT LOGIN_STATE
          INTO ISACCOUNTLOGINED
          FROM 회원테이블
         WHERE NICKNAME = IN_NICKNAME AND PASSWORD = IN_PASSWORD;

        SELECT LOGIN_DATE
          INTO pLOGIN_DATE
          FROM 접속이력테이블
         WHERE NICKNAME = IN_NICKNAME AND LOGIN_COUNT = (SELECT LOGIN_SEQ FROM 회원테이블 WHERE 회원테이블.NICKNAME = IN_NICKNAME);
    ELSE
        DBMS_OUTPUT.PUT_LINE('계정이 존재하지 않습니다');
        RETURN;
    END IF;

    IF(isAccountMatch = 1 AND ISACCOUNTLOGINED = 0) THEN
        UPDATE 회원테이블 SET LOGIN_STATE = 1 WHERE NICKNAME = IN_NICKNAME;
        INSERT INTO 접속이력테이블 VALUES(IN_NICKNAME, '로그인 성공', SYSDATE, 로그인시퀀스.NEXTVAL);
        UPDATE 회원테이블 SET LOGIN_SEQ = 로그인시퀀스.CURRVAL WHERE NICKNAME = IN_NICKNAME;
        DBMS_OUTPUT.PUT_LINE('로그인에 성공했습니다');
        DBMS_OUTPUT.PUT_LINE('마지막 로그인 ' || FLOOR(TO_NUMBER(SYSDATE - PLOGIN_DATE) * 24 * 60) || '분 전');
    ELSIF(ISACCOUNTMATCH = 1 AND ISACCOUNTLOGINED = 1) THEN
        INSERT INTO 접속이력테이블 VALUES(IN_NICKNAME, '로그인 실패/타 지역에서 이미 로그인 됨', SYSDATE, 로그인시퀀스.NEXTVAL);
        UPDATE 회원테이블 SET LOGIN_SEQ = 로그인시퀀스.CURRVAL WHERE NICKNAME = IN_NICKNAME;
        DBMS_OUTPUT.PUT_LINE('로그인 실패. 이미 계정에 접속되어 있습니다');
    ELSE
        INSERT INTO 접속이력테이블 VALUES(IN_NICKNAME, '로그인 실패/계정정보 오류', SYSDATE, 로그인시퀀스.NEXTVAL);
        UPDATE 회원테이블 SET LOGIN_SEQ = 로그인시퀀스.CURRVAL WHERE NICKNAME = IN_NICKNAME;
        DBMS_OUTPUT.PUT_LINE('로그인 실패. 로그인 정보가 틀려 접속에 실패했습니다');
    END IF;

END;

SELECT * FROM USER_ERRORS;

BEGIN
    로그인('rnjs1', 'samplepassword');
END;

-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------
-- -------------------------------------


CREATE OR REPLACE PROCEDURE 로그아웃(
    IN_NICKNAME IN VARCHAR2
)
IS
    isAccountExist NUMBER;
    isAccountLogined NUMBER;
BEGIN
    /* 로그인 상태여부 확인*/
    SELECT COUNT(*)
      INTO isAccountExist
      FROM 회원테이블
     WHERE NICKNAME = IN_NICKNAME;

    IF(ISACCOUNTEXIST = 1) THEN
        SELECT LOGIN_STATE INTO ISACCOUNTLOGINED FROM 회원테이블 WHERE NICKNAME = IN_NICKNAME;
        /* 로그인 상태면 로그아웃*/
        IF(ISACCOUNTLOGINED = 1) THEN
            UPDATE 회원테이블 SET LOGIN_STATE = 0 WHERE NICKNAME = IN_NICKNAME;
            INSERT INTO 접속이력테이블 VALUES(IN_NICKNAME, '로그아웃 성공', SYSDATE, 로그인시퀀스.NEXTVAL);
            UPDATE 회원테이블 SET LOGIN_SEQ = 로그인시퀀스.CURRVAL WHERE NICKNAME = IN_NICKNAME;
            DBMS_OUTPUT.PUT_LINE(IN_NICKNAME || ' 계정이 로그아웃 되었습니다');
        ELSE
            DBMS_OUTPUT.PUT_LINE('계정이 로그인 되어 있지 않습니다');
        END IF;
    ELSE
        DBMS_OUTPUT.PUT_LINE('해당 계정은 존재하지 않습니다');
    END IF;
END;

SELECT * FROM USER_ERRORS;

BEGIN
    로그아웃('rnjs1');
END;

SELECT * FROM 회원테이블;
SELECT * FROM 접속이력테이블;