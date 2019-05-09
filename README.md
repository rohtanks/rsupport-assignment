# 빌드 및 실행

빌드 및 실행 방법에 대한 설명입니다.

빌드를 위해서 STS 가 필요합니다.


## 1. 프로젝트 로컬 환경으로 임포트

### 1-1. 메이븐 프로젝트 임포트

![스크린샷 2015-05-19 오전 7 21 35](https://user-images.githubusercontent.com/20741709/57005375-96662b00-6c12-11e9-9aac-d11577df9d22.png)

![스크린샷 2015-05-19 오전 7 28 55](https://user-images.githubusercontent.com/20741709/57005387-a4b44700-6c12-11e9-8f6a-5763951ac1e9.png)  
Import -> Maven -> Check out Maven Projects from SCM

![제목 없음](https://user-images.githubusercontent.com/20741709/57005496-73884680-6c13-11e9-8b9c-9b7f70404ea3.png)

Finish

## 2. Maven 빌드

  
###  2-1. demo(프로젝트명) 우클릭  

###  2-2. Run As -> Maven build...

<img width="674" alt="스크린샷 2019-05-01 오전 5 42 49" src="https://user-images.githubusercontent.com/20741709/56992132-52eccc00-6bd4-11e9-822a-9c06ddcbf378.png">

###  2-3. 해당 내용 작성 후 실행  

       Goals: package -Dmaven.test.skip=true |  
       
       Profiles: 공란 |  
       
       Run  
       
<img width="691" alt="스크린샷 2019-05-01 오전 5 32 06" src="https://user-images.githubusercontent.com/20741709/56992287-a7904700-6bd4-11e9-8e66-3ce4164f7041.png">


###  2-4. BUILD SUCCESS 확인 및 경로 확인  
<img width="807" alt="스크린샷 2019-05-01 오전 5 36 31" src="https://user-images.githubusercontent.com/20741709/56992277-a2cb9300-6bd4-11e9-88da-66aaeddd64b2.png">

## 3. war 파일 실행

###  3-1. 해당 경로 확인  

###  3-2. 동일 경로에서
       java -jar demo-0.0.1-SNAPSHOT.war
       
## 4. 웹 브라우저 확인

###  4-1. localhost:8182/boards  

###  4-2. login 정보
       ahram1/pw111  
       
###  4-3. 신규 계정 생성
       /members/regist
