/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Enemy;
import ui.Menu;
import util.RpgUtil;
import java.io.Serializable;

/**
 *
 * @author Phantom
 */
public class Hero implements Serializable {

    private static final long serialVersionUID = 1L;

    private int hp = 100;
    private int stamina = 10;
    private int money = 0;
    private String name, enemyName;
    private int mp = 5;
    private int maxMp = 5;
    private int maxHp = 100;
    private int maxStamina = 10;
    private int exp;
    private int expToLevel = 100;
    private int heroLevel = 1;
    private int xpModiffiers = 4;
    private int dType;
    private static int statToUseStatic = 0;
    private int attack = 10, oAttack = 10;
    private int defend = 10, oDefend = 10;
    private int enemyDamageTaken, playerDamageTaken;
    private int accuracy = 100, evasion = 0, oAccuracy = 100, oEvasion = 0;
    private int finalBossCounter;
    private int newGamePlusCounter = 0;
    private static int newGamePlusCounterStatic = 0;
    private int secretBossCounter = 0;

    private static int[] skillLevelStatic = {1, 1, 1, 1, 0};
    private int[] skillCounter = {0, 0, 0, 0, 0};
    /*
    skillCounter[0] for iron guard
    skillCounter[1] for rage
    skillcounter[2] for eagle eye
    skillcounter[3] for illusion
     */

    private static int[] weaponCounterStatic = {0, 0, 0, 0, 0, 0, 0};
    /*
    weaponCounter[0]=wooden sword
    weaponCounter[1]=Myhril sword
    weaponCounter[2]=Holy sword
    weaponCounter[3]=butterfly dagger
    weaponCounter[4]=ghost rapier
    
     */
    private static int[] armorCounterStatic = {0, 0, 0, 0, 0, 0, 0};
    /*
    armorCounter[0]=leather armor
    armorCounter[1]=silver armor
    weaponCounter[2]=Holy armor
    armorCounter[3]=Thief cape
    weaponCounter[4]=Assassin robe
     */
    private int[] enemyBadStatCounter = {0, 0, 0, 0, 0};
    /*
    stat[0]=burn
     */

    public boolean alive;
    public Enemy a = null;

    private static int[] magicLevelCounterStatic = {1, 1, 1, 1, 0};
    /*
    magicCounter[0] for Heal
    magicCounter[1] for Inferno
    magiccounter[2] for Assasinate
    magiccounter[3] for Black hole
     */

    //static to non static for saving purpose
    private int statToUse = 0;

    private int[] skillLevel = {1, 1, 1, 1, 0};
    private int[] weaponCounter = {0, 0, 0, 0, 0, 0, 0};
    private int[] armorCounter = {0, 0, 0, 0, 0, 0, 0};
    private int[] magicLevelCounter = {1, 1, 1, 1, 0};

    private void saveToStatic() {
        statToUseStatic = statToUse;

        skillLevelStatic[0] = skillLevel[0];
        skillLevelStatic[1] = skillLevel[1];
        skillLevelStatic[2] = skillLevel[2];
        skillLevelStatic[3] = skillLevel[3];
        weaponCounterStatic[0] = weaponCounter[0];
        weaponCounterStatic[1] = weaponCounter[1];
        weaponCounterStatic[2] = weaponCounter[2];
        weaponCounterStatic[3] = weaponCounter[3];
        weaponCounterStatic[4] = weaponCounter[4];
        armorCounterStatic[0] = armorCounter[0];
        armorCounterStatic[1] = armorCounter[1];
        armorCounterStatic[2] = armorCounter[2];
        armorCounterStatic[3] = armorCounter[3];
        armorCounterStatic[4] = armorCounter[4];
        newGamePlusCounterStatic = newGamePlusCounter;
        magicLevelCounterStatic[0] = magicLevelCounter[0];
        magicLevelCounterStatic[1] = magicLevelCounter[1];
        magicLevelCounterStatic[2] = magicLevelCounter[2];
        magicLevelCounterStatic[3] = magicLevelCounter[3];

    }

    public void showStatus() {
        saveToStatic();
        statModiffierByItem();
        //back to original att/def
        attack = oAttack;
        defend = oDefend;
        accuracy = oAccuracy;
        evasion = oEvasion;

        //player HP check
        if (hp <= 0) {
            hp = 1;
        }
        if (hp >= maxHp) {
            hp = maxHp;
        }
        System.out.print("              ");
        System.out.println(RpgUtil.ANSI_BG_CYAN+RpgUtil.ANSI_BLACK + "|| " + name + " ||"+RpgUtil.ANSI_RESET);
        System.out.println("Hero Level :" + heroLevel + "    exp:" + exp + "/" + expToLevel + "    Attack:" + attack);
        System.out.println("HP         :" + hp + "/" + maxHp + "           Defend:" + defend);
        System.out.println("MP         :" + mp + "/" + maxMp + "               Accuracy:" + accuracy + "%");
        System.out.println("Stamina    :" + stamina + "/" + maxStamina + "             Evasion:" + evasion + "%");
        System.out.println("Money      :" + money + " gold");
        //Level up
        for (int i = 1; i <= 30; i++) {
            if (exp >= expToLevel) {
                xpModiffiers++;
                heroLevel++;
                exp = exp - expToLevel;
                expToLevel = expToLevel + 10 * xpModiffiers;
                statToUse = statToUse + 3;
            }
        }
    }

    //set Dungeon type
    /*
    dType 1= Dungeon 1
    dType 2= DUngeon 2
    dType 3= DUngeon 3
    dType 11=Boss 1
    dType 12=boss 2
    dType 13=boss 3
     */
    public void setdType(int dType) {
        this.dType = dType;
    }

    public void showStatusWithEnemy() {

        //check enemy still alive or not
        if (alive == false) {
            if (dType == 1) {
                a = Enemy.newRandomEnemyD1();
                alive = true;
                finalBossCounter = 3;
            } else if (dType == 2) {
                a = Enemy.newRandomEnemyD2();
                alive = true;
                finalBossCounter = 3;
            } else if (dType == 3) {
                a = Enemy.newRandomEnemyD3();
                alive = true;
                finalBossCounter = 3;
            } else if (dType == 11) {
                a = Enemy.newBossEnemy1();
                alive = true;
                finalBossCounter = 3;
            } else if (dType == 12) {
                a = Enemy.newBossEnemy2();
                alive = true;
                finalBossCounter = 3;
            } else if (dType == 13) {
                a = Enemy.newBossEnemy3();
                alive = true;
                finalBossCounter = 0;
            } else if (dType == 777) {
                a = Enemy.newBossEnemy777();
                alive = true;
                finalBossCounter = 3;
                secretBossCounter = 1;
            }
            skillCounter[0] = 0;
            skillCounter[1] = 0;
            skillCounter[2] = 0;
            skillCounter[3] = 0;
            enemyBadStatCounter[0] = 0;
        }
        //enemy HP check
        if (a.getHP() <= 0) {
            a.setHP(0);
        }

        //back to original att/def
        attack = oAttack;
        defend = oDefend;
        accuracy = oAccuracy;
        evasion = oEvasion;

        //player HP check
        if (hp <= 0) {
            hp = 0;
        }
        if (hp >= maxHp) {
            hp = maxHp;
        }
        //make sure skill counter >=0
        if (skillCounter[0] <= 0) {
            skillCounter[0] = 0;
        }
        if (skillCounter[1] <= 0) {
            skillCounter[1] = 0;
        }
        if (skillCounter[2] <= 0) {
            skillCounter[2] = 0;
        }
        if (skillCounter[3] <= 0) {
            skillCounter[3] = 0;
        }
        //makse sure enemy bad stat counter >=0
        if (enemyBadStatCounter[0] <= 0) {
            enemyBadStatCounter[0] = 0;
        }
        //Skill 1 buff
        if (skillCounter[0] > 0) {
            defend = (int) (oDefend + (oDefend * (0.25 * skillLevel[0])));
        }
        //Skill 2 buff
        if (skillCounter[1] > 0) {
            attack = (int) (oAttack + (oAttack * (0.25 * skillLevel[1])));
        }
        if (skillCounter[2] > 0) {
            accuracy = (oAccuracy + (10 * skillLevel[2]));
        }
        if (skillCounter[3] > 0) {
            evasion = (oEvasion + (10 * skillLevel[3]));
        }
        System.out.print("       ");
        System.out.print(RpgUtil.ANSI_BG_CYAN+RpgUtil.ANSI_BLACK + "|| " + name + " ||"+RpgUtil.ANSI_RESET+ "\t\t     ");
        
        System.out.println(RpgUtil.ANSI_BG_RED +RpgUtil.ANSI_BLACK+ "|| " + a.getName() + " ||"+RpgUtil.ANSI_RESET);
        System.out.println("Hero Level :" + heroLevel + "\t\t|" + " Enemy Level  :" + a.getLevel());
        System.out.println("HP         :" + hp + "/" + maxHp + "\t|" + " Hp           :" + a.getHP());
        System.out.println("MP         :" + mp + "/" + maxMp + "\t\t| Attack       :" + a.getAttack());
        System.out.println("Attack     :" + attack + "\t\t|" + " Defend       :" + a.getDefend());
        System.out.println("Defend     :" + defend + "\t\t|" + " Accuracy     :" + a.getAccuracy());
        System.out.println("Accuracy   :" + accuracy + "\t\t|" + " Evasion      :" + a.getEvasion());
        System.out.println("Evasion    :" + evasion + "\t\t|");
        if (skillCounter[0] > 0) {
            System.out.println("Defend up by " + (25 * skillLevel[0]) + "% for " + skillCounter[0] + " turn");
        }
        if (skillCounter[1] > 0) {
            System.out.println("Attack up by " + (25 * skillLevel[1]) + "% for " + skillCounter[1] + " turn");
        }
        if (skillCounter[2] > 0) {
            System.out.println("Accuracy up by " + (10 * skillLevel[2]) + " for " + skillCounter[2] + " turn");
        }
        if (skillCounter[3] > 0) {
            System.out.println("Evasion up by " + (10 * skillLevel[3]) + " for " + skillCounter[3] + " turn");
        }
        if (enemyBadStatCounter[0] > 0) {
            System.out.println("Enemy got burn for " + enemyBadStatCounter[0] + " turn");
        }
        //check enemy
        checkEnemyAliverOrNot();
        if (hp <= 0 && secretBossCounter == 1) {
            System.out.println(RpgUtil.ANSI_RED + "------------------");
            System.out.println(RpgUtil.ANSI_RED + "    you died");
            System.out.println(RpgUtil.ANSI_RED + "------------------");
            System.out.println("You are 100 years to early to beat The legendary teacher");
            alive = false;
            hp = 1;
            secretBossCounter=0;

        }
        //player died
        if (hp <= 0) {
            System.out.println(RpgUtil.ANSI_RED + "------------------");
            System.out.println(RpgUtil.ANSI_RED + "    you died");
            System.out.println(RpgUtil.ANSI_RED + "------------------");

            System.out.println("You lose " + heroLevel * 50 + " gold");
            reduceStat(0, 0, heroLevel * 50, 0);
            alive = false;
            hp = 1;

        }
    }

    public void checkEnemyAliverOrNot() {
        //enemy died
        if (a.getHP() <= 0) {
            reduceStat(0, 0, -a.getMoney(), -a.getExp());
            System.out.println(" you killed the " + a.getName());
            System.out.println("You get " + a.getExp() + " exp and " + a.getMoney() + " gold");

            alive = false;
            //final boss only
            if (finalBossCounter == 0) {
                finalBossCounter++;
            }
            if (alive == false && finalBossCounter == 1) {
                Menu.bossPopUp();
                newGamePlusCounter++;
            }
        }
    }

    public void attack() {
        if (secretBossCounter == 1) {
            System.out.println(" Your attack are too slow to hit");
        } else if (RpgUtil.chanceOver100(accuracy - a.getEvasion())) {
            if (attack - a.getDefend() <= 0) {
                enemyDamageTaken = 1;
            } else {
                enemyDamageTaken = attack - a.getDefend();
            }
            a.setHP(a.getHP() - enemyDamageTaken);
            System.out.println("Attack Success, you deal " + enemyDamageTaken + " damage");
        } else {
            System.out.println("Your attack missed");
        }
        //reduce skill counter
        skillCounter[0]--;
        skillCounter[1]--;
        skillCounter[2]--;
        skillCounter[3]--;

    }

    public void enemyAttack() {
        if (secretBossCounter == 1) {
            System.out.println("The Legendary teacher teach Advance Programming skill...");
            System.out.println("Your brain are too weak to receive the lesson");
            
            hp = 0;
        } else if (RpgUtil.chanceOver100(80)) {
            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {
                if (a.getAttack() - defend <= 0) {
                    playerDamageTaken = 1;
                } else {
                    playerDamageTaken = a.getAttack() - defend;
                }

                hp = hp - playerDamageTaken;
                System.out.println("Enemy Attack , you take " + playerDamageTaken + " damage");
            } else {
                System.out.println("Enemy attack miss");
            }
        } else {
            enemySkill1(a.getSkill1());
        }
        if (enemyBadStatCounter[0] > 0) {
            enemyDamageTaken = 5 * magicLevelCounter[1];
            a.setHP(a.getHP() - enemyDamageTaken);
            System.out.println(" Enemy take " + enemyDamageTaken + " from burn");
            enemyBadStatCounter[0]--;
        }
    }

    public void bossAttack() {
        if (RpgUtil.chanceOver100(60)) {
            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {
                if (a.getAttack() - defend <= 0) {
                    playerDamageTaken = 1;
                } else {
                    playerDamageTaken = a.getAttack() - defend;
                }

                hp = hp - playerDamageTaken;
                System.out.println("Enemy Attack , you take " + playerDamageTaken + " damage");
            } else {
                System.out.println("Enemy attack miss");
            }
        } else if (RpgUtil.chanceOver100(30)) {
            enemySkill1(a.getSkill1());
        } else {
            enemySkill2(a.getSkill2());
        }
        if (enemyBadStatCounter[0] > 0) {
            enemyDamageTaken = 5 * magicLevelCounter[1];
            a.setHP(a.getHP() - enemyDamageTaken);
            System.out.println(" Enemy take " + enemyDamageTaken + " from burn");
            enemyBadStatCounter[0]--;
        }
    }

    public void healMagic() {
        if (hp == maxHp) {
            System.out.println("Your HP is full");
        } else if (mp <= 0) {
            System.out.println("Not enough MP");
        } else {
            hp = hp + (int) ((double) maxHp * ((double) (10 * magicLevelCounter[0]) / 100));
            mp--;
            System.out.println("You cast Heal magic");
            System.out.println("HP increase by " + (int) ((double) hp * ((double) (10 * magicLevelCounter[0]) / 100)) + " HP");
            checkEnemyAliverOrNot();
            enemyAttack();
        }
    }

    public void infernoMagic() {
        if (mp <= 0) {
            System.out.println("Not enough MP");
        } else if (enemyBadStatCounter[0] > 0) {
            System.out.println("Enemy still burning");
        } else {
            enemyBadStatCounter[0] += 3;
            System.out.println("You cast Inferno magic");
            System.out.println("Enemy got burn for 3 turn");
            mp--;
            checkEnemyAliverOrNot();
            enemyAttack();
        }
    }

    public void assasinateMagic() {
        if (mp <= 0) {
            System.out.println("Not enough MP");
        } else {
            System.out.println("You cast Assassinate magic");
            enemyDamageTaken = (int) ((double) a.getHP() * ((double) (10 * magicLevelCounter[2]) / 100));
            a.setHP(a.getHP() - (int) ((double) a.getHP() * ((double) (10 * magicLevelCounter[2]) / 100)));
            System.out.println("Enemy take " + enemyDamageTaken);
            mp--;
            checkEnemyAliverOrNot();
            enemyAttack();
        }
    }

    public void blackHoleMagic() {
        if (mp <= 0) {
            System.out.println("Not enough MP");
        } else {
            System.out.println("You cast Black Hole magic");
            a.setHP(a.getHP() - magicLevelCounter[3] * 10);
            System.out.println("Enemy take" + magicLevelCounter[3] * 10);
            mp--;
            checkEnemyAliverOrNot();
            enemyAttack();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getStatToUse() {
        return statToUseStatic;
    }

    public static int getWeaponCounter(int i) {
        return weaponCounterStatic[i];
    }

    public static int getArmorCounter(int i) {
        return armorCounterStatic[i];
    }

    public static int getSkillLevel(int i) {
        return skillLevelStatic[i];
    }

    public static int getNewGamePlusCounter() {
        return newGamePlusCounterStatic;
    }

    public static int getMagicLevelCounterStatic(int i) {
        return magicLevelCounterStatic[i];
    }

    public void upgradeStat(int hp, int stamina, int mp) {
        if (statToUse > 0) {
            this.maxHp = this.maxHp + hp;
            this.maxStamina = this.maxStamina + stamina;
            this.maxMp = this.maxMp + mp;
            this.statToUse--;
        } else {
            System.out.println("------------------");
            System.out.println("not enough point");
            System.out.println("------------------");
        }
    }

    public void reduceStat(int hp, int stamina, int money, int exp) {
        //check if enough energy/money or not
        int valid = 1;

        if (this.stamina - stamina >= 0) {
            this.stamina = this.stamina - stamina;

        } else {
            System.out.println("------------------");
            System.out.println("not enough stamina");
            System.out.println("------------------");
            valid = 0;
        }

        if (valid == 1) {
            if (this.money - money >= 0) {
                this.money = this.money - money;
                this.exp = this.exp - exp;

            } else {
                System.out.println("not enough gold");
            }
        }

    }

    public void reduceStat(int stamina, int money, int exp) {
        //check if enough energy/money or not
        int valid = 1;

        if (this.stamina - stamina >= 0) {
            this.stamina = this.stamina - stamina;

        } else {
            System.out.println("------------------");
            System.out.println("not enough stamina");
            System.out.println("------------------");
            valid = 0;
        }

        if (valid == 1) {
            if (this.money - money >= 0) {
                this.money = this.money - money;
                this.exp = this.exp - exp;
                System.out.println("------------------");
                System.out.println(" Quest Success");
                System.out.println("------------------");
            } else {
                System.out.println("not enough gold");
            }
        }

    }

    public void buyWeapon(int index, int price) {
        if (money - price < 0) {
            System.out.println("Not enough gold");
        } else {
            weaponCounter[index - 1]++;
            money = money - price;
        }
    }

    public void buyArmor(int index, int price) {
        if (money - price < 0) {
            System.out.println("Not enough gold");
        } else {
            armorCounter[index - 1]++;
            money = money - price;
        }
    }

    public void buySkill(int index, int price) {
        if (money - price < 0) {
            System.out.println("Not enough gold");
        } else {
            skillLevel[index - 1]++;

            money = money - price;
        }
    }

    public void buyMagic(int index, int price) {
        if (money - price < 0) {
            System.out.println("Not enough gold");
        } else {
            magicLevelCounter[index - 1]++;

            money = money - price;
        }
    }

    public void statModiffierByItem() {
        oAttack = 10 + (1 * weaponCounter[0]) + (5 * weaponCounter[1]) + (10 * weaponCounter[2]) + (5 * weaponCounter[3]) + (5 * weaponCounter[4]);
        oDefend = 10 + (1 * armorCounter[0]) + (5 * armorCounter[1]) + (10 * armorCounter[2]) + (5 * armorCounter[3]) + (5 * armorCounter[4]);
        oAccuracy = 100 + (5 * weaponCounter[3]) + (10 * weaponCounter[4]);
        oEvasion = 0 + (5 * armorCounter[3]) + (10 * armorCounter[4]);
    }

    public void defendSkill() {
        if (skillCounter[0] <= 0) {
            skillCounter[0] = 3;
            System.out.println("You use Defend Skill");
            enemyAttack();
        } else {
            System.out.println(" Defend skill still active");
        }
    }

    public void rageSkill() {
        if (skillCounter[1] <= 0) {
            skillCounter[1] = 3;
            enemyAttack();
            System.out.println("You use Rage Skill");
        } else {
            System.out.println(" Defend skill still active");
        }
    }

    public void eagleEyeSkill() {
        if (skillCounter[2] <= 0) {
            skillCounter[2] = 5;
            System.out.println("You use Eagle Eye Skill");
            enemyAttack();
        } else {
            System.out.println(" Eagle Eye skill still active");
        }
    }

    public void illusionSkill() {
        if (skillCounter[3] <= 0) {
            skillCounter[3] = 5;
            System.out.println("You use Illusion Skill");
            enemyAttack();
        } else {
            System.out.println(" Illusion skill still active");
        }
    }

    public void run() {
        alive = false;
        System.out.println("You ran from " + a.getName());
    }

    public void rest() throws InterruptedException {
        hp = maxHp;
        stamina = maxStamina;
        mp = maxMp;
        System.out.print("Resting");
        Thread.sleep(300);
        System.out.print(".");
        Thread.sleep(300);
        System.out.print(".");
        Thread.sleep(300);
        System.out.print(".");
        Thread.sleep(300);
        System.out.print(".");
    }

    //Enemy Skill
    /*
    skill 0= critical hit
    skill 1=death spell
    skill 2=Heavy Slash
    skill 3=Planetary Devastation
    skill 4=Life Steal
    skill 5=almaghest
    skill 6=flare
     */
    //Boss skill
    /*
    skill 1= Mega Flare
     */
    private void enemySkill1(int skill) {
        if (skill == 0) {
            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {
                if (a.getAttack() - defend <= 0) {
                    playerDamageTaken = 2;
                } else {
                    playerDamageTaken = 2 * (a.getAttack() - defend);
                }

                hp = hp - playerDamageTaken;
                System.out.println("Enemy hit is critical , you take " + playerDamageTaken + " damage");
            } else {
                System.out.println("Enemy atack miss");
            }
        } else if (skill == 1) {
            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {
                if (a.getAttack() - defend <= 0) {
                    playerDamageTaken = 3;
                } else {
                    playerDamageTaken = 3 * (a.getAttack() - defend);
                }
                hp = hp - playerDamageTaken;
                System.out.println("Enemy cast Death Spell , you take " + playerDamageTaken + " damage");
            } else {
                System.out.println("Enemy skill miss");
            }
        } else if (skill == 2) {

            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {

                playerDamageTaken = 20;
                hp = hp - playerDamageTaken;
                System.out.println("Enemy use Heavy slash , you take " + playerDamageTaken + " damage");
            } else {
                System.out.println("Enemy skill miss");
            }

        } else if (skill == 3) {

            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {

                playerDamageTaken = 50;
                hp = hp - playerDamageTaken;
                System.out.println("Enemy use Planetary Devastation , you take " + playerDamageTaken + " damage");
            } else {
                System.out.println("Enemy skill miss");
            }

        } else if (skill == 4) {

            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {

                if (a.getAttack() - defend <= 0) {
                    playerDamageTaken = 3;
                } else {
                    playerDamageTaken = (a.getAttack() - defend);
                }

                hp = hp - playerDamageTaken;
                enemyDamageTaken = -playerDamageTaken;
                System.out.println("Enemy use Life Steal , you take " + playerDamageTaken + " damage");
                System.out.println("Enemy gain " + -enemyDamageTaken + " HP");
            } else {
                System.out.println("Enemy skill miss");
            }

        } else if (skill == 6) {

            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {

                playerDamageTaken = 50;
                hp = hp - playerDamageTaken;
                System.out.println("Enemy use Flare beam , you take " + playerDamageTaken + " damage");

            } else {
                System.out.println("Enemy skill miss");
            }

        } else if (skill == 7) {

            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {

                playerDamageTaken = 100;
                hp = hp - playerDamageTaken;
                System.out.println("Enemy use Ultima beam , you take " + playerDamageTaken + " damage");

            } else {
                System.out.println("Enemy skill miss");
            }

        } else if (skill == 8) {

            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {

                playerDamageTaken = 250;
                hp = hp - playerDamageTaken;
                System.out.println("Enemy use Valkyrie Drive Saber , you take " + playerDamageTaken + " damage");

            } else {
                System.out.println("Enemy skill miss");
            }

        } else if (skill == 9) {

            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {

                playerDamageTaken = 300;
                hp = hp - playerDamageTaken;
                System.out.println("Enemy use Chaos Soul , you take " + playerDamageTaken + " damage");

            } else {
                System.out.println("Enemy skill miss");
            }

        }
    }
// boss skill

    private void enemySkill2(int skill) {
        if (skill == 0) {
            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {
                playerDamageTaken = 100;

                hp = hp - playerDamageTaken;
                System.out.println("Enemy use Mega Flare , you take " + playerDamageTaken + " damage");
            } else {
                System.out.println("Enemy atack miss");
            }
        } else if (skill == 1) {
            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {
                playerDamageTaken = hp / 2;
                hp = hp - playerDamageTaken;

                System.out.println("Enemy use Valhalla Curse , you take " + playerDamageTaken + " damage");
            } else {
                System.out.println("Enemy atack miss");
            }
        } else if (skill == 2) {
            if (RpgUtil.chanceOver100(a.getAccuracy() - evasion)) {
                playerDamageTaken = -(1 - hp);
                hp = hp - playerDamageTaken;

                System.out.println("Enemy use Heavens Pulse , you take " + playerDamageTaken + " damage");
            } else {
                System.out.println("Enemy atack miss");
            }
        }
    }
    public static void battleWithEnemy(Hero hero1, int questOption) {
        do {

            hero1.showStatusWithEnemy();
            if (hero1.alive) {
                questOption = Menu.battleWithEnemy();
            }
            if (questOption == 1) {
                hero1.attack();
                if (hero1.alive) {
                    hero1.enemyAttack();
                }
                questOption = 0;
            } else if (questOption == 2) {
                questOption = Menu.skillMenu();
                if (questOption == 1) {
                    hero1.defendSkill();
                } else if (questOption == 2) {
                    hero1.rageSkill();
                } else if (questOption == 3) {
                    hero1.eagleEyeSkill();
                } else if (questOption == 4) {
                    hero1.illusionSkill();
                } else if (questOption == 5) {

                }
            } else if (questOption == 3) {
                questOption = Menu.magicMenu();
                if (questOption == 1) {
                    hero1.healMagic();
                } else if (questOption == 2) {
                    hero1.infernoMagic();
                } else if (questOption == 3) {
                    hero1.assasinateMagic();
                } else if (questOption == 4) {
                    hero1.blackHoleMagic();
                } else if (questOption == 5) {

                }hero1.checkEnemyAliverOrNot();
            } else if (questOption == 4) {
                hero1.run();
            }

        } while (hero1.alive);
    }
    public static void battleWithBoss(Hero hero1, int questOption) {
        do {

            hero1.showStatusWithEnemy();
            if (hero1.alive) {
                questOption = Menu.battleWithEnemy();
            }
            if (questOption == 1) {
                hero1.attack();
                if (hero1.alive) {
                    hero1.bossAttack();
                }
                questOption = 0;
            } else if (questOption == 2) {
                questOption = Menu.skillMenu();
                if (questOption == 1) {
                    hero1.defendSkill();
                } else if (questOption == 2) {
                    hero1.rageSkill();
                } else if (questOption == 3) {
                    hero1.eagleEyeSkill();
                } else if (questOption == 4) {
                    hero1.illusionSkill();
                } else if (questOption == 5) {

                }
            } else if (questOption == 3) {
                questOption = Menu.magicMenu();
                if (questOption == 1) {
                    hero1.healMagic();
                } else if (questOption == 2) {
                    hero1.infernoMagic();
                } else if (questOption == 3) {
                    hero1.assasinateMagic();
                } else if (questOption == 4) {
                    hero1.blackHoleMagic();
                } else if (questOption == 5) {

                }hero1.checkEnemyAliverOrNot();
            } else if (questOption == 4) {
                hero1.run();
            }

        } while (hero1.alive);
    }public static void battleWithSecretBoss(Hero hero1, int questOption) {
        do {

            hero1.showStatusWithEnemy();
            if (hero1.alive) {
                questOption = Menu.battleWithEnemy();
            }
            if (questOption == 1) {
                hero1.attack();
                if (hero1.alive) {
                    hero1.bossAttack();
                }
                questOption = 0;
            } else if (questOption == 2) {
                questOption = Menu.skillMenu();
                if (questOption == 1) {
                    System.out.println("Your skill are useless againts the legendary teacher");
                } else if (questOption == 2) {
                    System.out.println("Your skill are useless againts the legendary teacher");
                } else if (questOption == 3) {
                    System.out.println("Your skill are useless againts the legendary teacher");
                } else if (questOption == 4) {
                    System.out.println("Your skill are useless againts the legendary teacher");
                } else if (questOption == 5) {

                }
            } else if (questOption == 3) {
                questOption = Menu.magicMenu();
                if (questOption == 1) {
                    System.out.println("Your magic can't even scratch the legendary teacher");
                } else if (questOption == 2) {
                    System.out.println("Your magic can't even scratch the legendary teacher");
                } else if (questOption == 3) {
                    System.out.println("Your magic can't even scratch the legendary teacher");
                } else if (questOption == 4) {
                    System.out.println("Your magic can't even scratch the legendary teacher");
                } else if (questOption == 5) {

                }hero1.checkEnemyAliverOrNot();
            } else if (questOption == 4) {
                System.out.println("No one can escape the Legendary Teacher");
            }

        } while (hero1.alive);
    }

}
