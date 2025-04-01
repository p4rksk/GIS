package gis.RouteHistory;

import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class RouteHistoryController {
    private final RouteHistoryService routeHistoryService;
    private final HttpSession session;

}