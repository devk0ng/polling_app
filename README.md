## 요구사항 설계


**1. 회원 기능**
* 회원 등록 (회원가입)
* 로그인
* 로그아웃


**2. 설문기능**
* 설문 생성
* 설문 전체 목록 조회
* 설문 조회 (자신이 생성한 것)
* 설문 조회 (자신이 투표한 것)
* 설문 실시
* 설문 삭제


**3. 기타 요구사항**
* 설문 생성은 객관식, 주관식 두가지 타입으로 가능

<br/>


## 구조 설계


#### 도메인 설계 (JPA)

![real_final_class](https://user-images.githubusercontent.com/31160622/102716198-9a7e1980-431d-11eb-9e11-ace1aa1ca301.png)

: JPA에서는 JDBC를 사용했을 때와 달리 연관 관계에 있는 상대 테이블의 PK를 멤버변수로 갖지 않고, 엔티티 객체 자체를 통째로 참조해

<br/>



### Database 설계

<br/>

#### E-R Diagram

![er](https://user-images.githubusercontent.com/31160622/102334220-c4f46d80-3fd1-11eb-8b25-775612282bb9.png)

<br/>



#### Database Schema

: 해당 E-R Diagram을 바탕으로 구성한 데이터베이스 스키마

![revised_schema](https://user-images.githubusercontent.com/31160622/102472416-a22d8c00-4099-11eb-8ab7-0480dae88a92.png)

<br/>



#### ERD - MYSQL WORKBENCH VERSION

![sqlworkbench_erd](https://user-images.githubusercontent.com/31160622/102716226-cac5b800-431d-11eb-9aad-fec82b19ffda.PNG)

<br/>
