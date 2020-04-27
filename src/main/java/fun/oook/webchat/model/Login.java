package fun.oook.webchat.model;

import lombok.Data;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2020/4/27
 */
@Data
public class Login {
    private Long userId;

    private String password;
}
