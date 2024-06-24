import java.awt.image.AbstractMultiResolutionImage;
import java.io.*;
import java.nio.Buffer;


public class Main {
    public static void main(String[] args) {
////        Input Output -I/O
////        Key Content
//        /**
//         * 1.Stream: Astream in java is an abstraction that represents a sequence of data. It can be though as a flow of data that you can read or write
//         * 2. Input Stream: it is used to read from a source,such as a file, network connection, of keyboard input
//         * 3.Output Stream: it is used to write data to a destination, such as a file, network connection or console output
//         * 4.Byte Streams: these handle I/O of raw binary data. The primary classes for byte streams are InputStream and OutputStream
//         * 5.Character Streams: these handle I/O of character data, automatically handling character encoding. The primary classes for character streams are Reader and Writer
//         * 6.Buferred  Streams; these use a buffer to improve I/O performance by reducing the number of system-level I/O operations
//         * 7.File I/O: this refers to reading from and writing to a file on filesystem
//         * 8.Standard I/O:this refers to the standard input ( usually keyboard), standard output(usually console) and standard error streams
//         */
//
////        Byte Streams vs Character Streams
////        Java Provides two types of streams
//        /**
//         * 1.Byte Streams
//         * ->   Works with raw binary data
//         * -> Base Clases: InputStream and OutputStreams
//         * ->Examples: FileInputStream, FileOutputStream
//         *
//         * 2.Character Streams
//         * ->Works with Character data
//         * -> Automatically handles Character encoding
//         * ->Base classes:Reader and Writer
//         * ->Examples:FileReader, FileWriter
//         */
//
////        Byte Streams Examples
////        Create a sample binary data[1,2,3,4,5]
//        byte[] sampleBinarydata = {0x01,0x02,0x03,0x04,0x05};
//        try (FileInputStream fis = new FileInputStream("input1.bin"); FileOutputStream fos = new FileOutputStream("output.bin")){
//
////            Write the data to .bin file
////            fos.write(sampleBinarydata);
////            System.out.println("Sample data written to output.bin file");
//            int byteData;
//            while ((byteData = fis.read())!= -1) {
//                fos.write(byteData);
//            }
//
//        } catch (IOException e){
////            e.printStackTrace();
//System.err.println("Error in Writing to File" + e.getMessage());
//
//        }
//
////        Explanation
////        FileInputStream is used to read from the input file
////        FileOutputStream is used to write bytes to the output file
////        The read() method returns -1 when the end of the file is reached
////        The try-with-resources statement ensures that the Streams are properly closed
//
////        Character Streams
////        Create sample charcter data
//        char[] charData = {'1', '2', '3', '4', '5', '6'};
//
//
////        try (FileReader reader = new FileReader("input.txt");FileWriter writer = new FileWriter("output.txt")){
////
////////        Write data to .txt file
//////            writer.write(charData);
//////            System.out.println("Sample data written to input.txt");
////            int CharData;
////            while((CharData = reader.read()) != -1) {
////                writer.write(CharData);
////            }
////
////
////        } catch (IOException e) {
////            e.printStackTrace();
////            System.err.println("Error in Writing to the file" + e.getMessage());
////
////        }
//
////        Buffered I/O
////        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
////            String line;
////            while((line = br.readLine()) != null) {
////                bw.write(line);
////                bw.newLine();
////                System.out.println();
////            }
////
////        } catch(IOException e){
////            e.printStackTrace();
////        }
//
////        File copy program
////        1.Write a java program that copies content of one file to another. The program should take two command-line arguments;The source file path and the destination file path
////        try (FileReader fr = new FileReader("content.txt");FileWriter fw = new FileWriter("copy.txt")) {
////            int Character;
////            while ((Character = fr.read())!=-1){
////                fw.write(Character);
////
////            }
////        } catch(IOException e) {
////            e.printStackTrace();
////        }
        // Check if the number of arguments passed from the command line is exactly 2.
// args.length gives the number of command-line arguments.
//        if (args.length != 2) {
//            // If not, print a message explaining how to use the program.
//            // "<input.txt> <output.txt>" are placeholders for the actual file names the user should provide.
//            System.out.println("Usage: Java FileCopy <input.txt> <output.txt>");
//            // End the program because the required arguments were not provided.
//            return;
//        }
//
//// Store the first command-line argument in a variable named 'sourceFile'.
//// This is expected to be the path of the file you want to copy from.
//        String sourceFile = args[0];
//// Store the second command-line argument in a variable named 'destinationFile'.
//// This is expected to be the path of the file you want to copy to.
//        String destinationFile = args[1];
//
//// This line has an issue because it tries to access a third argument which doesn't exist.
//// The program expects only 2 arguments, so this will cause an ArrayIndexOutOfBoundsException.
//// String file = args[2]; // This line should be removed or commented out.
//
//// Try to open the source file for reading and the destination file for writing.
//// 'BufferedInputStream' and 'BufferedOutputStream' are used for efficient reading and writing.
//        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
//             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
//
//            // Create a buffer (temporary storage area) for reading chunks of the file.
//            byte[] buffer = new byte[1024]; // 1024 bytes = 1KB
//            int byteRead; // This will hold the number of bytes read in each operation.
//
//            // Read the first chunk of data into the buffer. The read method returns the number of bytes read,
//            // or -1 if there is no more data because the end of the file has been reached.
//            while ((byteRead = bis.read(buffer)) != -1) {
//                // Write the chunk of data that was just read into the destination file.
//                // It writes from the buffer, starting at index 0, up to the number of bytes read.
//                bos.write(buffer, 0, byteRead);
//            }
//
//            // If everything goes well, print a success message.
//            System.out.println("File Copied Successfully");
//
//        } catch (IOException e) {
//            // If an error occurs during reading or writing, catch the exception and print an error message.
//            System.out.println("An Error occurred: " + e.getMessage());
//        }
//
//
////
////        Line counter
////        2.Write a java program that counts the number of lines in a text file. The program should take the file path as a command line argument and print total number of line

//        if (args.length !=1){
//            System.out.println("Pass the file path of the Text File");
//        }
//        String TextFile = args[0];
//        int lineCount = 0;
//        try (BufferedReader bri = new BufferedReader(new FileReader(TextFile))){
//            while (bri.readLine() != null){
//                lineCount++;
//
//            }
//            System.out.println("The number of lines in the Text File are: " + lineCount);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//
//        }
//        try (BufferedReader bfr = new BufferedReader(new FileReader("content.input"))) {
//            String CharNums;
//            while((CharNums = bfr.readLine()) != null) {
//                System.out.println(CharNums.length());
//
//
//            }
//
//        } catch (IOException e){
//            e.printStackTrace();
//
//        }
////        CSV parser
////        Write a java program that reads a CSV(Comma Separate Values).Assume that the csv file does not contain any commas within the fields
        if (args.length != 1){
            System.out.println("Provide the file Path to the file");
            return;
        }
        String CommaFile = args[0];
        try (BufferedReader cr = new BufferedReader(new FileReader(CommaFile))) {
            String line;
            while ((line = cr.readLine())!= null) {
                String [] fields = line.split(",");
                for (String field : fields){
                    System.out.println(field + "");
                }


            }

        } catch (IOException e) {
            System.out.println("Error Occurred; "+ e.getMessage());
        }

    }
}
//        try (BufferedReader vr = new BufferedReader(new FileReader("values.txt"));BufferedWriter vw = new BufferedWriter(new FileWriter("comma.txt"))) {
//            String CommaValues;
//            while ((CommaValues = vr.readLine())!= null) {
//                for (int i = 0;i<CommaValues.length();i++){
//                    String comma;
//                }
//                vw.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//
//
//
//    }

