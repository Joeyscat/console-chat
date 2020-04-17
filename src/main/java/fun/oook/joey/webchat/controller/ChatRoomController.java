package fun.oook.joey.webchat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2019/3/2 10:19
 */
@Controller
//@RequestMapping("/chat-room")
@Slf4j
public class ChatRoomController {


    @GetMapping("/console")
    public String consoleChatRoom(HttpServletRequest request) {
        log.info(request.getLocalAddr());
        return "/console-chat-room";
    }
}
