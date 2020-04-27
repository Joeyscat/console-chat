package fun.oook.webchat.controller;

import fun.oook.webchat.model.ChatMessage;
import fun.oook.webchat.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


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
    public ChatMessage chat(final ChatMessage message, final String token) {
        log.info("/chat : {}", message);

        chatService.saveMessage(message, token);

        return message;
    }


    // todo 加个机器人进来玩

}
