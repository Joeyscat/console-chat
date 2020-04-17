package fun.oook.joey.webchat.controller;

import fun.oook.joey.webchat.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;


/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2019/3/2 10:29
 */
@Slf4j
@Controller
public class ChatMessageController {

    @MessageMapping("/room1")
    @SendTo("/topic/chat")
    public ChatMessage chat(ChatMessage message) {
        log.info("/chat : {}", message);

        ChatMessage reply = new ChatMessage();
        reply.setContent(message.getContent());
        reply.setUsername(message.getUsername());
        reply.setDate(message.getDate() == null ? new Date(System.currentTimeMillis()) : message.getDate());

        return reply;
    }

    // todo 加个机器人进来玩

}
