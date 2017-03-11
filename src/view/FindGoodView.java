package view;

import Util.ShowGoodList;
import dao.GoodDao;
import daoimp.GoodDaoImp;
import entity.Good;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lcl on 2017/3/11.
 */
public class FindGoodView extends BaseView {
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        GoodDao goodDao=new GoodDaoImp();



        System.out.println("1.按商品价格升序查询");
        System.out.println("2.按关键字查询");
        boolean tag=false;
        int index=0;
        do {
            try {
                index=scanner.nextInt();


            } catch (Exception e) {
                System.out.println("输入错误请重新输入");
                tag=true;
            }
        }while (tag);

        switch (index){
            case 1:

                List<Good> goodList=goodDao.findAll();
                Comparator<Good> comparator=new Comparator<Good>() {
                    @Override
                    public int compare(Good o1, Good o2) {
                        return  (int) (o1.getGoodPrice()-o2.getGoodPrice());
                    }
                };
                ShowGoodList.show(goodList);
                System.out.println("按下任意键后按回车返回商品维护界面");
                scanner.next();
                new GoodsControl().run();
                break;
            case 2:
                System.out.println("请输入你要查询的商品名称");
                String name=scanner.next();
                List<Good> goodList1=goodDao.findByName(name);
                if(goodList1.size()==0){
                    System.out.println("查无此商品，将返回商品维护界面");
                    System.out.println("按下任意键后按回车返回商品维护界面");
                    scanner.next();
                    new GoodsControl().run();
                }
                else {
                    ShowGoodList.show(goodList1);
                    System.out.println("按下任意键后按回车返回商品维护界面");
                    scanner.next();
                    new GoodsControl().run();
                }
        }

    }
}
