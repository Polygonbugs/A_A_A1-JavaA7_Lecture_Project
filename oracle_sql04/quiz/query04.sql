/*
 *  가장 많은 사원수를 가지는 부서 TOP3를 구하세요
 */

 SELECT DEPARTMENT_ID
      , COUNT(*)
   FROM (SELECT E.DEPARTMENT_ID
              , COUNT(*)
          FROM EMPLOYEES E
          JOIN DEPARTMENTS D
            ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
         GROUP BY E.DEPARTMENT_ID
         ORDER BY COUNT(*) DESC);
    GROUP BY DEPARTMENT_ID;


 /*
  * 평균 급여가 가장 높은 부서 TOP3를 구하세요. (부서 ID와 부서명이 같이 조회될 수 있게 하세요.)
  */

/*
 *  가장 최근에 입사한 사우너 5명이 소속되어 있는 부서를 찾으세요.
 */

/*
 *  1990 ~ 1999년도에 입사한 사원들 중 가장 많은 급여를 받는 사원 5명을 찾으세요.
 */
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
