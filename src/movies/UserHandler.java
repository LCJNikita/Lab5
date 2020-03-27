package movies;

import movies.commands.Command;

import java.util.HashSet;
import java.util.Scanner;

/**
 * user handler works with user
 */
public class UserHandler {
    private final String HELP_MESSAGE;
    private final HashSet<String> AVAILABLE_COMMANDS;
    private CommandParser parser;
    private MovieTreeSet treeSet;

    /**
     * UserHandler constructor
     * @param msg help message, that will be showed to user
     * @param cmnds available commands
     * @param treeSet main collection
     */
    public UserHandler(String msg, HashSet<String> cmnds, MovieTreeSet treeSet) {
        this.HELP_MESSAGE = msg;
        this.AVAILABLE_COMMANDS = cmnds;
        this.treeSet = treeSet;
        this.parser = new CommandParser(this.AVAILABLE_COMMANDS, this.HELP_MESSAGE);
    }

    /**
     * works with user
     * parse and execute commands
     */
    public void handleUser() {
        Scanner in = new Scanner(System.in);
        String str;
        Command command;
        while (true){
            System.out.println("Enter command: ");
            str = in.nextLine();
            command = parser.parse(str);
            if (command!= null){
                command.execute(this.treeSet);
                if (command.getClass().toString().toLowerCase().contains("exit")){
                    break;
                }
            } else {
                System.err.println("No such command");
            }
        }
    }
}
