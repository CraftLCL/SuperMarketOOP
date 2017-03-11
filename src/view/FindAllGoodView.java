package view;

import Util.ShowGoodList;
import dao.GoodDao;
import daoimp.GoodDaoImp;
import entity.Good;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lcl on 2017/3/10.
 */
public class FindAllGoodView extends BaseView {
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        GoodDao goodDao=new GoodDaoImp();
        List<Good> goodList=goodDao.findAll();
        ShowGoodList.show(goodList);
        System.out.println("按下任意键后按回车返回商品维护界面");
        scanner.next();
        new GoodsControl().run();



    }
}
