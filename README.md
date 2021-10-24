# DES-Encoder
DES-Encoder is a Java and JavaFX based DES-Encoder. DES-Encoder functionalities are accessible through a simple UI or through command codes using the Interpreter.
## About DES
So what is DES, actually?
DES, or Data Encryption System is a symmetric (meaning that the encryption and decryption keys used are the same) encryption algorithm.
First developed by IBM in the 1970s, following a public contest by the NIST/NBS it was adopted as a standard by the Federal Infomation Processing Standard in the United States.

Due to its small key size (56 bits) the adoption instantly raised some eyebrows, and in the 1990s Biham and Shamir report the first theoretical attack possible with an impractictal 2^47 chosen plaintexts.
In 1997 the DESCHALL Project publicly break a message encrypted using DES. 

## What are the notable characteristics of DES?
DES uses block sizes and keys of 64 bits, however:
- keys of 64 bits have 8 bits dedicated to error-code correction and detection making the effective key size long 56 bits.


![An general overview of of DES | Figure 1](/assets/images/des.png)
![An overview of the plaintex side of DES](/assets/images/des.png)
How is data encrypted with DES?
1) Inputs first pass through an "Initial Permutation". (IP in "Figure 1")
2) The 64 permutated bits are split into 2, 32 bits on the left and 32 bits on the right.
3) These left and right bits are permutated with 16 Feistel rounds, using the input key
3.1) The key is also permutated, using "shift logic"
4) After 16 Feistel rounds are applied, the output left and rights bits are united once again, and permutated using the Inverse of the "Initial Permutation".
The resulting 64 bits are the output of DES.

![An overview of the key side of DES](/assets/images/key.png)
3.1) As previously said, 8 of the 64 key bits are used for error detection and correction.
Keys are split once again in 2 halfs, and produced for each rounds using a permutation/contraction function, which permutates and reduces the number of bits (from 56 to 48).
The shifted halfs are the used as inputs for the next key generation round.

## So how does it all come together?
![An overview of the of DES](/assets/images/totdes.png)