import java.io.StringReader;
import java.io.StringWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// Some of the best usecases of the StringWriter is for concatenating multiple strings effectively rather than println and +
public class StringReaderAndStringWriter {
    public static void main(String[] args) throws IOException{
        String message = " This class implements a character buffer that can be used as an Writer. ";
        StringReader reader = new StringReader(message);
        StringWriter writer = new StringWriter();
        char[] buffer = new char[4];
        while(true){
            int readChars = reader.read(buffer);
            if(readChars == -1){
                break;
            }
            writer.write(buffer, 0, readChars);
        }
        System.out.println(writer.toString());
    }
    
}
