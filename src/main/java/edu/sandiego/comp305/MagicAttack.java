package edu.sandiego.comp305;

public class MagicAttack implements AttackStrategy {
    @Override
    public int executeAttack(final int attackerPower) {
        return attackerPower+2;
    }
}
