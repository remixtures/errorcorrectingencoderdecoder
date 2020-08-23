package correcter.encodedecode;

public class BitGetterSetter {

    static int getBitAt(byte data, int index) {
        int shift = 7 - index;
        return (data & (1 << shift)) >> shift;
    }

    static byte setBitAt(byte data, int index, int bit) {
        if (bit == 1) {
            return (byte) (data | (1 << (7 - index)));
        } else {
            return (byte) (data & ~(1 << (7 - index)));
        }
    }
}
