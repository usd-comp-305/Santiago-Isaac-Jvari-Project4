package edu.sandiego.comp305;

public class HeavyAttack implements AttackStrategy {
    private static final int HEAVY_ATTACK_BONUS = 8;
    @Override
    public int executeAttack(final int attackerPower) {
        return attackerPower+HEAVY_ATTACK_BONUS;
    }
}
