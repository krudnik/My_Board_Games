package pl.coderslab.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.playuser.PlayUser;
import pl.coderslab.user.User;

import java.util.Collection;
import java.util.List;

@Controller
public class GameController {

    private final GameDao gameDao;

    public GameController(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @GetMapping("/game/add")

    public String addGameForm(Model model) {
        Game predefinedGame = new Game();
        model.addAttribute("game", predefinedGame);
        return "/game/add";
    }

    @PostMapping("/game/add")
    public String addUser(Game game, Model model) {
        gameDao.saveGame(game);
        return "redirect:/game/list";
    }

    @RequestMapping("/game/delete/{id}")
    public String deleteGame(@PathVariable long id) {
        Game game = gameDao.findById(id);
        gameDao.delete(game);
        return "redirect:/game/list";
    }

    @GetMapping("/game/edit/{id}")
    public String editGame(@PathVariable long id, Model model) {
        Game gameToEdit = gameDao.findById(id);
        model.addAttribute("gameToEdit", gameToEdit);
        return "/game/edit";
    }

    @PostMapping("/game/edit/save/{id}")
    public String editUser(Game game, @PathVariable long id) {
        game.setId(id);
        gameDao.update(game);
        return "redirect:/game/list";
    }

    @GetMapping("/game/list")
    public String listPlayUser(Model model) {
        List<Game> games = gameDao.findAll();
        model.addAttribute("games", games);
        return "/game/list";
    }

    @GetMapping("/game/statistics/{id}")
    public String results(@PathVariable int id, Model model){
        Game game = gameDao.findById(id);
        List<PlayUser> maxPoints = gameDao.maxPoints(game);
        Double avgPoints = gameDao.avgPoints(game);
        model.addAttribute("maxPoints", maxPoints);
        model.addAttribute("avgPoints", avgPoints);
        return "/game/statistics";
    }

}
