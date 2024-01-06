import java.io.File;
import java.io.IOException;
public class FileAPIDemo{
    public static void main(String[] args) throws IOException{
        //I have provided the absolute path for the path argument.
        File f1 = new File("/home/ubuntu/environment/README.md");
        //We can also provide the relative path.But Absolute should be preferred.
        //File f1 = new File("../../README.md");
        System.out.println(f1.isFile());
        //
        
        File f2 = new File("/home/ubuntu/environment/");
        System.out.println(f2.exists());
        
        //Creating a new file by using the createNewFile() method.
        File f3 = new File(f2, "demo1.txt");
        f3.createNewFile();
        System.out.println(f3.exists());
        
        //Creating a new directory using the mkdir() method.
        
        File d1 = new File(f2, "demo1");
        d1.mkdir();
        System.out.println("does d1 exists " + d1.exists());
        
        
//Listing all the files and directories in a directory and storing them in a array of Strings and priting only the files them to console.
        File d2 = new File(f2, "policies");
        if(d2.exists() && d2.isDirectory()){
            String[] filesList = d2.list();
            for(String file:filesList){
                if(new File(d2, file).isFile()){
                     System.out.println("The file is "+file);
                }
            }
        }
    }
}