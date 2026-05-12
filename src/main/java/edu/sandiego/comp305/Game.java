package edu.sandiego.comp305;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private int enemiesKilled;
    private int bossesKilled;

    private final Scanner scanner;
    private final Player player;
    private final Dungeon dungeon;
    private final Shop shop;
    private final CombatManager combatManager;
    private final List<GameObserver> observers;

    public Game() {
        this.scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        this.observers = new ArrayList<>();
        this.dungeon = new Dungeon();
        this.shop = new Shop();
        this.combatManager = new CombatManager(dungeon);
        this.player = new Player();
        this.enemiesKilled = 0;
        this.bossesKilled = 0;
    }

    public void startGame() {
        System.out.println("=============================");
        System.out.println("  Welcome to Dungeon Daedalus!");
        System.out.println("=============================");
        System.out.print("Enter your name, adventurer: ");

        player.name = scanner.nextLine();

        System.out.println("Welcome, " + player.name + "!");
        notifyObservers("Game started. Happy hunting, "
                + player.name + "!");

        gameLoop();
    }

    private void gameLoop() {
        System.out.println("You begin in the town of Magnavox.");

        boolean running = true;

        while (running) {
            System.out.println("\n=============================");
            System.out.println("What would you like to do?");

            if (dungeon.inDungeon()) {
                dungeonChoices();
            } else {
                running = townChoices();
            }

            if (!player.isAlive()) {
                notifyObservers("You have died. Game over!");
                running = false;
            }
        }
    }

    public boolean townChoices() {
        System.out.println("1. Enter Dungeon");
        System.out.println("2. Enter Shop");
        System.out.println("3. Retire");

        final String input = getChoice();

        switch (input) {
            case "1":
                enterDungeon();
                break;

            case "2":
                enterShop();
                break;

            case "3":
                printFinalStats();
                notifyObservers("Thanks for playing! Goodbye.");
                return false;

            default:
                System.out.println("Invalid choice. Please enter 1-3.");
                break;
        }

        return true;
    }

    private void enterDungeon() {
        dungeon.enterDungeon();
        notifyObservers("You entered the dungeon.");
        printHints();
    }

    private void leaveDungeon() {
        dungeon.exitDungeon();
        notifyObservers("You left the dungeon.");
    }

    public void printHints() {
        final Direction[] directions = {
                Direction.LEFT,
                Direction.FORWARD,
                Direction.RIGHT
        };

        for (final Direction direction : directions) {
            System.out.println(dungeon.getHint(direction));
        }
    }

    public void dungeonChoices() {
        System.out.println("1. Explore Left");
        System.out.println("2. Explore Forward");
        System.out.println("3. Explore Right");
        System.out.println("4. Leave Dungeon");

        final String input = getChoice();

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
                leaveDungeon();
                break;

            default:
                System.out.println("Invalid choice. Please enter 1-4.");
                break;
        }
    }

    public String getChoice() {
        System.out.println("=============================");
        System.out.print("Enter choice: ");
        return scanner.nextLine();
    }

    public void explore(final Direction direction) {
        final Encounter encounter = dungeon.exploreDirection(direction);

        if (encounter == null) {
            notifyObservers("This path seems quiet.");
            printHints();
            return;
        }

        final Enemy enemy = createEnemyFromEncounter(encounter);

        notifyObservers("You encountered a " + enemy.getName() + "!");

        combatManager.startCombat(player, enemy);

        if (!player.isAlive()) {
            printDeathArt();
            notifyObservers("You were defeated.");
            printFinalStats();
        } else if (!enemy.isAlive()) {
            enemiesKilled++;

            if (enemy instanceof BossEnemy) {
                bossesKilled++;
            }

            notifyObservers("You defeated the " + enemy.getName() + "!");
        }

        if (player.isAlive() && dungeon.inDungeon()) {
            printHints();
        }
    }

    private Enemy createEnemyFromEncounter(final Encounter encounter) {
        if (encounter.isBossEncounter()) {
            return dungeon.getEnemyFactory().createBoss(
                    encounter.getEnemyName());
        }

        return dungeon.getEnemyFactory().createEnemy(
                encounter.getEnemyName(),
                dungeon.getDifficultyLevel());
    }

    public void enterShop() {
        boolean shopping = true;

        while (shopping) {
            System.out.println("\nWelcome to the shop!");
            System.out.println("Gold: " + player.getGold());
            System.out.println("1. Buy weapon upgrade - " + shop.getWeaponPrice());
            System.out.println("2. Buy armor upgrade - " + shop.getArmorPrice());
            System.out.println("3. Buy health potion - " + shop.getPotionPrice());
            System.out.println("4. Buy strength potion - " + shop.getPotionPrice());
            System.out.println("5. Leave shop");

            final String input = getChoice();

            switch (input) {
                case "1":
                    buyWeaponBoost();
                    break;

                case "2":
                    buyArmorUpgrade();
                    break;

                case "3":
                    buyHealthPotion();
                    break;

                case "4":
                    buyStrengthPotion();
                    break;

                case "5":
                    notifyObservers("Leaving shop.");
                    shopping = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
                    break;
            }
        }
    }

    private void buyWeaponBoost() {
        if (shop.buyWeaponBoost(player)) {
            notifyObservers("You bought a weapon upgrade.");
        } else {
            notifyObservers("Could not buy weapon upgrade.");
        }
    }

    private void buyArmorUpgrade() {
        if (shop.buyArmorUpgrade(player)) {
            notifyObservers("You bought an armor upgrade.");
        } else {
            notifyObservers("Could not buy armor upgrade.");
        }
    }

    private void buyHealthPotion() {
        final Potion potion = ItemFactory.createPotion(PotionType.HEALTH);

        if (shop.buyPotion(player, potion)) {
            notifyObservers("You bought a health potion.");
        } else {
            notifyObservers("Could not buy health potion.");
        }
    }

    private void buyStrengthPotion() {
        final Potion potion = ItemFactory.createPotion(PotionType.STRENGTH);

        if (shop.buyPotion(player, potion)) {
            notifyObservers("You bought a strength potion.");
        } else {
            notifyObservers("Could not buy strength potion.");
        }
    }

    public void notifyObservers(final String message) {
        for (final GameObserver observer : observers) {
            observer.update(message);
        }
    }

    public void addObserver(final GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(final GameObserver observer) {
        observers.remove(observer);
    }

    public Shop getShop() {
        return shop;
    }

    public CombatManager getCombatManager() {
        return combatManager;
    }

    private void printFinalStats() {
        System.out.println();
        System.out.println("========== Final Stats ==========");
        System.out.println("Total gold: " + player.getGold());
        System.out.println("Enemies killed: " + enemiesKilled);
        System.out.println("Bosses killed: " + bossesKilled);
        System.out.println("Rooms explored: " + dungeon.getRoomsExplored());
        System.out.println("=================================");
    }

    private void printDeathArt() {
        final String name = player.name;

        System.out.println("""
           .-=========-.
           \\'-=======-'/
           _|   R.I.P. |_
          ((|          |))
           \\| %-8s |/
            \\__     __/
              _`) (`_
            _/_______\\_
           /___________\\
           
            Here lies the adventurer.
            Game Over.
            """.formatted(name));
    }
}