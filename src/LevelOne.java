class LevelOne extends Level {
    boolean checkWinCondition() {
        return getAttackpart().equals("head") && getSpelltype().equals("Wingardium Leviosa");
    }
    public void displayWinMessage() {
        System.out.println("You lift the object and release it on Troll's head, and Troll is killed! Congratulations on passing Level 1: Troll Restroom!");
    }
}
