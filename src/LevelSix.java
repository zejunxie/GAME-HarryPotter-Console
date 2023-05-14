class LevelSix extends Level {
    boolean checkWinCondition() {
        return getSpelltype().equals("Sectumsempra");
    }
    void displayWinMessage() {
        System.out.println("You used Sectumsempra spell to destroy the Death Eaters trying to invade Hogwarts! Congratulations on passing Level 6: Astronomy Tower!");
    }
}
