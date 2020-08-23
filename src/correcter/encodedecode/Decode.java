package correcter.encodedecode;

import static correcter.encodedecode.BitGetterSetter.getBitAt;
import static correcter.encodedecode.BitGetterSetter.setBitAt;

public class Decode {

    public static byte[] decoder(final byte[] dataToDecode) {
        final byte[] decodedData = new byte[dataToDecode.length / 2];
        int decodedDataCount = 0;
        byte bitCount = 0;
        byte outData = 0;
        for (final byte data : dataToDecode) {
            int[] bits = decodeData(data);
            for (byte i = 0; i < 4; i++) {
                outData = setBitAt(outData, bitCount, bits[bitCount % 4]);
                bitCount++;
            }
            if (bitCount == 8) {
                decodedData[decodedDataCount++] = outData;
                bitCount = 0;
                outData = 0;
            }
        }
        return decodedData;
    }

    private static int[] decodeData(byte data) {
        int p1 = getBitAt(data, 0);
        int p2 = getBitAt(data, 2 - 1);
        int p4 = getBitAt(data, 4 - 1);
        int a = getBitAt(data, 3 - 1);
        int b = getBitAt(data, 5 - 1);
        int c = getBitAt(data, 6 - 1);
        int d = getBitAt(data, 7 - 1);
        boolean c1 = (p1 == (a ^ b ^ d));
        boolean c2 = (p2 == (a ^ c ^ d));
        boolean c4 = (p4 == (b ^ c ^ d));
        if (!(c1 && c2 || c2 && c4 || c4 && c1))
            if (c1)
                c = shiftInteger(c);
            else if (c2)
                b = shiftInteger(b);
            else if (c4)
                a = shiftInteger(a);
            else
                d = shiftInteger(d);
        return new int[] { a, b, c, d };
    }

    private static int shiftInteger(int number) {
        return number == 1 ? 0 : 1;
    }
}
