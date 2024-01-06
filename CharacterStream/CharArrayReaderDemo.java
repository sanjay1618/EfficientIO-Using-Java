import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;

//It is like charArray maintains an internal memory as buffers. or called as in-memory buffer.
public class CharArrayReaderDemo {
    public static void main(String[] args) throws IOException{
        String message = " It seems like there i BufferedStream())) or similar constructs.Everyone there is a great question";
        char[] readerBuffer = message.toCharArray();
        //CharArrayReader expects a char array as Datasource. So, first we need to create a char array for the data source.
        CharArrayReader in = new CharArrayReader(readerBuffer);
        //Also, the CharArrayWriter has an internal buffer which it will dynamically resize as the buffer size increases.
        CharArrayWriter out = new CharArrayWriter();
        //Temporary buffer for storing the read characters.
        char[] temp = new char[10];
        
        while(true){
            int readChars = in.read(temp);
            if(readChars == -1){
                break;
            }
            out.write(temp);
        }
        //char[] array = out.toCharArray(); (We can retrieve the contents of the buffer by invoking the toCharArray());
        //Also, we can invoke toString() on the CharArrayWriter instance.
        System.out.println(out.toString());
    }
}
