package pl.coderslab.play;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.game.Game;
import pl.coderslab.game.GameDao;

public class PlayConverter implements Converter<String, Play> {
    @Autowired
    private PlayDao playDao;

    @Override
    public Play convert(String source) {
        return playDao.findById(Long.parseLong(source));
    }
}
