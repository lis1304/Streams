import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WorkingToFile {

    public static File createFile(String name){
        File file = new File(name);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public static void writeToFile(File file, String text){

        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyFile(File fileFrom, File fileTo){

        try {
            Files.copy(fileFrom.toPath(),fileTo.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void serealizeStream(Serializable object, File file){

        try
                (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
            oos.writeObject(object);
        }
         catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createZipFile(File zipFileName, File[] fileToZipAdd){

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName)))

        {
            for (File file : fileToZipAdd) {
                ZipEntry entry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(entry);
                zipOutputStream.write(Files.readAllBytes(file.toPath()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
