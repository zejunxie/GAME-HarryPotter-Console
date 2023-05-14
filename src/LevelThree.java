class LevelThree extends Level {
    boolean checkWinCondition() {
        return getSpelltype().equals("Expecto Patronum");
        // Check if the player has used the Expecto Patronum spell to drive away the dementors
    }
    void displayWinMessage() {
        System.out.println("You have used the Expecto Patronum spell to drive away the Dementors! Congratulations on passing Level 3: Forbidden Forest Lake!");
    }
}
