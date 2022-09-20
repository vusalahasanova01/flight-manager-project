package util;

import model.DBEnum;

import javax.management.StringValueExp;
import java.io.*;
import java.nio.Buffer;
import java.util.Optional;

public class Id {
    private static final String FileLoc = "src/main/java/file/id/";
    public static Optional<Integer> getId(DBEnum dbEnum)  {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(FileLoc+dbEnum.getFileName()))){

            int id =Integer.parseInt(bufferedReader.readLine());
            increment(id,dbEnum);
            return  Optional.of(id);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
           return Optional.empty();
        } catch (IOException e) {
            System.out.println("io exception");
            return Optional.empty();
        }
    }


    private static void increment(int id,DBEnum dbEnum){
        try(BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter(FileLoc+dbEnum.getFileName()))){
            bufferedWriter .write((String.valueOf(++id)));
        } catch (IOException e) {
            throw new RuntimeException("id generator doesn't works.");
        }

    }
}
