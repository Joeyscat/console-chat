package fun.oook.webchat.mapper;

import fun.oook.webchat.model.ChatMessage;
import fun.oook.webchat.util.IdUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ChatMessageMapperTest {

    @Resource
    private ChatMessageMapper mapper;

    @Test
    void createChatMsg() {
        final ChatMessage msg = ChatMessage.builder()
                .id(Long.valueOf(IdUtils.longNumericId()))
                .userId(Long.valueOf(IdUtils.longNumericId()))
                .content("Hello")
                .createdDate(new Date())
                .msgType(1)
                .build();
        final int insert = mapper.insert(msg);
        System.out.println(insert);
        Assertions.assertEquals(1, insert);
    }

    @Test
    void selectChatMsgList() {
        final List<ChatMessage> chatMessages = mapper.selectAll();
        Assertions.assertNotNull(chatMessages);
//        chatMessages.forEach(System.out::println);
    }


    @Test
    void selectChatMsg() {
        final List<ChatMessage> chatMessages = mapper.selectAll();
        Assertions.assertNotNull(chatMessages);

        final long id = chatMessages.get(0).getId();
        final ChatMessage message = mapper.selectByPrimaryKey(id);
        System.out.println(message);
        Assertions.assertNotNull(message);
    }
}
