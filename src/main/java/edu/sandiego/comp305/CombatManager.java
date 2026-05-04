package edu.sandiego.comp305;


public class CombatManager {

    public void startCombat(final Player player, final Enemy enemy) {
        while (player.isAlive() && enemy.isAlive()) {
            playerTurn(player, enemy);

            if (enemy.isAlive()) {
                enemyTurn(enemy, player);
            }
        }

        if (player.isAlive()) {
            resolveVictory(player, enemy);
        }
    }

    public void playerTurn(final Player player, final Enemy enemy) {
        player.attack(enemy);
    }

    public void enemyTurn(final Enemy enemy, final Player player) {
        player.takeDamage(enemy.getAttackPower());
    }


    public void resolveVictory(final Player player, final Enemy enemy) {
        player.gold += enemy.getGoldReward();
    }

    public void resolveEnemyVictory(final Dungeon dungeon, final Enemy enemy) {
        if (enemy instanceof BossEnemy) {
            dungeon.increaseDifficulty();
        }
    }
}
