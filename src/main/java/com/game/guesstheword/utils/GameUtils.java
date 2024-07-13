package com.game.guesstheword.utils;

import com.game.guesstheword.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GameUtils {
    private Integer MAX_TRIES=5;
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    public int reduceTries(){
        return MAX_TRIES--;
    }

    public Integer getRemainingTries() {
        return MAX_TRIES;
    }

    public GameService reloadGame(){
        GameService gameService = applicationContext.getBean(GameService.class);
        MAX_TRIES = 5;
        return gameService;
    }
}
