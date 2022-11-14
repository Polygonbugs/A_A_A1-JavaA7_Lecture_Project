/*
 *  지출내역서(가계부)를 위한 테이블을 만들어 본다.
 *      - 테이블 이름은 '지출내역서'로 한다.
 *      - 컬럼은 ID, 지출날짜, 출입구분, 금액, 비고로 만들어 사용한다.
 *      - 비고의 경우 한글 100자 까지 저장 가능하게 한다.
 *      - 출입구분은 '출', '입'만 사용가능하게 한다.
 *      - ID는 해당 Record를 식별하기 위한 식별자로 사용할 것이다.
 */

CREATE TABLE 지출내역서  (
    ID VARCHAR2(10 CHAR) PRIMARY KEY,
    지출날짜 DATE,
    출입구분 CHAR(1 CHAR) CHECK(출입구분 in('출', '입')),
    금액 NUMBER DEFAULT(4500),
    비고 VARCHAR(100 CHAR)
);

SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = '지출내역서';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '지출내역서';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = '지출내역서';

INSERT INTO 지출내역서 VALUES('점심식사', '20221114', '출', 9500, '점심 가격이 너무 비싸다');
INSERT INTO 지출내역서(ID, 지출날짜, 비고) VALUES('저녁식사', '20221114', '저녁 가격이 너무 싼데');
INSERT INTO 지출내역서 VALUES('점심식사', '20221114', '사', 9500, '점심 가격이 너무 비싸다');
INSERT INTO 지출내역서 VALUES(NULL, '20221114', '입', 9500, '점심 가격이 너무 비싸다');

DELETE FROM 지출내역서 WHERE ID = '점심식사';

SELECT * FROM 지출내역서;
DROP TABLE 지출내역서;

