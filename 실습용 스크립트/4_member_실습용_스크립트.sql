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

INSERT INTO MEMBER VALUES ('user01', 'pass01', '김진호', 'M', 'kim_jh@kh.or.kr', '010-1234-1234', '경기도 남양주시 지금동', '20', sysdate);
INSERT INTO MEMBER VALUES ('user02', 'pass02', '유병승', 'M', 'yoo_bs@kh.or.kr', '010-1234-1234', '경기도 시흥시 정왕동', '19', sysdate);
INSERT INTO MEMBER VALUES ('user03', 'pass03', '유정훈', 'M', 'yoo_jh@kh.or.kr', '010-1234-1234', '서울시 강남구 역삼동', '12', sysdate);
INSERT INTO MEMBER VALUES ('user04', 'pass04', '김동현', 'M', 'kim_dh@kh.or.kr', '010-1234-1234', '서울시 관악구 봉천동', '27', sysdate);
INSERT INTO MEMBER VALUES ('user05', 'pass05', '최범석', 'M', 'choi_bs@kh.or.kr', '010-1234-1234', '경기도 수원시 연무동', '20', sysdate);
INSERT INTO MEMBER VALUES ('user06', 'pass06', '노민수', 'M', 'no_ms@kh.or.kr', '010-1234-1234', '인천광역시 계양구 동양동', '20', sysdate);

COMMIT;