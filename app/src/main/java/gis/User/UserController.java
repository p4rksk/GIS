package gis.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final User userService;
    private final HttpSession session;

    @PostMapping("/join")
    public String postMethodName() {
        // TODO: process POST request

        return "";
    }

}