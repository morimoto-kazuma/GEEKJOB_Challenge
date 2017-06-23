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
public class challenge3_3 {
    
    public static void main(String[] args){
    
        String Check = "森本";
        
        String change = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        String moji = "";
        
        boolean Answer = Check.equals("山本");
        
        
        if(Answer==true){
        System.out.println("間違い！");
        }else{
            moji = change.replace("U","う");
            moji = moji.replace("I","い");
            
        System.out.println(moji);
        }
        
    }
    
    
    
//    public boolean check(){
//    
//        String change = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
//        
//        if(true){
//        return System.out.println(change.replace("I"+"U","い"+"う"));
//        }else{
//        
//        }
//        
//    }
//    
//    
//    public static void main(String[] args){
//    
//        String change = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
//        
//        
//    }
    
}
