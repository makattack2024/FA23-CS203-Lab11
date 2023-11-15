import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;
    private String decrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        //TODO: Call the read method, encrypts it using cipher, and writes to new file
    	String content = readFile(inputFilePath); // reads the conent from input
    	String encryptedContent = encryptText(content, shift); // encrypt the content with cipher with specific shift
    	writeFile(encryptedContent, encryptedFilePath);   // writes content to new file 	
    }
    
    private static String encryptText(String text, int shift) {
    	StringBuilder encrypted = new StringBuilder(); //stores encrypted text
    	// iterste through each char in input
    	for (char c : text.toCharArray()) {
    		if (Character.isLetter(c)) {
    			// decides base for upper and lower letters
    			char base = Character.isUpperCase(c) ? 'A' : 'a';
    			// performs cipher and appends to result 
    			encrypted.append((char) ((c-base+shift)% 26 + base));
    		} else {
    			// if a char is not a letter, should append 
    			encrypted.append(c);
    		}
    	}
    	// return the encrypted text
    	return encrypted.toString();
    }

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    
    //get decrypted text
    public String getDecrypted() {
    	return decrypted;
    }
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        //TODO: Call the read method, decrypt the file contents, and then write to new file
    	String encrypted = readFile(messageFilePath); // read content from encrypted file
    	String decrypted = decryptText(encrypted, shift); // decryptes the file with cipher and specific shift
    	this.decrypted = decrypted; //update variable 
    	writeFile(decrypted,decryptedFilePath); // writes the decrypted to new file 
    }
    
    private static String decryptText(String text, int shift) {
    	StringBuilder decrypted = new StringBuilder();
    	
    	for (char c : text.toCharArray()) {
    		if (Character.isLetter(c)) {
    			char base = Character.isUpperCase(c) ? 'A' : 'a';
    			// performs decryption and appends result 
    			decrypted.append((char) ((c - base - shift + 26) % 26 + base));
    		} else {
    			decrypted.append(c); // if a char is not a letter, should append it without change
    		}
    	}
    	return decrypted.toString();
    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
    	 //TODO: Read file from filePath
    	StringBuilder content = new StringBuilder();
    	try (Scanner scanner = new Scanner(new File(filePath))){
    		while (scanner.hasNextLine()) {
    			content.append(scanner.nextLine()).append("\n");   
    			}
    	}
      
        return content.toString(); //returns as a string
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) {
        //TODO: Write to filePath
    	try(FileWriter writer = new FileWriter(filePath)) {
    		writer.write(data);
    	} catch (IOException e) {
    		e.printStackTrace(); //handle the exception when needed
    	}
    }

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}