package movies.commands;

import movies.MovieTreeSet;

/**
 * Info command
 */
public class InfoCommand implements Command {
    /**
     * Base constructor
     */
    public InfoCommand() {
    }

    /**
     * Print collection info
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        System.out.println(treeSet.getInfo());
    }
}
