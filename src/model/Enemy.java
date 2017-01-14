/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Phantom
 */
import util.RpgUtil;
import java.io.Serializable;
import java.util.Random;

public class Enemy implements Serializable {

    private final String name;
    private int hp;
    private final int attack;
    private final int defend;
    private final int level;
    private int exp;
    private int money;
    private final int evasion, accuracy;
    private int skill1, skill2;
    private static Random random = new Random();
    private static Random random1 = new Random();
    //Bestiary Counter

    public static Enemy newRandomEnemyD1() {

        int i = random1.nextInt(5);

        if (i == 0) {                                       //HP att def acc ev
            return new Enemy("Ghost", RpgUtil.randInt(1, 5), 10, 10, 3, 100, 5, 5, 2, 0);
        } else if (i == 1) {
            return new Enemy("Zombie", RpgUtil.randInt(1, 5), 12, 11, 5, 100, 5, 5, 3, 0);
        } else if (i == 2) {
            return new Enemy("Wraith", RpgUtil.randInt(3, 7), 20, 11, 6, 100, 5, 5, 5, 1);
        } else if (i == 3) {
            return new Enemy("Goblin", RpgUtil.randInt(1, 3), 8, 12, 3, 100, 10, 5, 7, 0);
        } else {
            return new Enemy("Vampire", RpgUtil.randInt(5, 10), 18, 14, 4, 105, 10, 5, 4, 4);
        }
    }

    public static Enemy newRandomEnemyD2() {

        int i = random1.nextInt(4);

        if (i == 0) {                                               //HP att def acc ev
            return new Enemy("Dark Knight", RpgUtil.randInt(10, 20), 20, 30, 20, 120, 10, 5, 3, 2);
        } else if (i == 1) {
            return new Enemy("Holy Knight", RpgUtil.randInt(10, 20), 20, 20, 30, 110, 20, 5, 4, 2);
        } else if (i == 2) {
            return new Enemy("Dark Wizard", RpgUtil.randInt(10, 20), 25, 45, 15, 115, 0, 5, 5, 3);
        } else {
            return new Enemy("Fallen King", RpgUtil.randInt(15, 25), 35, 30, 30, 125, 30, 10, 5, 5);
        }
    }

    public static Enemy newRandomEnemyD3() {

        int i = random1.nextInt(4);

        if (i == 0) {                                            //HP att def acc ev
            return new Enemy("Tiamat", RpgUtil.randInt(20, 30), 40, 45, 30, 120, 10, 10, 10, 7);
        } else if (i == 1) {
            return new Enemy("Marilith", RpgUtil.randInt(20, 30), 35, 40, 20, 110, 20, 10, 10, 7);
        } else if (i == 2) {
            return new Enemy("Kraken", RpgUtil.randInt(20, 30), 50, 45, 15, 115, 0, 10, 10, 7);
        } else {
            return new Enemy("Lich", RpgUtil.randInt(20, 30), 35, 35, 25, 125, 10, 10, 10, 7);
        }
    }

    public static Enemy newBossEnemy1() {
        //HP att def acc ev
        return new Enemy("Bahamut", 20, 70, 40, 40, 140, 30, 50, 100, 6, 0);
    }

    public static Enemy newBossEnemy2() {
        //HP att def acc ev
        return new Enemy("Valkyrie", 30, 100, 50, 60, 150, 40, 100, 200, 8, 1);
    }

    public static Enemy newBossEnemy3() {
        //HP att def acc ev
        return new Enemy("Chaos", 50, 200, 100, 100, 170, 60, 300, 400, 9, 2);
    }

    public static Enemy newBossEnemy777() {
        //HP att def acc ev
        return new Enemy("Mike Chan", 999, 999, 999, 999, 999, 999);
    }

    private Enemy(String name, int level, int hp, int attack, int defend, int accuracy, int evasion, int exp, int money, int skill) {
        this.name = name;
        this.level = level + (50 * Hero.getNewGamePlusCounter());
        this.attack = attack + this.level;
        this.defend = defend + this.level;
        this.hp = hp + this.level * 2;
        this.exp = exp * this.level;
        this.money = (money + this.level) * 10;
        this.accuracy = accuracy + (this.level * 2);
        this.evasion = evasion + (this.level * 2);
        this.skill1 = skill;
    }

    private Enemy(String name, int level, int hp, int attack, int defend, int accuracy, int evasion, int exp, int money, int skill, int skill2) {
        this.name = name;
        this.level = level + (50 * Hero.getNewGamePlusCounter());
        this.attack = attack + this.level;
        this.defend = defend + this.level;
        this.hp = hp + this.level * 2;
        this.exp = exp * this.level;
        this.money = (money + this.level) * 10;
        this.accuracy = accuracy + (this.level * 2);
        this.evasion = evasion + (this.level * 2);
        this.skill1 = skill;
        this.skill2 = skill2;
    }

    private Enemy(String name, int level, int hp, int attack, int defend, int accuracy, int evasion) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defend = defend;
        this.hp = hp;
        this.accuracy = accuracy;
        this.evasion = evasion;

    }

    public int getAttack() {
        return attack;
    }

    public int getMoney() {
        return money;
    }

    public int getDefend() {
        return defend;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return hp;
    }

    public int getExp() {
        return exp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getEvasion() {
        return evasion;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getSkill1() {
        return skill1;
    }

    public int getSkill2() {
        return skill2;
    }

    

}
