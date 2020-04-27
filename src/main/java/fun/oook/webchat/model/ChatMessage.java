package fun.oook.webchat.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhouYu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private Long id;

    private Long userId;

    private String content;

    private Date createdDate;

    private Integer msgType;

    private Integer roomId;
}
