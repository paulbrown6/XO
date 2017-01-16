package com.controller;

import com.game.GameButtons;
import com.logistic.Logistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Paul Brown on 09.01.2017.
 */

@Controller
public class MyController {

    private GameButtons game = GameButtons.getInstance();

    @Autowired
    private Logistic logistic;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ModelAndView game(@ModelAttribute("step") String s){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(s);
        Boolean bool = logistic.endGame();
        if (!s.equals("")) {
            game.addButton("O", s);
            bool = logistic.endGame();
            if (!bool) {
                String n = logistic.nextStep();
                if (n.equals("No step")) {
                    modelAndView.addObject("end", logistic.getWinner());
                    System.out.println(logistic.getWinner());
                } else {
                    game.addButton("X", n);
                    bool = logistic.endGame();
                }
            }
        }
        if (bool) {
            modelAndView.addObject("end", logistic.getWinner());
            System.out.println(logistic.getWinner());
        }
        modelAndView.setViewName("secondPage");
        return modelAndView;
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public ModelAndView gameInit() {
        ModelAndView modelAndView = new ModelAndView();
        logistic.reset();
        modelAndView.setViewName("secondPage");
        return modelAndView;
    }
}
