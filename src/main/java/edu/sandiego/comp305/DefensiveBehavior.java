package edu.sandiego.comp305;

public class DefensiveBehavior implements EnemyBehavior {
    @Override
    public void takeTurn(final Enemy enemy, final Player player) {

        if (enemy.getHealth() < enemy.health/2) {
            enemy.defend();
        } else {
            enemy.attack(player);
        }
    }
}
