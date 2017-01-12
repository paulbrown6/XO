package com.logistic;

import com.game.GameButtons;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Paul Brown on 12.01.2017.
 */
public class Logistic {

    private String winner = "";

    public boolean endGame(){
        winner = win();
        if (winner.equals("Winner Comp") || winner.equals("Winner Human")){
            return true;
        }
        return false;
    }

    private String win(){
        ArrayList<String> arrX = GameButtons.getButtonsX();
        ArrayList<String> arrO = GameButtons.getButtonsO();
        ArrayList<WinnerKey> keys = new WinnerKey().getKeys();
        for (WinnerKey key: keys) {
            Boolean a = false;
            Boolean b = false;
            Boolean c = false;
            for (String s: arrX){
                if (s.equals(key.getA())){
                    a = true;
                }
                if (s.equals(key.getB())){
                    b = true;
                }
                if (s.equals(key.getC())){
                    c = true;
                }
                if (a && b && c){
                    return "Winner Comp";
                }
            }
            for (String s: arrO){
                if (s.equals(key.getA())){
                    a = true;
                }
                if (s.equals(key.getB())){
                    b = true;
                }
                if (s.equals(key.getC())){
                    c = true;
                }
                if (a && b && c){
                    return "Winner Human";
                }
            }
        }
        return "No winner";

    }

    public String nextStep(){
        String s = "";
        Random r = new Random();
        while (true){
            ArrayList<WinnerKey> keys = new WinnerKey().getKeys();
            Integer a = r.nextInt(keys.size());
            s = keys.get(a).getA();
            if (stepBool(s)){
                System.out.println("Next step: " + s);
                return s;
            }
            s = keys.get(a).getB();
            if (stepBool(s)){
                System.out.println("Next step: " + s);
                return s;
            }
            s = keys.get(a).getC();
            if (stepBool(s)){
                System.out.println("Next step: " + s);
                return s;
            }
        }

    }

    private boolean stepBool(String s){
        ArrayList<String> arrX = GameButtons.getButtonsX();
        ArrayList<String> arrO = GameButtons.getButtonsO();
        for (String x: arrX) {
            if (x.equals(s)){
                return false;
            }
        }
        for (String o: arrO) {
            if (o.equals(s)){
                return false;
            }
        }
        return true;
    }

    public String getWinner() {
        return winner;
    }
}
