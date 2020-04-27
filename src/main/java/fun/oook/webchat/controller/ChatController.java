package fun.oook.webchat.controller;

import fun.oook.webchat.model.ChatMessage;
import fun.oook.webchat.model.UserInfo;
import fun.oook.webchat.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2019/3/2 10:29
 */
@Slf4j
@Controller
public class ChatController {

    @Resource
    private ChatService chatService;

    @MessageMapping("/room1")
    @SendTo("/topic/chat")
    public ChatMessage chat(final ChatMessage message, final HttpServletRequest req) {
        log.info("/chat : {}", message);
        final String sessionId = req.getSession().getId();
        final Long userId = userInfo(sessionId).getId();

        ChatMessage save = new ChatMessage();
        save.setContent(message.getContent());
        save.setUserId(userId);
        save.setCreatedDate(message.getCreatedDate() == null ? new Date(System.currentTimeMillis()) : message.getCreatedDate());

        chatService.saveMessage(save);

        return save;
    }

    private UserInfo userInfo(final String sessionId) {
        return UserInfo.builder().build();
    }

    // todo 加个机器人进来玩

}
