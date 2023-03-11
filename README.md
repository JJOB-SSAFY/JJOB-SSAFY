# 🔥 프로젝트 진행 기간
2023.01.09(월) ~ 2023.02.17(금)  
SSAFY 8기 2학기 공통프로젝트 - JJOB-SSAFY

![image](https://user-images.githubusercontent.com/65005680/220629775-b367c63b-8d5c-4b36-9788-aa0898852276.png)

# 📜 JJOB-SSAFY 개요
싸피 누적 취업생 3486명!
개발자 채용시장에서 점점 커지는 싸피의 영향력을 반영!!!    
싸피생들만을 위한 채용 솔루션 서비스!!!          
기존 잡싸피에 이력서 관리, 화상면접 기능, 싸피 지원자 정보 카드, 채용결과
피드백 기능등이 추가된 서비스를 만들었습니다.


# 📦 서비스 구조도
![Untitled](https://user-images.githubusercontent.com/66864811/220613265-dee09370-fa52-4302-a4a1-b1217f118263.png)

# 🌊 erd
![jjob_ssafy_erd](https://user-images.githubusercontent.com/66864811/220617540-c775a42a-5866-4848-86ed-2053d4e629f3.png)

### [포팅매뉴얼](https://github.com/JJOB-SSAFY/JJOB-SSAFY/blob/main/exec/%ED%8F%AC%ED%8C%85_%EB%A7%A4%EB%89%B4%EC%96%BC.pdf)


# 🛠️ 서비스 기능
- webRTC를 통한 실시간 면접
- 자기소개서 관리
- 각 회사의 리뷰 (채용 프로세스를 진행한 싸피인들이 느낀 후기들)
- 지원자 카드 (인사 채용자가 지원자들을 한 눈에 파악할 수 있도록 지원자 정보를 카드로 정리)
- 서류 전형 피드백 기능 (서류 전형 탈락 시 어떤 이유로 탈락되었는지 인사 담당자가 작성할 수 있음)

# 🔧 주요 기술
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

# 📺 서비스 화면
### 로그인

![로그인_AdobeExpress (1)](https://user-images.githubusercontent.com/75572705/220621201-76864200-eb73-40b6-9fe0-3dc67cb486b8.gif)

### 메인페이지

![메인페이지_AdobeExpress (1)](https://user-images.githubusercontent.com/75572705/220621432-17cabff1-f786-41b7-b7ce-698baa72da3a.gif)

### 채용공고_리스트

![채용공고_리스트_AdobeExpress](https://user-images.githubusercontent.com/75572705/220621550-cafbc399-e047-449b-b39a-0f87e1e6cb61.gif)

### 내 정보 변경

![내_정보_변경_AdobeExpress](https://user-images.githubusercontent.com/75572705/220621755-ecae05e0-0779-40d4-b530-33d5777bdca7.gif)

### 이력서 작성

![이력서_작성_AdobeExpress](https://user-images.githubusercontent.com/75572705/220621830-c3f08c1d-b43e-4dc8-ba9b-ebb61ecd570c.gif)

### 이력서 수정

![이력서_수정_AdobeExpress](https://user-images.githubusercontent.com/75572705/220621886-82c2c0d6-c90c-41a3-91bf-5c8802a66c47.gif)

### 이력서 삭제

![이력서_삭제_AdobeExpress](https://user-images.githubusercontent.com/75572705/220621903-84b5f9b3-7115-4301-8350-5dae0cf05184.gif)

### 리뷰 리스트

![리뷰_리스트_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622008-47de6973-f5ac-4db7-97c4-58f48d9af75b.gif)

### 이력서 지원

![이력서지원_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622024-64534794-0173-468a-b859-2268118f6e3a.gif)

### 지원자 정보 (유저)

![지원자_정보__유저__AdobeExpress](https://user-images.githubusercontent.com/75572705/220622152-a1a73bb9-28bc-4217-8087-8102c6782069.gif)

### 지원자 정보 (회사, 관리자)

![지원자_정보__관리자__회사__AdobeExpress](https://user-images.githubusercontent.com/75572705/220622201-b988060e-41ae-417c-9dcd-2de012ba997a.gif)

### 회사 등록

![회원등록_회사__AdobeExpress](https://user-images.githubusercontent.com/75572705/220622249-c4769cc5-0632-4bd1-87d0-fc8b3223a14a.gif)

### 회원 등록

![회원등록_회원__AdobeExpress](https://user-images.githubusercontent.com/75572705/220622253-432fc901-9722-4d65-a383-0da8708d7298.gif)

### 합격

![합격_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622331-0888a083-f417-4b8d-ba5a-d9ddfcb53985.gif)

### 불합격

![불합격_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622376-b099bddb-ad0b-4696-a426-72b44d791dbc.gif)

### 유저 불합격 확인

![유저_불합격_확인_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622431-0bf605d7-5e07-45ed-832b-30c7d6480535.gif)

### 유저 합격 확인

![유저_합격확인_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622418-a90c4cfa-b617-4adf-97d2-39ca72bb0d35.gif)

### 면접 방 생성하기

![면접방생성하기_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622571-3d6b6a6f-78a8-483d-b1fa-023277df70ce.gif)

### 면접 화면

![면접화면_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622596-3b9ceb78-c741-4143-b76e-402ad67ee209.gif)

### 리뷰 쓰기

![리뷰쓰기_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622605-2834efc9-e4b9-436d-9631-ac1e5538f536.gif)

### 리뷰 확인

![리뷰_확인_AdobeExpress](https://user-images.githubusercontent.com/75572705/220622634-d716a469-2b50-4588-8885-244e91f37a28.gif)


# 폴더 구조
### Backend
```
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
```
### Frontend
```
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
```

### eslint, prettier
```
module.exports = {
	root: true,
	extends: [
		'plugin:vue/vue3-essential',
		'eslint:recommended',
		'@vue/eslint-config-prettier',
	],
	parserOptions: {
		ecmaVersion: 'latest',
	},
	env: {
		'vue/setup-compiler-macros': true,
	},
	rules: {
		'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
		'no-unused-vars': 'off',

		'prettier/prettier': [
			'error',
			{
				singleQuote: true,
				semi: true,
				useTabs: true,
				tabWidth: 2,
				trailingComma: 'all',
				printWidth: 80,
				bracketSpacing: true,
				arrowParens: 'avoid',
				endOfLine: 'auto',
			},
		],
	},
};

```
