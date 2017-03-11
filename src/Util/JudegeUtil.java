package Util;

import view.AddGoodView;
import view.BaseView;
import view.MainMenu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by lcl on 2017/3/10.
 */
public class JudegeUtil {
    public static void judege(BaseView yView, BaseView nView, Scanner scanner){
        boolean m=false;
        String judege=null;
        do {
            judege=scanner.next();
            m=false;
            if("y".equals(judege)||"n".equals(judege)){
                if("y".equals(judege)){
                    yView.run();
                }
                else {
                    nView.run();
                }
            }
            else {
                System.out.println("请输入y或n!!!");
                m=true;
            }
        }while (m);
    }
    public static Number juedeNumber(String myclass, Scanner scanner,String name){
        switch (myclass){
            case "double":
                double priced=-1;
                boolean m=false;
                do {
                    String price=scanner.next();
                    m=false;
                    try {
                        priced=Double.parseDouble(price);
                        if(priced<=0){
                            System.out.println("输入的"+name+"不能为0或负数,请重新输入");
                            m=true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的"+name+"");
                        m = true;
                    }
                }while (m);
                return priced;
            case "int":
                int numd=-1;
                do {
                    String num=scanner.next();
                    m=false;
                    try {
                        numd=Integer.parseInt(num);
                        if(numd<=0){
                            System.out.println("输入的"+name+"不能为0或负数,请重新输入");
                            m=true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的"+name+"");
                        m=true;
                    }
                }while (m);
                return numd;
                default:
                    return null;

        }

    }
}
