package edu.sandiego.comp305;

public class HeavyAttack implements AttackStrategy {
    @Override
    public int executeAttack(final int attackerPower) {
        return attackerPower+5;
    }
}
