/*
 * EMPLOYEES의 HIRE_DATE 열의 값을 +10년 하여 수정한다.
 */

UPDATE EMPLOYEES
SET HIRE_DATE = ADD_MONTHS(HIRE_DATE, 120);

/*
 *  JOBS 테이블과 동일한 구조의 KJOBS 테이블을 만들고 JOB_TITLE 열의 값을
 *  한글로 번역하여 수정한다.
 *  단, MIN_SALARY, MAX_SALARY 컬럼은 만들 필요 없음.
 */

SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'JOBS';

SELECT * FROM SYS.USER_TAB_COLUMNS WHERE TABLE_NAME = 'JOBS';
CREATE TABLE KJOBS(
       JOB_ID VARCHAR2(10)
     , JOB_TITLE VARCHAR2(35)
);

INSERT INTO KJOBS(
    SELECT JOB_ID
         , JOB_TITLE
      FROM JOBS
);

UPDATE KJOBS SET JOB_TITLE = '회장' WHERE JOB_ID = 'AD_PRES';
UPDATE KJOBS SET JOB_TITLE = '관리부서장' WHERE JOB_ID = 'AD_VP';
UPDATE KJOBS SET JOB_TITLE = '관리보조' WHERE JOB_ID = 'AD_ASST';
UPDATE KJOBS SET JOB_TITLE = '재무관리자' WHERE JOB_ID = 'FI_MGR';
UPDATE KJOBS SET JOB_TITLE = '회계사' WHERE JOB_ID = 'FI_ACCOUNT';
UPDATE KJOBS SET JOB_TITLE = '회계관리사' WHERE JOB_ID = 'AC_MGR';
UPDATE KJOBS SET JOB_TITLE = '공인회계사' WHERE JOB_ID = 'AC_ACCOUNT';
UPDATE KJOBS SET JOB_TITLE = '영업관리자' WHERE JOB_ID = 'SA_MAN';
UPDATE KJOBS SET JOB_TITLE = '영업담당자' WHERE JOB_ID = 'SA_REP';
UPDATE KJOBS SET JOB_TITLE = '구매담당자' WHERE JOB_ID = 'PU_MAN';
UPDATE KJOBS SET JOB_TITLE = '구매사무원' WHERE JOB_ID = 'PU_CLERK';
UPDATE KJOBS SET JOB_TITLE = '재고관리자' WHERE JOB_ID = 'ST_MAN';
UPDATE KJOBS SET JOB_TITLE = '재고담당자' WHERE JOB_ID = 'ST_CLERK';
UPDATE KJOBS SET JOB_TITLE = '배송담당자' WHERE JOB_ID = 'SH_CLERK';
UPDATE KJOBS SET JOB_TITLE = '개발자' WHERE JOB_ID = 'IT_PROG';
UPDATE KJOBS SET JOB_TITLE = '마케팅매니저' WHERE JOB_ID = 'MK_MAN';
UPDATE KJOBS SET JOB_TITLE = '마케팅담당자' WHERE JOB_ID = 'MK_REP';
UPDATE KJOBS SET JOB_TITLE = '인적자원담당자' WHERE JOB_ID = 'HR_REP';
UPDATE KJOBS SET JOB_TITLE = '홍보담당자' WHERE JOB_ID = 'PR_REP';
SELECT * FROM KJOBS;

/*
 *  DEPARTMENTS 테이블에 DEPARTMENT_NAME_KR 컬럼을 추가 후 DEPARTMENT_NAME을
 *  한글로 번역한 데이터가 수정되게 한다.
 */

ALTER TABLE DEPARTMENTS ADD DEPARTMENT_NAME_KR VARCHAR(30);

SELECT 'UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '' WHERE DEPARTMENT_ID = ' || DEPARTMENT_ID FROM DEPARTMENTS;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '관리부' WHERE DEPARTMENT_ID = 10;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '마케팅부' WHERE DEPARTMENT_ID = 20;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '구매부' WHERE DEPARTMENT_ID = 30;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '인사부' WHERE DEPARTMENT_ID = 40;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '운송/선적' WHERE DEPARTMENT_ID = 50;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = 'IT부' WHERE DEPARTMENT_ID = 60;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '홍보부' WHERE DEPARTMENT_ID = 70;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '영업부' WHERE DEPARTMENT_ID = 80;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '행정부' WHERE DEPARTMENT_ID = 90;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '재무부' WHERE DEPARTMENT_ID = 100;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '회계부' WHERE DEPARTMENT_ID = 110;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '재무회계' WHERE DEPARTMENT_ID = 120;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '법인세' WHERE DEPARTMENT_ID = 130;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '통제와 신용' WHERE DEPARTMENT_ID = 140;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '주주서비스' WHERE DEPARTMENT_ID = 150;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '이익' WHERE DEPARTMENT_ID = 160;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '생산' WHERE DEPARTMENT_ID = 170;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '건설' WHERE DEPARTMENT_ID = 180;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '계약' WHERE DEPARTMENT_ID = 190;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '운영' WHERE DEPARTMENT_ID = 200;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = 'IT지원' WHERE DEPARTMENT_ID = 210;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = 'NOC' WHERE DEPARTMENT_ID = 220;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = 'IT헬프데스크' WHERE DEPARTMENT_ID = 230;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '정부판매' WHERE DEPARTMENT_ID = 240;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '소매판매' WHERE DEPARTMENT_ID = 250;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '모집' WHERE DEPARTMENT_ID = 260;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '급여' WHERE DEPARTMENT_ID = 270;


/*
 * KJOBS 테이블에 한글로 번역한 직무 타이틀을 JOBS 테이블에 JOB_TITLE_KR 컬럼을
 * 추가 후 수정이 되도록 한다. (DEPARTMENTS 테이블처럼 하나의 테이블에 영문/한글이
 * 모두 들어가게 한다.) 모든 작업을 완료 후 KJOBS 테이블은 제거한다.
 */

ALTER TABLE JOBS ADD JOB_TITLE_KR VARCHAR2(30);
UPDATE JOBS
   SET JOB_TITLE_KR = (SELECT JOB_TITLE
                         FROM KJOBS
                        WHERE JOB_ID = JOBS.JOB_ID);

SELECT * FROM JOBS;

DROP TABLE KJOBS;

SELECT * FROM KJOBS;

/*
 *  JOBS 테이블에 다음의 데이터를 추가 한다. (JOB_TITLE_KR도 추가되어 있어야 함)
 *      JOB_ID      JOB_TITLE          MIN_SALARY      MAX_SALARY
 *      IT_ITRN     Intern Programmer  3200            3800
 *      SV_MGR      Service Manager    4000            10000
 *      SV_ENG      Server Engineer    6000            12000
 *      NT_MGR      Network Manager    5000            11000
 *      NT_ENG      Network Engineer   7000            13000
 */

INSERT INTO JOBS VALUES('IT_ITRN', 'Intern Programmer', 3200, 3800, '인턴 개발자');
INSERT INTO JOBS VALUES('SV_MGR', 'Service Manager', 4000, 10000, '서비스 매니저');
INSERT INTO JOBS VALUES('SV_ENG', 'Service Engineer', 6000, 12000, '서버 엔지니어');
INSERT INTO JOBS VALUES('NT_MGR', 'Network Manager', 5000, 11000, '네트워크 매니저');
INSERT INTO JOBS VALUES('NT_ENG', 'Network Engineer', 7000, 13000, '네트워크 엔지니어');

SELECT * FROM JOBS;
/*
 *  DEPARTMENTS 테이블에 다음의 데이터를 추가한다.(DEPARTMENT_NAME_KR도 추가되어 있어야 함)
 *      DEPARTMENT_ID       DEPARTMENT_NAME     MANAGER_ID      LOCATION_ID
 *      280                 Server              NULL            3000
 *      290                 Network             NULL            3000
 */

INSERT INTO DEPARTMENTS VALUES(
    (SELECT (MAX(DEPARTMENT_ID) + 10) FROM DEPARTMENTS)
    , 'Server'
    , NULL
    , 3000
    , '서버관리부'
);

INSERT INTO DEPARTMENTS VALUES(
    (SELECT (MAX(DEPARTMENT_ID) + 10) FROM DEPARTMENTS)
    , 'Network'
    , NULL
    , 3000
    , '네트워크관리부'
);

SELECT * FROM DEPARTMENTS;


/*
 *  새로 신설된 Server, Network 부서를 위한 인력을 충원하고 있는 것으로 가정하여 각 부서마다
 *  3명의 인원을 EMPLOYEES에 추가한다.
 *      - 초기에 모든 인원은 JOBS 테이블의 MIN_SALARY의 급여를 받는 것으로 한다.
 *      - Server, Network 부서에 인원을 추가할 때 반드시 1명의 부서장이 필요하기 때문에 인원 중 1명을
 *        부서장으로 만든다.(DEPARTMENTS 테이블의 MANAGER_ID를 설정한다.)
 *      - 부서장으로 선택된 인원은 JOBS 테이블의 MIN_SALARY 급여에서 +2000 상승된 급여로 받을 수 있게 데이터를 수정한다.
 */

INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '철수', '김', 'KCHUL', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'SV_MGR')
                    , 'SV_MGR', 280);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '영수', '박', 'PYOUNG', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'SV_ENG')
                    , 'SV_ENG', 280);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '강석', '이', 'LKANG', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'SV_ENG')
                    , 'SV_ENG', 280);


INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '주식', '강', 'KJU', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'NT_MGR')
                    , 'NT_MGR', 290);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '장원', '서', 'SJANG', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'NT_ENG')
                    , 'NT_ENG', 290);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '지원', '임', 'IJI', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'NT_ENG')
                    , 'NT_ENG', 290);


UPDATE DEPARTMENTS
   SET MANAGER_ID = (SELECT EMPLOYEE_ID
                       FROM EMPLOYEES
                      WHERE EMPLOYEES.DEPARTMENT_ID = 280
                        AND FIRST_NAME = '철수'
                        AND LAST_NAME = '김')
WHERE DEPARTMENT_ID = 280;

UPDATE DEPARTMENTS
   SET MANAGER_ID = (SELECT EMPLOYEE_ID
                       FROM EMPLOYEES
                      WHERE EMPLOYEES.DEPARTMENT_ID = 290
                        AND FIRST_NAME = '주식'
                        AND LAST_NAME = '강')
WHERE DEPARTMENT_ID = 290;

UPDATE DEPARTMENTS
   SET MANAGER_ID = (SELECT EMPLOYEE_ID
                       FROM EMPLOYEES
                      WHERE EMPLOYEES.DEPARTMENT_ID = 280
                        AND FIRST_NAME = '철수'
                        AND LAST_NAME = '김')
WHERE DEPARTMENT_ID = 280;

UPDATE DEPARTMENTS
   SET MANAGER_ID = (SELECT EMPLOYEE_ID
                       FROM EMPLOYEES
                      WHERE EMPLOYEES.DEPARTMENT_ID = 290
                        AND FIRST_NAME = '주식'
                        AND LAST_NAME = '강')
WHERE DEPARTMENT_ID = 290;


UPDATE EMPLOYEES
   SET SALARY = SALARY + 2000
WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID
                        FROM DEPARTMENTS
                        WHERE EMPLOYEES.DEPARTMENT_ID IN (280, 290));


SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID >= 207;

/*
 * 물가 상승분을 반영하여 모든 급여 정보를 수정하려고 한다.
 * JOBS 테이블과 EMPLOYEES 테이블의 모든 급여 정보를 기존보다 5% ~ 10% 상승시키도록 한다.
 *      - 급여가 4000 미만인 경우 10% 상승
 *      - 급여가 4000 이상 8000 미만인 경우 8% 상승
 *      - 급여가 8000 이상 12000 미만인 경우 6% 상승
 *      - 급여가 12000 이상인 경우 5% 상승
 *      - 정수 1번째 자리에서 절삭할 것. 예) 4333.333은 4330으로 절삭
 */

UPDATE JOBS
   SET (MIN_SALARY, MAX_SALARY) = (SELECT CASE WHEN MIN_SALARY < 4000 THEN TRUNC(MIN_SALARY * 1.1, -1)
                                               WHEN MIN_SALARY < 8000 THEN TRUNC(MIN_SALARY * 1.08, -1)
                                               WHEN MIN_SALARY < 12000 THEN TRUNC(MIN_SALARY * 1.06, -1)
                                               ELSE TRUNC(MIN_SALARY * 1.05)
                                            END AS MIN_SALARY
                                        , CASE WHEN MAX_SALARY < 4000 THEN TRUNC(MAX_SALARY * 1.1, -1)
                                               WHEN MAX_SALARY < 8000 THEN TRUNC(MAX_SALARY * 1.08, -1)
                                               WHEN MAX_SALARY < 12000 THEN TRUNC(MAX_SALARY * 1.06, -1)
                                               ELSE TRUNC(MAX_SALARY * 1.05)
                                            END AS MAX_SALARY
                                        FROM JOBS J
                                       WHERE J.JOB_ID = JOBS.JOB_ID);

SELECT * FROM JOBS;

UPDATE EMPLOYEES
   SET SALARY = (SELECT CASE WHEN SALARY < 4000 THEN TRUNC(SALARY * 1.1, -1)
                             WHEN SALARY < 8000 THEN TRUNC(SALARY * 1.08, -1)
                             WHEN SALARY < 12000 THEN TRUNC(SALARY * 1.06, -1)
                             ELSE TRUNC(SALARY * 1.05)
                        END AS MAX_SALARY
                  FROM EMPLOYEES E
                 WHERE E.JOB_ID = EMPLOYEE_ID);


SELECT TRUNC(1111, -1) FROM DUAL;
/*
 * 사내 공지를 위한 게시판 기능을 추가해야 한다. 다음의 요구사항에 맞추어 테이블을 생성하고
 * 첫번째 공지를 작성하도록 한다. (첫번째 공지는 모든 부서가 열람할 수 있게 한다.)
 *  - 공지 게시판은 부서별 공지와 전체 공지로 나누어져 운영되야 한다.
 *  - 전체 공지는 모든 부서가 확일할 수 있는 공지이며 부서별 공지는 지정한 부서에 소속된 사원만 볼 수 있는 공지이다.
 *  - 공지를 작성할 때 다음의 정보가 저장되어야 한다.
 *      번호, 제목, 내용, 작성일자, 부서ID
 */

CREATE TABLE NOTICE(
          ID NUMBER PRIMARY KEY
        , TITLE VARCHAR2(250) NOT NULL
        , CONTENT VARCHAR2(2000)
        , WRITEDATE DATE
        , DEPT_ID NUMBER
);

INSERT INTO NOTICE VALUES(1, '전체 공지입니다.', '모든 부서에서 확인할 수 있습니다.', SYSDATE, 0);

SELECT * FROM NOTICE;


/*
 *  사내 공지 게시판 테이블을 생성 후에 다음의 공지를 추가로 작성한다.
 *  - 모든 부섬나다 'xxx 부서만 확인할 수 있는 공지입니다' 라는 메시지를 추가한다.
 */

INSERT INTO NOTICE(
       SELECT ROWNUM + 1 AS ID
            , DEPARTMENT_NAME_KR || '부서 공지' AS TITLE
            , DEPARTMENT_NAME_KR || '부서만 확인할 수 있는 공지입니다.' AS CONTENT
            , SYSDATE AS WRITE_DATE
            , DEPARTMENT_ID AS DEPT_ID
       FROM DEPARTMENTS
);

SELECT * FROM NOTICE;


/*
 * 100 번 사원이 공지를 열람한다는 가정하에 100번 사원이 소속된 부서의 공지와 전체 공지가 보일 수 있는
 * SELECT 쿼리문을 작성하세요.
 */
SELECT *
  FROM NOTICE N
  LEFT OUTER JOIN EMPLOYEES E
    ON N.DEPT_ID = E.DEPARTMENT_ID
 WHERE E.EMPLOYEE_ID = 100
    OR N.DEPT_ID = 0;

/*
 *   공지 게시판에 중요도 기능을 추가하여 가장 중요한 공지가 가장 먼저 조회될 수 있도록 테이블을 수정하도록 한다.
 *      - 중요도는 1 ~ 5까지 사용할 수 있다.
 *      - 중요도를 설정하지 않으면 기본 3으로 저장되게 한다.
 *      - 전체 공지용으로 중요도 1 ~ 5 까지 총 5개의 공지 데이터를 추가한다.
 *      - 추가한 공지 데이터를 조회할 때 중요도 순으로 조회가 될 수 있도록
 *        SELECT 구문을 작성한다.
 */

ALTER TABLE NOTICE ADD ORD NUMBER(1) DEFAULT(3);
ALTER TABLE NOTICE ADD CONSTRAINTS NOTICE_ORD_CK CHECK(ORD BETWEEN 1 AND 5);

SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'NOTICE';

UPDATE NOTICE
   SET ORD = 1
 WHERE DEPT_ID = 0;

SELECT *
  FROM NOTICE N
  LEFT OUTER JOIN EMPLOYEES E
    ON N.DEPT_ID = E.DEPARTMENT_ID
 WHERE E.EMPLOYEE_ID = 100
    OR N.DEPT_ID = 0
 ORDER BY ORD, ID;

/*
 *  DEPARTMENTS 테이블에서 MANAGER_ID가 없는 부서는 삭제하도록 한다.
 *  NOTICE 테이블도 삭제할 부서의 공지사항이 삭제되도록 한다.
 *  1번문제
 *  1. DEPARTMENTS 테이블에서 MANAGER_ID가 없는 부서를 취득한다.
 *  2. 취득한 데이터를 제거하는 쿼리문을 작성한다. (서브 쿼리 이용)
 * --> 자식 레코드 문제는 내가 잘못 테이블을 중간에 집어 넣는 바람에 발생하게 됬다.
 *  2번문제
 *  1. 1번문제에서 취득한 부서 정보 데이터를 NOTICE 테이블에서 제거하는 쿼리문을 작성한다.
 *
 */

DELETE
FROM NOTICE
WHERE DEPT_ID IN (SELECT DEPARTMENT_ID
                  FROM DEPARTMENTS
                  WHERE MANAGER_ID IS NULL);

DELETE
  FROM DEPARTMENTS
 WHERE MANAGER_ID IS NULL;


/*
 *  EMPLOYEES 테이블의 COMMISSION_PCT가 NULL인 경우 0으로 수정한다.
 *  1. 수정한다 : UPDATE
 *  2. 개체 : EMPLOYEES
 *  3. 0으로 : SET COMISSION_PCT = 0
 *  3. WHERE : COMMISSION IS NULL
 */

 UPDATE EMPLOYEES
    SET COMMISSION_PCT = 0
  WHERE COMMISSION_PCT IS NULL;

/*
 *  EMPLOYEES 테이블의 MANAGER_ID 가 없는 사원은 DEPARTMENT_ID에 해당하는 부서 정보를 찾아서
 *  해당 부서의 MANAGER_ID 값이 EMPLOYEES 테이블의 MANAGER_ID가 되도록 수정한다.
 *  필드 값의 흐름을 먼저 파악하는 것이 중요하다.
 *  1. EMPLOYEES 테이블을 수정
 *  2. EMPLOYEES 테이블의 MANAGER_ID 값을 설정한다.
 *      2-1. DEPARTMENT_ID에 해당하는 부서 정보를 찾아서 해당 부서의 MANAGER_ID 값이 되도록
 *      WHERE E2.EMPLOYEE_ID = E.MANAGER_ID -> 1개 행을 만들기 위한 문법
 *  3. MANAGER_ID 가 없는 사원은
 */

UPDATE EMPLOYEES E
   SET E.DEPARTMENT_ID = (SELECT E2.DEPARTMENT_ID
                            FROM EMPLOYEES E2
                           WHERE E2.EMPLOYEE_ID = E.MANAGER_ID)
 WHERE E.DEPARTMENT_ID IS NULL;

/*
 *  EMPLOYEES 테이블의 DEPARTMENT_ID 가 없는 사원은 MANAGER_ID에 해당하는 사원 정보를 찾아서
 *  해당 사원의 DEPARTMENT_ID 값이 EMPLOYEES 테이블의 DEPARTMENT_ID가 되도록 수정한다.
 */

UPDATE EMPLOYEES E1
   SET E1.DEPARTMENT_ID = (SELECT E2.DEPARTMENT_ID
                             FROM EMPLOYEES E2
                            WHERE E2.EMPLOYEE_ID = E1.MANAGER_ID)
 WHERE E1.DEPARTMENT_ID IS NULL;
