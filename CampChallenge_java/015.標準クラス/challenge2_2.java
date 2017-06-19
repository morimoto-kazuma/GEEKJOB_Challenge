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
import java.util.Date;
import java.text.SimpleDateFormat;

public class challenge2_2 {
    public static void main(String[] args){
    
   Date now = new Date();
   
   SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   
   System.out.print(SDF.format(now));
        
    }
}
