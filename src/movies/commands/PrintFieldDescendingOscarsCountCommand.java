package movies.commands;

import movies.MovieTreeSet;

/**
 * PrintFieldDescendingOscarsCountCommand
 */
public class PrintFieldDescendingOscarsCountCommand implements Command {
    /**
     * Base constructor
     */
    public PrintFieldDescendingOscarsCountCommand() {
    }

    /**
     * pring oscars count in reverse sotring
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        System.out.println();
        treeSet.getOscarsCountRevSorted().forEach(aLong -> System.out.print(aLong + " "));
        System.out.println();
    }
}
