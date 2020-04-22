package fun.oook.webchat.mapper;

import fun.oook.webchat.model.ChatMessage;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

class ChatMessageMapperTest {

    private SqlSession session;
    private ChatMessageMapper mapper;

    @BeforeEach
    void setUp() throws IOException {
        final String resource = "config/mybatis-config.xml";
        final InputStream input = Resources.getResourceAsStream(resource);
        final SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);
        session = sessionFactory.openSession();
        mapper = session.getMapper(ChatMessageMapper.class);

    }

    @AfterEach
    void tearDown() {
        if (session != null) {
            session.close();
        }
    }

    @Test
    void createChatMsg() {
        final ChatMessage msg = ChatMessage.builder()
                .id(System.currentTimeMillis())
                .username("Joey")
                .content("Hello")
                .date(new Date())
                .msgType(1)
                .build();
        final int insert = mapper.createChatMsg(msg);
        System.out.println(insert);
        Assertions.assertEquals(1, insert);

        session.commit();
    }

    @Test
    void selectChatMsgList() {
        final List<ChatMessage> chatMessages = mapper.selectChatMsgList();
        Assertions.assertNotNull(chatMessages);
//        chatMessages.forEach(System.out::println);
    }


    @Test
    void selectChatMsg() {
        final List<ChatMessage> chatMessages = mapper.selectChatMsgList();
        Assertions.assertNotNull(chatMessages);

        final long id = chatMessages.get(0).getId();
        final ChatMessage message = mapper.selectChatMsg(id);
        System.out.println(message);
        Assertions.assertNotNull(message);
    }
}
