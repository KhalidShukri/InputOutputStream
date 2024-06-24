import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) {
//        Input Output -I/O
//        Key Content
        /**
         * 1.Stream: Astream in java is an abstraction that represents a sequence of data. It can be though as a flow of data that you can read or write
         * 2. Input Stream: it is used to read from a source,such as a file, network connection, of keyboard input
         * 3.Output Stream: it is used to write data to a destination, such as a file, network connection or console output
         * 4.Byte Streams: these handle I/O of raw binary data. The primary classes for byte streams are InputStream and OutputStream
         * 5.Character Streams: these handle I/O of character data, automatically handling character encoding. The primary classes for character streams are Reader and Writer
         * 6.Buferred  Streams; these use a buffer to improve I/O performance by reducing the number of system-level I/O operations
         * 7.File I/O: this refers to reading from and writing to a file on filesystem
         * 8.Standard I/O:this refers to the standard input ( usually keyboard), standard output(usually console) and standard error streams
         */

//        Byte Streams vs Character Streams
//        Java Provides two types of streams
        /**
         * 1.Byte Streams
         * ->   Works with raw binary data
         * -> Base Clases: InputStream and OutputStreams
         * ->Examples: FileInputStream, FileOutputStream
         *
         * 2.Character Streams
         * ->Works with Character data
         * -> Automatically handles Character encoding
         * ->Base classes:Reader and Writer
         * ->Examples:FileReader, FileWriter
         */

//        Byte Streams Examples
//        Create a sample binary data[1,2,3,4,5]
        byte[] sampleBinarydata = {0x01,0x02,0x03,0x04,0x05};
        try (FileInputStream fis = new FileInputStream("input1.bin"); FileOutputStream fos = new FileOutputStream("output.bin")){

//            Write the data to .bin file
//            fos.write(sampleBinarydata);
//            System.out.println("Sample data written to output.bin file");
            int byteData;
            while ((byteData = fis.read())!= -1) {
                fos.write(byteData);
            }

        } catch (IOException e){
//            e.printStackTrace();
System.err.println("Error in Writing to File" + e.getMessage());

        }

//        Explanation
//        FileInputStream is used to read from the input file
//        FileOutputStream is used to write bytes to the output file
//        The read() method returns -1 when the end of the file is reached
//        The try-with-resources statement ensures that the Streams are properly closed

//        Character Streams
//        Create sample charcter data
        char[] charData = {'1', '2', '3', '4', '5', '6'};


//        try (FileReader reader = new FileReader("input.txt");FileWriter writer = new FileWriter("output.txt")){
//
//////        Write data to .txt file
////            writer.write(charData);
////            System.out.println("Sample data written to input.txt");
//            int CharData;
//            while((CharData = reader.read()) != -1) {
//                writer.write(CharData);
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.err.println("Error in Writing to the file" + e.getMessage());
//
//        }

//        Buffered I/O
//        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
//            String line;
//            while((line = br.readLine()) != null) {
//                bw.write(line);
//                bw.newLine();
//                System.out.println();
//            }
//
//        } catch(IOException e){
//            e.printStackTrace();
//        }

//        File copy program
//        1.Write a java program that copies content of one file to another. The program should take two command-line arguments;The source file path and the destination file path
//        try (FileReader fr = new FileReader("content.txt");FileWriter fw = new FileWriter("copy.txt")) {
//            int Character;
//            while ((Character = fr.read())!=-1){
//                fw.write(Character);
//
//            }
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
        if (args.length != 2) {
            System.out.println("Usage: Java FileCopy <input.txt> <output.txt>");
            return;
        }
        String sourceFile = args[0];
        String destinationFile = args[1];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
         byte [] buffer = new byte[1024];
         int byteRead;
         while ((byteRead = bis.read(buffer))!= -1){
             bos.write(buffer,0,byteRead);

         }
            System.out.println("File Copied Successfully");

        } catch (IOException e){
            System.out.println("An Error occurred: " + e.getMessage());

        }
//
//        Line counter
//        2.Write a java program that counts the number of lines in a text file. The program should take the file path as a command line argument and print total number of line
        try (BufferedReader bfr = new BufferedReader(new FileReader("content.input"))) {
            String CharNums;
            while((CharNums = bfr.readLine()) != null) {
                System.out.println(CharNums.length());


            }

        } catch (IOException e){
            e.printStackTrace();

        }
//        CSV parser
//        Write a java program that reads a CSV(Comma Separate Values).Assume that the csv file does not contain any commas within the fields
        try (BufferedReader vr = new BufferedReader(new FileReader("values.txt"));BufferedWriter vw = new BufferedWriter(new FileWriter("comma.txt"))) {
            String CommaValues;
            while ((CommaValues = vr.readLine())!= null) {
                for (int i = 0;i<CommaValues.length();i++){
                    String comma;
                }
                vw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }



    }
}