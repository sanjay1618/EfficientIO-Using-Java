import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class FileInputStreamDemo1{
    public static void main(String[] args) throws IOException, FileNotFoundException{
        FileInputStream input1 = new FileInputStream(new File("/home/ubuntu/environment/demo1.txt"));
        int readByte = 0;
        //read() method reads just one byte from the file and if it reaches end of file it reurns -1.
        while((readByte = input1.read()) != -1){
            System.out.print((char) readByte);
            //So basically it just reads an character ASCIII character. 
        }
        
        //Reading the image as bytes and then creating a new image from this stream.
        File homePath = new File("/home/ubuntu/environment");
        File image1 = new File(homePath, "image1.png");
        //Creating a new image file 
        File image2 = new File(homePath, "image2.png");
        image2.createNewFile();
        //Reading the image1 and saving it to the image2 file path
        
        FileInputStream in1 = new FileInputStream(image1);
        FileOutputStream out1 = new FileOutputStream(image2);
        readByte = 0;
        while((readByte = in1.read()) != -1){
            out1.write(readByte);
        }
        in1.close();
        out1.close();
        
        // Reading the entire file into buffer and then writing rather than reading a single byte each time.
        FileInputStream inputS1 = new FileInputStream(new File(homePath, "image1.png"));
        FileOutputStream outputS1 = new FileOutputStream(new File(homePath, "image3.png"));
        //create an array of byte which acts as a buffer for storing the contents of the file.
        long image1Length = new File(homePath, "image1.png").length();
        //length() method return the size of the file in bytes.
        byte[] arrayBuffer = new byte[(int) image1Length];
        //Read method uses the arrayBuffer to store the read bytes and later write uses this buffer to write
        inputS1.read(arrayBuffer);
        outputS1.write(arrayBuffer);
        
    }
    
}