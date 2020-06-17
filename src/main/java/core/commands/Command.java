package core.commands;

public interface Command {
    void run(String[] args);
    String getHelp();
    String[] getParams();
}
