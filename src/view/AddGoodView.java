package view;

import Util.JudegeUtil;
import dao.GoodDao;
import daoimp.GoodDaoImp;
import entity.Good;
import org.junit.Test;

import java.util.Scanner;
import java.util.UUID;

/**
 * Created by lcl on 2017/3/5.
 */

public class AddGoodView extends BaseView {
    @Test
    @Override
    public void run(){
        Scanner scanner= new Scanner(System.in);
        Good good=new Good();
        GoodDao goodDao=new GoodDaoImp();

        good.setGoodId(UUID.randomUUID().toString());

        System.out.println("添加商品名称：");
        good.setGoodName(String.valueOf(scanner.next()));


        System.out.println("添加商品价格：");
        //region
        /*double priced=-1;
        boolean m=false;
        do {
            String price=scanner.next();
            m=false;
            try {
                priced=Double.parseDouble(price);
                if(priced<=0){
                    System.out.println("输入的价格不能为0或负数,请重新输入");
                    m=true;
                }
            } catch (NumberFormatException e) {
                System.out.println("请输入正确的价格");
                m=true;
            }
        }while (m);*/
        //endregion
        double priced=(double)JudegeUtil.juedeNumber("double",scanner,"价格");
        good.setGoodPrice(priced);



        System.out.println("请输入添加商品的数量");
        //region
       /* int numd=-1;
        do {
            String num=scanner.next();
            m=false;
            try {
                numd=Integer.parseInt(num);
                if(numd<=0){
                    System.out.println("输入的数量不能为0或负数,请重新输入");
                    m=true;
                }
            } catch (NumberFormatException e) {
                System.out.println("请输入正确的数量");
                m=true;
            }
        }while (m);*/
       //endregion
        int numd=(int)JudegeUtil.juedeNumber("int",scanner,"数量");
        good.setGoodNum(numd);

        goodDao.addGood(good);



        System.out.println("\n");
        System.out.println("是否继续操作（y/n）");



        //region 没有封装的y n判断代码
        /*String judege=null;
        do {
            judege=scanner.next();
            m=false;
            if("y".equals(judege)||"n".equals(judege)){
                if("y".equals(judege)){
                    new AddGoodView().run();
                }
                else {
                    new MainMenu().run();
                }
            }
            else {
                System.out.println("请输入y或n!!!");
                m=true;
            }
        }while (m);*/
        //endregion



        JudegeUtil.judege(new AddGoodView(),new GoodsControl(),scanner);




    }
}
