
public class EncryptionTester {
	
	public static void main(String[] args) throws Exception {
        String encryptedFilePath = "src/encrypted.txt";
        String decryptedFilePath = "src/decrypted.txt";
        String inputFilePath = "src/encryptMe.txt";
        String outputFilePath = "src/newEncrypted.txt";
		
        int shift = 1; // Says how much you would like to shift

        Encrypter enc = new Encrypter(shift);

<<<<<<< HEAD
        
        System.out.println("Encrypting...");
		enc.encrypt(inputFilePath, outputFilePath);
		System.out.println("Encryption complete.");
		
		System.out.println("Decrypting...");
		enc.decrypt(encryptedFilePath, decryptedFilePath);
		System.out.println("Decryption complete.");
		
		// access the decrypted text with getDecrypted
		String decrypted = enc.getDecrypted();
		
		System.out.println("Decrypted text:" + decrypted);
		System.out.println("Shift amount:" + shift);
		
		System.out.println("It works.");
		
=======
		enc.encrypt(inputFilePath, outputFilePath);
		enc.decrypt(encryptedFilePath, decryptedFilePath);
>>>>>>> origin/main

	}


<<<<<<< HEAD
}
=======
}
>>>>>>> origin/main
