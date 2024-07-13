package com.game.guesstheword.controller;

import com.game.guesstheword.service.GameService;
import com.game.guesstheword.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private GameUtils gameUtils;

    @GetMapping("/home")
    public String getWord(@RequestParam(value = "char", required = false) String guessedChar, Model model){
        if(guessedChar!=null){
            if(!gameService.addGuess(guessedChar.charAt(0))){
                gameUtils.reduceTries();
            }
        }
        model.addAttribute("randomWord", gameService.getWord());
        model.addAttribute("remainingTries", gameUtils.getRemainingTries());
        return "homePage";
    }

    @GetMapping("/reload")
    public String reloadGame(Model model){
        gameService = gameUtils.reloadGame();
        model.addAttribute("randomWord", gameService.getWord());
        model.addAttribute("remainingTries", gameUtils.getRemainingTries());
        return "redirect:/home";
    }
}
