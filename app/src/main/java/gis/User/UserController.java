package gis.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    @PostMapping("/join")
    public String postMethodName() {
        // TODO: process POST request
        System.out.println("kakaoApiKey = " + kakaoApiKey);
        return "";
    }

    @GetMapping("/")
    public String getMethodName() {
        return "index";
    }

}