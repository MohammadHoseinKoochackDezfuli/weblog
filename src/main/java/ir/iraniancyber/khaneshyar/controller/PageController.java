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
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(){return "admin";}
    @GetMapping("/post")
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

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/updateTag")
    public String updateTag(){return "updateTag";}

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/updatePost")
    public String updatePost(){return "updatePost";}
}
