SELECT * FROM EMPLOYEE WHERE EMP_ID = 999;

CREATE TABLE BOOK (
    BOOK_ID NUMBER PRIMARY KEY,
    TITLE VARCHAR2(50) NOT NULL,
    AUTHOR VARCHAR2(20) NOT NULL,
    PUBLISHER VARCHAR2(20) NOT NULL,
    PUBLISHER_DATE DATE NOT NULL,
    PRICE NUMBER NOT NULL
);

CREATE SEQUENCE SEQ
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCYCLE
NOCACHE;


INSERT INTO BOOK
VALUES (SEQ.NEXTVAL, 'ȫ�浿��', '���', 'Ȱ���', SYSDATE, 5000000);



