# devkobe-hompage: 개인 기술 블로그 프로젝트

Java Spring Boot를 사용하여 개발 중인 개인 기술 블로그입니다. 이 프로젝트는 개발 경험과 학습 내용을 체계적으로 기록하고 공유하는 것을 목표로 합니다.

-----

## 🚀 주요 기능

요구사항 명세서에 따라 다음과 같은 기능들을 단계적으로 구현할 예정입니다:

  * **핵심 기능**:
      * Markdown을 지원하는 게시글 작성, 수정, 삭제 (CRUD)
      * 카테고리 및 태그 시스템
      * 소개(About), 포트폴리오 등 정적 페이지 관리
  * **사용자 경험 (UX)**:
      * 게시글 검색 (제목, 본문, 태그 기반)
      * 댓글 기능 (Giscus 등 외부 서비스 연동)
      * 다크 모드 및 반응형 UI 지원
  * **관리자 기능**:
      * 보안 인증을 통한 관리자 로그인
  * **SEO 및 확장성**:
      * 검색 엔진 최적화 (메타태그, 사이트맵)
      * RSS 피드 제공
      * Google Analytics 연동

-----

## 🛠️ 기술 스택

이 프로젝트는 다음의 기술 스택을 기반으로 구축됩니다:

| 구분      | 기술                               | 역할                              |
| :-------- | :--------------------------------- | :-------------------------------- |
| **Backend** | Java 17, Spring Boot 3.x           | 웹 프레임워크 및 비즈니스 로직    |
|           | Spring Data JPA                    | 데이터베이스 연동 및 관리         |
|           | Spring Security                    | 인증 및 보안                      |
| **Frontend**| Thymeleaf                          | 서버 사이드 템플릿 엔진           |
| **Database**| H2 (개발용), MySQL/PostgreSQL (운영용) | 데이터 저장소                     |
| **Build** | Gradle                             | 의존성 관리 및 빌드 자동화        |

-----

## 🏁 시작하기

### 사전 요구사항

  * Java 17 이상
  * IntelliJ IDEA 또는 Eclipse와 같은 IDE

### 프로젝트 실행 방법

1.  **저장소 복제:**

    ```bash
    git clone https://github.com/your-username/devkobe-hompage.git
    ```

2.  **애플리케이션 실행:**
    프로젝트 루트 디렉토리에서 아래의 Gradle 명령어를 실행합니다.

    ```bash
    ./gradlew bootRun
    ```

3.  **접속:**
    애플리케이션이 성공적으로 실행되면 웹 브라우저를 통해 `http://localhost:8080` 으로 접속할 수 있습니다.

-----

## 📖 프로젝트 구조

프로젝트는 표준 Spring Boot 디렉터리 구조를 따릅니다.

```
src/
└── main/
    ├── java/
    │   └── com/kobe/devkobehompage/  # 메인 패키지
    │       ├── controller/         # 웹 요청 처리
    │       ├── service/            # 비즈니스 로직
    │       ├── repository/         # 데이터 접근
    │       ├── entity/             # 데이터베이스 모델
    │       └── dto/                # 데이터 전송 객체
    └── resources/
        ├── static/                 # CSS, JS, 이미지 등 정적 파일
        ├── templates/              # Thymeleaf 템플릿 파일
        └── application.properties  # 애플리케이션 설정
```

-----

## 📜 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다.