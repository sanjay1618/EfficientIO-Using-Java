import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.io.File;
import java.util.*;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException{
        File homePath = new File("/home/ubuntu/environment"); 
        File f1 = new File(homePath, "demo1.txt");
        FileInputStream fInputStream = new FileInputStream(f1);
        BufferedInputStream bufferedStreamIn = new BufferedInputStream(fInputStream);
        File f2 = new File(homePath, "output2.txt");
        f2.createNewFile();
        FileOutputStream fOutputStream = new FileOutputStream(f2);
        BufferedOutputStream bufferedStreamOut = new BufferedOutputStream(fOutputStream);
        int read = 0;
        while((read = bufferedStreamIn.read()) != -1){
            bufferedStreamOut.write(read);
        }
        bufferedStreamIn.close();
        bufferedStreamOut.close();
        
    }
    
}
