package view;

import Util.ShowGoodList;
import dao.GoodDao;
import daoimp.GoodDaoImp;
import entity.Good;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lcl on 2017/3/10.
 */
public class DeleteGoodView extends BaseView {
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        GoodDao goodDao=new GoodDaoImp();

        System.out.println("请输入要删除的商品的名称");
        String goodName=scanner.next();
        ArrayList<Good> goodList=(ArrayList<Good>) goodDao.findByName(goodName);
        if(goodList==null){
            System.out.println("查无此商品,将返回商品维护界面");
            new GoodsControl().run();
        }
        else {
            ShowGoodList.show(goodList);
            System.out.println("请输入要删除商品的编号");
            int index=scanner.nextInt();
            goodDao.deleteGood(goodList.get(index-1).getGoodId());
            System.out.println("删除成功\n\n");
            new GoodsControl().run();
        }

        //region显示列表
        /*int i=1;
        for (Good good:goodList
             ) {
            System.out.println(i+"        "+ good.getGoodName()+"                    "+good.getGoodPrice()+"                     "+good.getGoodNum());
            i++;
        }*/
        //endregion

    }
}
