package pl.coderslab.play;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.game.Game;
import pl.coderslab.game.GameDao;
import pl.coderslab.user.User;
import pl.coderslab.user.UserDao;

import java.util.List;

@Controller
public class PlayController {
    private final PlayDao playDao;
    private final GameDao gameDao;
    private final UserDao userDao;

    public PlayController(PlayDao playDao, GameDao gameDao, UserDao userDao) {
        this.playDao = playDao;
        this.gameDao = gameDao;
        this.userDao = userDao;
    }


    @GetMapping("/play/add")

    public String addGameForm(Model model) {
        Play predefinedGame = new Play();
        model.addAttribute("play", predefinedGame);
        return "/play/add";
    }

    @ModelAttribute("games")
    public List<Game> games() {
        return this.gameDao.findAll();
    }

    @ModelAttribute("users")
    public List<User> users() {
        return this.userDao.findAll();
    }

    @PostMapping("/play/add")
    @ResponseBody
    public String addPlay(Play play, Model model) {
        playDao.savePlay(play);
        return play.toString();
    }
}
