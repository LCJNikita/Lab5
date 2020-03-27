package movies.commands;

import movies.MovieTreeSet;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * HistoryCommand
 */
public class HistoryCommand implements Command {
    private Deque<String> commands;

    /**
     * Base constructor
     *
     * @param commands commands names deque
     */
    public HistoryCommand(Deque<String> commands) {
        this.commands = new ArrayDeque<>(commands);
    }

    /**
     * Print last 15 commands
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        for (int i = 0; i < 15; i++) {
            System.out.println(commands.pollLast());
            if (commands.isEmpty()) {
                break;
            }
        }
    }
}
