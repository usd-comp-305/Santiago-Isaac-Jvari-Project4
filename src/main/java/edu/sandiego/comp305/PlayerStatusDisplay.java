package edu.sandiego.comp305;

public class PlayerStatusDisplay implements GameObserver {

    @Override
    public void update(final String message) {
        System.out.println("\n[Player Update]");
        System.out.println(message);
    }
}

