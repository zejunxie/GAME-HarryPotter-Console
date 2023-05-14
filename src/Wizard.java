import java.util.Scanner;
public  class Wizard {
    String name;
    Wand wand;
    SortingHat sortingHat;
    int healthPoints;
    int spellDamage;
    int accuracy;
    int resistance;
    int potionEffectiveness;
    House house;
    String weapon;

    public Wizard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hogwarts! You’re a wizard, insert your name !");
        this.name = scanner.nextLine();
        wand = new Wand();
        sortingHat = new SortingHat();
        house = sortingHat.assignhouse();
        healthPoints = 100;
        spellDamage = house.getSpelldamage();
        accuracy = house.getAccuracy();
        resistance = house.getResistance();
        potionEffectiveness = house.getPotionhpmodif();
        weapon=house.getWeapons();
    }
}