package movies.commands;

import movies.MovieTreeSet;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Show command
 */
public class ShowCommand implements Command {
    /**
     * Base constructor
     */
    public ShowCommand() {
    }

    /**
     * Show all objects to user
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        ArrayList<JSONObject> list = treeSet.getJSONObjects();
        if (list.size() == 0) {
            System.out.println("Empty");
        } else {
            treeSet.getJSONObjects().forEach(jsonObject -> System.out.println(jsonObject.toString()));
        }
    }
}
