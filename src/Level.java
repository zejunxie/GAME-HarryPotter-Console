abstract class Level {
    private String attackPart;
    private String spelltype;
    private String weapontype;
    abstract boolean checkWinCondition();
    abstract void displayWinMessage();


    public String getAttackpart() {
        return attackPart;
    }
    public String getSpelltype() {
        return spelltype;
    }
    public String getWeapontype() {
        return weapontype;
    }



    public void setSpelltype(String spelltype) {
        this.spelltype = spelltype;
    }
    public void setAttackpart(String attackPart) {
        this.attackPart = attackPart;
    }
    public void setWeapontype(String weapontype) {
        this.weapontype = weapontype;
    }
}