package fun.oook.webchat.controller;

import fun.oook.webchat.model.Login;
import fun.oook.webchat.model.Register;
import fun.oook.webchat.model.UserInfo;
import fun.oook.webchat.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserInfo> register(final Register register) {

        final UserInfo user = userService.register(register);

        return ResponseEntity.ok(user);
    }


//    @PostMapping("/login")
    public ResponseEntity<UserInfo> login(final Login login) {
        final UserInfo userInfo = userService.login(login);

        return ResponseEntity.ok(userInfo);
    }

}
