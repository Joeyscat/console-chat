package fun.oook.webchat.service;

import com.github.javafaker.Faker;
import fun.oook.webchat.model.ChatMessage;
import fun.oook.webchat.util.IdUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Locale;

@SpringBootTest
class ChatServiceTest {

    @Resource
    private ChatService chatService;

    private Faker faker = new Faker(Locale.CHINA);


    @Test
    void saveMessage() {
        final ChatMessage message = ChatMessage.builder()
                .id(IdUtils.longNumericId())
                .content(faker.book().title())
                .msgType(1)
                .userId(IdUtils.longNumericId())
                .createdDate(new Date(System.currentTimeMillis()))
                .build();
        final String token = IdUtils.numericId();
        chatService.saveMessage(message, token);
    }
}
