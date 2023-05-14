class LevelTwo extends Level {
    boolean checkWinCondition() {
        return getWeapontype().equals("The legendary sword of Godric Gryffindor")||getSpelltype().equals("Accio");
        // Check if the player has defeated the snake monster using the Gryffindor's sword or the snake monster's fangs(use Accio)
    }
    void displayWinMessage() {
        if (getWeapontype().equals("The legendary sword of Godric Gryffindor")){
            System.out.println("You have used Griffindor's sword to defeat the snake monster! Congratulations on passing Level 2: The Secret Room!");
        }else {
            System.out.println("You used the Accio spell to knock out the snake demon's teeth and used it to defeat the boss! Congratulations on passing Level 2: The Secret Room!");
        }

    }
}
