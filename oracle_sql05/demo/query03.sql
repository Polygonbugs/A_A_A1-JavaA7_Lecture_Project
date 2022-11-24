/*
 *  INDEX(색인) 객체
 *      - SQL 명령문 중 조회에 대한 처리 속도를 향상시키기 위해서 사용
 *      - 조회 속도는 빨라지지만 INSERT, UPDATE, DELETE 작업이 자주 이루어지는 경우에는
 *        해당 작업에 대한 성능이 저하된다.
 *      - INDEX 객체를 위한 추가 저장 공간이 필요함. (색인을 위한 저장공간이다)
 *
 *  고유(UNIQUE) 인덱스
 *      - 중복 값이 포함될 수 없다.
 *      - PRIMARY KEY, UNIQUE 제약 조건을 생성하면 자동으로 설정됨
 *
 *  비고유(NONUNIQUE) 인덱스
 *      - 비번하게 사용되는 일반 컬럼을 대상으로 사용
 *      - 주로 조회 성능 향상을 위해 사용
 *
 *  단일(SINGLE) 인덱스
 *      - 한 개의 컬럼으로 구성한 인덱스
 *
 *  결합(COMPOSITE) 인덱스
 *      - 두 개 이상의 컬럼으로 구성한 인덱스
 *
 *  함수 기반(FUNCTION-BASED) 인덱스
 *      - SELECT 절이나 WHERE 절에 산술 계산식 / 함수식이 사용된 경우
 *
 */

/* PK 조건으로 조회하면 INDEX 사용하는 것이 빠르다 */

/*  비고유 인덱스(단일 인덱스) */
CREATE INDEX 인덱스명 ON 테이블명(컬럼명);

/*  고유 인덱스(단일 인덱스) */
CREATE UNIQUE INDEX 인덱스명 ON 테이블명(컬럼명);

/* 결합 인덱스 */
CREATE INDEX 인덱스명 ON 테이블명(컬럼명1, 컬럼명2);

/* 함수 기반 인덱스 */
CREATE INDEX 인덱스명 ON 테이블명(계산식 또는 함수식);

/* 인덱스 제거 */
DROP INDEX 인덱스명;

/*
 * 인덱스 재구성
 *      DELETE 작업으로 데이터가 제거된 경우 INDEX 색인 데이터는
 *      제거가 되어 있지 않기 때문에 이를 완전히 제거하고 다시
 *      INDEX 색인을 생성하기 위해 사용.
 */
ALTER INDEX 인덱스명 REBUILD;

/* 인덱스 설정 확인 */
SELECT * FROM USER_IND_COLUMNS
 WHERE INDEX_NAME = '인덱스명';

SELECT * FROM USER_IND_COLUMNS
 WHERE TABLE_NAME = '테이블명';

SELECT *
  FROM USER_IND_COLUMNS
 WHERE TABLE_NAME = 'EMPLOYEES';

SELECT *
  FROM USER_IND_COLUMNS
 WHERE TABLE_NAME = 'JOBS';