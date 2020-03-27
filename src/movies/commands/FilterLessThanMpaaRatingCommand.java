package movies.commands;

import movies.MovieTreeSet;
import movies.MpaaRating;

public class FilterLessThanMpaaRatingCommand implements Command {
    private MpaaRating rating;

    public FilterLessThanMpaaRatingCommand(String arg) {
        this.rating = MpaaRating.getByName(arg);
    }

    @Override
    public void execute(MovieTreeSet treeSet) {
        if (this.rating != null){
            treeSet.getLessThanMpaaRating(this.rating).forEach(System.out::println);
        } else {
            System.err.println("Incorrect rating");
        }
    }
}
