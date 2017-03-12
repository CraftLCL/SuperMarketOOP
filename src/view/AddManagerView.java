package view;

import dao.ManagerDao;
import daoimp.ManagerImp;
import entity.Manager;

import java.util.Scanner;

/**
 * Created by lcl on 2017/3/11.
 */
public class AddManagerView extends BaseView {
    private int num;
    public AddManagerView(int num){
        this.num=num;
    }
    public AddManagerView(){

    }
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        Manager manager=new Manager();
        ManagerDao managerDao=new ManagerImp();
        System.out.println("添加用户账号");
        String userName=scanner.next();
        manager.setUserName(userName);
        System.out.println("添加用户密码");
        String passWorld=scanner.next();
        manager.setPassWorld(passWorld);
        managerDao.addManager(manager);

        System.out.println("添加用户成功");
        if (num==0){
            new MainMenu().run();
        }
        else {
            new ManagerControl().run();
        }


    }
}
