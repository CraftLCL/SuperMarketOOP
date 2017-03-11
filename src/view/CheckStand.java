package view;

import Util.JudegeUtil;
import Util.ShowGoodList;
import dao.GoodDao;
import daoimp.GoodDaoImp;
import entity.Good;

import java.util.List;
import java.util.Scanner;

/**
 * Created by lcl on 2017/3/11.
 */
public class CheckStand extends BaseView {
    Scanner scanner=new Scanner(System.in);

    @Override
    public void run() {
        GoodDao goodDao=new GoodDaoImp();
        int sum=0;

        System.out.println("输入商品关键字");
        String goodName=scanner.next();
        List<Good> goodList= goodDao.findByName(goodName);
        if(goodList.size()==0){
            System.out.println("没有这个商品，将返回主界面");
            new MainMenu().run();
        }
        else {
            ShowGoodList.show(goodList);
            boolean flag=false;
            do{
                System.out.println("请选择商品");
                int index= (int)JudegeUtil.juedeNumber("int",scanner,"索引");
                Good good=goodList.get(index-1);
                System.out.println("请输入购买数量");
                int buyNum=(int)JudegeUtil.juedeNumber("int",scanner,"数量");
                if(buyNum>good.getGoodNum()){
                    System.out.println("没有这么多的商品，将重新加载购买页面");
                    new CheckStand().run();
                }
                System.out.println(good.getGoodName()+"            "+good.getGoodPrice()+"￥               购买数量"+buyNum+"              "+good.getGoodName()+"总价："+buyNum*good.getGoodPrice());
                good.setGoodNum(good.getGoodNum()-buyNum);
                good.setGoodSale(good.getGoodSale()+buyNum);
                goodDao.updateGood(good);
                sum+=buyNum*good.getGoodPrice();
                String judege=scanner.next();
                if ("y".equals(judege))
                {
                    flag=true;
                }
                if("n".equals(judege)){
                    flag=false;
                }

            }while (flag);
            System.out.println("总计："+sum+"\n\n");
            System.out.println("请输入实际缴纳的金额");
            double getMoney=(double)JudegeUtil.juedeNumber("double",scanner,"金额");
            System.out.println("找钱："+(getMoney-sum));
            System.out.println("谢谢光临");
            System.out.println("按下任意键后按回车返回主界面");
            scanner.next();
            new MainMenu().run();


        }
    }
}
