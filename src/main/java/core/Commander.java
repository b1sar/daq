package core;

import core.commands.Command;
import core.commands.SplitByBookmarksCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;

public class Commander {
    public HashMap<String, Command> cmds;
    public Scanner scanner;
    public static Commander instance;

    public void setup() {
        //Add all available commands to cmds
        cmds = new HashMap<>();
        cmds.put("splitByBookmarks", new SplitByBookmarksCommand());
    }

    public void call(String[] rawArgs) {
        String function = rawArgs[0];
        String[] args = Arrays.copyOfRange(rawArgs, 1, rawArgs.length);

        Command command = cmds.get(function);

        if(command == null) {
            cmdPrint("command function: '"+function+"' not found. Type -help for a list of functions");
        } else {
            cmdPrint("Running the function: '"+function+"'");
            command.run(args);
        }
    }

    public static Commander getInstance(){
        if(instance != null) {
            instance = new Commander();
        }

        return instance;
    }

    public Commander(){
        cmdPrint("Setting up commands");
        setup();
        instance = this;
    }

    public static void cmdPrint(String msg) {
        Log.log(Level.INFO, "- " + msg);
    }
}
