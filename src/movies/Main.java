package movies;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    /**
     * main method
     * @param args console args
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("File name arg is required. Try again");
            return;
        }
        String msg = "           Commands : \n" +
                "\thelp                                         | get help info\n" +
                "\tinfo                                         | get collection info\n" +
                "\tshow                                         | show collection elements\n" +
                "\tadd {element}                                | add element in json format\n" +
                "\tupdate id {element}                          | change element with id\n" +
                "\tremove_by_id id                              | remove element by id param\n" +
                "\tclear                                        | clear collection\n" +
                "\tsave                                         | save collection into json file\n" +
                "\texecute_script file_name                     | execute script from file\n" +
                "\texit                                         | exit\n" +
                "\tadd_if_max {element}                         | add element if it is greater than others\n" +
                "\tadd_if_min {element}                         | add element if it is less than others\n" +
                "\thistory                                      | show last 15 commands\n" +
                "\tmax_by_oscars_count                          | show element with max oscars count\n" +
                "\tfilter_less_than_mpaa_rating mpaaRating      | show elements with rating less than mpaaRating\n" +
                "\tprint_field_descending_oscars_count          | show oscars count in reversive sorting\n";

        MovieTreeSet treeSet = new MovieTreeSet(args[0]);
        HashSet<String> cmnds = new HashSet<>(Arrays.asList("help", "info", "show", "add",
                "update", "remove_by_id", "clear", "save", "execute_script", "exit", "add_if_max", "add_if_min",
                "history", "max_by_oscars_count", "filter_less_than_mpaa_rating", "print_field_descending_oscars_count"));

        UserHandler handler = new UserHandler(msg, cmnds, treeSet);
        handler.handleUser();
    }


}
