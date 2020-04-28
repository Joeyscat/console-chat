package fun.oook.webchat.service;

import fun.oook.webchat.model.Login;
import fun.oook.webchat.model.Register;
import fun.oook.webchat.model.UserInfo;
import fun.oook.webchat.model.UserPass;
import fun.oook.webchat.util.IdUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2020/4/27
 */
@Service
public class UserService {

    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserPassService userPassService;

    public UserInfo register(final Register register) {
        final String email = register.getEmail();
        final String password = register.getPassword();

        final Long userId = IdUtils.longNumericId();
        final UserInfo userInfo = UserInfo.builder()
                .id(userId)
                .email(email)
                .userCode(IdUtils.shortId())
                .avatar("")
                .nickname("")
                .build();

        final UserPass userPass = UserPass.builder()
                .id(userId)
                .password(password)
                .userId(userId)
                .valid(1).build();

        userInfoService.insert(userInfo);
        userPassService.insert(userPass);

        return userInfo;
    }

    public UserInfo login(final Login login) {

        final UserInfo userInfo = UserInfo.builder().email(login.getUsername()).build();
        final UserInfo existsUser = userInfoService.select(userInfo);

        return existsUser;
    }
}
