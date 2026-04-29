package edu.sandiego.comp305;

public class HeavyAttack implements AttackStrategy {
    @Override
    public int executeAttack(int attackerPower) {
        return attackerPower+5;
    }
}
