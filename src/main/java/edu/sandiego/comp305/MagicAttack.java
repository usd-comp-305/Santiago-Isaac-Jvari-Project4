package edu.sandiego.comp305;

public class MagicAttack implements AttackStrategy {
    @Override
    public int executeAttack(int attackerPower) {
        return attackerPower+2;
    }
}
