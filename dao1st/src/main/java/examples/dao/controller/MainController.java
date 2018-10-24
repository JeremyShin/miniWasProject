package examples.dao.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {
    public MainController() {
        System.out.println("MainController()!");
    }

    // http://localhost:8080
    @RequestMapping("/")
    public String main() {
        return "index"; //view name을리턴. /WEB-INF/views/index.jsp로forword
    }
}
