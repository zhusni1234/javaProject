import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class IntegerProcess {
    public static void main(String[] args) throws Exception {
        // Path to the input file
        File inputFile = new File("C:\\Users\\User\\javaProject\\IntegerRCW\\input.txt");
        Scanner scanner = new Scanner(inputFile);
        
        // Path to the output file
        FileWriter writer = new FileWriter("C:\\Users\\User\\javaProject\\IntegerRCW\\output.txt");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {           
                // Convert the line to an integer and divide by 2
                int number = Integer.parseInt(line);
                if(number==0){
                    System.out.println("Zero cannot be divided");
                }
                else{
                int result = number / 2;
                //write to output
                writer.write(result + "\n");
                }
                
                
            } catch (NumberFormatException e) {
                System.out.println("Skipping non-integer value: " + line);
            }
        }

        // Close scanner and writer
        scanner.close();
        writer.close();
    }
}
