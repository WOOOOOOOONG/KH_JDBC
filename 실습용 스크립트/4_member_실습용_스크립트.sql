DROP TABLE MEMBER;

CREATE TABLE MEMBER (
  MEMBER_ID VARCHAR2(30),
  MEMBER_PWD VARCHAR2(30),
  MEMBER_NAME VARCHAR2(30),
  GENDER VARCHAR2(10),
  EMAIL VARCHAR2(50),
  PHONE VARCHAR2(30),
  ADDRESS VARCHAR2(100),
  AGE NUMBER,
  ENROLL_DATE DATE
);

SELECT * FROM MEMBER;

INSERT INTO MEMBER VALUES ('user01', 'pass01', '����ȣ', 'M', 'kim_jh@kh.or.kr', '010-1234-1234', '��⵵ �����ֽ� ���ݵ�', '20', sysdate);
INSERT INTO MEMBER VALUES ('user02', 'pass02', '������', 'M', 'yoo_bs@kh.or.kr', '010-1234-1234', '��⵵ ����� ���յ�', '19', sysdate);
INSERT INTO MEMBER VALUES ('user03', 'pass03', '������', 'M', 'yoo_jh@kh.or.kr', '010-1234-1234', '����� ������ ���ﵿ', '12', sysdate);
INSERT INTO MEMBER VALUES ('user04', 'pass04', '�赿��', 'M', 'kim_dh@kh.or.kr', '010-1234-1234', '����� ���Ǳ� ��õ��', '27', sysdate);
INSERT INTO MEMBER VALUES ('user05', 'pass05', '�ֹ���', 'M', 'choi_bs@kh.or.kr', '010-1234-1234', '��⵵ ������ ������', '20', sysdate);
INSERT INTO MEMBER VALUES ('user06', 'pass06', '��μ�', 'M', 'no_ms@kh.or.kr', '010-1234-1234', '��õ������ ��籸 ���絿', '20', sysdate);

COMMIT;