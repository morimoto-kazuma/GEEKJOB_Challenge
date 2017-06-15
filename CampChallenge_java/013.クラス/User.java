/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Java;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author PCUser
 */
public class User extends Human {

    ArrayList<Integer> cards1 = new ArrayList<Integer>();

    public User() {

        for (int a = 0; a < 4; a++) {
            int num = 0;

            for (int b = 0; b < 13; b++) {
                num++;
                if (num >= 10) {
                    num = 10;
                }
                cards1.add(num);
            }
        }

    }

    ArrayList<Integer> deal1() {

        Random rand = new Random();
        Integer index1 = rand.nextInt(cards1.size());
        Integer index2 = rand.nextInt(cards1.size());

        ArrayList<Integer> kodomo1 = new ArrayList<Integer>();
        kodomo1.add(cards1.get(index1));
        kodomo1.add(cards1.get(index2));

        return kodomo1;
    }

    ArrayList<Integer> hit1() {

        Random rand = new Random();
        Integer index3 = rand.nextInt(cards1.size());

        ArrayList<Integer> kodomo2 = new ArrayList<Integer>();
        kodomo2.add(cards1.get(index3));

        return kodomo2;
    }

    @Override
    public int open() {
        //myCardsの中身を合計し返却する処理。
        Integer total = 0;

        for (int i = 0; i < myCards.size(); i++) {
            Integer value = myCards.get(i);
            total = total + value;

        }
        return total;
    }

    @Override
    public void setCard(ArrayList<Integer> al) {

        for (int i = 0; i < al.size(); i++) {
            Integer info = al.get(i);
            myCards.add(info);

        }

    }

    @Override//openしてa>=16ならfalse、a<=16ならtrue
    public boolean checkSum() {

        if (open() <= 16) {
            return true;
        } else {
            return false;
        }
    }

}
