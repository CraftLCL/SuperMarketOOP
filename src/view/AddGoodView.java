package view;

import entity.Good;

import java.util.Scanner;

/**
 * Created by lcl on 2017/3/5.
 */
public class AddGoodView {
    public void run(){
        Scanner scanner= new Scanner(System.in);
        Good good=new Good();
        System.out.println("添加商品名称：");
        good.setGoodName(String.valueOf(scanner.next()));


        System.out.println("添加商品价格：");
        double priced=-1;
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
                System.out.println("请输入正确的数量");
                m=true;
            }
        }while (m);
        good.setGoodPrice(priced);



        System.out.println("请输入添加商品的数量");
        int numd=-1;
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
        }while (m);
        good.setGoodNum(numd);


        System.out.println("\n");
        System.out.println("是否继续添加（y/n）");
        do {

        }while (m);
        String judege=scanner.next();
        if("y".equals(judege)||"n".equals(judege)){

        }




    }
}
