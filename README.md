# framework-demo-spring-session-redis

## Redis 세션 설정방법

1. pom.xml에 redis와 session 디렌던시를 추가한다.

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.session</groupId>
			<artifactId>spring-session-data-redis</artifactId>
		</dependency>
```

2. application.yml에 redis 접속 설정을 추가한다.
```
spring:
  redis:
    host: localhost
    port: 6379
```

3. 설정완료되었고, 세션에 애트리뷰트 등록하면 redis로 기록된다.

```
@RestController("/")
public class SampleController {

	@GetMapping("")
	public String index(HttpSession session) {
		session.setAttribute("name", "testname");
		return session.getId() + "Hello " + session.getAttribute("name");
	}
}
```
