//package spring.login;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import spring.foo.Foo;
//
//@Controller
//public class UserController {
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model) {
//        User user = new User();
//        user.setFirstName("barbar");
//        user.setLastName("barbar");
//
//        model.addAttribute("foo", user);
//        return "/login";
//    }
//
//    @RequestMapping(value = "/index", method = RequestMethod.POST)
//    public String processForm(@ModelAttribute(value = "foo") Foo foo) {
//        return "/index";
//
//
//    }
//}