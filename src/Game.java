import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Wizard wizard;
    private final Enemy[] enemies;
    private final Level[] levels;
    public Game(Wizard wizard, Enemy[] enemies, Level[] levels) {
        this.wizard = wizard;
        this.enemies = enemies;
        this.levels = levels;
    }
    public void displayInfo(){
        System.out.println("\n" + "Here are some of your personal information:");
        System.out.println("Your Name: " + wizard.name);
        System.out.println("Wand Type: " + wizard.wand.type);
        System.out.println("Wand Wood: " + wizard.wand.wood);
        System.out.println("Wand Length: " + wizard.wand.length + " inches");
        System.out.println("House: " + wizard.house);
        System.out.println("Health Points: " + wizard.healthPoints);
        System.out.println("Spell Damage: " + wizard.spellDamage);
        System.out.println("Accuracy: " + wizard.accuracy + "%");
        System.out.println("Resistance: " + wizard.resistance);
        System.out.println("Potency of potion: " + wizard.potionEffectiveness + "HP+" + "\n");
    }
    public void checkInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you ready to fight against the enemy? Please enter 1 to start the game!");
        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input != 1) {
                System.out.println("Invalid input!");
                checkInput();
            } else {
                System.out.println("Game start!");
            }
        } else {
            System.out.println("Invalid input!");
            checkInput();
        }
    }
    public void play() {
        outerLoop:
        for (int i = 0; i < levels.length; i++) {
            while (wizard.healthPoints > 0) {

                // Print current state of the game
                System.out.println("LEVEL"+(i+1)+": " + enemies[i].location);
                System.out.println("Tips: " + enemies[i].tips);
                System.out.println("Player: " + wizard.name + " ------ HP: " + wizard.healthPoints);
                System.out.println("Enemy: " + enemies[i].name + " ------ HP: " + enemies[i].healthPoints+"\n");

                // Player's turn
                if (enemies[4].healthPoints<=70){
                    System.out.println("You have obtained an item ----- Fireworks, you can click use weapon to use it!");
                }
                String playerChoice = showActionMenu();
                levels[i].setSpelltype("missSpell");
                levels[i].setAttackpart("missAttackPart");
                levels[i].setWeapontype("missWeapon");

                switch (playerChoice) {
                    case "spell":
                        String spellType = showSpellMenu();
                        String attackPart = showAttackPartMenu();
                        if (wizard.accuracy >= new Random().nextInt(100)) {
                            int damage = wizard.spellDamage;
                            enemies[i].healthPoints -= damage;
                            System.out.println("You dealt " + damage + " points of spell damage to the enemy !" + "      Enemy's HP->" + enemies[i].healthPoints);
                            levels[i].setSpelltype(spellType);
                            levels[i].setAttackpart(attackPart);
                        } else {
                            System.out.println("Unfortunately!You missed!");
                        }
                        break;
                    case "potion":
                        String potionType = showPotionMenu();
                        int phReply = calculatePhReply(potionType);
                        wizard.healthPoints += phReply;
                        System.out.println("Your hp has returned " + phReply + " points, now your ph:" + wizard.healthPoints);
                        break;
                    case "weapon":
                        if (i==4){
                            levels[i].setWeapontype("Fireworks");
                            break;
                        } else if (wizard.house == House.GRYFFINDOR){
                            levels[i].setWeapontype(wizard.weapon);
                            System.out.println("You have successfully summoned " + wizard.weapon + " and unleashed it on the enemy!");
                            break;
                        }else {
                            System.out.println("Sorry, only GRYFFINDOR has weapons.");
                        }



                }
                if (levels[i].checkWinCondition()) {
                    enemies[i].healthPoints = 0;
                    levels[i].displayWinMessage();
                    if (i!=6){
                        AttributeSelect();
                    }
                    break;
                }

                // enemy's turn
                if (enemies[i].healthPoints > 0) {
                    System.out.println("\n" + "For " + enemies[i].name + "'s turn :");
                    int damage = enemies[i].attack() - wizard.resistance;
                    wizard.healthPoints -= damage;
                    System.out.println(enemies[i].name + " dealt " + damage + " points of damage to you ! "+"      Your HP->"+wizard.healthPoints+"\n");
                } else {
                    System.out.println("Congratulations! You have successfully defeated the enemy, now you can move on to the next level!");
                    AttributeSelect();
                    break;
                }
                if (wizard.healthPoints <= 0){
                    System.out.println("Game over! You are defeated by the enemy");
                    break outerLoop;
                }
            }
    }
}
    static String showActionMenu() {
        System.out.println("Now it's your turn. Please choose one of your actions!");
        System.out.println("1. Use spells");
        System.out.println("2. Use potions");
        System.out.println("3. Summon weapons");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            return "spell";
        } else if (choice == 2){
            return "potion";
        } else if (choice == 3) {
            return "weapon";
        }
        System.out.println("Invalid input");
        return "Invalid input" +showActionMenu();
    }

    static String showSpellMenu() {
        System.out.println("Select the spell type you want to use ：");
        System.out.println("1. Wingardium Leviosa");
        System.out.println("2. Expelliarmus");
        System.out.println("3. Expecto Patronum");
        System.out.println("4. Accio");
        System.out.println("5. Sectumsempra");
        Scanner scanner = new Scanner(System.in);
        int spellType = scanner.nextInt();
        if (spellType == 1) {
            return "Wingardium Leviosa";
        } else if (spellType == 2){
            return "Expelliarmus";
        } else if (spellType == 3) {
            return "Expecto Patronum";
        } else if (spellType == 4) {
            return "Accio";
        } else if (spellType == 5) {
            return "Sectumsempra";
        }
        System.out.println("Invalid input");
        return "Invalid input" + showSpellMenu();
    }

    static String showAttackPartMenu() {
        System.out.println("Select the target area for your spell ：");
        System.out.println("1. Head");
        System.out.println("2. Torso");
        System.out.println("3. Legs");
        Scanner scanner = new Scanner(System.in);
        int attackPart = scanner.nextInt();
        if (attackPart == 1) {
            return "head";
        } else if (attackPart == 2){
            return "torso";
        } else if (attackPart == 3) {
            return "legs";
        }
        System.out.println("Invalid input");
        return "Invalid input" + showAttackPartMenu();
    }
    static String showPotionMenu() {
        System.out.println("Select the type of potion you want to use ：");
        System.out.println("1. HealingPotion");
        System.out.println("2. Elixir");
        Scanner scanner = new Scanner(System.in);
        int potionType = scanner.nextInt();
        if (potionType == 1) {
            return "HealingPotion";
        } else {
            return "Elixir";
        }
    }
    static int calculatePhReply(String potionType) {
        int phReply = 0;
        if (potionType.equals("HealingPotion")) {
            phReply = 10;
        } else if (potionType.equals("Elixir")) {
            phReply = 50;
        }
        return phReply;
    }
    public void AttributeSelect(){
        wizard.healthPoints=100;
        System.out.println("Before moving on to the next level, you can choose an attribute to improve!");
        System.out.println("1. Damage ");
        System.out.println("2. Hit rate");
        Scanner scanner3 = new Scanner(System.in);
        int AttributeSelect = scanner3.nextInt();
        if (AttributeSelect==1){
            wizard.spellDamage += 5 ;
            System.out.println("Your damage points have increased by 5 points! Your spell damage now is " + wizard.spellDamage+".   And your HP is also back to 100"+"\n");
        }else if (AttributeSelect==2){
            wizard.accuracy += 3;
            System.out.println("Your hit rate has increased by 3 points! Your hit rate now is " + wizard.accuracy+".   And your HP is also back to 100"+"\n");
        }
    }
}
