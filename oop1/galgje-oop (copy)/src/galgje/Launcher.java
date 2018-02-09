/**
 * Galgje - OOP
 * @author Dominic Dingena.
 *
 */

package galgje;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game();
        game.loop();

        // Exit message
        System.out.println("Thank you for playing.");
    }
}
