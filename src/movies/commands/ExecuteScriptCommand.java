package movies.commands;

import movies.CommandParser;
import movies.MovieTreeSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ExecuteScriptCommand
 */
public class ExecuteScriptCommand implements Command {
    private String fileName;
    private CommandParser parser;

    /**
     * Base constructor
     *
     * @param fileName file with script
     * @param parser   parser to parse commands
     */
    public ExecuteScriptCommand(String fileName, CommandParser parser) {
        this.fileName = fileName;
        this.parser = parser;
    }

    /**
     * load script from file and execute
     *
     * @param treeSet main collection
     */
    @Override
    public void execute(MovieTreeSet treeSet) {
        File file;
        file = new File(fileName);
        if (!file.canRead()) {
            System.err.println("Cant read file " + fileName + ".\nScript execution failed.");
            return;
        }
        try (Scanner fin = new Scanner(file)) {
            String str;
            Command command;
            while (fin.hasNextLine()) {
                str = fin.nextLine();
                command = parser.parse(str);
                if (command != null && !command.getClass().toString().contains("ExecuteScriptCommand")) {
                    command.execute(treeSet);
                } else if (command != null && command.getClass().toString().contains("ExecuteScriptCommand")) {
                    String executeFileName = ((ExecuteScriptCommand) command).getFileName();
                    if (this.parser.getExecutedFiles().contains(executeFileName)) {
                        System.err.println("recursive execute_script_command is unavaliable, " + executeFileName + " file was already called.");
                    } else {
                        this.parser.getExecutedFiles().add(fileName);
                        command.execute(treeSet);
                    }
                } else {
                    System.err.println(String.format("No such command: %s", str));
                }

            }
        } catch (FileNotFoundException ex) {
            System.err.println("No such file " + fileName + ".\nScript execution failed.");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println("Script failed");
        }
    }

    public String getFileName() {
        return fileName;
    }
}
