import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminFile {

    private static final String FOLDER = "conversacion/";

    public static boolean createFolder(String patch) {

        File folder = new File(FOLDER + patch);
        return folder.mkdir();

    }

    public static boolean createFolders(String patch) {

        File folder = new File(FOLDER + patch);
        return folder.mkdirs();
    }

    public static boolean createFile(String patch, String name) {

        File file = new File(FOLDER + patch + "/" + name);
        try {
            return file.createNewFile();
        } catch (Exception e) {
            return false;

        }
    }

    public static boolean writeFile(String patch, String name, String text) {

        try {
            FileWriter Writer = new FileWriter(FOLDER + patch + "/" + name);
            Writer.write(text);
            Writer.close();

        } catch (Exception e) {
            return false;

        }
        return true;
    }

    public static boolean writeFileanidado(String patch, String name, String text) {

        try {
            FileWriter Writer = new FileWriter(FOLDER + patch + "/" + name, true);
            Writer.write(text + "\n");
            Writer.close();

        } catch (Exception e) {
            return false;

        }
        return true;
    }

    public static boolean writeFileBuffer(String patch, String name, String text) {

        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(FOLDER + patch + "/" + name, true));
            buffer.write(text);
            buffer.newLine();
            buffer.close();
            return true;

        } catch (Exception e) {
            return false;

        }
    }

    public static void readFile(String patch, String name) {

        try {
            FileReader reader = new FileReader(FOLDER + patch + "/" + name);

            int character;
            while ((character = reader.read()) != -1) {
                System.out.println((char) character);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void readFileBuffer(String patch, String name) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FOLDER + patch + "/" + name));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }

        } catch (Exception e) {
            Logger.getLogger(AdminFile.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    public static boolean deleteall(String patch) {
        File folder = new File(FOLDER + patch);

        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteall(file.getAbsolutePath());
                    } else {
                        file.delete();
                    }
                }

            } else {
                folder.delete();
            }

        }
        return true;

    }
}