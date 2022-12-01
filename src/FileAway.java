import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
public class FileAway {
    public static void main(String[] args) {
        Scanner inFile;
        JFileChooser chooser = new JFileChooser();
        String line;
        int numLines = 0;
        int numWords = 0;
        int numChars = 0;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target);
                System.out.println("File: " + target.getFileName());
                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    numLines++;
                    numChars += line.length();
                    numWords += new StringTokenizer(line, " ,").countTokens();
                }
                inFile.close();
                System.out.printf("Lines: %d\nWords: %d\nCharacters: %d\n", numLines, numWords, numChars);
            } else { // user did not select a file
                System.out.println("You must select a file, quitting program..");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was Not Found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException Error.");
            e.printStackTrace();
        }
    }
}
