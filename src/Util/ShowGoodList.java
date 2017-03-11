package Util;

import entity.Good;

import java.util.List;

/**
 * Created by lcl on 2017/3/10.
 */
public class ShowGoodList {
    public static void show(List<Good> goodList){
        int i=1;
        System.out.println("商品序号    "+"商品名称                "+"商品价格                 "+"商品数量");
        for (Good good:goodList
                ) {
            System.out.println(i+"            "+ good.getGoodName()+"                    "+good.getGoodPrice()+"                     "+good.getGoodNum());
            i++;
        }
    }
}
