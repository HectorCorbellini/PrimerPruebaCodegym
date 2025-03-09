package com.example.cryptography;

public class EjecutorPruebas {
    private static final String TEST_INPUT = "test_input.txt";
    private static final String TEST_OUTPUT = "test_output.txt";
    private static final String TEST_CONTENT = "This is a test message to encrypt.";

    public static void main(String[] args) {
        // Create test input file
        try {
            java.io.FileWriter writer = new java.io.FileWriter(TEST_INPUT);
            writer.write(TEST_CONTENT);
            writer.close();
        } catch (java.io.IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
            return;
        }

        // Set auto test mode
        Consola.setAutoTest(true, 3);  // Using key = 3 for testing

        System.out.println("\n=== Testing Option 1: ENCRYPT ===");
        Principal.main(new String[]{"1"});
        
        System.out.println("\n=== Testing Option 2: DECRYPT ===");
        // Copy encrypted output to new input
        try {
            java.nio.file.Files.copy(
                java.nio.file.Paths.get(TEST_OUTPUT),
                java.nio.file.Paths.get(TEST_INPUT),
                java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );
        } catch (java.io.IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
            return;
        }
        Principal.main(new String[]{"2"});

        System.out.println("\n=== Testing Option 3: BRUTE FORCE ===");
        Principal.main(new String[]{"3"});

        System.out.println("\n=== Testing Option 4: ANALYSIS ===");
        Principal.main(new String[]{"4"});

        System.out.println("\nTest completed! Check the contents of test_output.txt after each operation.");
    }
}
