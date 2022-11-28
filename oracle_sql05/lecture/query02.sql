/*
 *  VIEW 객체
 *      - SELECT 문의 실행 결과를 저장한 가상 테이블
 *      - 테이블과 다르게 실제 데이터를 저장하고 있지는 않다.
 *      - 실제 데이터를 저장하고 있지는 않지만 실제 테이블을 사용하는 것과 동일하게 사용 가능하다
 */

/* View는 강의에는 별로 쓰지 않는다.*/

/*복잡한 쿼리 문을 미리 만들어둬서 그것을 활용할 목적으로 사용하는 것이다*/

/* READ ONLY로 설정하여 데이터만 확인하는 용도로 사용할 수 있다 */
/* CREATE OR REPLACE :  없으면 새로 만들고 있으면 수정해라 */
/* FORCE : 조건에 맞지 않아도 강제로 VIEW를 만들 수 있게 한다. */
CREATE OR REPLACE FORCE VIEW V_EMP
AS
SELECT EMPLOYEE_ID AS EMP_ID
     , FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME
     , LOWER(EMAIL) || '@emp.co.kr' AS EMAIL
     , SALARY
     , MANAGER_ID
     , DEPARTMENT_ID AS DEPT_ID
  FROM EMPLOYEES
 WHERE MANAGER_ID BETWEEN 100 AND 110
  WITH CHECK OPTION;
/*WITH READ ONLY;*/

UPDATE V_EMP
SET MANAGER_ID = 130
WHERE EMP_ID = 101;

/* 데이터 베이스를 사용할 줄 모르는 일반인들에게 사용할 때 쓴다. READ ONLY 와 같이 쓰이는 옵션*/
SELECT * FROM V_EMP;

/*
 *  VIEW를 사용하여 INSERT, UPDATE, DELETE 작업을 할 수 있지만 다음의 경우에는
 *  사용을 할 수 없다.
 *      1. VIEW에 포함되지 않은 컬럼을 사용하는 경우
 *      2. VIEW에 포함되지 않은 컬럼 중 NOT NULL 제약조건이 있는 경우
 *      3. 산술 표현식으로 정의된 경우
 *      4. 그룹함수나 GROUP BY 절이 포함된 경우
 *      5. DISTINCT 키워드가 있는 경우
 *      6. JOIN을 사용하여 여러 테이블이 결합된 경우
 */


