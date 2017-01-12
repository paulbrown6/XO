package com.game;

import java.util.ArrayList;

/**
 * Created by Paul Brown on 12.01.2017.
 */
public class GameButtons {

    private static GameButtons instance;

    private static ArrayList<String> buttonsX = new ArrayList<String>();

    private static ArrayList<String> buttonsO = new ArrayList<String>();

    public static synchronized GameButtons getInstance(){
        if (instance == null){
            instance = new GameButtons();
        }
        return instance;
    }

    private GameButtons(){}

    public void addButtonX(String s){
        System.out.println("buttonX добавлена");
        buttonsX.add(s);
    }

    public void addButtonO(String s){
        System.out.println("buttonO добавлена");
        buttonsO.add(s);
    }

    public String getButton(Integer x, Integer y){
        String s = "";
        Boolean bool = true;
        for (int i = 0; i < buttonsX.size(); i++){
            System.out.println(x.toString().charAt(0)+""+y.toString().charAt(0));
            System.out.println(buttonsX.get(i).charAt(0) + "" + buttonsX.get(i).charAt(1));
            String num = x + "" + y;
            if (buttonsX.get(i).equals(num)){
                s = "<td id=\"" + x + y + "\"> " +
                        "<img src =\"../resources/cross.png\" \">" +
                        " </td>";
                bool = false;
                System.out.println("Цикл на X завершился успешно");
                break;
            }
            System.out.println("Цикл на X идет...");
        }
        for (int i = 0; i < buttonsO.size(); i++){
            System.out.println(x.toString().charAt(0)+""+y.toString().charAt(0));
            System.out.println(buttonsO.get(i).charAt(0) + "" + buttonsO.get(i).charAt(1));
            String num = x + "" + y;
            if (buttonsO.get(i).equals(num)){
                s = "<td id=\"" + x + y + "\"> " +
                        "<img src =\"../resources/noll.png\" \">" +
                        " </td>";
                bool = false;
                System.out.println("Цикл на O завершился успешно");
                break;
            }
            System.out.println("Цикл на O идет...");
        }
        if (bool) {
            s = "<td id=\"" + x + y + "\"> " +
                    "<input class =\"button\" type=\"submit\" name=\"step\" value=\"" + x + y + "\" form=\"go\" style=\"text-indent: -9999px\">" +
                    " </td>";
        }
        System.out.println(s);
        return s;
    }

    public static ArrayList<String> getButtonsX() {
        return buttonsX;
    }

    public static ArrayList<String> getButtonsO() {
        return buttonsO;
    }

    public void resetButtons(){
        buttonsX = new ArrayList<String>();
        buttonsO = new ArrayList<String>();
    }
}
