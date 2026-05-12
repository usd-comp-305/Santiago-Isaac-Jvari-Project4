package edu.sandiego.comp305;

public class RageBehavior implements EnemyBehavior {
    @Override
    public void takeTurn(final Enemy enemy, final Player player) {

        if (enemy.getHealth() > enemy.getHealth()/2) {
            enemy.rage();
        } else {
            enemy.attack(player);
        }
    }
}
