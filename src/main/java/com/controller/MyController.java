package com.controller;

import com.game.GameButtons;
import com.logistic.Logistic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Paul Brown on 09.01.2017.
 */

@Controller
public class MyController {

    private static ArrayList<String> oldstep;

    private static GameButtons game = GameButtons.getInstance();

    private static Logistic logistic = new Logistic();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ModelAndView game(@ModelAttribute("step") String s){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(s);
        game.addButtonO(s);
        String n = logistic.nextStep();
        game.addButtonX(n);
        modelAndView.setViewName("secondPage");
        if (logistic.endGame()){
            modelAndView.addObject("end", logistic.getWinner());
            System.out.println(logistic.getWinner());
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public ModelAndView gameInit() {
        ModelAndView modelAndView = new ModelAndView();
        game.resetButtons();
        modelAndView.setViewName("secondPage");
        return modelAndView;
    }
}
