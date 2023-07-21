# SpringBoot - MSA Project History

## 목차


- [#4 Place Micro Service 생성](#place-service-생성)
- [#3 User Service 생성](#user-service-생성)
- [#2 API Gateway 생성](#api-gateway-생성)
- [#1 Discovery Server ( Eureka )](#discovery-server-생성-eureka)

---

### Place Service 생성

```
서비스 정보
- eureka server에서 random port 지정
- localhost:8000/place-service/health-check 를 통해 접속 확인 가능


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

  








