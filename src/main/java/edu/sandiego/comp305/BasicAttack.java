package edu.sandiego.comp305;

public class BasicAttack implements AttackStrategy {
    @Override
    public int executeAttack(final int attackerPower){
        return attackerPower;
    }
}
