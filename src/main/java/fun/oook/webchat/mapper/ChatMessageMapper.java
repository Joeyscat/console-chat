package fun.oook.webchat.mapper;

import fun.oook.webchat.model.ChatMessage;

import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2020/4/17 12:10
 */
public interface ChatMessageMapper {

    int createChatMsg(ChatMessage chatMessage);

    ChatMessage selectChatMsg(long id);

    List<ChatMessage> selectChatMsgList();

}
