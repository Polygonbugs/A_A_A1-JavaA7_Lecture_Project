/*
 *      SEQUENCE 객체
 *          - 번호 발생기 객체
 *          - 정수값을 순차적으로 생성하는 객체
 *          - PRIMARY KEY로 사용하는 번호(ID)등에 사용하여 정수값을 생성하기 위한 용도로 많이 사용
 */

/* CACHE : 미리 생성할 정수값 수량*/
CREATE SEQUENCE SEQ1
          START WITH 10
      INCREMENT BY 10
       MAXVALUE 100
       MINVALUE -100
          CYCLE
          CACHE 10;

/* Start With 수정이 안된다.*/
ALTER SEQUENCE SEQ1
     INCREMENT BY 5
      MAXVALUE 250
      MINVALUE -100
       NOCYCLE
       NOCACHE;


DROP SEQUENCE SEQ1;

CREATE SEQUENCE SEQ_TEMP;
CREATE TABLE TEMP(
    ID NUMBER PRIMARY KEY
);
INSERT INTO TEMP VALUES(SEQ_TEMP.NEXTVAL);

UPDATE TEMP
SET ID = SEQ_TEMP.NEXTVAL
WHERE ID = 4;

SELECT * FROM TEMP;

SELECT SEQ1.NEXTVAL FROM DUAL;
-- Sequence 객체를 처음 만들자마자 실행하면 오류가 발생한다. Start With 10으로 시작해도 마찬가지이다.
SELECT SEQ1.CURRVAL FROM DUAL;