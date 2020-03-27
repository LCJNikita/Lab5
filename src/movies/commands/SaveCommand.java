package movies.commands;

import movies.MovieTreeSet;

/**
 * SaveCommand
 */
public class SaveCommand implements Command {
    /**
     * Base constructor
     */
    public SaveCommand() {
    }

    /**
     * Save collection to default file
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        if (treeSet.save()) {
            System.out.println("Save success");
        }
    }
}
