

/*
 Changelog:
 v0.3
 -added upgrade status feature
 -fix exp bug
 v0.4 
 -added dungeon menu
 -battle with enemy
 -added new quest
 v0.45
 -added new enemy
 -skill feature
 -enemy drop money
 v0.5
 -added shop feature
 -added new armor & weapon
 v0.55
 -added clear screen function
 v0.6 {2nd dungeon appear)
 -upgrade the battle system
 -new dungeon with harder enemy
 v0.7(Major update!!!)(4 Nov 2016)
 -name input bug fix
 -add save and load feature
 -confirm before exit
 -fix the save bug
 -add evasion and accuracy stat to player and enemy
 v0.75
 -minor save bug fix
 -add skill shop
 v0.8 
 -skill bug fix
 -enemy have skill
 -boss feature
 v0.9
 -added final boss
 -3rd dungeon
 v1.0
 -added magic feature
 -added magic shop
 -new skill

 future update:

 -more weapon & armor
 -new skill
 -more feature

 */
import model.Hero;
import ui.Menu;
import util.RpgUtil;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.fusesource.jansi.AnsiConsole;

/**
 *
 * @author Phantom
 */
public class BasicRPG1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        //Enable Jansi feature
        //AnsiConsole.systemInstall();
        
        new File("save").mkdir();
        int option, questOption, ulang = 1;
        String exitConfirm;
        Scanner inputString = new Scanner(System.in);
        Hero hero1 = null;

        do {

            ulang = 0;

            questOption = Menu.startMenu();
            if (questOption == 1) {
                hero1 = new Hero();

                hero1.setName(Menu.inputName());
                ulang = 1;
            } else if (questOption == 2) {
                hero1 = Menu.load();
                if (hero1 == null) {
                    ulang = 0;
                } else {
                    ulang = 1;
                }
            } else if (questOption == 3) {
                Menu.showChangelog();
            } else if (questOption == 4) {
                Menu.showAboutMe();
            } else if (questOption == 5) {
                System.exit(0);
            }
            RpgUtil.clearScreen();
        } while (ulang == 0);
        
        Menu.introduction();
        do {
            hero1.showStatus();
            option = Menu.mainMenu();

            if (option == 1) {
                RpgUtil.clearScreen();
                
                do {
                    ulang = 0;

                    hero1.showStatus();
                    questOption = Menu.questMenu();
                    if (questOption == 1) {
                        hero1.reduceStat(1, -10, -10);
                    } else if (questOption == 2) {
                        hero1.reduceStat(3, -40, -20);
                    } else if (questOption == 3) {
                        hero1.reduceStat(5, -70, -30);
                    } else if (questOption == 4) {
                        hero1.reduceStat(7, -100, -50);
                    } else if (questOption == 5) {
                        ulang = 1;
                    }

                } while (ulang == 0);

            } else if (option == 2) {

                do {

                    ulang = 0;
                    hero1.showStatus();
                    questOption = Menu.dungeonMenu();
                    if (questOption == 1) {

                        hero1.setdType(1);
                        Hero.battleWithEnemy(hero1, questOption);

                    } else if (questOption == 2) {

                        hero1.setdType(2);
                        Hero.battleWithEnemy(hero1, questOption);

                    } else if (questOption == 3) {

                        hero1.setdType(3);
                        Hero.battleWithEnemy(hero1, questOption);

                    } else if (questOption == 4) {
                        ulang = 1;
                    }
                } while (ulang == 0);
            } else if (option == 3) {

                do {

                    ulang = 0;
                    hero1.showStatus();
                    questOption = Menu.bossMenu();
                    if (questOption == 1) {

                        hero1.setdType(11);
                        Hero.battleWithBoss(hero1, questOption);
                    } else if (questOption == 2) {

                        hero1.setdType(12);
                        Hero.battleWithBoss(hero1, questOption);

                    } else if (questOption == 3) {
                        hero1.setdType(13);
                        Hero.battleWithBoss(hero1, questOption);

                    } else if (questOption == 4) {
                        ulang = 1;
                    }
                } while (ulang == 0);
            } else if (option == 4) {
                do {

                    System.out.println("");
                    ulang = 0;
                    hero1.showStatus();
                    questOption = Menu.upgradeMenu();
                    if (questOption == 1) {
                        hero1.upgradeStat(10, 0, 0);
                    } else if (questOption == 2) {
                        hero1.upgradeStat(0, 0, 1);
                    } else if (questOption == 3) {
                        hero1.upgradeStat(0, 1, 0);
                    } else if (questOption == 4) {
                        ulang = 1;
                    }
                } while (ulang == 0);

            } else if (option == 5) {
                do {
                    RpgUtil.clearScreen();
                    
                    ulang = 0;
                    hero1.showStatus();
                    questOption = Menu.shopMenu();
                    if (questOption == 1) {
                        ulang = 2;
                        do {

                            hero1.showStatus();
                            questOption = Menu.weaponShopMenu();
                            if (questOption == 1) {
                                hero1.buyWeapon(1, (100 + (50 * Hero.getWeaponCounter(0))));
                            } else if (questOption == 2) {
                                hero1.buyWeapon(2, (500 + (100 * Hero.getWeaponCounter(1))));
                            } else if (questOption == 3) {
                                hero1.buyWeapon(3, (950 + (150 * Hero.getWeaponCounter(2))));
                            } else if (questOption == 4) {
                                hero1.buyWeapon(4, (1000 + (200 * Hero.getWeaponCounter(3))));
                            } else if (questOption == 5) {
                                hero1.buyWeapon(5, (1250 + (250 * Hero.getWeaponCounter(4))));
                            } else if (questOption == 6) {
                                ulang = 0;
                            }
                        } while (ulang == 2);
                    } else if (questOption == 2) {
                        ulang = 2;
                        do {

                            hero1.showStatus();
                            questOption = Menu.armorShopMenu();
                            if (questOption == 1) {
                                hero1.buyArmor(1, (100 + (50 * Hero.getArmorCounter(0))));
                            } else if (questOption == 2) {
                                hero1.buyArmor(2, (400 + (100 * Hero.getArmorCounter(1))));
                            } else if (questOption == 3) {
                                hero1.buyArmor(3, (950 + (150 * Hero.getArmorCounter(2))));
                            } else if (questOption == 4) {
                                hero1.buyArmor(4, (1000 + (200 * Hero.getArmorCounter(3))));
                            } else if (questOption == 5) {
                                hero1.buyArmor(5, (1250 + (250 * Hero.getArmorCounter(4))));
                            } else if (questOption == 6) {
                                ulang = 0;
                            }
                        } while (ulang == 2);
                    } else if (questOption == 3) {
                        ulang = 2;
                        do {

                            hero1.showStatus();
                            questOption = Menu.skillShopMenu();
                            if (questOption == 1) {
                                hero1.buySkill(1, Hero.getSkillLevel(0) * 500);
                            } else if (questOption == 2) {
                                hero1.buySkill(2, Hero.getSkillLevel(1) * 500);
                            } else if (questOption == 3) {
                                hero1.buySkill(3, Hero.getSkillLevel(2) * 500);
                            } else if (questOption == 4) {
                                hero1.buySkill(4, Hero.getSkillLevel(3) * 500);
                            } else if (questOption == 5) {
                                ulang = 0;
                            }
                        } while (ulang == 2);
                    } else if (questOption == 4) {
                        ulang = 2;
                        do {

                            hero1.showStatus();
                            questOption = Menu.magicShopMenu();
                            if (questOption == 1) {
                                hero1.buyMagic(1, Hero.getSkillLevel(0) * 1000);
                            } else if (questOption == 2) {
                                hero1.buyMagic(2, Hero.getSkillLevel(1) * 1000);
                            } else if (questOption == 3) {
                                hero1.buyMagic(3, Hero.getSkillLevel(2) * 5000);
                            } else if (questOption == 4) {
                                hero1.buyMagic(4, Hero.getSkillLevel(3) * 500);
                            } else if (questOption == 5) {
                                ulang = 0;
                            }
                        } while (ulang == 2);
                    } else if (questOption == 5) {
                        ulang = 1;
                    }

                } while (ulang == 0);
            } else if (option == 6) {
                hero1.rest();

            } else if (option == 7) {
                do {
                    RpgUtil.clearScreen();
                    System.out.println("");
                    ulang = 0;
                    hero1.showStatus();
                    questOption = Menu.homeMenu();
                    if (questOption == 1) {
                        Menu.save(hero1);
                    } else if (questOption == 2) {
                        hero1 = Menu.load();
                    } else if (questOption == 3) {
                        ulang = 1;
                    }
                } while (ulang == 0);
            } else if (option == 8) {
                do {
                    System.out.print("Are you sure? (Y/N):");
                    exitConfirm = inputString.nextLine();
                    if (!exitConfirm.equals("Y") && !exitConfirm.equals("y") && !exitConfirm.equals("n") && !exitConfirm.equals("N")) {
                        System.out.println("  error!!!");
                    }
                } while (!exitConfirm.equals("Y") && !exitConfirm.equals("y") && !exitConfirm.equals("n") && !exitConfirm.equals("N"));
                if (exitConfirm.equals("Y") || exitConfirm.equals("y")) {
                    ulang = 2;
                } else {
                    ulang = 1;
                }

            } else if (option == 777) {

                do {

                    ulang = 0;
                    hero1.showStatus();
                    questOption = Menu.secretBossMenu();
                    if (questOption == 1) {

                        hero1.setdType(777);
                        Hero.battleWithSecretBoss(hero1, questOption);

                    } else if (questOption == 2) {
                        ulang = 1;
                    }
                } while (ulang == 0);
            }
            RpgUtil.clearScreen();
            
        } while (ulang == 1);

    }

}
