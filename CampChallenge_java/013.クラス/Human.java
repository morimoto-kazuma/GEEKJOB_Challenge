/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Java;

import java.util.ArrayList;

/**
 *
 * @author PCUser
 */
abstract public class Human {

    ArrayList<Integer> myCards = new ArrayList<Integer>();

    abstract public int open();

    abstract public void setCard(ArrayList<Integer> al);

    abstract public boolean checkSum();

}
