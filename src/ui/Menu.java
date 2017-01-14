/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.Hero;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import javax.swing.JOptionPane;
import util.RpgUtil;

/**
 *
 * @author Phantom
 */
public class Menu {

    static Scanner option = new Scanner(System.in);
    static Scanner inputString = new Scanner(System.in);

    public static String inputName() {
        String name;
        do {
            System.out.print("Input your hero name:");
            name = inputString.next();
        } while (name == null);
        String message = String.format("hi %s ,welcome to My Game \n-By Kenichi", name);
        JOptionPane.showMessageDialog(null, message);
        return name;
    }

    public static void showChangelog() {
        StringBuilder sb = new StringBuilder();
        sb.append("Changelog:\n"
                + "v0.3\n"
                + "-added upgrade status feature,fix exp bug\n"
                + "v0.4 \n"
                + "-added dungeon menu,battle with enemy,added new quest\n"
                + "v0.45\n"
                + "-added new enemy,skill feature,enemy drop money\n"
                + "v0.5\n"
                + "-added shop feature,added new armor & weapon\n"
                + "v0.55\n"
                + "-added clear screen function\n"
                + "v0.6 {2nd dungeon appear)\n"
                + "-upgrade the battle system,new dungeon with harder enemy\n"
                + "v0.7(Major update!!!)(4 Nov 2016)\n"
                + "-name input bug fix,add save and load feature,confirm before exit\n"
                + "-fix the save bug,add evasion and accuracy stat to player and enemy\n"
                + "v0.75\n"
                + "-minor save bug fix,add skill shop\n"
                + "v0.8 \n"
                + "-skill bug fix,enemy have skill,boss feature\n"
                + "v0.9\n"
                + "-added final boss,3rd dungeon\n"
                + "v1.0\n"
                + "-added magic feature,added magic shop,new skill");

        JOptionPane.showMessageDialog(null, sb.toString(), "Changelog", 1);
    }
    public static void showAboutMe() {
        StringBuilder sb = new StringBuilder();
        sb.append("About Me: \n"
                + "Name: Kenichi-(AKA PhantomX7)\n"
                + "SSID:22848\n"
                + "Class:16-IS2\n"
                + "      UPH Medan 2016");

        JOptionPane.showMessageDialog(null, sb.toString(), "About Me", 1);
    }

    public static void introduction() throws InterruptedException {
        System.out.println("Welcome Hero, You are the chosen one to defeat Chaos.");
        Thread.sleep(450);
        System.out.println("But First you need some experience in battle and strong "
                + "enough to beat him.");
        Thread.sleep(450);
        System.out.println("If you feel confident enough try to battle him in the Ruin of the Abyss.");
        Thread.sleep(450);
        System.out.println("You can start by doing quest and hunt for monster in Dungeon.");

    }

    public static int startMenu() {
        System.out.println(RpgUtil.ANSI_BG_RED + "                                                             ");
        System.out.println(RpgUtil.ANSI_BG_RED + RpgUtil.ANSI_YELLOW + "                      Ordeal of Knight                       ");
        System.out.println(RpgUtil.ANSI_BG_RED + "                    © Kenichi-(PhantomX7)                    ");
        System.out.println(RpgUtil.ANSI_BG_RED + "                                                             ");
        System.out.println(RpgUtil.ANSI_RESET+"");
        System.out.println("\\\\+++++Ordeal of Knight v1.0+++++//");
        
        System.out.println("||                               ||");
        System.out.println("||      1.New Game               ||");
        System.out.println("||      2.Load game              ||");
        System.out.println("||      3.Changelog              ||");
        System.out.println("||      4.About me               ||");
        System.out.println("||      5.Exit                   ||");
        System.out.println("===================================");

        int choice = 0;
        do {
            System.out.print("What do you want to do?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("What do you want to do?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Please input 1-5!!!");
            }
        } while (choice < 1 || choice > 5);
        return choice;
    }

    public static int mainMenu() {

        System.out.println("\\\\=====Main Menu======//");
        System.out.println("1.Quest");
        System.out.println("2.Dungeon");
        System.out.println("3.Boss Dungeon");
        System.out.println("4.Upgrade Status");
        System.out.println("5.Shop");
        System.out.println("6.Rest");
        System.out.println("7.Home");
        System.out.println("8.Exit");
        int choice = 0;
        do {
            System.out.print("What do you want to do?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("What do you want to do?:");
            }
            choice = option.nextInt();
            if ((choice < 1 || choice > 8) && !(choice == 777)) {
                System.out.println("Please input 1-8!!!");
            }
        } while ((choice < 1 || choice > 8) && !(choice == 777));
        return choice;
    }

    public static int homeMenu() {

        System.out.println("\\\\======Home=====//");

        System.out.println("1.Save");
        System.out.println("2.Load");
        System.out.println("3.Exit");
        int choice = 0;
        do {
            System.out.print("What do you want to do?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("What do you want to do?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Please input 1-3!!!");
            }
        } while (choice < 1 || choice > 3);
        return choice;
    }

    public static int questMenu() {

        System.out.println("\\\\=====Quest=====//");
        System.out.println("1.Goblin Hunt (-1 stamina/+10 gold/+10 xp)");
        System.out.println("2.Raid bandit camp (-3 stamina/+40 gold/+20 xp)");
        System.out.println("3.Invade Troll cave(-5 stamina/+70 gold/+30 xp)");
        System.out.println("4.Dragon hunt(-7 stamina/+100 gold/+50 xp)");
        System.out.println("5.Back to Main Menu");
        int choice = 0;
        do {
            System.out.print("Which quest do you want to do?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("Which quest do you want to do?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Please input 1-5!!!");
            }
        } while (choice < 1 || choice > 5);
        return choice;

    }

    public static int secretBossMenu() {

        System.out.println("\\\\=====Secret Boss=====//");
        System.out.println("1.The Legendary Teacher, M chan");
        System.out.println("2.Back to Main Menu");
        int choice = 0;
        do {
            System.out.print("Which quest do you want to do?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("Which quest do you want to do?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Please input 1-2!!!");
            }
        } while (choice < 1 || choice > 2);
        return choice;

    }

    public static void questSuccess() {
        System.out.println("------------------");
        System.out.println(" Quest Success");
        System.out.println("------------------");
    }

    public static int dungeonMenu() {

        System.out.println("\\\\=====Dungeon=====//");
        System.out.println("1.Haunted village Expedition(recommended level 1+)");
        System.out.println("2.Castle of death(recommended level 12+)");
        System.out.println("3.Pandaemonium(recommende level 25+)");
        System.out.println("4.Back to Main Menu");
        int choice = 0;
        do {
            System.out.print("Which dungeon do you want to go?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("Which dungeon do you want to go?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Please input 1-4!!!");
            }
        } while (choice < 1 || choice > 4);
        return choice;

    }

    public static int bossMenu() {

        System.out.println("\\\\=====Boss Battle=====//");
        System.out.println("1.Bahamut Lair(recommended level 20+)");
        System.out.println("2.Valhalla (recommended level 30+");
        System.out.println("3.Ruin of the Abyss (recommended level 40+)");
        System.out.println("4.Back to Main Menu");
        int choice = 0;
        do {
            System.out.print("Which dungeon do you want to go?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("Which dungeon do you want to go?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Please input 1-4!!!");
            }
        } while (choice < 1 || choice > 4);
        return choice;

    }

    public static int upgradeMenu() {

        System.out.println("\\\\=====Upgrade=====//");
        System.out.println("Point left:" + Hero.getStatToUse());
        System.out.println("1.+10 max HP (1 point)");
        System.out.println("2.+1 max MP (1 point)");
        System.out.println("3.+1 max Stamina (1 point)");
        System.out.println("4.Back to Main Menu");
        int choice = 0;
        do {
            System.out.print("Which status do you want to increase?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("Which status do you want to increase?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Please input 1-4!!!");
            }
        } while (choice < 1 || choice > 4);
        return choice;

    }

    public static int shopMenu() {

        System.out.println("\\\\=====Shop=====//");
        System.out.println("1.Weapon Shop");
        System.out.println("2.Armor Shop");
        System.out.println("3.Skill Shop");
        System.out.println("4.Magic Shop");
        System.out.println("5.Back to Main Menu");
        int choice = 0;
        do {
            System.out.print("Which shop do you want to visit?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("Which shop do you want to visit?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Please input 1-5!!!");
            }
        } while (choice < 1 || choice > 5);
        return choice;

    }

    public static int weaponShopMenu() {

        System.out.println("\\\\=====Weapon Shop=====//");
        System.out.println("1.Wooden sword (+1 attack,price: " + (100 + (50 * Hero.getWeaponCounter(0))) + "gold)(you have " + Hero.getWeaponCounter(0) + ")");
        System.out.println("2.Mythril sword (+5 attack,price: " + (500 + (100 * Hero.getWeaponCounter(1))) + "gold)(you have " + Hero.getWeaponCounter(1) + ")");
        System.out.println("3.Holy sword (+10 attack,price: " + (950 + (150 * Hero.getWeaponCounter(2))) + "gold)(you have " + Hero.getWeaponCounter(2) + ")");
        System.out.println("4.Butterfly Dagger (+5 attack,+5 accuracy,price: " + (1000 + (200 * Hero.getWeaponCounter(3))) + "gold)(you have " + Hero.getWeaponCounter(3) + ")");
        System.out.println("5.Ghost Rapier (+5 attack,+10 accuracy,price: " + (1250 + (250 * Hero.getWeaponCounter(4))) + "gold)(you have " + Hero.getWeaponCounter(4) + ")");
        System.out.println("6.Back");
        int choice = 0;
        do {
            System.out.print("What weapon do you want to buy?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("What weapon do you want to buy?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 6) {
                System.out.println("Please input 1-6!!!");
            }
        } while (choice < 1 || choice > 6);
        return choice;

    }

    public static int armorShopMenu() {

        System.out.println("\\\\=====Armor Shop=====//");
        System.out.println("1.Leather armor (+1 defend,price: " + (100 + (50 * Hero.getArmorCounter(0))) + "gold)(you have " + Hero.getArmorCounter(0) + ")");
        System.out.println("2.Silver armor (+5 defend,price: " + (500 + (100 * Hero.getArmorCounter(1))) + "gold)(you have " + Hero.getArmorCounter(1) + ")");
        System.out.println("3.Holy armor (+10 defend,price: " + (950 + (150 * Hero.getArmorCounter(2))) + "gold)(you have " + Hero.getArmorCounter(2) + ")");
        System.out.println("4.Thief Cape (+5 defend,+5 evasion,price: " + (1000 + (200 * Hero.getArmorCounter(3))) + "gold)(you have " + Hero.getArmorCounter(3) + ")");
        System.out.println("5.Assassin robe (+5 defend,+10 accuracy,price: " + (1250 + (250 * Hero.getArmorCounter(4))) + "gold)(you have " + Hero.getArmorCounter(4) + ")");
        System.out.println("6.Back");
        int choice = 0;
        do {
            System.out.print("What armor do you want to buy?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("What armor do you want to buy?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 6) {
                System.out.println("Please input 1-6!!!");
            }
        } while (choice < 1 || choice > 6);
        return choice;

    }

    public static int skillShopMenu() {

        System.out.println("\\\\=====Skill Shop=====//");
        System.out.println("1.Iron Guard Lv:" + Hero.getSkillLevel(0) + " Price:" + Hero.getSkillLevel(0) * 500);
        System.out.println("2.Rage Lv:" + Hero.getSkillLevel(1) + " Price:" + Hero.getSkillLevel(1) * 500);
        System.out.println("3.Eagle Eye Lv:" + Hero.getSkillLevel(2) + " Price:" + Hero.getSkillLevel(2) * 500);
        System.out.println("4.Illusion Lv:" + Hero.getSkillLevel(3) + " Price:" + Hero.getSkillLevel(3) * 500);
        System.out.println("5.Back");
        int choice = 0;
        do {
            System.out.print("What armor do you want to buy?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("What armor do you want to buy?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Please input 1-5!!!");
            }
        } while (choice < 1 || choice > 5);
        return choice;

    }

    public static int magicShopMenu() {

        System.out.println("\\\\=====Magic Shop=====//");
        System.out.println("1.Heal Lv:" + Hero.getMagicLevelCounterStatic(0) + " Price:" + Hero.getMagicLevelCounterStatic(0) * 1000);
        System.out.println("2.Inferno Lv:" + Hero.getMagicLevelCounterStatic(1) + " Price:" + Hero.getMagicLevelCounterStatic(1) * 1000);
        System.out.println("3.Assassinate Lv:" + Hero.getMagicLevelCounterStatic(2) + " Price:" + Hero.getMagicLevelCounterStatic(2) * 5000);
        System.out.println("4.Black Hole Lv:" + Hero.getMagicLevelCounterStatic(3) + " Price:" + Hero.getMagicLevelCounterStatic(3) * 500);
        System.out.println("5.Back");
        int choice = 0;
        do {
            System.out.print("What armor do you want to buy?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("What armor do you want to buy?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Please input 1-5!!!");
            }
        } while (choice < 1 || choice > 5);
        return choice;

    }

    public static int skillMenu() {

        System.out.println("\\\\=====Skill=====//");
        System.out.println("1.Iron Guard Lv:" + Hero.getSkillLevel(0) + "(+25% defend for each skill level for 3 turn)");
        System.out.println("2.Rage Lv:" + Hero.getSkillLevel(1) + "(+25% attack for each skill level 3 turn");
        System.out.println("3.Eagle Eye Lv:" + Hero.getSkillLevel(2) + "(+10 accuracy for each skill level for 5 turn)");
        System.out.println("4.Illusion Lv:" + Hero.getSkillLevel(3) + "(+10 evasion for each skill level 5 turn");
        System.out.println("5.back");

        int choice = 0;

        do {
            System.out.print("Which skill do you want to use?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("Which skill do you want to use:?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Please input 1-5!!!");
            }
        } while (choice < 1 || choice > 5);
        return choice;
    }

    public static int magicMenu() {

        System.out.println("\\\\=====Magic=====//");
        System.out.println("1.Heal Lv:" + Hero.getMagicLevelCounterStatic(0) + "(heal hp by 10% HP for each magic level)");
        System.out.println("2.Inferno Lv:" + Hero.getMagicLevelCounterStatic(1) + "(Burn enemy by 5 HP for each magic level for 3 turn");
        System.out.println("3.Assassinate Lv:" + Hero.getMagicLevelCounterStatic(2) + "(Reduce enemy HP by 10% for each magic level)");
        System.out.println("4.Black Hole Lv:" + Hero.getMagicLevelCounterStatic(3) + "(Inflict 10 damage for each magic level)");
        System.out.println("5.back");

        int choice = 0;

        do {
            System.out.print("Which magic do you want to use?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("Which skill do you want to use:?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Please input 1-5!!!");
            }
        } while (choice < 1 || choice > 5);
        return choice;
    }
    public static int battleWithEnemy() {
        Scanner option = new Scanner(System.in);
        System.out.println("\\\\=====Battle=====//");
        System.out.println("1.Attack");
        System.out.println("2.Skill");
        System.out.println("3.Magic");
        System.out.println("4.run");

        int choice = 0;

        do {
            System.out.print("Which do you want to do?:");
            while (!option.hasNextInt()) {
                System.out.println("That's not a number!!!");
                option.next(); // this is important!
                System.out.print("Which quest do you want to do?:");
            }
            choice = option.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Please input 1-4!!!");
            }
        } while (choice < 1 || choice > 4);
        return choice;
    }

    public static void bossPopUp() {

        String message = "Congratz, you have beat the Final Boss\n"
                + "you can continue to play as long as you want. \n"
                + "As each time you defeat the final boss,the enemy got stronger\n"
                + "Thanks for playing my game..."
                + "\n input 777 in main menu for secret boss";
        JOptionPane.showMessageDialog(null, message);

    }

    static final String fileName = "save/Savedata.sav";

    public static void save(Serializable objectToSerialize) throws InterruptedException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);// can be anything

            //Byte Stream creation
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objectToSerialize);

            //flush (write) the stream
            oos.flush();
            //close the stream
            oos.close();
            System.out.print("Saving");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            System.out.println(" Save Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Hero load() throws InterruptedException {
        // check if file exist or not
        if (checkFileExist()) {
            // if exist create a new Stream
            FileInputStream fis = null;
            try {// initialize fis
                fis = new FileInputStream(fileName);
                //create ois from fis
                ObjectInputStream ois = new ObjectInputStream(fis);
                //create object from the stream
                //Cast it to the type of object that we need
                Hero hero1 = (Hero) ois.readObject();
                ois.close();
                System.out.print("Loading");
                Thread.sleep(300);
                System.out.print(".");
                Thread.sleep(300);
                System.out.print(".");
                Thread.sleep(300);
                System.out.print(".");
                Thread.sleep(300);
                System.out.print(".");
                System.out.println("Load Success");
                return hero1;
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            System.out.print("Loading");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            System.out.println("Save File Not Found");
            Thread.sleep(1000);
            return null;
        }

    }

    public static boolean checkFileExist() {
        // check if the file exist with the name of "filename" in given directory
        return new File(fileName).isFile();
    }
}
