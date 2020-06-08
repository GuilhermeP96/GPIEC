package br.com.technobsoftwares.gpiec;






import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JTextField;


public class DBDiagnostico {
    public static String status;
    public static String iptest;
    public static StringBuilder sb = new StringBuilder();
    public static int svron= 0;
    
    
   public static void Gravar(JTextField campo){
       
       File arq = new File("ipservice.ecg");
       try{
           FileWriter escreva = new FileWriter(arq);
           BufferedWriter buffer = new BufferedWriter(escreva);
           campo.write(buffer);
       }catch(IOException e){
           e.printStackTrace();
       }
       ConnectionFactory.ipservice = iptest;
  }
   public static void Abrir(JTextField campo){
       
       File arq = new File("ipservice.ecg");
       try{
           FileReader leia = new FileReader(arq);
           BufferedReader buffer = new BufferedReader(leia);
           campo.read(buffer,null);
       }catch(IOException e){
           e.printStackTrace();
       } 
   }
   
   public static void IP() throws FileNotFoundException{
       ConnectionFactory.ipservice = new Scanner(new File("ipservice.ecg")).useDelimiter("\\Z").next();
   }
   
   public static void Testar(JTextField campo){
       status = null;
       iptest = campo.getText();
       String iptemp = ConnectionFactory.ipservice;
       
            try
            {
            ConnectionFactory c = new ConnectionFactory();
            iptemp = c.ipservice;
            ConnectionFactory.ipservice = iptest;
            c.getConnectiontest();
            status = "Conectado ao banco!";
            }catch (Exception e)
            {
                    status = "Erro ao conectar com o banco!"; 
            }
            ConnectionFactory.ipservice = iptemp;
             
   }
}
