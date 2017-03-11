package view;

import Util.ShowGoodList;
import dao.GoodDao;
import daoimp.GoodDaoImp;
import entity.Good;

import java.util.List;
import java.util.Scanner;

/**
 * Created by lcl on 2017/3/10.
 */
public class UpdateGoodView extends BaseView{
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        GoodDao goodDao=new GoodDaoImp();
        System.out.println("请输入要修改的商品名称");
        String goodName=scanner.next();
        List<Good> goodList=goodDao.findByName(goodName);
        if(goodList==null){
            System.out.println("查无此商品,将返回查询界面\n\n");
            new UpdateGoodView().run();
        }
        else {
            ShowGoodList.show(goodList);
        }
        System.out.println("请输入要修改的编号");
        int index=scanner.nextInt()-1;
        Good updategood=goodList.get(index);

        System.out.println("请输入要修改的内容");

        System.out.println("1.修改商品名称");
        System.out.println("2.修改商品价格");
        System.out.println("3.修改商品数量");

        boolean flag=false;
        do {
            String input= scanner.next();
            switch (input){
                case "1":
                    System.out.println("修改商品的名称");
                    updategood.setGoodName(scanner.next());
                    break;
                case "2":
                    System.out.println("修改商品价格");
                    updategood.setGoodPrice(Double.parseDouble(scanner.next()));
                    break;
                case "3":
                    System.out.println("修改商品数量");
                    updategood.setGoodNum(Integer.parseInt(scanner.next()));
                    break;
                    default:
                        System.out.println("请重新输入上面提示的数字");
                        flag=true;
            }
        }while (flag);

        goodDao.updateGood(updategood);
        System.out.println("修改成功\n\n");
        System.out.println("按下任意键后按回车返回商品维护界面");
        scanner.next();
        new GoodsControl().run();
    }
}
