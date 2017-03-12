package view;

import java.util.Scanner;

/**
 * Created by lcl on 2017/3/5.
 */
public class MainMenu extends BaseView{
    public static String [] margs;
    public static void main(String[] args) {
        margs=args;
        new MainMenu().run();
    }

    public   void run() {
        new LoginView().run();
        System.out.println("*********************************************************");
        System.out.println("                     1.商品维护");
        System.out.println("                     2.前台收银");
        System.out.println("                     3.商品管理");
        System.out.println("*********************************************************");

        boolean m=false;
        do {
            System.out.println("请选择，输入数字或按0退出");
            Scanner scanner=new Scanner(System.in);
            String input= scanner.next();
            int i=-1;
            m=false;
            try {
                i= Integer.parseInt(input);
                switch (i){
                    case 0:
                        System.out.println("谢谢您的使用");
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("执行商品维护界面\n\n");
                        new GoodsControl().run();
                        break;
                    case 2:
                        System.out.println("执行前台收银界面\n\n");
                        new CheckStand().run();
                        break;
                    case 3:
                        System.out.println("执行商品管理界面\n\n");
                        new GoodManage().run();
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
