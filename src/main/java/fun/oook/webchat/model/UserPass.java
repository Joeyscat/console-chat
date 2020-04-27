package fun.oook.webchat.model;

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
public class UserPass {
    private Long id;

    private Long userId;

    private String password;

    private Integer valid;
}
