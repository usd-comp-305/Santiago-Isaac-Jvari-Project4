package edu.sandiego.comp305;

public class HintSystem {

    public String getHintForEnemy(final Enemy enemy,
            final Direction direction) {

        return getDirectionalMessage(direction, enemy.getHint());
    }

    public String getDirectionalMessage(final Direction direction,
            final String hint) {

        return "To the " + direction.toString().toLowerCase() + ": " + hint;
    }
}

