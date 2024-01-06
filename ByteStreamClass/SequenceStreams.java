import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.io.File;
import java.util.*;
import java.io.InputStream;
import java.io.FileNotFoundException;

public class SequenceStreams{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File homePath = new File("/home/ubuntu/environment"); 
        File f1 = new File(homePath, "demo1.txt");
        File f2 = new File(homePath, "details.txt");
        FileInputStream f1InStream = new FileInputStream(f1);
        FileInputStream f2InStream = new FileInputStream(f2);
        //Third source of Byte array.
        String dataString = "This is the third source for my data and it is in byte array";
        byte[] bytes1 = dataString.getBytes();
        ByteArrayInputStream bInStream = new ByteArrayInputStream(bytes1);
        //Creating an enumeration of InputStreams for passing the input streams to the Sequence Streams.
        Vector<InputStream> vector = new Vector<InputStream>();
        vector.add(f1InStream);
        vector.add(f2InStream);
        vector.add(bInStream);
        Enumeration<InputStream> elements = vector.elements();
        //This will sequentially read all the data from the sources given to the constructor.
        SequenceInputStream in = new SequenceInputStream(elements);
        int read = 0;
        while((read = in.read()) != -1){
            System.out.print((char) read);
        }
        in.close();
        
        
    }
}