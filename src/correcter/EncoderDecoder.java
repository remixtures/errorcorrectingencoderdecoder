package correcter;

import correcter.encodedecode.Decode;
import correcter.encodedecode.Encode;
import correcter.readwrite.ReadWriteData;
import java.util.Random;
import java.util.Scanner;

public class EncoderDecoder {

    public void userOptions() {
        Scanner scanner = new Scanner(System.in);
        byte[] readData;
        byte[] encodedData;
        byte[] readEncodedData;
        byte[] glitchedData;
        byte[] receivedData;
        byte[] decodedData;

        System.out.println("Write a mode: ");
        String mode = scanner.next();
        scanner.close();

        switch (mode) {
            case "encode":
                readData = ReadWriteData.readFromFile("send.txt");
                encodedData = Encode.encoder(readData);
                ReadWriteData.writeToFile("encoded.txt", encodedData);
                break;
            case "send":
                readEncodedData = ReadWriteData.readFromFile("encoded.txt");
                glitchedData = generateDataError(readEncodedData);
                ReadWriteData.writeToFile("received.txt", glitchedData);
                break;
            case "decode":
                receivedData = ReadWriteData.readFromFile("received.txt");
                decodedData = Decode.decoder(receivedData);
                ReadWriteData.writeToFile("decoded.txt", decodedData);
                break;
            default:
        }
    }

    private static byte[] generateDataError(byte[] inputData) {
        Random random = new Random();
        byte[] outputData = new byte[inputData.length];
        for (int i = 0; i < inputData.length; i++) {
            int num = 1 << random.nextInt(8);
            outputData[i] = (byte) (inputData[i] ^ num);
        }
        return outputData;
    }
}
