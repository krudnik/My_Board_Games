package pl.coderslab.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.user.User;

import java.util.Collection;

@Controller
public class GameController {

    private final GameDao gameDao;

    public GameController(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @GetMapping("/game/add")

    public String addGameForm(Model model) {
        Game predefinedGame = new Game();
        predefinedGame.setTitle("plansza");
        model.addAttribute("game", predefinedGame);
        return "/game/add";
    }

    @PostMapping("/game/add")
    @ResponseBody
    public String addUser(Game game, Model model) {
        gameDao.saveGame(game);
        return game.toString();
    }

}
