/*
 * 다음의 테이블을 생성한다.
 *     - 회원 테이블 : 회원으로 가입된 사용자의 정보가 기록되는 테이블
 *     - 회원 요청 테이블 : 회원 가입을 위해 가입 요청을 한 사용자의 정보가 기록되는 테이블
 *     - 접속 이력 테이블 : 로그인 및 로그아웃한 회원의 접속 시간을 기록하기 위한 테이블
 *
 * 1. 회원 가입 요청에는 최소한 "닉네임"과 "이메일" 정보가 필요합니다.
 * 2. 관리자가 회원 가입을 승낙하면 회원 가입 요청 테이블의 데이터를 기반으로 회원 테이블의
 *    데이터가 생성됩니다.
 * 3. 회원 테이블의 데이터가 생성될 때 초기 패스워드로 "samplepassword" 가 저장되야 합니다.
 * 4. 회원은 닉네임과 패스워드를 사용하여 로그인을 할 수 있으며 로그인 기록은 접속 이력 테이블에
 *    저장되야 합니다.(로그아웃도 접속 이력 테이블에 저장되야 합니다.)
 * 5. 접속 이력 정보는 최소한 누가, 언제 접속했는지 또는 접속을 해제 했는지 기록될 수 있어야 합니다.
 * 6. 회원 테이블에 최근 로그인 날짜를 기록하여 로그인을 할 때 마다 "n 일 만에 다시 접속하셨습니다."
 *    또는 "n 개월 만에 다시 접속하셨습니다." 와 같은 정보가 생성될 수 있게 합니다.
 */
CREATE TABLE ACCOUNTS(
       ID NUMBER PRIMARY KEY
     , NICKNAME VARCHAR2(50) UNIQUE
     , EMAIL VARCHAR2(75) UNIQUE
     , PASSWORD VARCHAR2(100) NOT NULL
     , LOGINDATE DATE
);

CREATE SEQUENCE SEQ_ACCOUNTS NOCACHE;

CREATE TABLE REQ_ACCOUNTS(
       ID NUMBER PRIMARY KEY
     , NICKNAME VARCHAR2(50) UNIQUE
     , EMAIL VARCHAR2(75) UNIQUE
     , ISALLOWED CHAR(1) DEFAULT('P') CHECK(ISALLOWED IN ('N', 'Y', 'P'))
     , REQDATE DATE DEFAULT(SYSDATE)
);

CREATE SEQUENCE SEQ_REQ_ACCOUNTS NOCACHE;

CREATE TABLE ACCOUNT_ACCESS_LOGS(
       ID NUMBER PRIMARY KEY
     , AID NUMBER REFERENCES ACCOUNTS(ID)
     , LOGTYPE VARCHAR2(8) CHECK(LOGTYPE IN ('LOGIN', 'LOGOUT'))
     , LOGDATE DATE DEFAULT(SYSDATE)
);

CREATE SEQUENCE SEQ_ACCOUNT_ACCESS_LOGS NOCACHE;

/*
 * 회원 가입 요청 데이터 저장
 */
INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL)
     VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, '홍길동', 'hong@gmail.com');
INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL)
     VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, '최가영', 'choi@gmail.com');
INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL)
     VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, '이정후', 'lee@gmail.com');

SELECT * FROM REQ_ACCOUNTS;

/*
 * 회원 가입 승낙을 위한 회원 요청 데이터 조회
 */
SELECT ID
     , NICKNAME
     , EMAIL
     , ISALLOWED
  FROM REQ_ACCOUNTS
 WHERE ISALLOWED = 'P';

SELECT ID
     , NICKNAME
     , EMAIL
     , ISALLOWED
  FROM REQ_ACCOUNTS
 WHERE ISALLOWED = 'P'
   AND REQDATE BETWEEN TO_DATE('20221101') AND TO_DATE('20221201');

/*
 * 회원 가입 승낙 처리
 */
UPDATE REQ_ACCOUNTS
   SET ISALLOWED = 'Y'
 WHERE ISALLOWED = 'P'
   AND ID = 2;

UPDATE REQ_ACCOUNTS
   SET ISALLOWED = 'Y'
 WHERE ISALLOWED = 'P'
   AND ID IN (1, 3);

UPDATE REQ_ACCOUNTS
   SET ISALLOWED = 'Y'
 WHERE ISALLOWED = 'P'
   AND REQDATE BETWEEN TO_DATE('20221101') AND TO_DATE('20221202');

/*
 * 승낙 처리된 데이터를 회원으로 이전
 */
INSERT INTO ACCOUNTS(
    SELECT SEQ_ACCOUNTS.NEXTVAL
         , RA.NICKNAME
         , RA.EMAIL
         , 'samplepassword'
         , NULL
      FROM REQ_ACCOUNTS RA
      LEFT OUTER JOIN ACCOUNTS A
        ON RA.NICKNAME = A.NICKNAME
       AND RA.EMAIL = A.EMAIL
     WHERE RA.ISALLOWED = 'Y'
       AND A.ID IS NULL
);


/*
 * 회원이 로그인 요청을 할 때 닉네임과 암호를 확인 하기 위한 조회
 */
SELECT ID
     , NICKNAME
     , PASSWORD
     , LOGINDATE
  FROM ACCOUNTS
 WHERE NICKNAME = '최가영'
   AND PASSWORD = 'samplepassword';

SELECT COUNT(*)
  FROM ACCOUNTS
 WHERE NICKNAME = '최가영'
   AND PASSWORD = 'samplepassword';

/*
 * 회원 확인 후 최근 로그인 시간 기록(LOG 테이블 포함)
 */
UPDATE ACCOUNTS
   SET LOGINDATE = SYSDATE
 WHERE NICKNAME = '최가영'
   AND PASSWORD = 'samplepassword';

INSERT INTO ACCOUNT_ACCESS_LOGS VALUES(SEQ_ACCOUNT_ACCESS_LOGS.NEXTVAL
                                     , (SELECT ID FROM ACCOUNTS WHERE NICKNAME = '최가영'
                                          AND PASSWORD = 'samplepassword')
                                     , 'LOGIN', SYSDATE);

/*
 * 로그아웃 할 때 LOG 테이블에 기록
 */
INSERT INTO ACCOUNT_ACCESS_LOGS VALUES(SEQ_ACCOUNT_ACCESS_LOGS.NEXTVAL, 9, 'LOGOUT', SYSDATE);
SELECT * FROM ACCOUNT_ACCESS_LOGS;

/*
 * 로그인을 한 회원의 정보를 조회 할 때 몇 분 또는 몇 시간, 일, 개월, 년 만에
 * 접속을 했는지 포함하여 조회
 */
SELECT CASE WHEN BEFORE_HOUR = 0 THEN
                TO_CHAR(BEFORE_MINUTE) || '분'
            WHEN BEFORE_DAY = 0 THEN
                TO_CHAR(BEFORE_HOUR) || '시간 ' ||
                TO_CHAR(BEFORE_MINUTE - (BEFORE_HOUR * 60)) || '분'
            WHEN BEFORE_MONTH = 0 THEN
                TO_CHAR(BEFORE_DAY) || '일 ' ||
                TO_CHAR(BEFORE_HOUR - (BEFORE_DAY * 24)) || '시간 ' ||
                TO_CHAR(BEFORE_MINUTE - ((BEFORE_DAY * 24 + BEFORE_HOUR - BEFORE_DAY * 24) * 60)) || '분'
            WHEN BEFORE_YEAR = 0 THEN
                TO_CHAR(BEFORE_MONTH) || '개월'
            ELSE
                TO_CHAR(BEFORE_YEAR) || '년 ' ||
                TO_CHAR(BEFORE_MONTH - BEFORE_YEAR * 12) || '개월'
         END AS X
  FROM (SELECT FLOOR(SYSDATE - TO_DATE('20221113')) AS BEFORE_DAY
             , FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE('20221113'))) AS BEFORE_MONTH
             , FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE('20221113')) / 12) AS BEFORE_YEAR
             , FLOOR(TO_NUMBER(SYSDATE - TO_DATE('20221113')) * 24) AS BEFORE_HOUR
             , FLOOR(TO_NUMBER(SYSDATE - TO_DATE('20221113')) * 24 * 60) BEFORE_MINUTE
          FROM DUAL)
;

/*
 * 회원이 암호 변경 요청을 했을 때 암호를 변경하기 위한 수정 구문
 */

/*
 * 회원이 암호를 변경할 때 현재 사용했던 암호가 새로운 암호에 포함되지 않게 하기 위한 구문
 */






INSERT INTO ACCOUNTS(
    SELECT SEQ_ACCOUNTS.NEXTVAL
         , NICKNAME
         , EMAIL
         , 'samplepassword'
         , NULL
      FROM REQ_ACCOUNTS
     WHERE ISALLOWED = 'Y'
);



SELECT *
      FROM REQ_ACCOUNTS RA
      LEFT OUTER JOIN ACCOUNTS A
        ON RA.NICKNAME = A.NICKNAME
       AND RA.EMAIL = A.EMAIL
     WHERE RA.ISALLOWED = 'Y'
       AND A.ID IS NULL


       SELECT * FROM REQ_ACCOUNTS;
       SELECT * FROM ACCOUNTS;




