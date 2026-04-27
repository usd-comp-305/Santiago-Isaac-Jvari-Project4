
public class Player {
    String name;
    int health;
    int gold;
    Weapon weapon;
    Armor armor;
    ArrayList<items> inventory;
    AttackStrategy attackStrategy;

    public void attack(){

    }
    public void takeDamage(int damage){
    }
    public void heal (int health){

    }
    public void buyItem(Item item){

    }
    public void usePotion(Potion potion){
    }
    public void equipWeapon(Weapon weapon){

    }
    public void equipArmor(Armor armor){

    }
    public void setAttackStrategy(AttackStrategy strategy){

    }
    public boolean isAlive(){
        return false;
    }

}
