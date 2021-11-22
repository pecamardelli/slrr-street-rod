package java.util;

import java.io.*;
import java.util.*;

public class Logger extends GameType
{
    public static File logFile;

    public static void log(String data){
        if (!logFile) {
            logFile = new File( "system.log");
            logFile.open( File.MODE_WRITE );
        }
        logFile.write("\n" + data + "\n");
    }

    public static void closeLogFile() {
        if (logFile) {
            logFile.close();
        }
    }
}