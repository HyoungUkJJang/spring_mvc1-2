package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // 레스트 컨트롤러는 문자열을 리턴하면 바로 스트링이 반환됨 일반적인 컨트롤러는 뷰이름으로 반환되어 뷰리졸버를 실행
public class LogTestController {

    // @Slf4J 를 쓰면 선언 안해도 로그를 쓸수있다.
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("log-test")
    public String logTest(){

        String name = "Spring";

       // log.trace("trace log = {}, {}", name, "Spring2");
        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.info("info log = {} ", name);
//        log.info("info log = " + name);

        log.warn("warn log = {}", name);
        log.error("error log= {} ",name);

        return "ok";
    }

}
