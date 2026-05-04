package edu.sandiego.comp305;

public class RageBehavior implements EnemyBehavior {
    @Override
    public void takeTurn(final Enemy enemy, final Player player) {
        //change this later
        if (enemy.getHealth() < 20) {
            enemy.rage();
        } else {
            enemy.attack(player);
        }
    }
}
