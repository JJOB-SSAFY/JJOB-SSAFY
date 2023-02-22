# 프로젝트 진행 기간
2023.01.09(월) ~ 2023.02.17(금)
SSAFY 8기 2학기 공통프로젝트 - JJOB-SSAFY

# JJOB-SSAFY 개요
싸피 누적 취업생 3486명!
개발자 채용시장에서 점점 커지는 싸피의 영향력을 반영한 
싸피생 전용 채용 솔루션 서비스!!!
기존 잡싸피에 이력서 관리, 화상면접 기능, 싸피인 정보 카드, 채용결과
피드백 기능등이 추가된 서비스를 만들었습니다.


# 서비스 구조도
![Untitled](https://user-images.githubusercontent.com/66864811/220613265-dee09370-fa52-4302-a4a1-b1217f118263.png)

###erd
![jjob_ssafy_erd](https://user-images.githubusercontent.com/66864811/220617540-c775a42a-5866-4848-86ed-2053d4e629f3.png)

### 포팅매뉴얼(https://github.com/JJOB-SSAFY/JJOB-SSAFY/blob/main/exec/%ED%8F%AC%ED%8C%85_%EB%A7%A4%EB%89%B4%EC%96%BC.pdf)


# 서비스 기능
- webRTC를 통한 실시간 면접
- 자기소개서 관리
- 각 회사의 리뷰 (채용 프로세스를 진행한 싸피인들이 느낀 후기들)
- 지원자 카드 (인사 채용자가 지원자들을 한 눈에 파악할 수 있도록 지원자 정보를 카드로 정리)
- 서류 전형 피드백 기능 (서류 전형 탈락 시 어떤 이유로 탈락되었는지 인사 담당자가 적시할 수 있음)

# 주요 기술
### 🖱️Backend

- IntelliJ
- spring boot 2.7.7
- spring-boot-jpa
- Spring Security
- Querydsl
- Java 11
- AWS EC2
- mysql 5.7.35
- WebSocket

### 🖱️Frontend

- Visual Studio Code
- Vue.js 3 , Vite
- Node.js 16.19.0
- Vuetify
- SweetAlert
- Vuex
- Firebase 9.17.1
- Webstomp-Client 1.2.6
- Sock.js-Client 1.6.1

### 🖱️Web RTC

- openvidu 2.25

### 🖱️CI/CD

- aws ec2
- docker
- nginx
- jenkins

### 🖱️협업 툴

- Git
- Jira
- Mattermost
- Discord

### 🖱️기타 편의 툴

- postman

# 서비스 화면


#폴더 구조
### Backend
JJOB-SSAFY/
├── api/
│   ├── controller
│   ├── request/
│   │   └── resume
│   ├── response/
│   │   └── resume
│   └── service
├── common/
│   ├── auth
│   ├── exception
│   └── util
├── config
└── db/
    ├── entity/
    │   └── resume
    └── repository/
        └── resume
### Frontend
JJOB-SSAFY /
├── node_modules
├── public
└── src/
    ├── api
    ├── assets/
    │   ├── css
    │   ├── fonts
    │   └── images
    ├── common
    ├── router
    ├── store
    └── views/
        ├── login
        ├── main/
        │   ├── components
        │   ├── homepage
        │   ├── infoCards
        │   ├── interview
        │   ├── openvidu
        │   ├── presentation
        │   ├── recruit
        │   └── review
        ├── myInfo/
        │   └── resume
        └── register


