package edu.sandiego.comp305;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.addObserver(new PlayerStatusDisplay());
        game.addObserver(new GameLogger());

        game.startGame();
    }
}
