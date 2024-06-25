import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSV {
    public static void main(String[]args){
//        CSV parser
//////        Write a java program that reads a CSV(Comma Separate Values).Assume that the csv file does not contain any commas within the fields
//        if (args.length != 1){
//            System.out.println("Provide the file Path to the file");
//            return;
//        }
//        String CommaFile = args[0];
//        try (BufferedReader cr = new BufferedReader(new FileReader(CommaFile))) {
//            String line;
//            while ((line = cr.readLine())!= null) {
//                String [] fields = line.split(",");
//                for (String field : fields){
//                    System.out.println(field + ",");
//                }
//            }
//
//        } catch (IOException e) {
//            System.out.println("Error Occurred; "+ e.getMessage());
//        }

        if (args.length != 1){
            System.out.println("Usage: java CSV <filepath>");
        }
        String filePath = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine())!= null){
                String[] fields = line.split(",");
                for (String field : fields){
                    System.out.println(field.trim() + ",");

                }
                System.out.println();

            }


        } catch (IOException e){
            System.out.println("An Error occurred: "+ e.getMessage());

        }
    }
}
