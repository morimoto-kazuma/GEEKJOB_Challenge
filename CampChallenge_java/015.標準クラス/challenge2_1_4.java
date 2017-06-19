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
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.DateFormat;

public class challenge2_1_4 {
    
       public static void main(String[] args) throws ParseException {

        Date d = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String day = sdf.format("2016-11-4 10:0:0");
        Date dt = sdf.parse("2015-1-1 0:0:0");
        Date dz = sdf.parse("2015-12-31 23:59:59");
        
        long dtz = dz.getTime() - dt.getTime();
        
        System.out.print(dtz);

    } 
    
}
