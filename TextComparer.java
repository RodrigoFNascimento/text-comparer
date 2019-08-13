import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TextComparer {

    public static void main(String[] args) {
        
        try (FileInputStream inputStream1 = new FileInputStream(args[0])) {

            BufferedReader readerFile1 = new BufferedReader(new InputStreamReader(inputStream1));

            try (FileInputStream inputStream2 = new FileInputStream(args[1])) {

                BufferedReader readerFile2 = new BufferedReader(new InputStreamReader(inputStream2));
                
                String file1Line;
                String file2Line;
                int counter = 1;

                do {

                    file1Line = readerFile1.readLine();
                    file2Line = readerFile2.readLine();

                    if (file1Line == null && file2Line == null) {
                        System.out.println("Both files are equal");
                        break;
                    }

                    if (file1Line == null)
                        System.out.println("EOF 1 before file 2 at line " + counter);

                    if (file2Line == null)
                        System.out.println("EOF 2 before file 1 at line " + counter);

                    if (file1Line.compareTo(file2Line) != 0) {

                        System.out.println("Diff found at line " + counter);
                        System.out.println("File 1:");
                        System.out.println(file1Line);
                        System.out.println("File 2:");
                        System.out.println(file2Line);

                    } else {
                        counter++;
                    }

                } while (file1Line.compareTo(file2Line) == 0);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}