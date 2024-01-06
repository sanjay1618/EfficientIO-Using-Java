import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PipedStreamDemo {
    public static void  main(String[] args) throws IOException{
        File homePath = new File("/home/ubuntu/environment");
        File f1 = new File(homePath, "demo1.txt");
        FileInputStream finStream = new FileInputStream(f1);
        
        //PipedInputStream and PipedOutputStream creates a pipeline where two threads read and write can simultaneoulsy as soon as 
        //data is available. Otherwise it has to wait untill all read is done. 
        //This way we can reduce the latency. 
        
        PipedInputStream pin1 = new PipedInputStream();
        PipedOutputStream pout1 = new PipedOutputStream(pin1); 
        Runnable writeToPipe = () -> {
            try{
            int read = 0;
            while((read = finStream.read()) != -1 ){
                System.out.println("Received the byte"+ read);
                //Writing the byte read from the file to the pipe.
                pout1.write(read);
            }
        }
        catch(IOException e){
            //
        }
        };
        Runnable readFromPipe = () -> {
            try{
            int read = 0;
            while((read = pin1.read()) != 0){
                System.out.println("Processed" + read);
            }
            }
            catch(IOException e){
                //
                
            }
        };
       
        new Thread(writeToPipe).start();
        new Thread(readFromPipe).start();
       
    }
    
}
