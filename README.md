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



**4. 기술 사항**
Spring boot, Jpa, Mysql

<br/>


## 구조 설계


#### 도메인 설계 (JPA 기반 Entity 관계 설계)

![real_final_class](https://user-images.githubusercontent.com/31160622/102716198-9a7e1980-431d-11eb-9e11-ace1aa1ca301.png)

: JPA에서는 JDBC를 사용했을 때와 달리 연관 관계에 있는 상대 테이블의 PK를 멤버변수로 갖지 않고, 엔티티 객체 자체를 통째로 참조해

<br/>



### Database 설계

<br/>

#### E-R Diagram

![er (2)](https://user-images.githubusercontent.com/31160622/102717491-02d0f900-4326-11eb-9cf1-0ae048126454.png)


<br/>



#### Database Schema

: 해당 E-R Diagram을 바탕으로 구성한 데이터베이스 스키마

![revised_schema](https://user-images.githubusercontent.com/31160622/102472416-a22d8c00-4099-11eb-8ab7-0480dae88a92.png)

<br/>



#### ERD - MYSQL WORKBENCH VERSION

![sqlworkbench_erd](https://user-images.githubusercontent.com/31160622/102716226-cac5b800-431d-11eb-9aad-fec82b19ffda.PNG)

<br/>



## UI 설계



### Login 화면

<img width="790" alt="로그인" src="https://user-images.githubusercontent.com/31160622/102716445-59870480-431f-11eb-9627-84506e24dadb.PNG">

**Short Description**

: 접속시 가장 먼저 보이는 화면으로 로그인을 통해 설문기능을 사용할 수 있는 화면으로 이동할 수 있습니다. 

<br/>

**Detail Description**

**1. Component**

* Startpage (노란색) : 처음 로그인과 회원가입에 있어 전체 틀을 담당하는 컴포넌트
* Login (파란색) : User의 입력을 통한 로그인 또는 회원가입으로 이동할 수 있는 컴포넌트

**2. component구조**

* Startpage
  * Login

**3. 추가 설명**

: 존재하지 않는 회원정보일 경우 팝업창을 통해 알림. 존재하는 회원정보일 경우 Polling List를 볼 수 있는 화면으로 이동

<br/>



### Register 화면

<img width="787" alt="회원가입" src="https://user-images.githubusercontent.com/31160622/102716756-2e051980-4321-11eb-9107-189a18ead5e4.PNG">


**Short Description**

: 로그인화면에서 회원가입 버튼을 통해 이동하는 화면. 회원가입을 담당

<br/>

**Detail Description**

**1. Component**

* Startpage (노란색) : 처음 로그인과 회원가입에 있어 전체 틀을 담당하는 컴포넌트
* Register (파란색) : User의 입력을 통한 회원가입을 담당하는 컴포넌트

**2. component구조**

* Startpage
  * Register

**3. 추가 설명**

: 추가적으로 검증하는 부분(아이디 중복, 비밀번호 확인)은 존재하지 않으며 User에게서 입력받은 정보를 바탕으로 회원가입을 진행.

<br/>



### PollingList 화면

<img width="788" alt="설문목록" src="https://user-images.githubusercontent.com/31160622/102716855-cef3d480-4321-11eb-8385-44d66eb3fb0a.PNG">


**Short Description**

: 로그인 성공시 처음으로 보여지는 화면이자 설문목록들을 볼 수 있는 화면.

<br/>

**Detail Description**

**1. Component**

* Mainpage (노란색) : 로그인 성공 후 화면구성에 대해 전체 틀을 담당하는 컴포넌트
* PollingList (파란색) : User의 입력을 통한 회원가입을 담당하는 컴포넌트

**2. component구조**

* Mainpage
  * PollingList

**3. 추가 설명**

1) 우측상단의 버튼들을 통해 화면이동 가능. My 버튼의 경우 드롭다운 형태로 위 그림과 같은 메뉴들이 존재
2) 설문목록들의 컨텐츠들은 클릭가능이며 만약 투표를 하였을 경우 결과화면으로, 하지 않았을 경우 투표화면으로 이동

<br/>



### VotePolling 화면

<img width="789" alt="설문투표" src="https://user-images.githubusercontent.com/31160622/102717502-1f6d3100-4326-11eb-9db1-f07ac8bfc3e9.PNG">



**Short Description**

: 설문목록 화면에서 투표를 하지않은 컨텐츠를 클릭하였을 때 이동하는 설문투표 화면.

<br/>

**Detail Description**

**1. Component**

* Mainpage (노란색) : 로그인 성공 후 화면구성에 대해 전체 틀을 담당하는 컴포넌트
* Voting (파란색) : 투표내용들을 담기 위한 틀을 담당하는 컴포넌트
* ObjectiveVote (초록색) : 객관식 질문과 보기들을 나타내기 위한 컴포넌트
* SubjectiveVote (빨간색) : 주관식 질문과 그 해답을 입력받는 것을 위한 컴포넌트

**2. component구조**

* Mainpage
  * Voting
    * Objective

**3. 추가 설명**

1) 우측상단의 버튼들을 통해 화면이동 가능. My 버튼의 경우 드롭다운 형태로 위 그림과 같은 메뉴들이 존재
2) 설문목록들의 컨텐츠들은 클릭가능이며 만약 투표를 하였을 경우 결과화면으로, 하지 않았을 경우 투표화면으로 이동
