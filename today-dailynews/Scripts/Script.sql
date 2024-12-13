-- 스키마 생성
-- CREATE USER 스키마 이름 IDENTIFIED BY 비밀번호
CREATE USER NEWS IDENTIFIED BY 123456;

-- 시퀀스 생성
CREATE SEQUENCE user_id_seq;

-- 테이블 생성
CREATE TABLE USERS(
	USER_ID_seq NUMBER,
	NAME VARCHAR2(100),
	EMAIL VARCHAR2(150),
	SUB_PATH VARCHAR2(200)
); 

-- 테이블 삭제
DROP TABLE USERS;

-- 데이터 삽입
INSERT INTO users values (1,'김연희','mouse97_@naver.com', '인터넷 검색')

-- 출력
SELECT * FROM USERS;
SELECT count(*) FROM users;

-- 모든 테이블스페이스(tablespace)에 대한 권한을 부여
GRANT UNLIMITED TABLESPACE TO NEWS;
GRANT CREATE SESSION TO news;