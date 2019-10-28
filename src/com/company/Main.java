package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner k = new Scanner(System.in);
    static Random r = new Random();
    public static boolean secret = false;
    public static int count = 0;
    public static void main(String[] args) {

        System.out.println("Welcome to Zork! Type QUIT at any time to quit the game."); // A welcome to the game with directions on how to navigate the text game

        System.out.println("This is a directional adventure game. The goal is to find the secret room. " +
                "From your starting room in the foyer you can move in any direction using" + "N,S, E, or W." + "Any other key will cause an error, good luck!");



        boolean repeat = true; // this will keep the while loop going until someone enters "quit" or goes south from the foyer changing the out outcome to false

        int next = 1;
        while (repeat) {
            if (next == 1) { //each of these if statements coincide with the address of the room (rooms 1-8) which would be next
                int n = foyer();
                while (n == -1) {// this while statement talks to each of our methods which says if the user enters an incorrect entry it will return -1, printing this error message.
                    //this loop will keep on running until user enters a correct value
                    System.out.println("You have reached a dead-end. Choose another direction. ");
                    n = foyer();
                }
                count++; // this count++ helps us by counting each time the user enters each room before he or she quits or leaves the house
                next = n;
            } else if (next == 2) {
                int n = frontroom();
                while (n == -1) {
                    System.out.println("You have reached a dead-end. Choose another direction. ");
                    n = frontroom();
                }
                count++;
                next = n;
            } else if (next == 3) {
                int n = library();
                while (n == -1) {
                    System.out.println("You have reached a dead-end. Choose another direction. ");
                    n = library();
                }
                count++;
                next = n;
            } else if (next == 4) {
                int n = kitchen();
                while (n == -1) {
                    System.out.println("You have reached a dead-end. Choose another direction. ");
                    n = kitchen();
                }
                count++;
                next = n;
            } else if (next == 5) {
                int n = diningroom();
                while (n == -1) {
                    System.out.println("You have reached a dead-end. Choose another direction. ");
                    n = diningroom();
                }
                count++;
                next = n;
            } else if (next == 6) {
                int n = vault();
                while (n == -1) {
                    System.out.println("You have reached a dead-end. Choose another direction. ");
                    n = vault();
                }
                count++;
                next = n;
            } else if (next == 7) {
                int n = parlor();
                while (n == -1) {
                    System.out.println("You have reached a dead-end. Choose another direction. ");
                    n = parlor();
                }
                count++;
                next = n;
            } else if (next == 8) {
                int n = secretRoom();
                while (n == -1) {
                    System.out.println("You have reached a dead-end. Choose another direction. ");
                    n = secretRoom();
                }
                count++;
                next = n;
            } else if (next == -2) {
                repeat = false;
            }
        }
        System.out.println("You have left the house. You visited "+ count + " rooms.");
        int ghost = 1 + r.nextInt(4); //if the boolean comes up "false" via the "return -2" in our if statements it exits the while loop and brings us to this exit message
        if(ghost == 1){ // after the sout we run our random number generator to give us a 1 in 4 chance of being followed by a ghost and prints the sout message if the random number generator is a "1"
            System.out.println("You are being followed by a ghost. His name is Casper.");
        }
    }

    public static int foyer() {
        System.out.println("You are in the foyer. There is a dead scorpion."); // once you enter each room two messages are prompted in each method for what is in the room and asking which direction you want to go
        System.out.println("Which direction do you want to go?");
        String direction = k.next(); // the direction is chosen by the user
        if (direction.equalsIgnoreCase("n")) { // the only way to proceed through the while loop is to enter the correct direction into the next room.
            return 2; // If the user enters "n" the if statement returns 2 and continues and moves on to the front room via our if statement inside our main method
        } else if (direction.equalsIgnoreCase("quit") || direction.equalsIgnoreCase("s")) {
            return -2; // if the user exits the game using "quit" or direction "s" it will send -2 to our if statements bringing up an exit message
        } else {
            return -1; // if they enter anything else it will return -1 which brings up an error message in our if statements prompting user to try another direction
        }
    }

    public static int frontroom() {
        System.out.println("You are in the front room. There is a piano.");

        System.out.println("Which direction do you want to go?");
        String direction = k.next();
        if (direction.equalsIgnoreCase("s")) {
            return 1;
        } else if (direction.equalsIgnoreCase("w")) {
            return 3;
        } else if (direction.equalsIgnoreCase("e")) {
            return 4;
        } else if (direction.equalsIgnoreCase("quit")) {
            return -2;
        } else {
            return -1;
        }
    }

    public static int library() {
        System.out.println("You are in the library. There are spiders in this room.");
        System.out.println("Which direction do you want to go?");
        String direction = k.next();
        if (direction.equalsIgnoreCase("n")) {
            return 5;
        } else if (direction.equalsIgnoreCase("e")) {
            return 2;
        } else if (direction.equalsIgnoreCase("quit")) {
            return -2;
        } else {
            return -1;
        }
    }

    public static int kitchen() {
        System.out.println("You are in the kitchen. There are bats in this room.");
        System.out.println("Which direction do you want to go?");
        String direction = k.next();
        if (direction.equalsIgnoreCase("w")) {
            return 2;
        } else if (direction.equalsIgnoreCase("n")) {
            return 7;
        } else if (direction.equalsIgnoreCase("quit")) {
            return -2;
        } else {
            return -1;
        }
    }

    public static int parlor() {
        System.out.println("You are in the parlor. There a treasure chest in this room.");
        System.out.println("Which direction do you want to go?");
        String direction = k.next();
        if (direction.equalsIgnoreCase("w")) {
            return 6;
        } else if (direction.equalsIgnoreCase("s")) {
            return 4;
        } else if (direction.equalsIgnoreCase("quit")) {
            return -2;
        } else {
            return -1;
        }
    }

    public static int secretRoom() {
        System.out.println("You are in the Secret Room!!! There are piles of gold in this room!! Congrats!");
        System.out.println("Which direction do you want to go?");
        String direction = k.next();
        if (direction.equalsIgnoreCase("w")) {
            return 6;
        } else if (direction.equalsIgnoreCase("quit")) {
            return -2;
        } else {
            return -1;
        }
    }
    public static int vault() {
        Scanner k = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        System.out.println("You are in the vault. There are three walking skeletons.");
        System.out.println("Which direction do you want to go?");
        String direction = k.next();
        int sr = 1 + r.nextInt(4);
        if (direction.equalsIgnoreCase("e")) {
            if(secret){ // this global variable "secret" only runs when you already entered the room
                System.out.println("Would you like to go to the parlor or the secret room(P/S)?"); // once secretroom has been visited this prompt will run allowing user to choose which room they want to enter
                String s = k.next();
                if(s.equalsIgnoreCase("s")){
                    return 8;
                }
                else{
                    return 7;
                }
            }
            else { // this is only running before the secretroom has been unlocked
                if (sr == 1) { // if sr which is our random number equals 1 from our 1-4 range secret will equal true and will return 8 and enter the Secret room, otherwise it will return 7 and bring user to the parlor
                    secret = true;
                    return 8;
                } else {
                    return 7;
                }
            }
        }
        else if (direction.equalsIgnoreCase("quit")) {
            return -2;
        } else {
            return -1;
        }
    }

    public static int diningroom() {
        System.out.println("You are in the dining room. There is dust and an empty box.");
        System.out.println("Which direction do you want to go?");
        String direction = k.next();
        if (direction.equalsIgnoreCase("s")) {
            return 3;
        } else if (direction.equalsIgnoreCase("quit")) {
            return -2;
        } else {
            return -1;
        }
    }
}
