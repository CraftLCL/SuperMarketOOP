package view;

import dao.ManagerDao;
import daoimp.ManagerImp;
import entity.Manager;

import java.util.Scanner;

/**
 * Created by lcl on 2017/3/11.
 */
public class UpdateManagerView extends BaseView {
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        ManagerDao managerDao=new ManagerImp();
        System.out.println("请输入要修改密码的账号");
        String userName=scanner.next();
        Manager manager=managerDao.findByUserName(userName);
        if (manager==null){
            System.out.println("查无此商品将返回上级菜单");
            new GoodManage().run();
        }
        System.out.println("请输入要修改的密码：");
        String passWorld=scanner.next();
        manager.setPassWorld(passWorld);
        managerDao.updateManger(manager);
        System.out.println("修改成功\n\n");
        new ManagerControl().run();

    }
}
