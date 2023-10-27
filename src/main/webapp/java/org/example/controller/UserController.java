package src.main.webapp.java.org.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import src.main.webapp.java.org.example.domain.User;
import src.main.webapp.java.org.example.domain.UserActivityAccess;
import src.main.webapp.java.org.example.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    static private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/browse")
    public Model browse(Model model) {

        model.addAttribute("users", userService.getAllUsers());

        return model;
    }

    @GetMapping(value = "/editUser")
    @ModelAttribute
    public void getProduct(@RequestParam(required = false, defaultValue = "0") long productId, Model model) {

        if (productId > 0 && userService.getUser(productId) != null)

            model.addAttribute("users", userService.getUser(productId));
        else
            model.addAttribute("users", new User());
    }

    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid @ModelAttribute User user, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {

            for (var fieldError : bindingResult.getFieldErrors()) {
                LOGGER.info(fieldError.getField() + " " + fieldError.getDefaultMessage());
            }

            modelAndView.setViewName("/product/editUser");
            modelAndView.addObject("AccessDetail", new UserActivityAccess(user.getUserId()));

            return modelAndView;
        }


        long userId = user.getUserId();

        if (userId > 0 && userService.getUser(userId) != null) {

            userService.updateUser(userId,
                    user.getFirstname(),
                    user.getLastname(), user.getPhone(), user.getGender());

        } else {

            userService.addUser(user.getFirstname(),
                    user.getLastname(),
                    user.getPhone(), user.getGender());

        }

        modelAndView.addObject("users", userService.getAllUsers());

        modelAndView.setViewName("/users/browse");

        return modelAndView;
    }
}
