package core;

import java.util.logging.*;

public class Log
{
    private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new LogFormatter());
        LogManager.getLogManager().reset();
        LOGGER.addHandler(handler);
    }

    public static void sendStartupMessage()
    {
        LOGGER.log(Level.INFO, "\n------------------------------------------\n"
                + "Divide And Conquer is starting up: \n"
                + "-------------------------------------------");
    }


    public static void log(Level level, String message)
    {
        LOGGER.log(level, message);
    }


    public static class LogFormatter extends Formatter {

        @Override
        public String format(LogRecord record){
            if(record.getLevel() == Level.INFO){
                return record.getMessage() + "\r\n";
            }else{
                return "[" + record.getLevel() + "]" + record.getMessage() + "\r\n";
            }
        }
    }
}
