import java.io.File;
import java.io.IOException;
public class FileAPIDemo2{
    public static void main(String[] args) throws IOException{
        File d1 = new File("/home/ubuntu/environment/");
        File f1 = new File(d1, "demo1.txt");
        
        //Getting the size or length or number of bytes of a file and the return type of length() method is long since it can be a long one.
        long demo1Size = 0;
        if(f1.exists() && f1.isFile()){
            demo1Size =  f1.length();
        }
        System.out.println("The length of the "+f1.getName()+" is " + demo1Size);
        //Getting the name of the parent directory of a file object.
        System.out.println("The parent name of the file object is " + f1.getParent());
    }
}    
