CREATE SEQUENCE SEQ_TEMP
          START WITH 5
      INCREMENT BY 10
       MAXVALUE 100
       MINVALUE -100
          CYCLE
        NOCACHE;

DROP SEQUENCE SEQ_TEMP;

CREATE TABLE TEST(
    TEST_COL NUMBER PRIMARY KEY
);

DROP TABLE TEST;


INSERT INTO TEST VALUES(SEQ_TEMP.nextval);

ALTER SEQUENCE SEQ_TEMP INCREMENT BY -50;

SELECT * FROM TEST;
