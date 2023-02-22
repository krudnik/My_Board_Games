package pl.coderslab.playuser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.game.Game;
import pl.coderslab.game.GameDao;
import pl.coderslab.play.Play;
import pl.coderslab.play.PlayDao;
import pl.coderslab.user.User;
import pl.coderslab.user.UserDao;

import java.util.List;

@Controller
public class PlayUserController {
    private final PlayDao playDao;
    private final GameDao gameDao;
    private final UserDao userDao;
    private final PlayUserDao playUserDao;

    public PlayUserController(PlayDao playDao, GameDao gameDao, UserDao userDao, PlayUserDao playUserDao) {
        this.playDao = playDao;
        this.gameDao = gameDao;
        this.userDao = userDao;
        this.playUserDao = playUserDao;
    }


    @GetMapping("/playUser/add")

    public String addGameForm(Model model) {
        PlayUser pointsGame = new PlayUser();
        model.addAttribute("playUser", pointsGame);
        return "/playUser/add";
    }

    @ModelAttribute("games")
    public List<Game> games() {
        return this.gameDao.findAll();
    }

    @ModelAttribute("users")
    public List<User> users() {
        return this.userDao.findAll();
    }
    @ModelAttribute("plays")
    public List<Play> plays() {
        return this.playDao.findAll();
    }

    @PostMapping("/playUser/add")
    @ResponseBody
    public String addPlay(PlayUser playUser, Model model) {
        playUserDao.savePlay(playUser);
        return playUser.toString();
    }
}
