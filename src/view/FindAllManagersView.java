package view;

import dao.ManagerDao;
import daoimp.ManagerImp;
import entity.Manager;

import java.util.List;
import java.util.Scanner;

/**
 * Created by lcl on 2017/3/11.
 */
public class FindAllManagersView extends BaseView {
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        ManagerDao managerDao= new ManagerImp();
        List<Manager> managerList= managerDao.findAllManagers();
        for (Manager manager:managerList
             ) {
            System.out.println("账号："+manager.getUserName()+"       密码"+manager.getPassWorld());
        }
        new ManagerControl().run();
    }
}
