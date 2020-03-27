package movies.commands;

import movies.Movie;
import movies.MovieTreeSet;

/**
 * Update Command
 */
public class UpdateCommand implements Command {
    private long id;
    private String elem;
    private boolean isCorrectId;

    /**
     * Base constructor
     *
     * @param arg id and elem
     */
    public UpdateCommand(String arg) {
        String[] splitArg = arg.split(" ", 2);
        try {
            this.id = Long.parseLong(splitArg[0]);
            this.isCorrectId = true;
            System.out.println(String.format("Elem with id %d was successfully updated", this.id));
        } catch (NumberFormatException ex) {
            System.err.println("Incorrect id. Update failed");
            this.isCorrectId = false;
        }
        try {
            this.elem = splitArg[1];
        } catch (IndexOutOfBoundsException ex) {
            this.elem = "";
            System.err.println("Element is required");
        }
    }


    /**
     * Update elem by id
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        if (isCorrectId) {
            try {
                if (treeSet.update(id, Movie.getFromJson(elem))) {
                    System.out.println("Update success");
                } else {
                    System.err.println("Update failed");
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println("Update failed");
            }
        }
    }
}
