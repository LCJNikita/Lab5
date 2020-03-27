package movies.commands;

import movies.Movie;
import movies.MovieTreeSet;

/**
 * Add command
 */
public class AddCommand implements Command {
    private String jsonStr;

    /**
     * Base constructor
     *
     * @param arg json str
     */
    public AddCommand(String arg) {
        this.jsonStr = arg;
    }

    /**
     * Add elem in collection
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        if (treeSet.addFromUser(this.jsonStr)) {
            System.out.println("Successfully added");
        } else {
            System.err.println("Adding failed");
        }
    }
}
