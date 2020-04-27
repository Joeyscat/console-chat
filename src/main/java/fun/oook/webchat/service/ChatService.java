package fun.oook.webchat.service;

import fun.oook.webchat.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2020/4/27
 */
@Service
public class ChatService {

    @Resource
    private ChatMessageService chatMessageService;

    public void saveMessage(final ChatMessage chatMessage){

        chatMessageService.insert(chatMessage);
    }
}
