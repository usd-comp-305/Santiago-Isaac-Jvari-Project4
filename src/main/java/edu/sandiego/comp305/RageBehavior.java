package edu.sandiego.comp305;

public class RageBehavior implements EnemyBehavior {
    private static final int HALF_HEALTH_DIVISOR = 2;

    @Override
    public void takeTurn(final Enemy enemy, final Player player) {
        if (enemy.getHealth() > enemy.getMaxHealth() / HALF_HEALTH_DIVISOR) {
            enemy.rage();
        }

        enemy.attack(player);
    }
}
