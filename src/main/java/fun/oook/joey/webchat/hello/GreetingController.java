package fun.oook.joey.webchat.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2019/3/1 23:06
 */
@Controller
@Slf4j
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        log.info("/hello");
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()));
    }
}
