package ir.iraniancyber.khaneshyar.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PageController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }

    @GetMapping("/moreViews")
    public String moreViews() {
        return "moreViews";
    }

    @GetMapping("/category")
    public String category() {
        return "category";
    }

    @GetMapping("/post")
    //@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String showExam() {
        return "post";
    }

    @GetMapping("/tag")
    public String tag() {
        return "tag";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/showExamQuestion")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String ShowExamQuestion() {
        return "showExamQuestion";
    }

    @GetMapping("/theNewestTests")
    public String theNewestTests() {
        return "theNewestTests";
    }

    @GetMapping("/403")
    public String accessDen() {
        return "403";
    }

    @GetMapping("/allExam")
    public String allExam() {
        return "theNewestTests";
    }

    @GetMapping("/startExam")
    public String startExam() {
        return "startExam";
    }
}
