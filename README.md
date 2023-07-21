# SpringBoot - MSA Project History

## 목차

1. [Discovery Server ( Eureka )](###Discovery-Server-생성-(Eureka))
2. [API Gateway 생성](###API-Gateway-생성)
3. [User Service 생성](###User-Service-생성)

---


### Discovery Server 생성 (Eureka)

```
서비스 정보
- port : 8761
- name : discovery-service
- localhost:8000 에서 Discovery Client 확인 가능

dependencies
- Eureka Server
- Lombok
```

---

  
### API Gateway 생성

```
서비스 정보
- port : 8000
- name : apigateway-service
- 추가한 micro service를 등록
- 추가된 micro service
    - (o) user-service 
    - (x) catalog-service
    - (x) order-service

dependencies
  - Netflix Eureka Client
  - Gateway
  - Lombok

```
### User Service 생성

```
서비스 정보
- eureka server에서 random port 지정
- localhost:8000/user-service/health-check 를 통해 접속 확인 가능


dependencies
  - Netflix Eureka Client
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - Spring Boot Devtools
  - MySQL Connector
  - Lombok
```

---

