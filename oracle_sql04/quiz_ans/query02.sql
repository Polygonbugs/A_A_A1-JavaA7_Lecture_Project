/*
 *  DEPARTMENTS 테이블과 LOCATIONS 테이블을 사용하여 각 부서가 어느 지역에
 *  위치하는지 알아보세요.
 */

SELECT D.DEPARTMENT_NAME
     , D.MANAGER_ID
     , L.LOCATION_ID
     , L.STREET_ADDRESS
     , L.POSTAL_CODE
     , L.CITY
     , L.STATE_PROVINCE
  FROM DEPARTMENTS D
  JOIN LOCATIONS L
    ON D.LOCATION_ID = L.LOCATION_ID
 ORDER BY 1;

/*
 * 지역별로 몇 개의 부서가 배치되었는지 알아내시오.
 */

SELECT COUNT(*)
     , L.LOCATION_ID
     , L.STREET_ADDRESS
     , L.POSTAL_CODE
     , L.CITY
     , L.STATE_PROVINCE
  FROM DEPARTMENTS D
  JOIN LOCATIONS L
    ON D.LOCATION_ID = L.LOCATION_ID
 GROUP BY L.LOCATION_ID
     , L.STREET_ADDRESS
     , L.POSTAL_CODE
     , L.CITY
     , L.STATE_PROVINCE;

/*
 *  지역별 사원수가 얼마나 되는지 알아보세요.
 */

SELECT COUNT(*) AS 인원수
     , L.LOCATION_ID
     , L.STREET_ADDRESS
     , L.POSTAL_CODE
     , L.CITY
     , L.STATE_PROVINCE
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
  JOIN LOCATIONS L
    ON D.LOCATION_ID = L.LOCATION_ID
 GROUP BY L.LOCATION_ID
     , L.STREET_ADDRESS
     , L.POSTAL_CODE
     , L.CITY
     , L.STATE_PROVINCE;

SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;