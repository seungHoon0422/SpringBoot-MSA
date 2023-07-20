# SpringBoot-MSA

## Micro Service Architecture 구현

### #1 Discovery Server 생성 (Eureka)

- port : 8761
- name : discovery-service
- localhost:8000 에서 Discovery Client 확인 가능
  
### #2 API Gateway 생성

- port : 8000
- name : apigateway-service
- 추가한 micro service를 등록
- 추가된 micro service
    - (o) user-service 
    - (x) catalog-service
    - (x) order-service
 

### #3 user-service 생성

- eureka server에서 random port 지정
- localhost:8000/user-service/health-check 를 통해 접속 확인 가능

