package movies.commands;

import movies.MovieTreeSet;

/**
 * Exit Command
 */
public class ExitCommand implements Command {
    /**
     * Base constructor
     */
    public ExitCommand() {
    }

    /**
     * print exit
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        System.out.println("Exit");
    }
}
