package edu.sandiego.comp305;

public final class Main {

    private Main() {
        throw new UnsupportedOperationException();
    }

    public static void main(final String[] args) {
        final Game game = new Game();

        game.addObserver(new PlayerStatusDisplay());
        //game.addObserver(new GameLogger());

        game.startGame();
    }
}
