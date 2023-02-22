package pl.coderslab.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.playuser.PlayUser;

import java.awt.print.Book;
import java.util.List;

@Controller
public class UserController {
    private final UserDao userDao;

    public
    UserController(UserDao userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/user/add")

    public String addUserForm(Model model) {
        User predefinedUser = new User();
        model.addAttribute("user", predefinedUser);
        return "/user/add";
    }

    @PostMapping("/user/add")
    public String addUser(User user, Model model) {
        userDao.saveUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User user = userDao.findById(id);
        userDao.delete(user);
        return "redirect:/user/list";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable long id, Model model) {
        User userToEdit = userDao.findById(id);
        model.addAttribute("userToEdit", userToEdit);
        return "/user/edit";
    }

    @PostMapping("/user/edit/save/{id}")
    public String editUser(User user, @PathVariable long id) {
        user.setId(id);
        userDao.update(user);
        return "redirect:/user/list";
    }

    @GetMapping("/user/list")
    public String listPlayUser(Model model) {
        List<User> users = userDao.findAll();
        model.addAttribute("users", users);
        return "/user/list";
    }

    @GetMapping("/user/results/{id}")
    public String results(@PathVariable int id, Model model){
        User user = userDao.findById(id);
        List<PlayUser> userPlays = userDao.results(user);
        model.addAttribute("userPlays", userPlays);
        return "/user/userPlays";
    }

}

