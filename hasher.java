import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class hasher {

    public static void main(String[] args) {
        // Accept user input
        Scanner scanner = new Scanner(System.in);

        // Choose the hashing algorithm
        System.out.println("Pick hashing algorithm:");
        System.out.println("1. MD5");
        System.out.println("2. SHA-1");
        System.out.println("3. SHA-256");
        System.out.print("Enter choice (1, 2, 3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  

        // Accept input string
        System.out.print("Enter string to be hashed: ");
        String input = scanner.nextLine();

        // Choose the hashing algorithm
        String algorithm;
        switch (choice) {
            case 1:
                algorithm = "MD5";
                break;
            case 2:
                algorithm = "SHA-1";
                break;
            case 3:
                algorithm = "SHA-256";
                break;
            default:
                System.out.println("Invalid choice. Using default: MD5.");
                algorithm = "MD5";
                break;
        }

        try {
            // Create MessageDigest instance
            MessageDigest md = MessageDigest.getInstance(algorithm);

            // Update the digest with input bytes
            md.update(input.getBytes());

            // Hash computation
            byte[] digestBytes = md.digest();

            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : digestBytes) {
                // Convert each byte to two-digit hexadecimal
                String hex = Integer.toHexString(0xff & b);
                // Leading zero if necessary
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Output result
            System.out.println(algorithm + " Hash: " + hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error in hashing operation: " + e.getMessage());
        }

        // Close scanner
        scanner.close();
    }
}
