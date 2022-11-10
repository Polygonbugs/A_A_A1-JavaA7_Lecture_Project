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

