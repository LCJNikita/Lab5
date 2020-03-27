package movies.commands;

import movies.MovieTreeSet;

/**
 * AddIfMin Command
 */
public class AddIfMinCommand implements Command {
    private String jsonStr;

    /**
     * Base constructor
     *
     * @param arg json str
     */
    public AddIfMinCommand(String arg) {
        this.jsonStr = arg;
    }

    /**
     * Add elem in collection
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        if (treeSet.addIfMinFromUser(this.jsonStr)) {
            System.out.println("Successfully added");
        } else {
            System.err.println("Adding failed");
        }
    }
}
