package DivinanceMC.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileManager {
	
    public static String readFile(File file) {
        String toReturn = "";
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                toReturn += line;
            }
        } catch (Exception e) {
            // Do nothing.
        }
        return toReturn;
    }

    public static void createFile(File file) {
        try {
            file.createNewFile();
        } catch (Exception e) {
            // Do nothing.
        }
        
    }

    public static void writeToFile(String toWrite, File file) {
        try {
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.print(toWrite);
            writer.close();
        } catch (Exception e) {
            // Do nothing.
        }
        
    }
    
}