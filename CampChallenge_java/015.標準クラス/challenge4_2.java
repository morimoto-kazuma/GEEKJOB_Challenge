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
import java.io.*;

public class challenge4_2 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    
    File fp = new File("morimoto");
    
    FileReader fr = new FileReader(fp);
    
    BufferedReader br = new BufferedReader(fr);
    
    System.out.println(br.readLine());
    
    br.close();
    
    }
}
