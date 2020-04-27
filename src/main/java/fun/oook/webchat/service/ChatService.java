package fun.oook.webchat.service;

import fun.oook.webchat.model.ChatMessage;
import fun.oook.webchat.model.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2020/4/27
 */
@Service
public class ChatService {

    @Resource
    private ChatMessageService chatMessageService;

    @Resource
    private UserInfoService userInfoService;

    public void saveMessage(final ChatMessage message, final String token) {

        final UserInfo userInfo = userInfo(token);

        ChatMessage save = new ChatMessage();
        save.setContent(message.getContent());
        save.setUserId(userInfo.getId());
        save.setCreatedDate(message.getCreatedDate() == null ? new Date(System.currentTimeMillis()) : message.getCreatedDate());

        chatMessageService.insert(message);
    }

    private UserInfo userInfo(final String token) {
        Assert.hasText(token, "token must be not null");

        return userInfoService.selectAll().get(0);
    }
}
