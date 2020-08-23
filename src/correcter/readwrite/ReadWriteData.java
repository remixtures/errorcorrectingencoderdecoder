package correcter.readwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadWriteData {

    public static byte[] readFromFile(String inputFile) {
        File inputFileName = new File(inputFile);
        try (FileInputStream stream = new FileInputStream(inputFileName)) {
            return stream.readAllBytes();
        } catch (Exception e) {
            System.out.println("Error in reading the file: " + inputFileName.getName());
            return new byte[]{};
        }
    }

    public static void writeToFile(String outputFile, byte[] data) {
        File outputFileName = new File(outputFile);
        try (FileOutputStream stream = new FileOutputStream(outputFileName)) {
            stream.write(data);
        } catch (final Exception e) {
            System.out.println("Error in writing the file: " + outputFileName.getName());
        }
    }
}
