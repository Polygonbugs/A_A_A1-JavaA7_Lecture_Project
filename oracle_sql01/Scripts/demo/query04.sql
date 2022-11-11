/*
 *  함수
 *  - 단일 함수
 *      - 문자 함수 : 문자열에서 일부 문자열만 잘라내거나, 공백제거, 대소문자변환, 변경 등의 기능 제공
 *      - 숫자 함수 : 소수점에 처리를 위한 기능을 제공
 *      - 날짜 함수 : 날짜를 생성하거나 생성된 날짜에서 년, 월, 일 등의 정보를 처리하기 위한 기능 제공
 *      - 형변환 함수 : 문자를 숫자로, 숫자를 문자로, 날짜형식의 문자를 날짜로 + 날짜를 문자로
 *                   변환하기 위한 기능 제공
 *   - 그룹 함수 : 조회된 결과의 집합을 사용하여 총합 전체조회 레코드 수, 최대값, 최솟값 등의 기능 제공
 */

 /*
  * 문자 함수
  */

SELECT EMAIL
     , LENGTH(EMAIL) AS 문자열길이
  FROM EMPLOYEES;

SELECT JOB_ID
     , INSTR(JOB_ID, '_') AS "_언더바(_) 문자위치"
  FROM EMPLOYEES;

/*
 * SUBSTR(column name, startIndex, endIndex) : 한 컬럼에 있는 문자열 정보를 startIndex ~ endIndex 까지 자름
 */
SELECT JOB_ID
     , SUBSTR(JOB_ID, 0, 2) AS "접두사"
  FROM EMPLOYEES;

SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , UPPER(FIRST_NAME || ' ' || LAST_NAME) AS 대문자
     , LOWER(FIRST_NAME || ' ' || LAST_NAME) AS 소문자
     , INITCAP(FIRST_NAME || ' ' || LAST_NAME) AS "단어의 첫 문자만 대문자"
     , CONCAT(FIRST_NAME, LAST_NAME) AS 결합
 FROM EMPLOYEES;

SELECT EMAIL
    , LPAD(EMAIL, 20) AS "왼쪽에 패딩(공백) 추가"
    , RPAD(EMAIL, 20) AS "오른쪽에 패딩(공백) 추가"
    , LPAD(EMAIL, 20, 'x') AS "왼쪽에 패딩(x) 추가"
    , RPAD(EMAIL, 20, 'x') AS "왼쪽에 패딩(x) 추가"
  FROM EMPLOYEES;

SELECT TRIM(LPAD(EMAIL, 20)) AS "여백제거"
     , LTRIM(LPAD(EMAIL, 20, 'x'), 'x') AS "왼쪽에 있는 특정 문자 제거"
     , RTRIM(RPAD(EMAIL, 20, 'x'), 'x') AS "오른쪽에 있는 특정 문자 제거"
  FROM EMPLOYEES;

SELECT PHONE_NUMBER AS 전화번호
     , REPLACE(PHONE_NUMBER, '.', '-') AS 전화번호
FROM EMPLOYEES;

/*
 *  숫자 함수 (Dual은 테스트용 테이블이다)
 */

SELECT ABS(-10) AS 절대값
    , MOD(5, 2) AS 나머지
    , ROUND(12.345, 1) AS 반올림1
    , ROUND(12.356, 1) AS 반올림2
    , ROUND(12.345, 2) AS 반올림3
    , ROUND(12.356, 2) AS 반올림4
    , FLOOR(12.345) AS 버림1
    , FLOOR(12.745) AS 버림2
    , TRUNC(12.345, 1) AS 버림3
    , TRUNC(12.345, 2) AS 버림4
    , CEIL(12.345) AS 올림
  FROM DUAL;

/*
 * 날짜 함수
 */
 SELECT SYSDATE AS "시스템 날짜"
     , SYSTIMESTAMP AS "시스템 타임 스탬프"
     FROM DUAL;


/*
 *  한국 표준시가 제대로 나오지 않는다.
 */

SELECT EXTRACT(YEAR FROM SYSDATE) AS 년도
     , EXTRACT(MONTH FROM SYSDATE) AS 월
     , EXTRACT(DAY FROM SYSDATE) AS 일
     , EXTRACT(HOUR FROM SYSTIMESTAMP) AS 시
     , EXTRACT(MINUTE FROM SYSTIMESTAMP) AS 분
     , EXTRACT(SECOND FROM SYSTIMESTAMP) AS 초
  FROM DUAL;

SELECT ADD_MONTHS(SYSDATE, 1) AS "1개월 뒤"
     , ADD_MONTHS(SYSDATE, 2) AS "2개월 뒤"
     , ADD_MONTHS(SYSDATE, 3) AS "3개월 뒤"
    FROM DUAL;

SELECT LAST_DAY(ADD_MONTHS(SYSDATE, 1)) AS "12월 마지막 일자"
     , LAST_DAY(ADD_MONTHS(SYSDATE, 2)) AS "1월 마지막 일자"
     , LAST_DAY(ADD_MONTHS(SYSDATE, 3)) AS "2월 마지막 일자"
    FROM DUAL;

SELECT NEXT_DAY(SYSDATE, 1) AS "다음 일요일"
     , NEXT_DAY(SYSDATE, 2) AS "다음 월요일"
     , NEXT_DAY(SYSDATE, 3) AS "다음 화요일"
     , NEXT_DAY(SYSDATE, 4) AS "다음 수요일"
     , NEXT_DAY(SYSDATE, 5) AS "다음 목요일"
     , NEXT_DAY(SYSDATE, 6) AS "다음 금요일"
     , NEXT_DAY(SYSDATE, 7) AS "다음 토요일"
    FROM DUAL;

SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE, 5)) AS 개월차
    FROM DUAL;

SELECT SYSDATE AS "현재날짜"
     , SYSDATE + 10 AS "10일 뒤"
     , SYSDATE - 10 AS "10일 전"
     , SYSDATE + INTERVAL '15' DAY AS "15일 뒤"
     , SYSDATE - INTERVAL '15' DAY AS "15일 전"
     , SYSDATE + INTERVAL '5' MONTH AS "5개월 뒤"
     , SYSDATE - INTERVAL '5' MONTH AS "5개월 전"
     , SYSDATE + INTERVAL '2' YEAR AS "2년 뒤"
     , SYSDATE - INTERVAL '2' YEAR AS "2년 전"
    FROM DUAL;

SELECT SYSTIMESTAMP + INTERVAL '5' HOUR AS "5시간 뒤"
     , SYSTIMESTAMP - INTERVAL '5' HOUR AS "5시간 전"
     , SYSTIMESTAMP + INTERVAL '50' Minute AS "50분 뒤"
     , SYSTIMESTAMP - INTERVAL '50' Minute AS "50분 전"
     , SYSTIMESTAMP + INTERVAL '50' SECOND AS "50초 뒤"
     , SYSTIMESTAMP - INTERVAL '50' SECOND AS "50분 전"
    FROM DUAL;

/*
 *  형변환 함수
 *      TO_CHAR(숫자 또는 날짜값) : 문자 타입으로 변환
 *      TO_NUMBER(문자) : 숫자 타입으로 변환
 *      TO_DATE(숫자 또는 문자) : 날짜 타입으로 변환
 */
SELECT '문자타입'
     , 1234 AS 숫자타입
     , SYSDATE AS 날짜타입
  FROM DUAL;

SELECT TO_CHAR(100)
     , TO_CHAR(123.456)
     , TO_CHAR(SYSDATE)
     , TO_CHAR(123456, '999,999,999')
     , TO_CHAR(123456.789, '999,999.99999')
     , TO_CHAR(123456, '000,000,000')
    FROM DUAL;

SELECT TO_CHAR(SYSDATE)
     , TO_CHAR(SYSDATE, 'YYYYMMDD')
     , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS')
     , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS')
     , TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초" DY"요일"')
    FROM DUAL;

SELECT TO_NUMBER('1234')
     , TO_NUMBER('12.34')
     , TO_NUMBER('123,456', '999,999')
    FROM DUAL;

SELECT TO_DATE(20221111)
     , TO_DATE('20221111')
     , TO_DATE('2022-11-11')
     , TO_DATE('2022/11/11')
     , TO_DATE('2022.11.11')
     , TO_DATE('2022년 11월 11일', 'YYYY"년" MM"월" DD"일"')
    FROM DUAL;