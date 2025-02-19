package com.day1.advanceProblems;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.io.*;

public class EncryptionUtil {

    private static final String ALGORITHM = "AES";

    // Method to generate a secret key
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128); // AES 128-bit encryption
        return keyGen.generateKey();
    }

    // Method to encrypt data
    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt data
    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }
    public static SecretKey getKeyFromString(String keyString) {
        return new SecretKeySpec(Base64.getDecoder().decode(keyString), ALGORITHM);
    }
}
class CSVHandler {

    // Method to write data into a CSV file with encrypted sensitive fields
    public static void writeEncryptedCSV(String fileName, String[][] data, SecretKey key) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        // Writing headers
        writer.write("Name,Email,Salary\n");

        // Writing data and encrypting sensitive fields
        for (String[] row : data) {
            String encryptedEmail = EncryptionUtil.encrypt(row[1], key);
            String encryptedSalary = EncryptionUtil.encrypt(row[2], key);

            writer.write(row[0] + "," + encryptedEmail + "," + encryptedSalary + "\n");
        }

        writer.close();
    }

    // Method to read data from a CSV file with decrypted sensitive fields
    public static void readDecryptedCSV(String fileName, SecretKey key) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        // Skip the header line
        reader.readLine();

        // Read and decrypt data
        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(",");
            String decryptedEmail = EncryptionUtil.decrypt(columns[1], key);
            String decryptedSalary = EncryptionUtil.decrypt(columns[2], key);

            System.out.println("Name: " + columns[0] + ", Email: " + decryptedEmail + ", Salary: " + decryptedSalary);
        }

        reader.close();
    }

    public static void main(String[] args) {
        try {
            // Example data
            String[][] data = {
                    {"John Doe", "johndoe@example.com", "5000"},
                    {"Jane Smith", "janesmith@example.com", "6000"}
            };

            SecretKey key = EncryptionUtil.generateKey();

            String fileName = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\encryption.csv";

            writeEncryptedCSV(fileName, data, key);

            readDecryptedCSV(fileName, key);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
