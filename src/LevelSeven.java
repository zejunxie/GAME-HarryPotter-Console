class LevelSeven extends Level {
    boolean checkWinCondition() {
        return getSpelltype().equals("Expelliarmus");
    }
    void displayWinMessage() {
        System.out.println("You used Expelliarmus spell and Voldemort and Bellatrix Lestrange were defeated by you ! Congratulations on passing Level 7: Hogwarts!");
        System.out.println("Congratulations on completing all the levels! You have successfully graduated from the most prestigious witchcraft school on the planet and have acquired a brand new wand with endless energy!");

    }
}
