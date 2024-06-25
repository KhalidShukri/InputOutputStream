import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class lineCount {
    public static void main(String[]args){
        if (args.length !=1){
            System.out.println("Pass the file path of the Text File");
        }
        String TextFile = args[0];
        int lineCount = 0;
        try (BufferedReader bri = new BufferedReader(new FileReader(TextFile))){
            while (bri.readLine() != null){
                lineCount++;

            }
            System.out.println("The number of lines in the Text File are: " + lineCount);
        } catch (IOException e){
            System.out.println(e.getMessage());

        }

    }
}
