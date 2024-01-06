import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class FileReaderDemo{
    public static void main(String[] args) throws IOException{
        File homePath = new File("/home/ubuntu/environment");
        File f1 = new File(homePath, "RandomText.txt");
        //FileInputStream fIn = new FileInputStream(f1);
        
        File f2 = new File(homePath, "output2.txt");
        //You need to specify the charset encoding in the FileReader class constructor.
        FileReader fIn = new FileReader(f1);
        FileWriter fout = new FileWriter(f2);
        int read = 0;
        while((read = fIn.read()) != -1){
            System.out.print((char)read);
            fout.write(read);
        }
        fIn.close();
        fout.close();
        
        //If you see the output on the console, only the english letters are working correctly for the FileInputStream.
        //To avoid that, we will use FileReader a class of Character Stream which preserves the encoding of the text.
    }
    
}