import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.io.IOException;

public class GZIP{
    static String FILE_TO_COMPRESS = "/home/ubuntu/environment/details.txt";
    static String FILE_TO_WRITE = "/home/ubuntu/environment/details.gz";
    static String FILE_TO_DECOMPRESS = "/home/ubuntu/environment/details.1.gz";
    public static void main(String[] args) throws IOException{
        compress();
        decompress();

    }
    public static void compress() throws IOException{
        FileInputStream input = new FileInputStream(new File(FILE_TO_COMPRESS));
        File file_to_write = new File(FILE_TO_WRITE);
        file_to_write.createNewFile();
        FileOutputStream output = new FileOutputStream(file_to_write);
        GZIPOutputStream gzipOutput = new GZIPOutputStream(output);
        
        int size;
        byte[] buffer = new byte[1024];
        while((size = input.read(buffer)) != -1){
            gzipOutput.write(buffer, 0, size);
        }
        input.close();
        gzipOutput.close();
        System.out.println("Compressed succesfully");
    }
    
    public static void decompress() throws IOException{
        FileInputStream is = new FileInputStream(FILE_TO_DECOMPRESS);
        GZIPInputStream gzipInput = new GZIPInputStream(is);
        FileOutputStream output = new FileOutputStream(FILE_TO_COMPRESS);
        int size;
        byte[] buffer = new byte[1024];
        while((size = gzipInput.read(buffer)) != -1){
            output.write(buffer, 0, size);
        }
        gzipInput.close();
        output.close();
        System.out.println("Decompressed succesfully");
    }
}