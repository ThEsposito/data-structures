import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReading {
    public static void main(String[] args) {
        String[] lines;
        try{
            lines = readFile("file.ds1");
            
        } catch(FileNotFoundException e){
            System.out.println("File not Found! Check path: file1.ds1");
            return;
        }

        for(int i=0; i<lines.length; i++){
            if(lines[i] == null) break;
            System.out.println(lines[i]);
        }

        if(lines != null) {
            try {
                writeFile("out.ds1", lines);
            } catch (FileNotFoundException e) {
                System.out.printf("Error writing file: %s\n", e.getMessage());
            }
        }
    }

    public static String[] readFile(String path) throws FileNotFoundException {
        String[] lines = new String[100];
        File file = new File(path);
        Scanner sc = new Scanner(file);
        
        int i = 0;
        while(sc.hasNextLine()){
            lines[i] = sc.nextLine();
            i++;
        }
        sc.close();
        
        return lines;
    }

    public static void writeFile(String path, String[] lines) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path);

        int i = 0;
        while(lines[i]!=null){
            writer.println(lines[i]);
            i++;
        }

        writer.close();
    }
}
