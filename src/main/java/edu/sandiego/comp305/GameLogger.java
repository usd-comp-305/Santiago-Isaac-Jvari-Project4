package edu.sandiego.comp305;

public class GameLogger implements GameObserver {

    @Override
    public void update(final String message) {
        System.out.println(message);
    }
}

