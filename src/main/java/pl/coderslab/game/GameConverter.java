package pl.coderslab.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.awt.print.Book;

public class GameConverter implements Converter<String, Game> {
    @Autowired
    private GameDao gameDao;

    @Override
    public Game convert(String source) {
        return gameDao.findById(Long.parseLong(source));
    }
}
