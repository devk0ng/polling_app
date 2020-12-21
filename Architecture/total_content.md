#### 설계를 하며 진행하였던 모든 과정을 담은 자료입니다.



### 초기 설계

#### 기능 목록

: 가장 기본적인 기능들을 바탕으로 구성

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
* 조회에서는 원하는 내용을 바탕으로 검색 가능
* 설문 생성은 객관식, 주관식 두가지 타입으로 가능


**4. 추가 사항**

: 만약 위의 기능들을 구현하고 시간이 남을 경우 (아마 그러긴 힘들지 않을까..) 고려해둔 사항들

* 카테고리 별로 분류
* 설문 결과에 대해 다양한 형태의 그래프로 시각화

<br/>



#### 도메인 설계

**Class Diagram**

![1차본](https://user-images.githubusercontent.com/31160622/102178685-31e00880-3ee9-11eb-9bd5-d4761ac9e178.PNG)

: 초기에 위와 같이 생각하였으나 대답의 경우도 주관식과 객관식에 따라 다른 형태를 띄기에 수정이 필요하다고 느낌

<br/>


![2차본](https://user-images.githubusercontent.com/31160622/102178693-34daf900-3ee9-11eb-849c-e10c091a8872.PNG)

: 위와 같이 생각하였는데 현재로써 문제점이 눈에 뛰지는 않았으나 조금 이상하다는 느낌이 든다.... 

거기다 질문과 대답의 경우 상속을 이용하였는데 부모가 자식에게 상속할 어트리뷰트가 없을 것 같은데 상속으로 표현하는게 좋을지의 여부도 잘 모르겠다...

<br/>


![2차본_2](https://user-images.githubusercontent.com/31160622/102178697-373d5300-3ee9-11eb-8acd-afff004efb32.PNG)

: 상속을 제외한 상태로 구성을 해보았다. 위의 저녀석과 밑의 녀석 중 뭐가 나을까... 지금 생각하였을 때는 각각의 관계는 상속으로 표현할 수 있는 관계가 맞고 상속 시켜주는 어트리뷰트가 현재 없다하더라도 미래에 어떻게 될지 모르고 관계를 표현할 때에도 조금 더 좋다고 판단하여 현재는 상속을 이용하여 표현한 녀석을 선택.

<br/>


### 추가사항!

: 문제점을 발견! 회원이 설문을 만드는 데는 일대다 관계가 맞으나 회원이 설문을 투표하는 데에는 다대다 관계야! 

-> 투표를 위한 녀석을 따로 만들어주고 다대다 관계를 풀어줄 수 있게 수정

![최종클다](https://user-images.githubusercontent.com/31160622/102217070-6a023e00-3f1f-11eb-8976-aab6b8d922e6.png)

<br/>



#### 위의 Diagram 을 바탕으로 Attribute 를 추가한 class diagram
![class_Digram](https://user-images.githubusercontent.com/31160622/102184972-aa4bc700-3ef3-11eb-89c3-6f1ba7ed97e9.png)


<br/>


#### 현재까지 최종수정 본
![final_](https://user-images.githubusercontent.com/31160622/102294254-3c071300-3f8c-11eb-84df-af75a1116314.png)

<br/>



#### UI Design

: 전체적인 디자인은 일반적인 웹페이지 게시판의 형태를 띄고 있습니다. 

* 처음 접속화면

![ui1](https://user-images.githubusercontent.com/31160622/102196091-c3a83f80-3f02-11eb-95ad-eb2e1c6d31d7.PNG)

: 간단한 어플리케이션을 소개하는 문구를 메인으로 위와 같은 디자인을 생각하고 있습니다. 

<br/>


* 설문등록화면

![ui2](https://user-images.githubusercontent.com/31160622/102196149-d91d6980-3f02-11eb-9fc0-817bca218045.PNG)

: 객관식, 주관식을 선택해서 질문을 추가할 수 있으며 이를 바탕으로 등록

<br/>


* 설문목록 화면

![ui3](https://user-images.githubusercontent.com/31160622/102196162-db7fc380-3f02-11eb-9de6-f29bb4f89f67.PNG)

: 현재까지 등록된 설문 목록들을 볼 수 있으며 설문을 참여하지 않았을 경우 참여가, 참여하였을 경우 결과가 화면에 띄어집니다.

  또한 원하는 내용을 바탕으로 검색을 진행할 수 있습니다.
  
<br/>


* 메인화면 상단의 메뉴 (로그인 하였을 경우)

![ui5](https://user-images.githubusercontent.com/31160622/102196180-e0dd0e00-3f02-11eb-9e27-e094cae2e3ec.PNG)

: 위의 그림처럼 로그아웃과 내설문목록을 확인할 수 있습니다.

<br/>


* 메인화면 상단의 메뉴 (로그인 하지 않았을 경우)

![ui4](https://user-images.githubusercontent.com/31160622/102196175-de7ab400-3f02-11eb-95d6-11f448f2a159.PNG)

: 위의 그림처럼 로그인과 회원가입을 확인할 수 있습니다.

<br/>


* 회원가입

![ui6](https://user-images.githubusercontent.com/31160622/102196191-e5a1c200-3f02-11eb-818e-965ac095c4a8.PNG)

: 회원가입에 필요한 사항을 입력한 후 간단하게 username 중복검사만 거친 후 회원가입을 진행할 수 있습니다.

<br/>



* 로그인

![ui7](https://user-images.githubusercontent.com/31160622/102196206-e9cddf80-3f02-11eb-9610-c13b6bfb3765.PNG)

: 로그인화면입니다!

<br/>


***



### 피드백 ( 리뷰 시간을 진행하며 받았던 피드백 )
1) 관계를 나타내기 위해 존재하는 클래스가 불필요한 속성을 가지고 있다
2) 주관식, 객관식의 결정을 위한 자료형을 boolean타입으로 진행할 경우 2가지로 제한적이게 된다
3) 관계가 정확하지 않은 것들이 보여 한번 더 확인이 필요하다
4) UI 디자인에 있어 React의 컴포넌트 개념에 따라 설계,디자인 하는 것이 좋을 것 같다
5) 설문검색 등은 우선 제외하고 구현하는 것이 좋지 않을까 생각함

<br/>



### 수정사항
1) Member와 Survey의 관계를 나타내기 위해 존재하는 Vote의 멤버 수정
2) 주관식, 객관식에 있어 이를 위한 자료의 자료형을 boolean에서 enum으로 수정
3) 불필요해 보이던 관계 (상속으로 복잡하게 보였던 부분) 제거
4) 객관식에 대해 각 목록별 count속성을 두어 조금 더 편리하게 관리할 수 있도록 수정
5) 설문내용 검색을 요구사항에서 제거
6) UI의 경우 React의 컴포넌트 개념을 잡고 재디자인할 것으로 생각

***

<br/>



## 수정사항을 반영한 재설계


#### 요구사항


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



#### 도메인 설계 

![real_final_class](https://user-images.githubusercontent.com/31160622/102601860-12084900-4164-11eb-8c39-e8a683be1131.png)

<br/>



### Database 설계

<br/>

#### E-R Diagram

![er](https://user-images.githubusercontent.com/31160622/102334220-c4f46d80-3fd1-11eb-8b25-775612282bb9.png)

<br/>



#### Database Schema

: 해당 E-R Diagram을 바탕으로 구성한 데이터베이스 스키마

![revised_schema](https://user-images.githubusercontent.com/31160622/102472416-a22d8c00-4099-11eb-8ab7-0480dae88a92.png)


*** 

<br/>


### 피드백
1) ER-Diagram이 눈에 바로 들어오지 않는다
2) React의 깊은 공부 보다는 UI 설계에 들어가고 구현을 진행하여야 한다 

<br/>


### 수정사항
1) 설문삭제 기능을 제거
2) React 의 컴포넌트 개념 바탕으로 UI 설계
3) 일대일 관계중 다대다 관계로 표현해야 할 부분들 수정 ( 질문과 대답에 대한 관계 )
4) ER-Diagram의 fk 지정에 있어 방향이 잘못된 부분 수정
5) 조금 더 한눈에 들어오는 스타일로 ER-Digram 재생성
6) UI 디자인에 있어 최대한 간단하게 진행하기위해 초기와는 다르게 UI 수정 ( 로그인 -> 기능이용으로 로그인이 가장 먼저 보이는 페이지로 수정)

***

<br/>

## 수정사항을 반영한 재설계 (현재)

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
