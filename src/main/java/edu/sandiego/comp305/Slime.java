package edu.sandiego.comp305;

public class Slime extends Enemy {
    public Slime() {
        super("Slime", 30, 5, 10, "sloshing");
        setBehaviorStrategy(new RageDefensiveBehavior());
    }
}
