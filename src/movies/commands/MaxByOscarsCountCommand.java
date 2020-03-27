package movies.commands;

import movies.MovieTreeSet;

/**
 * MaxByOscarsCountCommand
 */
public class MaxByOscarsCountCommand implements Command {
    /**
     * Base constructor
     */
    public MaxByOscarsCountCommand() {
    }

    /**
     * Show movie with max oscars count
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        if (treeSet.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println(treeSet.getMovieMaxOscarsCount().toJSONObject().toString());
        }
    }
}
