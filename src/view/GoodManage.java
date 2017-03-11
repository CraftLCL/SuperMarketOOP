package view;

import Util.JudegeUtil;
import dao.GoodDao;
import daoimp.GoodDaoImp;
import entity.Good;

import java.util.List;
import java.util.Scanner;

/**
 * Created by lcl on 2017/3/11.
 */
public class GoodManage extends BaseView{
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        System.out.println("1.维护管理员");
        System.out.println("2.显示所有商品");

        boolean flag=false;
        do{
            int input= (int)JudegeUtil.juedeNumber("int",scanner,"数字");
            switch (input){
                case 1:

                    break;
                case 2:
                    new GoodSaleView().run();
                    break;
                    default:
                        System.out.println("输入错误请重新输入");
                        flag=true;
                        break;
            }
        }while (flag);


    }
}
