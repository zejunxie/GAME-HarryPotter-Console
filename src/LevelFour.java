class LevelFour extends Level {
    boolean checkWinCondition() {
        // Check if the player is close to Portolion and use the Accio spell to draw it in
        return getSpelltype().equals("Accio");
    }
    void displayWinMessage() {
        System.out.println("You approach Portolion and use the Accio spell to draw it in! Congratulations on passing Level 4: Little Haggadon Graveyard!");
    }
}