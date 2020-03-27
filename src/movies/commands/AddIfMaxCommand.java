package movies.commands;

import movies.MovieTreeSet;

/**
 * AddIfMax Command
 */
public class AddIfMaxCommand implements Command {
    private String jsonStr;

    /**
     * Base constructor
     *
     * @param arg json str
     */
    public AddIfMaxCommand(String arg) {
        this.jsonStr = arg;
    }

    /**
     * Add elem in collection
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        if (treeSet.addIfMaxFromUser(this.jsonStr)) {
            System.out.println("Successfully added");
        } else {
            System.err.println("Adding failed");
        }
    }
}
