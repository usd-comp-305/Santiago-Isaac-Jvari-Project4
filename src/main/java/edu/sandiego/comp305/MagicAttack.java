package edu.sandiego.comp305;

public class MagicAttack implements AttackStrategy {

    private static final int MAGIC_ATTACK_BONUS = 5;

    @Override
    public int executeAttack(final int attackerPower) {
        return attackerPower+MAGIC_ATTACK_BONUS;
    }
}
