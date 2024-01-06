import java.io.File;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class InMemoryStream {
    public static void main(String[] args) throws IOException, FileNotFoundException{
        String message = "We are going to test some demonstration on the ByteStream class methods...";
        byte[] messageAsBytes = message.getBytes();
        ByteArrayInputStream byteIn1 = new ByteArrayInputStream(messageAsBytes);
        //Creating a separte buffer for storing the read bytes from the ByteArrayInputStream.
        byte[] buffer1 = new byte[3];
        while(byteIn1.available() > 0){
            int read = byteIn1.read(buffer1); 
            System.out.println("Number of Bytes read are" + read);
        }
        
    }
    
}
