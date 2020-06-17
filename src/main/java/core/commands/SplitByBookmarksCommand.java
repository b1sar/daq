package core.commands;

import core.Commander;

public class SplitByBookmarksCommand implements Command{
    @Override
    public void run(String[] args) {
        Commander.cmdPrint("Splitting the books");
    }

    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public String[] getParams() {
        return new String[0];
    }
}
