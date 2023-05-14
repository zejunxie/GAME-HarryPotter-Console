public class Main {
    public static void main(String[] args) {
// Create wizard
        Wizard wizard = new Wizard();

// Create enemy
        Enemy[] enemies = new Enemy[7];
        enemies[0] = new Enemy("Troll", 100, 40, "Toilets of the dungeon", "In order to defeat him, you must lift the objects and release them when they are above his head.");
        enemies[1] = new Enemy("Basil", 100, 40, "Room of secrets", "Summon the legendary sword of Godric Gryffindor or rip off one of its fangs and use it to destroy Tom Jedusol's diary.");
        enemies[2] = new Enemy("Detractors", 100, 40, "Lake in the Forbidden Forest", "The destroyers are on the run. They're roaming the streets and the countryside. Fortunately, you've heard of a spell that will make them fly ...... Expect... Expect... ... ");
        enemies[3] = new Enemy("Voldemort and Peter Pettigrew", 100, 40, "Little Hangleton Cemetery", "Get close to Portkey and draw him to you (Accio)");
        enemies[4] = new Enemy("Dolores Umbridge", 100, 40, "Hogwarts Examination Hall", " Dolores Umbridge is guarding the grain. Your goal is to distract her until the Fireworks are ready to be used.");
        enemies[5] = new Enemy("Death Eaters", 100, 40, "Astronomy tower", "Death Eaters are attacking Hogwarts. Are you ready to defend yourselves? You must attack them from the front (Sectumsempra)");
        enemies[6] = new Enemy("Voldemort and Bellatrix Lestrange", 100, 40, "Poudlard", "Beware of the Avada Kedavra. When in doubt, use the Expelliarmus spell ! ");

// Create level
        Level[] levels = new Level[7];
        levels[0] = new LevelOne();
        levels[1] = new LevelTwo();
        levels[2] = new LevelThree();
        levels[3] = new LevelFour();
        levels[4] = new LevelFive();
        levels[5] = new LevelSix();
        levels[6] = new LevelSeven();

//Play game
        Game game = new Game(wizard, enemies, levels);
        game.displayInfo();
        game.checkInput();
        game.play();
    }
}



