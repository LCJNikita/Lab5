package movies.commands;

import movies.MovieTreeSet;

/**
 * ClearCommand
 */
public class ClearCommand implements Command {
    /**
     * Base constructor
     */
    public ClearCommand() {
    }

    /**
     * clear collection
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        treeSet.clear();
        System.out.println("Collection cleared");
    }
}
