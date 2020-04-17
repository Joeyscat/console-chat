package fun.oook.webchat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2019/3/2 11:38
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    private long id;

    private String username;

    private String content;

    private Date date;

    private int msgType;
}
