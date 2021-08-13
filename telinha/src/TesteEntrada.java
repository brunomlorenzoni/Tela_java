
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TesteEntrada {
    
    public static void main(String[] args) {
        
        try{
            InputStream stream = new FileInputStream("C:\\Users\\rh02\\Desktop\\NetBeans\\telinha\\login.txt");    
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);
            
            String linha = " ";
            while((linha = buffer.readLine())!= null){
                System.out.println(linha);
            }
            buffer.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
}
