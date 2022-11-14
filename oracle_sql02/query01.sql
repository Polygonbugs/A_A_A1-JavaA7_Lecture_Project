/*
 *   DDL
 *      - 데이터 정의어로 데이터를 저장하고 다루기 위한 객체를
 *        생성하고(CREATE), 수정하고(ALTER), 삭제하는(DROP)하는 구문을 말한다.
 *      - ORACLE에서 사용하는 객체들로는 TABLE, VIEW, SEQUENCE, USER,
 *        PROCEDUAL, FUNCTION 등이 있다.
 */

/*
 *   CREATE TABLE
 *      - 테이블 객체를 생성하기 위한 구문
 *
 *   CREATE TABLE <테이블명> ( [] : 생략가능, <> : 필수작성
 *      <컬럼명> <데이터타입> [제약조건]
 *     ,<컬럼명> <데이터타입> [제약조건]
 *     ....
 *  );
 *
 *  데이터 타입
 *      - CHAR(크기) : 고정 크기(바이트) 문자 데이터, 최대 2000 바이트 저장가능
 *        CHAR(크기 CHAR) : 문자를 기준으로 크기를 설정
 *      - VARCHAR2(크기) : 가변 크기(바이트) 문자 데이터, 최대 4000 바이트 저장가능
 *                        한글은 3 바이트 -> 크기가 10이면 한글은 3자만 쓸 수 있다.
 *        VARCHAR2(크기 CHAR) : 문자를 기준으로 크기를 설정
 *      - NUMBER : 숫자 데이터(최대 40자리)
 *      - NUMBER(길이) : 숫자 데이터, 길이 지정 가능
 *      - NUMBER(길이, 자릿수) : 숫자 데이터, 소수점 자릿수까지 지정
 *      - DATE : 날짜 데이터
 *      - TIMESTAMP : 타임스탬프 데이터
 *      - LOB : 가변길이 바이너리 데이터, 최대 2GB 까지 저장 가능
 *      - LONG : 가변길이 문자 데이터, 최대 2GB 까지 저장 가능
 *      - BLOB : 대용량 데이터 저장용 객체, 4GB 까지 저장 가능 (바이너리 데이터)
 *      - CLOB : 대용량 데이터 저장용 객체, 4GB 까지 저장 가능 (문자 데이터)
 *
 *  제약 조건
 *      NOT NULL : NULL 데이터 저장을 허용하지 않음
 *      UNIQUE : 중복값 저장을 허용하지 않음 (NULL값은 중복해서 들어갈 수 있다)
 *      PRIMARY : NULL, 중복값 저장을 모두 허용하지 않음(Record의 고유 식별값<식별하는 값>으로 사용하기 위해)
 *      FOREIGN KEY : 참조하는 테이블의 컬럼의 값이 존재하면 허용(외래키 : 다른 테이블의 값을 참조하여 관계를 형성)
 *      CHECK : 지정한 값만 저장할 수 있음
 *      DEFAULT : 기본값을 설정하여 데이터 추가 작업에 누락이 되어 있어도 기본값이 저장되게 한다.
 *                제약 조건은 아니지만 제약조건이 작성되는 부분에 사용되어서 여기에 작성함.
 *
 *      위의 제약 조건을 위반하는 데이터 추가/수정/삭제 작업이 이루어지느 경우 "제약조건 위반"이라는 에러가 발생하게 된다.
 *      이로 인해 데이터에 대한 무결성 보장을 수행할 수 있게 된다.
 */

-- 처음 크기를 지정할 때부터 데이터 크기를 잡아두어야 한다.
SELECT LENGTHB('가나다') FROM DUAL;

CREATE TABLE TEST1_T (
      COL_NAME1 NUMBER                      PRIMARY KEY
    , COL_NAME2 CHAR(10 CHAR)               CHECK(COL_NAME2 IN('A', 'B', 'C'))
    , COL_NAME3 VARCHAR2(10 CHAR)
    , COL_NAME4 DATE                        DEFAULT(SYSDATE)
);

SELECT * FROM TEST1_T;

SELECT * FROM USER_ALL_TABLES;
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = 'TEST1_T';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TEST1_T';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TEST1_T';

INSERT INTO TEST1_T VALUES(2, 'C', '1', TO_DATE(20221114));
INSERT INTO TEST1_T(COL_NAME1, COL_NAME2, COL_NAME3) VALUES(1, '1', '1');
INSERT INTO TEST1_T VALUES(1, NULL, NULL, DEFAULT);

INSERT INTO TEST1_T VALUES(NULL, NULL, NULL, NULL);
INSERT INTO TEST1_T VALUES(1, NULL, NULL, NULL);

-- INSERT INTO TEST1_T VALUES (2, '한글데이터', '한글데이터를입력해봅시다', NULL);
-- INSERT INTO TEST1_T VALUES (2, '한글데이터를입력해봅시다', '한글데이터', NULL);

DROP TABLE TEST1_T;
