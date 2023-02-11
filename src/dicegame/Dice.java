package dicegame;

import java.util.Random;

/**
 * @author Andrey Tynyanyi
 * @version 1.0
 */

public class Dice {
    Random rand = new Random();
    public int faceDice;

    public Dice(){
        faceDice = rand.nextInt(6)+1;
    }
}
