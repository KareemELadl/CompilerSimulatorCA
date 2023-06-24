import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileEncryptionExample {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void encryptFile(String inputFile, String outputFile, String key) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        doCrypto(Cipher.ENCRYPT_MODE, inputFile, outputFile, key);
    }

    public static void decryptFile(String inputFile, String outputFile, String key) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        doCrypto(Cipher.DECRYPT_MODE, inputFile, outputFile, key);
    }

    private static void doCrypto(int cipherMode, String inputFile, String outputFile, String key) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(cipherMode, secretKey);

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile);
             CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) >= 0) {
                cipherOutputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        String inputFile = "plaintext.txt";
        String encryptedFile = "plaintext.txt";
        String decryptedFile = "decrypted.txt";
        String key = "ThisIsASecretKey";

        try {

            decryptFile(encryptedFile, decryptedFile, key);
            System.out.println("File decrypted successfully: " + decryptedFile);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
