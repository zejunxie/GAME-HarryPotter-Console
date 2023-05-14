class LevelFive extends Level {
    boolean checkWinCondition() {
        return getWeapontype().equals("Fireworks");
    }
    void displayWinMessage() {
        System.out.println("You used the Fireworks to get the party started! Congratulations on passing level 5: Hogwarts Lab!");
    }
}
