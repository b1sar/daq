package core;

import core.commands.Command;

import java.util.HashMap;

public class Executor {
    public HashMap<String, Command> cmds;

    public static void main(String[] args) {
        Log.sendStartupMessage();
        sleep(2);
        Commander commander = new Commander();
        sleep(1);
        commander.call(new String[]{"splitByBookmarks", "eheh"});
        sleep(1);
        Commander.cmdPrint("Stopping the program");
    }
    public static void sleep(Integer seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
