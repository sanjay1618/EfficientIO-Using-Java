import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class BufferedCharacterStreams {
    public static void main(String[] args) throws IOException{
        File homePath = new File("/home/ubuntu/environment");
        File f1 = new File(homePath, "RandomText.txt");
        //FileInputStream fIn = new FileInputStream(f1);
        
        File f2 = new File(homePath, "output2.txt");
        //So, basically, for the read it fill in the internal buffer and for the next read, it reads from the buffer rather than 
        // going to the file or data source.
        //By wrapping a BufferedReader around a Reader, you introduce a buffer that holds a chunk of data from the underlying stream.
        //When you make a read request, the BufferedReader checks if the requested data is already present in the buffer.
        //If it is, the data is served directly from the buffer without making additional system calls.
        //If the buffer is empty or does not have enough data, a larger chunk is read from the underlying stream into the buffer.
        BufferedReader reader = new BufferedReader(new FileReader(f1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        //The below code reads one character at a time. We can imporve this by reading one line at a time.
       /* while(true){
            int readChar = reader.read();
            if(readChar == -1){
                break;
            }
            writer.write(readChar);
        }*/
        
        //Reads line  by line and writes to the buffer line by line.
        while(true){
            String line = reader.readLine();
            if(line == null) {
                break;
            }
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
        writer.close();
        reader.close();
        
    }
    
}
