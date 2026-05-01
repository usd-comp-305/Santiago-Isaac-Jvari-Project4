package edu.sandiego.comp305;

import java.util.ArrayList;

public class Shop {
    public void displayItems(){

    }
    public void buyWeaponUpgrade(int boostAmount,int price, Weapon weapon, Player player){
        player.buyItem(weapon,boostAmount);
    }
    public void buyArmorUpgrade(int price, Armor armor){

    }

    public void buyPotion(int price, Potion potion){

    }

}



