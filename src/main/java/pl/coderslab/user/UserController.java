package pl.coderslab.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        predefinedUser.setNickName("pionek");
        model.addAttribute("user", predefinedUser);
        return "/user/add";
    }

    @PostMapping("/user/add")
    @ResponseBody
    public String addUser(User user, Model model) {
        userDao.saveUser(user);
        return user.toString();
    }


//    @RequestMapping("/person/get/{id}")
//    @ResponseBody
//    public String getPerson(@PathVariable long id) {
//        Person person = personDao.findById(id);
//        return person.toString();
//    }
//
//    @RequestMapping("/person/delete/{id}")
//    @ResponseBody
//    public String deletePerson(@PathVariable long id) {
//        Person person = personDao.findById(id);
////        PersonDetails personDetails = personDetailsDao.findById(person.getDetails().getId());
////        personDetailsDao.delete(personDetails);
//        personDao.delete(person);
//        return "deleted";
//    }
//
//    @RequestMapping("/person/update/{id}/{login}")
//    @ResponseBody
//    public String updatePerson(@PathVariable long id, @PathVariable String login) {
//        Person person = personDao.findById(id);
//        person.setLogin(login);
//        personDao.update(person);
//        return person.toString();
//    }


}

