package src.main.webapp.java.org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import src.main.webapp.java.org.example.domain.Activity;
import src.main.webapp.java.org.example.domain.User;
import src.main.webapp.java.org.example.domain.UserActivityAccess;
import src.main.webapp.java.org.example.service.UserService;

import java.util.List;

@Controller
@SessionAttributes("activity")
public class AddAccessController {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public Activity getActivity() {

        return new Activity();
        
    }

    @GetMapping("/addAccess")
    public String addAccess(Model model, @RequestParam(defaultValue = "0") long userId) {

        model.addAttribute("invoiceDetail", new UserActivityAccess(userId));
        model.addAttribute("product", userService.getUser(userId));

        return "addAccess";
    }

    @PostMapping("/addToAccessList")
    public String addToaccesslist(@ModelAttribute User user, UserActivityAccess userActivityAccess) {

        List<UserActivityAccess> userActivityAccessList = user.getAccessList();

        if (userActivityAccessList == null)
            userActivityAccessList = (List<UserActivityAccess>) new UserActivityAccess();

        userActivityAccessList.add(userActivityAccess);
        user.setAccessList(userActivityAccessList);

        return "/home";
    }


    @GetMapping("clearList")
    public String clearList(SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return "/home";
    }
}
