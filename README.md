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



**3. 기타 요구사항**
* 설문 생성은 객관식, 주관식 두가지 타입으로 가능



**4. 기술 사항**
* Spring boot
* Jpa
* Mysql
* React

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

![revised_schema](https://user-images.githubusercontent.com/31160622/102718796-762a3900-432d-11eb-88d1-1ebadf800e5d.png)

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
* PollingList (파란색) : 설문목록들을 나타내는 것을 담당하는 컴포넌트

**2. component구조**

* Mainpage
  * PollingList

**3. 추가 설명**

1) 우측상단의 버튼들을 통해 화면이동 가능. My 버튼의 경우 드롭다운 형태로 위 그림과 같은 메뉴들이 존재
2) 설문목록들의 컨텐츠들은 클릭가능이며 만약 투표를 하였을 경우 결과화면으로, 하지 않았을 경우 투표화면으로 이동
3) 로그아웃은 클릭 시 로그아웃과 동시에 가장 처음 보이는 화면인 로그인화면으로 이동

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
    * ObjectiveVote
    * SubjectiveVote

**3. 추가 설명**

1) 객관식에 대한 답변을 할 수 있는 내용들을 상단에 먼저 띄운 후 하단에 주관식에 대한 내용들을 띄울 것 (데이터를 불러와 화면에 나타낼 때 편의를 위해)
2) 완료버튼을 클릭 시 설문목록으로 화면이동


<br/>



### PollingResult 화면

<img width="789" alt="설문결과" src="https://user-images.githubusercontent.com/31160622/102717658-0c0e9580-4327-11eb-84ec-a0b62f55edf9.PNG">



**Short Description**

: 설문목록 화면에서 투표를 한 컨텐츠를 클릭하였을 때 이동하는 설문결과 화면.

<br/>

**Detail Description**

**1. Component**

* Mainpage (노란색) : 로그인 성공 후 화면구성에 대해 전체 틀을 담당하는 컴포넌트
* Result (파란색) : 결과내용들을 담기 위한 틀을 담당하는 컴포넌트
* ObjectiveResult (초록색) : 객관식 결과에 대한 내용들을 나타내기 위한 컴포넌트
* SubjectiveReuslt (빨간색) : 주관식 결과에 대한 내용들을 나타내기 위한 컴포넌트

**2. component구조**

* Mainpage
  * Result
    * ObjectiveResult
    * SubjectiveResult

**3. 추가 설명**

1) 객관식에 대한 결과들을 상단에 먼저 띄운 후 하단에 주관식에 대한 내용들을 띄울 것 (투표화면과 같은 이유에서)
2) 돌아가기 버튼을 클릭 시 설문목록으로 화면이동



<br/>



### MakePolling 화면

<img width="786" alt="설문만들기" src="https://user-images.githubusercontent.com/31160622/102717861-4b89b180-4328-11eb-91b0-6402268eac91.PNG">



**Short Description**

: 오른쪽 상단의 MakePolling 버튼을 클릭시 이동하는 설문생성 화면.

<br/>

**Detail Description**

**1. Component**

* Mainpage (노란색) : 로그인 성공 후 화면구성에 대해 전체 틀을 담당하는 컴포넌트
* Making (파란색) : 질문내용들을 담기 위한 틀을 담당하는 컴포넌트
* ObjectiveMake (초록색) : 객관식 질문 대한 내용들을 나타내기 위한 컴포넌트
* SubjectiveMake (빨간색) : 주관식 질문에 대한 내용들을 나타내기 위한 컴포넌트

**2. component구조**

* Mainpage
  * Making
    * ObjectiveMake
    * SubjectiveMake

**3. 추가 설명**

1) 우측 상단의 Make Polling 버튼을 통해 들어올 수 있는 화면이며 설문생성을 담당
2) 객관식 질문의 경우 추가 버튼을 통해 보기들을 추가 가능
3) subjective 버튼을 통해 주관식 질문 추가를, objective 버튼을 통해 객관식 질문 추가가능
4) 취소를 할 경우 설문에 대한 저장 없이 목록화면으로, 완료를 할 경우 설문에 대한 내용들을 저장 후 목록화면으로 이동


<br/>



### MyPolling 화면

<img width="788" alt="내가만든설문" src="https://user-images.githubusercontent.com/31160622/102717933-b33ffc80-4328-11eb-8b8c-3dcf40b12c6d.PNG">



**Short Description**

: 오른쪽 상단의 My버튼 클릭시 dropdown 되는 메뉴 중 My Polling을 클릭하여 이동하는 내가 생성한 설문목록들을 위한 화면

<br/>

**Detail Description**

**1. Component**

* Mainpage (노란색) : 로그인 성공 후 화면구성에 대해 전체 틀을 담당하는 컴포넌트
* PollingList (파란색) : 설문목록들을 나타내는 것을 담당하는 컴포넌트


**2. component구조**

* Mainpage
  * PollingList

**3. 추가 설명**

: 전체적인 구조는 설문목록과 동일하나 회원정보를 바탕으로 그 회원이 생성한 설문목록들을 보여준다는 차이점이 존재하는 화면



<br/>



### VotingList 화면

<img width="787" alt="내가투표한설문" src="https://user-images.githubusercontent.com/31160622/102718009-1598fd00-4329-11eb-9651-acbd5ef3493f.PNG">



**Short Description**

: 오른쪽 상단의 My버튼 클릭시 dropdown 되는 메뉴 중 Voting List을 클릭하여 이동하는 내가 투표한 설문목록들을 위한 화면

<br/>

**Detail Description**

**1. Component**

* Mainpage (노란색) : 로그인 성공 후 화면구성에 대해 전체 틀을 담당하는 컴포넌트
* PollingList (파란색) : 설문목록들을 나타내는 것을 담당하는 컴포넌트


**2. component구조**

* Mainpage
  * PollingList

**3. 추가 설명**

: 전체적인 구조는 설문목록과 동일하나 회원정보를 바탕으로 그 회원이 투표한 설문목록들을 보여준다는 차이점이 존재하는 화면
