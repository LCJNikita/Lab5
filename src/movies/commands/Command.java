package movies.commands;

import movies.MovieTreeSet;

public interface Command {
    void execute(MovieTreeSet treeSet);
}
