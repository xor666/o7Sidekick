package com.Mattera.o7sidekick.others;

public abstract class consoleColor {

    static String defaultColor = "\u001B[0m"; // Réinitialisation de la couleur
    static String green = "\u001B[32m"; // Vert
    static String red = "\u001B[31m"; // Rouge
    static String orange = "\u001B[33m"; // Orange
    static String blue = "\u001B[34m"; // Bleu
    public static void setGreen(){
        System.out.println(green);
    }
    public static void setRed(){
        System.out.println(red);
    }
    public static void setOrange(){
        System.out.println(orange);
    }
    public static void setBlue(){
        System.out.println(blue);
    }
    public static void setDefaultColor(){
        System.out.println(defaultColor);
    }

    public static void showMessageColorized(String message, String color){
        switch(color){

            case "green":
                setGreen();
                System.out.println(message);
                setDefaultColor();
                break;

            case "red":
                setRed();
                System.out.println(message);
                setDefaultColor();
                break;

            case "orange":
                setOrange();
                System.out.println(message);
                setDefaultColor();
                break;

            case "blue":
                setBlue();
                System.out.println(message);
                setDefaultColor();
                break;

            case "normal":
                setDefaultColor();
                System.out.println(message);
                setDefaultColor();
                break;
            default:
                setDefaultColor();
                System.out.println(message);
                break;
        }

    }

    public static void showMessageColorized(String message){
        System.out.println(message);
    }
}
