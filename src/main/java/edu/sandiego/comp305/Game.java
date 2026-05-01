package edu.sandiego.comp305;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {


    Player player;
    Dungeon dungeon;
    Shop shop;
    CombatManager combatManager;
    List<GameObserver> observers;

    public Game() {
        this.observers = new ArrayList<>();
        this.dungeon = new Dungeon();
        this.shop = new Shop();
        this.combatManager = new CombatManager();
        this.player = new Player();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("  Welcome to Dungeon Daedalus!");
        System.out.println("=============================");
        System.out.print("Enter your name, adventurer: ");
        player.name = scanner.nextLine();
        System.out.println("Welcome, " + player.name + "!");
        notifyObservers("Let Games started! Happy hunting " + player.name + " and may the odds be ever in your favor!");
    }

    private void gameLoop() {

        System.out.println("You begin in town of Magnavox");
        Scanner scanner = null;
        
        boolean running = true;
        while (running) {
            

            System.out.println("\n=============================");
            System.out.println("What would you like to do?");
            
            if (dungeon.InDungeon()){dungeonChoices();}
            
            else {
                if(!townChoices()){
                    running = false;
                    break;
                }
            }
            

            // Check if player is still alive
            if (!player.isAlive()) {
                System.out.println("\nYou have died. Game over!");
                running = false;
            }
        }

        scanner.close();
    }

    public boolean townChoices(){
        System.out.println("1. Enter Dungeon");
        System.out.println("2. Enter Shop");
        System.out.println("3. Retire");
        String input = getChoice();
        switch (input) {
            case "1":
                enterDungeon();
                break;
            case "2":
                enterShop();
                break;
            case "3":
                System.out.println("Thanks for playing! Goodbye.");
                return false;
            default:
                System.out.println("Invalid choice. Please enter 1-3.");
                return true;

        }
    }

    private void enterDungeon() {
    }

    public void printHints(){
        Direction[] directions = Direction.values();
        for (int i = 0; i < 3; i++) {
            System.out.println(dungeon.getHint(directions[i]));
        }
    }

    public void dungeonChoices() {

        System.out.println("1. Explore Left");
        System.out.println("2. Explore Forward");
        System.out.println("3. Explore Right");
        System.out.println("4. Leave Dungeon");
        String input = getChoice();
        switch (input) {
            case "1":
                explore(Direction.LEFT);
                break;
            case "2":
                explore(Direction.FORWARD);
                break;
            case "3":
                explore(Direction.RIGHT);
                break;
            case "4":
                explore(Direction.OUT);
                break;
            default:
                System.out.println("Invalid choice. Please enter 1-4.");
        }
    }
    public String getChoice () {
        Scanner scanner = null;
        System.out.println("=============================");
        System.out.print("Enter choice: ");
        return scanner.nextLine();
        }
    

    public void explore(Direction direction) {
        // TODO: implement
    }

    public void enterShop() {
        // TODO: implement
    }

    public void notifyObservers(String message) {
        // TODO: implement
    }

    public void addObserver(GameObserver observer) {
        // TODO: implement
    }

    public void removeObserver(GameObserver observer) {
        // TODO: implement
    }
}
