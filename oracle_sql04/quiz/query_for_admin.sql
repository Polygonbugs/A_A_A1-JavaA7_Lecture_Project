DROP USER DEV01 CASCADE;

/*
 *  web_admin 계정을 새로 만들고 필요한 권한을 설정 후
 *  web_admin 계정의 connection 정보를 생성 후 접속
 *  HQ_TABLE을 스크립트로 실행하여 테이블 및 데이터 추가
 *  EMPLOYEE 테이블을 확인하여 추가가 잘 되었는지 확인.
 */

CREATE USER web_admin identified by web_admin;

GRANT CONNECT, RESOURCE TO web_admin;
GRANT INSERT ANY TABLE, UPDATE ANY TABLE
    , DELETE ANY TABLE TO web_admin;
GRANT CREATE VIEW TO web_admin;

ALTER USER web_admin quota 10M ON USERS;

DROP USER web_admin cascade;

SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE = 'WEB_ADMIN';
SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'WEB_ADMIN';
SELECT * FROM ROLE_SYS_PRIVS WHERE ROLE IN ('CONNECT', 'RESOURCE');