package fun.oook.joey.webchat.model;

import lombok.Data;

import java.util.Date;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2019/3/2 11:40
 */
@Data
public class ReplyMessage {

    private String content;

    private Date date;
}
