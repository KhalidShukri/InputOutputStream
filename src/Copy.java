import java.io.*;

public class Copy {
    public static void main(String[]args){
        if (args.length != 2) {
            // If not, print a message explaining how to use the program.
            // "<input.txt> <output.txt>" are placeholders for the actual file names the user should provide.
            System.out.println("Usage: Java FileCopy <input.txt> <output.txt>");
            // End the program because the required arguments were not provided.
            return;
        }

// Store the first command-line argument in a variable named 'sourceFile'.
// This is expected to be the path of the file you want to copy from.
        String sourceFile = args[0];
// Store the second command-line argument in a variable named 'destinationFile'.
// This is expected to be the path of the file you want to copy to.
        String destinationFile = args[1];

// This line has an issue because it tries to access a third argument which doesn't exist.
// The program expects only 2 arguments, so this will cause an ArrayIndexOutOfBoundsException.
// String file = args[2]; // This line should be removed or commented out.

// Try to open the source file for reading and the destination file for writing.
// 'BufferedInputStream' and 'BufferedOutputStream' are used for efficient reading and writing.
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            // Create a buffer (temporary storage area) for reading chunks of the file.
            byte[] buffer = new byte[1024]; // 1024 bytes = 1KB
            int byteRead; // This will hold the number of bytes read in each operation.

            // Read the first chunk of data into the buffer. The read method returns the number of bytes read,
            // or -1 if there is no more data because the end of the file has been reached.
            while ((byteRead = bis.read(buffer)) != -1) {
                // Write the chunk of data that was just read into the destination file.
                // It writes from the buffer, starting at index 0, up to the number of bytes read.
                bos.write(buffer, 0, byteRead);
            }

            // If everything goes well, print a success message.
            System.out.println("File Copied Successfully");

        } catch (IOException e) {
            // If an error occurs during reading or writing, catch the exception and print an error message.
            System.out.println("An Error occurred: " + e.getMessage());
        }

    }
}
