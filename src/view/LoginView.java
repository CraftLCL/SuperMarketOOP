package view;

import dao.ManagerDao;
import daoimp.ManagerImp;
import entity.Manager;

import java.util.List;
import java.util.Scanner;

/**
 * Created by lcl on 2017/3/11.
 */
public class LoginView extends BaseView{
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        ManagerDao managerDao=new ManagerImp();
        List<Manager> managerList= managerDao.findAllManagers();
        if (managerList.size()==0){
            System.out.println("没有用户将执行添加用户操作");
            new AddManagerView(0).run();
        }
        int time=3;
        boolean flag=false;
        do{
            System.out.println("请输入用户名：");
            String userName=scanner.next();
            System.out.println("请输入密码： ");
            String passWorld=scanner.next();

            Manager manager= managerDao.findByUserName(userName);
            if (manager!=null){
                if (manager.getPassWorld().equals(passWorld)){
                    System.out.println("登陆成功");
                }
                else {
                    time--;
                    if (time==0){
                        System.out.println("密码错误次数太多系统退出");
                        System.exit(0);
                    }
                    System.out.println("密码错误，你还有"+time+"机会");
                    flag=true;
                }
            }
            else {
                System.out.println("没有这个用户，系统将退出");
                System.exit(0);
            }
        }
        while (flag);

    }
}
