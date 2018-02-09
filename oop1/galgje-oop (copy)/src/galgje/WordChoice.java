/**
 * Galgje - OOP
 * @author Dominic Dingena.
 *
 */

package galgje;

public enum WordChoice {
    COMPUTER("The computer chooses a word at random"),
    USER("Choose a word yourself");

    private final String description;

    private WordChoice (String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
