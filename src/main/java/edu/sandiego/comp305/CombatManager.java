package edu.sandiego.comp305;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CombatManager {
    private final Dungeon dungeon;

    private final Scanner scanner;

    public CombatManager(final Dungeon dungeon) {
        this.dungeon = dungeon;
        this.scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    }

    public void startCombat(final Player player, final Enemy enemy) {
        System.out.println("\nA " + enemy.getName() + " appears!");

        while (player.isAlive() && enemy.isAlive()) {
            displayCombatStatus(player, enemy);

            playerTurn(player, enemy);

            if (enemy.isAlive()) {
                enemyTurn(enemy, player);
            }
        }

        if (player.isAlive()) {
            resolveVictory(player, enemy);
        }
    }

    private void displayCombatStatus(final Player player, final Enemy enemy) {
        System.out.println("\n---------- Combat ----------");
        System.out.println(player.name + " HP: " + player.getHealth());
        System.out.println(enemy.getName() + " HP: " + enemy.getHealth());
        System.out.println("----------------------------");
    }

    public void playerTurn(final Player player, final Enemy enemy) {
        choosePotion(player);
        chooseAttackStrategy(player);

        final int enemyHealthBefore = enemy.getHealth();

        player.attack(enemy);

        final int damageDone = enemyHealthBefore - enemy.getHealth();

        System.out.println("You attacked the " + enemy.getName()
                + " for " + damageDone + " damage.");
    }

    private void choosePotion(final Player player) {
        System.out.println("\nYour potions:");

        boolean hasPotion = false;
        int potionNumber = 1;

        for (final Item item : player.inventory) {
            if (item instanceof Potion) {
                System.out.println(potionNumber + ". " + item.name);
                potionNumber++;
                hasPotion = true;
            }
        }

        if (!hasPotion) {
            System.out.println("You do not have any potions.");
            return;
        }

        System.out.println("Use a potion?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        final String input = getChoice();

        if (input.equals("1")) {
            usePotion(player);
        }
    }

    private void usePotion(final Player player) {
        int potionNumber = 1;

        System.out.println("\nChoose a potion:");

        for (final Item item : player.inventory) {
            if (item instanceof Potion) {
                System.out.println(potionNumber + ". " + item.name);
                potionNumber++;
            }
        }

        final String input = getChoice();

        int currentPotionNumber = 1;

        for (final Item item : player.inventory) {
            if (item instanceof Potion) {
                if (input.equals(String.valueOf(currentPotionNumber))) {
                    final Potion potion = (Potion) item;
                    player.usePotion(potion);
                    player.inventory.remove(item);

                    System.out.println("You used " + item.name + ".");
                    return;
                }

                currentPotionNumber++;
            }
        }

        System.out.println("Invalid potion choice.");
    }

    private void chooseAttackStrategy(final Player player) {
        System.out.println("\nChoose your attack:");
        System.out.println("1. Basic attack");
        System.out.println("2. Heavy attack");
        System.out.println("3. Magic attack");

        final String input = getChoice();

        switch (input) {
            case "1":
                player.setAttackStrategy(new BasicAttack());
                System.out.println("You chose a basic attack.");
                break;

            case "2":
                player.setAttackStrategy(new HeavyAttack());
                System.out.println("You chose a heavy attack.");
                break;

            case "3":
                player.setAttackStrategy(new MagicAttack());
                System.out.println("You chose a magic attack.");
                break;

            default:
                player.setAttackStrategy(new BasicAttack());
                System.out.println("Invalid choice. Using basic attack.");
                break;
        }
    }

    public void enemyTurn(final Enemy enemy, final Player player) {
        printEnemyBehavior(enemy);

        final int playerHealthBefore = player.getHealth();

        if (enemy.getBehaviorStrategy() != null) {
            enemy.getBehaviorStrategy().takeTurn(enemy, player);
        } else {
            enemy.attack(player);
        }

        final int damageTaken = playerHealthBefore - player.getHealth();

        System.out.println("The " + enemy.getName()
                + " hit you for " + damageTaken + " damage.");
    }

    private void printEnemyBehavior(final Enemy enemy) {
        if (enemy.getBehaviorStrategy() instanceof RageBehavior) {
            System.out.println("The " + enemy.getName()
                    + " is raging and will hit harder!");
        } else if (enemy.getBehaviorStrategy() instanceof DefensiveBehavior) {
            System.out.println("The " + enemy.getName()
                    + " is defending and will take less damage!");
        }
    }

    public void resolveVictory(final Player player, final Enemy enemy) {
        player.increaseGold(enemy.getGoldReward());

        System.out.println("You defeated the " + enemy.getName() + "!");
        System.out.println("You gained " + enemy.getGoldReward() + " gold.");

        if (enemy instanceof BossEnemy) {
            dungeon.increaseDifficulty();
            System.out.println("The dungeon grows more dangerous...");
            System.out.println("Difficulty is now " + dungeon.getDifficultyLevel() + ".");
        }
    }

    private String getChoice() {
        System.out.print("Enter choice: ");
        return scanner.nextLine();
    }
}
