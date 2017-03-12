package view;

import dao.ManagerDao;
import daoimp.ManagerImp;
import entity.Manager;

import java.util.Scanner;

/**
 * Created by lcl on 2017/3/11.
 */
public class DeleteManagerView extends BaseView {
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        ManagerDao managerDao=new ManagerImp();
        System.out.println("请输入要删除的账号");
        String userName=scanner.next();
        Manager manager=managerDao.findByUserName(userName);
        if (manager==null){
            System.out.println("查无此商品将返回上级菜单");
            new GoodManage().run();
        }
        System.out.println("账号："+manager.getUserName()+"\n密码："+manager.getPassWorld());
        managerDao.deleteManager(userName);
        System.out.println("删除成功");
        new ManagerControl().run();
    }
}
