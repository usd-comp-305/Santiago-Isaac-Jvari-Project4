package edu.sandiego.comp305;

public class DefensiveBehavior implements EnemyBehavior {
    @Override
    public void takeTurn(Enemy enemy, Player player) {
        //change this later
        if (enemy.getHealth() < 20) {
            enemy.defend();
        } else {
            enemy.attack(player);
        }
    }
}