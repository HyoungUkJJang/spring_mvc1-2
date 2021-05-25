package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
//@RestController
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username,age);

        response.getWriter().write("ok");
    }

    @ResponseBody // 문자를 그대로 반환시킴
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge)
    {
        log.info("memberName={}, memberAge={}",memberName,memberAge);
        return "ok";
    }

    @ResponseBody // 문자를 그대로 반환시킴
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age) // 변수명과 파라미터 명을 동일하게 맞춰주면 생략가능
    {
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody // 문자를 그대로 반환시킴
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age)  // 그냥 다없애고 변수명만 맞춰주면 된다 단순타입일때 가능
    {
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    //필수로 값을 받고싶을떈 required를 쓴다.
    @ResponseBody // 문자를 그대로 반환시킴
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam(required = false) Integer age)  // 그냥 다없애고 변수명만 맞춰주면 된다 단순타입일때 가능
    {
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody // 문자를 그대로 반환시킴
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,
                                      @RequestParam(defaultValue = "-1") int age)  // 그냥 다없애고 변수명만 맞춰주면 된다 단순타입일때 가능
    {
        // 디폴트값은 빈문자를 보내도 기본값으로 세팅해줌
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody // 문자를 그대로 반환시킴
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap)  // 그냥 다없애고 변수명만 맞춰주면 된다 단순타입일때 가능
    {
        // 디폴트값은 빈문자를 보내도 기본값으로 세팅해줌
        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String moderAttributeV1(@ModelAttribute HelloData helloData) //자동화로 객체 생성
    {
        log.info("helloData {}",helloData);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String moderAttributeV2(HelloData helloData) // 이것도 애노테이션 생략가능
    {
        log.info("helloData {}",helloData);
        return "ok";
    }
}
