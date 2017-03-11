package view;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by lcl on 2017/3/5.
 */
public class GoodsControl extends BaseView {
    @Test
    public  void run(){
        System.out.println("               商超购物管理系统    商品维护\n");
        System.out.println("*********************************************************");
        System.out.println("                       1.添加商品\n");
        System.out.println("                       2.更改商品\n");
        System.out.println("                       3.删除商品\n");
        System.out.println("                       4.显示所有商品\n");
        System.out.println("                       5.查询商品\n");
        System.out.println("*********************************************************\n\n");
        System.out.println("                请选择，输入数字或按0返回上一菜单");


        boolean m=false;
        do {
            Scanner scanner=new Scanner(System.in);
            String input= scanner.next();
            int i=-1;
            m=false;
            try {
                i= Integer.parseInt(input);

                switch (i){
                    case 0:
                        System.out.println("返回主菜单\n");
                        new MainMenu().run();
                        break;
                    case 1:
                        System.out.println("执行添加商品界面\n\n");
                        new AddGoodView().run();
                        break;
                    case 2:
                        System.out.println("执行更改商品界面\n\n");
                        new UpdateGoodView().run();
                        break;
                    case 3:
                        System.out.println("执行删除商品界面\n\n");
                        new DeleteGoodView().run();
                        break;
                    case 4:
                        System.out.println("执行显示所有商品界面\n\n");
                        new FindAllGoodView().run();
                        break;
                    case 5:
                        System.out.println("执行查询商品界面\n\n");
                        new FindGoodView().run();
                        break;
                    default:
                        System.out.println("输入错误请重新输入\n\n");
                        m=true;

                }
            } catch (NumberFormatException e) {
                System.out.println("输入的不是数字，请重新输入");
                m=true;
            }

        }while (m);
    }
}
