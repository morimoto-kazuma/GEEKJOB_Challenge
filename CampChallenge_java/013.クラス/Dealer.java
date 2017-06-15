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
public class Dealer extends Human {

    ArrayList<Integer> cards = new ArrayList<Integer>();

    public Dealer() {
        for (int a = 0; a < 4; a++) { //③を4回繰り返し処理。
            int num = 0; //初期値　for文の中にあるので2週目以降も初期値は0スタート。

            for (int b = 0; b < 13; b++) {
                num++; //numを13回繰り返し1つづつ足していく処理。  ①
                if (num >= 10) { //numが10以上になった場合は  ②
                    num = 10;    //残りは10として処理。
                }
                cards.add(num);  //①+②をcardsへ追加。　③
            }
        }
    }

    ArrayList<Integer> deal() {

        Random rand = new Random();
        Integer index1 = rand.nextInt(cards.size());
        Integer index2 = rand.nextInt(cards.size());

        ArrayList<Integer> oya1 = new ArrayList<Integer>();
        oya1.add(cards.get(index1));
        oya1.add(cards.get(index2));

        return oya1;
    }

    ArrayList<Integer> hit() {

        Random rand = new Random();
        Integer index3 = rand.nextInt(cards.size());

        ArrayList<Integer> oya2 = new ArrayList<Integer>();
        oya2.add(cards.get(index3));

        return oya2;
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
