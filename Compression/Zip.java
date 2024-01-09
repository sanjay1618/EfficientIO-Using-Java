import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.io.IOException;
public class Zip{
    static String archieveFolder = "/home/ubuntu/environment/archieve.zip";
    public static void main(String[] args) throws IOException{
         makeArchieve();
    
    }
    private static void makeArchieve() throws IOException{
        ZipOutputStream zipoutputStream = new ZipOutputStream(new FileOutputStream(archieveFolder)); 
        ZipEntry dirEntry1 = new ZipEntry("Random/");
        zipoutputStream.putNextEntry(dirEntry1);
        ZipEntry fileEntry1 = new ZipEntry("Random/random.txt");
        zipoutputStream.putNextEntry(fileEntry1);
        String message = "This is a demo of ZIP compression ";
        byte[] m = message.getBytes();
        zipoutputStream.write(m, 0, m.length);
        zipoutputStream.closeEntry();
        zipoutputStream.close();
    }
}