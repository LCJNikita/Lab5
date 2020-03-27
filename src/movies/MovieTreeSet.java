package movies;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Class that control Tree Set Movie collection
 */
public class MovieTreeSet {
    private TreeSet<Movie> treeSet;
    String fileName;
    LocalDate initialDate;
    PrintStream err;
    PrintStream out;

    /**
     * Movie TreeSet constructor
     *
     * @param fileName filename to load collection
     */
    public MovieTreeSet(String fileName) {
        this.err = System.err;
        this.out = System.out;
        this.initialDate = LocalDate.now();
        this.fileName = fileName;
        this.treeSet = new TreeSet<>();
        this.loadJsonFile(this.fileName);
        if (this.treeSet.size() == 0) {
            System.out.println("Created empty collection");
        }
    }

    /**
     * @return true if empty
     */
    public boolean isEmpty() {
        return this.treeSet.isEmpty();
    }

    /**
     * size
     *
     * @return treeset size
     */
    public int size() {
        return this.treeSet.size();
    }

    /**
     * add movie to tree set
     *
     * @param m movie to be added
     * @return true if successfully added
     */
    public boolean add(Movie m) {
        return this.treeSet.add(m);
    }

    /**
     * add movie witj json str
     *
     * @param m json str
     * @return true if successfully added
     */
    public boolean add(String m) {
        try {
            return this.add(Movie.getFromJson(m));
        } catch (ParseException e) {
            err.println("Incorrect JSON format");
        } catch (Exception e) {
            err.println(e.getMessage());
        }
        return false;
    }

    /**
     * add movie with json str and user input
     *
     * @param m json str
     * @return true if successfully added
     */
    public boolean addFromUser(String m) {
        try {
            return this.add(Movie.getFromUserInput(System.in, out, m));
        } catch (ParseException e) {
            err.println("Incorrect JSON format");
        } catch (Exception e) {
            err.println(e.getMessage());
        }
        return false;
    }

    /**
     * add movie if it is greater than all other
     *
     * @param m movie to be added
     * @return true if successfully added
     */
    public boolean addIfMax(Movie m) {
        return (m.compareTo(this.treeSet.last()) > 0) && (this.add(m));
    }

    /**
     * add movie from json str if it is greater than all other
     *
     * @param m movie json str to be added
     * @return true if successfully added
     */
    public boolean addIfMax(String m) {
        try {
            return addIfMax(Movie.getFromJson(m));
        } catch (ParseException e) {
            err.println("Incorrect JSON format");
        } catch (Exception e) {
            err.println(e.getMessage());
        }
        return false;
    }

    /**
     * add movie from json str and user input if it is greater than all other
     *
     * @param m movie json str to be added
     * @return true if successfully added
     */
    public boolean addIfMaxFromUser(String m) {
        try {
            return addIfMax(Movie.getFromUserInput(System.in, out, m));
        } catch (ParseException e) {
            err.println("Incorrect JSON format");
        } catch (Exception e) {
            err.println(e.getMessage());
        }
        return false;
    }

    /**
     * add movie if it is less than all other
     *
     * @param m movie to be added
     * @return true if successfully added
     */
    public boolean addIfMin(Movie m) {
        return (m.compareTo(this.treeSet.first()) < 0) && (this.add(m));
    }

    /**
     * add movie from json str if it is less than all other
     *
     * @param m movie json str to be added
     * @return true if successfully added
     */
    public boolean addIfMin(String m) {
        try {
            return addIfMin(Movie.getFromJson(m));
        } catch (ParseException e) {
            err.println("Incorrect JSON format");
        } catch (Exception e) {
            err.println(e.getMessage());
        }
        return false;
    }

    /**
     * add movie from json str if it is less than all other
     *
     * @param m movie json str to be added
     * @return true if successfully added
     */
    public boolean addIfMinFromUser(String m) {
        try {
            return addIfMin(Movie.getFromUserInput(System.in, out, m));
        } catch (ParseException e) {
            err.println("Incorrect JSON format");
        } catch (Exception e) {
            err.println(e.getMessage());
        }
        return false;
    }

    /**
     * update element with id
     *
     * @param id id elem to be updated
     * @param m  elem than will be replaced old elem
     * @return true if successfully updated
     */
    public boolean update(long id, Movie m) {
        TreeSet<Movie> tempSet = new TreeSet<>(this.treeSet);
        if (tempSet.add(m)) {
            this.treeSet.removeIf(movie -> movie.getId() == id);
            m.setId(id);
            return this.add(m);
        } else {
            return false;
        }
    }

    /**
     * remove movie from tree set
     *
     * @param m movies.Movie obj to be removed
     * @return true if successfully removed
     */
    public boolean remove(Movie m) {
        return this.treeSet.remove(m);
    }

    /**
     * remove movie with json str
     *
     * @param m json str
     * @return true if successfully removed
     */
    public boolean remove(String m) {
        try {
            return this.remove(Movie.getFromJson(m));
        } catch (Exception e) {
            err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Clear collection
     */
    public void clear() {
        this.treeSet.clear();
    }

    /**
     * remove elem by id
     *
     * @param id id of elem to be removed
     * @return true if successfully removed
     */
    public boolean removeById(long id) {
        return this.treeSet.removeIf(movie -> movie.getId() == id);
    }

    /**
     * Create treeSet with elements of current treeset, where all movies have mpaa rating less than rating
     *
     * @param rating mpaa rating to be compared
     * @return treeset with elements have less mpaa rating
     */
    public TreeSet<Movie> getLessThanMpaaRating(MpaaRating rating) {
        TreeSet<Movie> resultSet = new TreeSet<>(this.treeSet);
        resultSet.removeIf(movie -> movie.getMpaaRating() == null || movie.getMpaaRating().compareTo(rating) > 0);
        return resultSet;
    }

    /**
     * Get movie with max Oscars count
     *
     * @return movie with max Oscars count
     */
    public Movie getMovieMaxOscarsCount() {
        return this.treeSet.stream().max(Movie::compareOscarsCountTo).orElse(null);
    }

    /**
     * get information about collection
     *
     * @return collection info
     */
    public String getInfo() {
        return String.format("creation Date: %s;\nLength: %d; Type: %s", this.initialDate, this.treeSet.size(), Movie.class);
    }

    /**
     * Clear current collection and try to load new collection from file.
     * If can't read file or file doesn't exist, current collection don't clear.
     *
     * @param fileName file name to load collection from
     */
    public void loadJsonFile(String fileName) {
        File file;
        file = new File(fileName);
        try {
            if (!file.canRead()) {
                err.println("Cant read file " + (String) fileName + ".\nLoading failed.");
                return;
            }
        } catch (NullPointerException ex) {
            System.err.println("Filename error.\nLoading failed.");
            return;
        }
        try (Scanner fin = new Scanner(file)) {
            String str;
            this.treeSet.clear();
            while (fin.hasNextLine()) {
                str = fin.nextLine();
                this.add(str);
            }
            System.out.println("File " + fileName + " successfully loaded");
        } catch (FileNotFoundException ex) {
            err.println("No such file " + fileName + ".\nLoading failed.");
        } catch (Exception ex) {
            err.println(ex.getMessage());
            err.println("Loading failed");
        }
    }

    /**
     * save collection to file in JSON format
     *
     * @param fileName file name to save collection to
     * @return true in save succes
     */
    public boolean saveJsonFile(String fileName) {
        File file;
        file = new File(fileName);
        if (!file.canWrite()) {
            err.println("Can't write to file " + fileName + ".\nSaving failed.");
            return false;
        }
        try (PrintWriter pw = new PrintWriter(file)) {
            this.treeSet.forEach(movie -> pw.println(movie.toJSONObject().toString()));
            return true;
        } catch (FileNotFoundException ex) {
            err.println("No such file " + fileName + ".\nSaving failed.");
            return false;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * save into default file
     *
     * @return true in save succes
     */
    public boolean save() {
        return this.saveJsonFile(this.fileName);
    }

    /**
     * get all elems in JSON
     *
     * @return JSON Object array list
     */
    public ArrayList<JSONObject> getJSONObjects() {
        ArrayList<JSONObject> list = new ArrayList<>();
        this.treeSet.forEach(movie -> list.add(movie.toJSONObject()));
        return list;
    }

    /**
     * get oscar counters field in reversed sorting
     *
     * @return oscars counters reversed
     */
    public ArrayList<Long> getOscarsCountRevSorted() {
        ArrayList<Long> oscars = new ArrayList<>();
        this.treeSet.forEach(movie -> oscars.add(movie.getOscarsCount()));
        oscars.sort(Long::compareTo);
        Collections.reverse(oscars);
        return oscars;
    }
}
