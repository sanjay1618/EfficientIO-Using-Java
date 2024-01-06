import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class FileReaderBuffer {
    public static void main(String[] args) throws IOException{
        File homePath = new File("/home/ubuntu/environment");
        File f1 = new File(homePath, "RandomText.txt");
        File f2 = new File(homePath, "output3.txt");
        f2.createNewFile();
        FileReader reader = new FileReader(f1, StandardCharsets.UTF_8);
        FileWriter writer = new FileWriter(f2, StandardCharsets.UTF_8);
        //Creating the character buffer.
        char[] cs = new char[1024];
       System.out.println(reader.getEncoding());
       //So, the read method returns the number of charcters read. So, we can use that to write only that many of characters to the 
       //file. Otherwise, it will write the entire buffer size.
       
       while(true){
           int readChars = reader.read(cs);
           if(readChars == -1){
               break;
           }
           writer.write(cs, 0, readChars);
           System.out.println("Processed some buffer of chars "+readChars);
       }
        writer.flush();
        writer.close();
    }
}
