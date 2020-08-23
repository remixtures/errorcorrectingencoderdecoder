package correcter.encodedecode;

import static correcter.encodedecode.BitGetterSetter.getBitAt;
import static correcter.encodedecode.BitGetterSetter.setBitAt;

public class Encode {

    public static byte[] encoder(byte[] dataToEncode) {
        final byte[] encodedData = new byte[dataToEncode.length * 2];
        for (int i = 0; i < dataToEncode.length; i++) {
            for (int j = 0; j < 2; j++) {
                int[] data = new int[4];
                for (int k = 0; k < 4; k++)
                    data[k] = getBitAt(dataToEncode[i], j * 4 + k);
                encodedData[2 * i + j] = encodeData(data);
            }
        }
        return encodedData;
    }

    private static byte encodeData(final int[] data) {
        byte encodedData = 0;
        encodedData = setBitAt(encodedData, 0, data[0] ^ data[1] ^ data[3]);
        encodedData = setBitAt(encodedData, 2 - 1, data[0] ^ data[2] ^ data[3]);
        encodedData = setBitAt(encodedData, 3 - 1, data[0]);
        encodedData = setBitAt(encodedData, 4 - 1, data[1] ^ data[2] ^ data[3]);
        encodedData = setBitAt(encodedData, 5 - 1, data[1]);
        encodedData = setBitAt(encodedData, 6 - 1, data[2]);
        encodedData = setBitAt(encodedData, 7 - 1, data[3]);
        return encodedData;
    }
}
