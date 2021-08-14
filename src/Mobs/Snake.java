package src.Mobs;

import src.Material.IMaterial;
import src.Material.Items.Armors.HeavyArmor;
import src.Material.Items.Armors.LightArmor;
import src.Material.Items.Armors.MediumArmor;
import src.Material.Items.Weapons.Pistol;
import src.Material.Items.Weapons.Shotgun;
import src.Material.Items.Weapons.Sword;

public class Snake extends Obstacle {
    public Snake () {
        super("Yılan", 3, 12, 0, 5);
        int damage = (int)(Math.random() * 3) + 3;
        this.setDamage(damage);
        this.setLoot(generateLoot());
    }


    private IMaterial generateLoot(){
        int rewardTypeChance = (int)(Math.random() * 100);
        int reward = (int)(Math.random() * 100);
        IMaterial mat = null;
        if (rewardTypeChance <= 15){//Weapon Chance
            if (reward <= 20){//shotgun
                mat = new Shotgun();
            }else if (reward <= 50){//sword
                mat = new Sword();
            }else{//pistol
                mat = new Pistol();
            }
        }else if (rewardTypeChance > 15 && rewardTypeChance <= 30){//Armor Chance
            if (reward <= 20){//heavy armor
                mat = new HeavyArmor();
            }else if (reward <= 50){//medium armor
                mat = new MediumArmor();
            }else{//light armor
                mat = new LightArmor();
            }
        }else if (rewardTypeChance > 30 && rewardTypeChance <= 55){//Money Chance
            if (reward <= 20){//10 coin
                this.setAward(10);
            }else if (reward <= 50){//5 coin
                this.setAward(5);
            }else{//1 coin
                this.setAward(1);
            }

        }/*else if (rewardTypeChance > 55){//Nothing Chance

        }*/
        return mat;
    }
}
