/*
 * 특정 직무에 대한 급여 테이블을 일정 퍼센트 상승 및 감소를 시킨 경우
 * JOBS 테이블의 MIN_SALARY, MAX_SALARY 컬럼의 값과
 * EMPLOYEES 테이블에 동일 직무를 부여 받은 사원의 SALARY 컬럼의 값을
 * 변경하는 PROCEDURE를 생성한다.
 *
 * 프로시저의 실행 결과로 몇개의 행이 반영되었는지 반환할 수 있게 한다.
 *
 * 매개변수는 재할당이 가능하지 않다. 매개변수의 문자형의 크기는 따로 지정해주지 않아도 된다.
 */

CREATE OR REPLACE PROCEDURE PROC_INC_JOB_SALARY(pJOB_ID IN VARCHAR2, pPERCENT IN NUMBER, )
IS
BEGIN

END;

