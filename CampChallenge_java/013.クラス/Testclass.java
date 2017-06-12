/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author PCUser
 */
public class Testclass {

}

abstract class Human {

    ArrayList<Integer> myCards = new ArrayList<Integer>();

    abstract void open();

    abstract void setCard(ArrayList al);

    abstract void checkSum();

}
//継承クラス↓

abstract class Dealer extends Human {

    ArrayList<Integer> cards1 = new ArrayList<Integer>();

    public Dealer() {
        for (int a = 0; a < 4; a++) { //③を4回繰り返し処理。
            int num = 0; //初期値　for文の中にあるので2週目以降も初期値は0スタート。

            for (int b = 0; b < 13; b++) {
                num++; //numを13回繰り返し1つづつ足していく処理。  ①
                if (num >= 10) { //numが10以上になった場合は  ②
                    num = 10;    //残りは10として処理。
                }
                cards1.add(num);  //①+②をcardsへ追加。　③
            }
        }
    }

    ArrayList deal() {

        Random rand = new Random();
        Integer index1 = rand.nextInt(cards1.size());
        Integer index2 = rand.nextInt(cards1.size());

        ArrayList<Integer> oya1 = new ArrayList<Integer>();
        oya1.add(cards1.get(index1));
        oya1.add(cards1.get(index2));

        return oya1;
    }

    ArrayList hit() {

        Random rand = new Random();
        Integer index3 = rand.nextInt(cards1.size());

        ArrayList<Integer> oya2 = new ArrayList<Integer>();
        oya2.add(cards1.get(index3));

        return oya2;
    }

}

abstract class User extends Human {

    public void setCard(ArrayList al) {

    }

}
