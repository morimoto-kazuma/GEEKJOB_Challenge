/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage;

/**
 *
 * @author PCUser
 */
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.DateFormat;
import java.io.*;

public class challenge4_3 {


     public static void main(String[] args) throws ParseException, IOException{
     
      Date d = new Date();
      SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      
          String[] Hako = {"A","B","C","D"};
    
     Random rand = new Random();
     Integer RandomHako = rand.nextInt(Hako.length);
     
      
      Date z = new Date();
      SimpleDateFormat sdf2 =
            new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");      
       
      
       File fp = new File("RandomFile"); 
        
       FileWriter fw = new FileWriter(fp);
       
       fw.write("開始:"+sdf.format(d)+"終了:"+sdf.format(z));
       
       fw.close();
     
    
    
    
    
    FileReader fr = new FileReader(fp);
    
    BufferedReader br = new BufferedReader(fr);
    
    System.out.println(br.readLine());
    
    br.close();
    
    }
     
}
