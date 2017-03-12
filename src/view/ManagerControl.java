package view;

import java.util.Scanner;

/**
 * Created by lcl on 2017/3/11.
 */
public class ManagerControl extends BaseView {
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        System.out.println("1.增加用户");
        System.out.println("2.删除用户");
        System.out.println("3.修改用户");
        System.out.println("4.显示所有用户");
        System.out.println("输入0返回上一级菜单");
        boolean flag=false;
        do{
            switch (scanner.next()){
                case "0":
                    new GoodManage().run();
                    break;
                case "1":
                    new AddManagerView().run();
                    break;
                case "2":
                    new DeleteManagerView().run();
                    break;
                case "3":
                    new UpdateGoodView().run();
                    break;
                case "4":
                    new FindAllManagersView().run();
                    break;
                    default:
                        System.out.println("输入错误请重新输入");
                        flag=true;
                        break;

            }
        }while (flag);

    }
}
