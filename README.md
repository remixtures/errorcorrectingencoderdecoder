Project developed within HyperSkill's Java Developer curriculum. 

The program reads the text the user wants to send from the send.txt and simulates its posting through a poor internet connection by making one-bit errors in every byte of the text. 

For that, the program implements a Hamming code. In this code, every byte contains 4 significant bits, and the other 4 bits are used as an overhead (to be more precise, since the last one just isn't used, only 3 of them are used as an overhead).

MODES:

"encode": text from an input file is converted to a ready-to-send form (where you have three significant bits per byte). The resulting bytes are then saved into a (different) output file.

"send": generates errors in the bytes (1 bit per byte) of a text file and saves the resulting bytes into another file.

"decode": an encoded input file is decoded back into normal text which is then saved to an output file.

Example 1:

Write a mode: encode

send.txt:

text view: Test

hex view: 54 65 73 74

bin view: 01010100 01100101 01110011 01110100

encoded.txt:

expand: ..0.101. ..0.100. ..0.110. ..0.101. ..0.111. ..0.011. ..0.111. ..0.100.

parity: 01001010 10011000 11001100 01001010 00011110 10000110 00011110 10011000

hex view: 4A 98 CC 4A 1E 86 1E 98

Example 2:

Write a mode: send

encoded.txt:

hex view: 4A 98 CC 4A 1E 86 1E 98

bin view: 01001010 10011000 11001100 01001010 00011110 10000110 00011110 10011000

received.txt:

bin view: 01011010 10001000 10001100 01001110 00010110 10100110 00111110 10010000

hex view: 5A 88 8C 4E 16 A6 3E 90

Example 3:

Write a mode: decode

received.txt:

hex view: 5A 88 8C 4E 16 A6 3E 90

bin view: 01011010 10001000 10001100 01001110 00010110 10100110 00111110 10010000

decoded.txt:

correct: 01001010 10011000 11001100 01001010 00011110 10000110 00011110 10011000

decode: 01010100 01100101 01110011 01110100

hex view: 54 65 73 74

text view: Test