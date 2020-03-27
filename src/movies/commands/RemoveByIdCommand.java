package movies.commands;

import movies.MovieTreeSet;

/**
 * RemoveByIdCommand
 */
public class RemoveByIdCommand implements Command {
    private long id;
    private boolean isCorrectId;

    /**
     * Base constructor
     *
     * @param arg elem id
     */
    public RemoveByIdCommand(String arg) {
        try {
            this.id = Long.parseLong(arg);
            this.isCorrectId = true;
        } catch (NumberFormatException ex) {
            System.err.println("Incorrect id");
        }
    }


    /**
     * remove elem by id
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        if (this.isCorrectId) {
            if (treeSet.removeById(this.id)) {
                System.out.println(String.format("Remove elem with %d id success", this.id));
            } else {
                System.err.println("Remove failed");
            }
        } else {
            System.err.println("Remove failed");
        }
    }
}
