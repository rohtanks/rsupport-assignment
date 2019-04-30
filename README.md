# rsupport-assignment

빌드 및 실행 방법에 대한 설명입니다.

빌드를 위해서 STS 가 필요합니다.


1. 프로젝트 로컬 환경으로 임포트
  
2. Maven 빌드

  2-1. demo(프로젝트명) 우클릭
  
  2-2. Run As -> 5 Maven build...
  
  2-3. Goals: package -Dmaven.test.skip=true
       Profiles: 공란
       Run
  
  2-4. BUILD SUCCESS 확인

3. war 파일 실행

  3-1. 해당 경로 확인
  
  3-2. 동일 경로에서
       java -jar demo-0.0.1-SNAPSHOT.war
       
4. 웹 브라우저 확인

  4-1. localhost:8182/boads
