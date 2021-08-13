
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;


public class TesteSaida {
    
    public static void main(String[] args) {
        
        try{
            OutputStream stream = new FileOutputStream("C:\\Users\\rh02\\Desktop\\NetBeans\\telinha\\login.txt");
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            BufferedWriter buffer = new BufferedWriter(writer);
            
            buffer.write("bruno lorenzoni aaaa");
            buffer.write("\r\n");
            
            buffer.flush();
            buffer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
