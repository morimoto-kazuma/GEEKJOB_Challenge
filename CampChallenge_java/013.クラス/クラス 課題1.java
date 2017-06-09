/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample2;

/**
 *
 * @author PCUser
 */
//新規クラス
class Human {

    public String name = "";
    public int age = 0;

    public void setHuman(String n, int a) {
        this.name = n; this.age = a;

    }

    public void getHuman() {
        System.out.println(name + age);
    }
}

public class kurasu1 {

    public static void main(String[] args) {

        //上で作ったクラスのインスタンスを生成
//    int num = 8;
//    System.out.println(num);
//    
        Human hito = new Human();
//    
//    System.out.println(hito.age);
//    
        hito.age = 40;
//    System.out.println(hito.age);
//
//
        hito.setHuman("森本", 26);
//System.out.println(hito.name);
//System.out.println(hito.age);

        hito.getHuman();

    }

}
