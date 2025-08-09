import java.io.IOException;
import java.util.Scanner;


public class Menu {
    public static void printMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSelect mode:\n");
        System.out.println("Encryption – 1 + Enter");
        System.out.println("Decryption – 2 + Enter");
        System.out.println("Exit – 0 + Enter");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> encryptFlow(scanner);
            case 2 -> decryptFlow(scanner);
            default -> System.out.println("Exiting...");
        }
    }

    private static void encryptFlow(Scanner scanner) {
        System.out.print("\nEnter the path to the file: ");
        String filePath = scanner.nextLine();

        if (!Validator.isFileExists(filePath)) {
            System.out.println("File not found!");
            return;
        }

        System.out.print("Enter the key (1-62): ");
        int key = scanner.nextInt();

        if (!Validator.isValidKey(key)) {
            System.out.println("Invalid key!");
            return;
        }

        try {
            String text = FileManager.readFile(filePath);
            String encrypted = CaesarCipher.encrypt(text, key);
            FileManager.writeFile(encrypted, filePath + "enc");
            System.out.println("File encrypted successfully!");
        } catch (IOException e) {
            System.out.println("Error reading/writing the file.");
        }
    }

    private static void decryptFlow(Scanner scanner) {
        System.out.print("\nEnter the path to the file: ");
        String filePath = scanner.nextLine();

        if (!Validator.isFileExists(filePath)) {
            System.out.println("File not found!");
            return;
        }

        System.out.print("Enter the key (1-62): ");
        int key = scanner.nextInt();

        if (!Validator.isValidKey(key)) {
            System.out.println("Invalid key!");
            return;
        }

        try {
            String text = FileManager.readFile(filePath);
            String decrypted = CaesarCipher.decrypt(text, key);
            FileManager.writeFile(decrypted, filePath + "dec");
            System.out.println("File decrypted successfully!");
        } catch (IOException e) {
            System.out.println("Error reading/writing the file.");
        }
    }
}