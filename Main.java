import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        String textToFile = "Компания «МегаФон» начала работы по подготовке к включению в систему вызова экстренных оперативных служб по единому номеру 112. ";

        //создаем файл с текстом
        File file1 = WorkingToFile.createFile("file1.txt");
        //пишем в файл текст
        WorkingToFile.writeToFile(file1,textToFile);


        //создаем новый файл
        File file2 = WorkingToFile.createFile("file2.txt");
        //копируем содержимое
        WorkingToFile.copyFile(file1,file2);


        //сериализация
        TestSerializable testSerializable = new TestSerializable("serializible",1,2);
        File seriaz = WorkingToFile.createFile("seriaz.txt");
        WorkingToFile.serealizeStream(testSerializable,seriaz);


        //расширенная сериализация
        TestExternalizable testExternalizable = new TestExternalizable("exserializible",5);
        File exseriaz = WorkingToFile.createFile("exseriaz.txt");
        WorkingToFile.serealizeStream(testExternalizable,exseriaz);


        //файлы в архив
        File[] allFile = {file1,file2,seriaz,exseriaz};

        File zipFile = WorkingToFile.createFile("zipfile.zip");
        WorkingToFile.createZipFile(zipFile,allFile);


    }




}
