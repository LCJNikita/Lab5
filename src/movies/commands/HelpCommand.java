package movies.commands;

import movies.MovieTreeSet;

/**
 * Help command
 */
public class HelpCommand implements Command {
    private final String HELP_MESSAGE;

    /**
     * Creates with help message
     *
     * @param helpMessage help message
     */
    public HelpCommand(String helpMessage) {
        this.HELP_MESSAGE = helpMessage;
    }

    /**
     * show help message
     *
     * @param treeSet main treeset
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        System.out.println(this.HELP_MESSAGE);
    }
}
