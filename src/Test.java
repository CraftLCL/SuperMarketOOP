import dao.GoodDao;
import daoimp.GoodDaoImp;
import entity.Good;
import view.AddGoodView;
import view.GoodsControl;

import java.util.List;
import java.util.UUID;


public class Test {

    public static void main(String[] args) {
         //new GoodsControl().run();
         new AddGoodView().run();
         /*String s= UUID.randomUUID().toString().replace("-","");
        System.out.println(s);*/

    }
 /*   @org.junit.Test
    public void addGoodTest(){
        GoodDao goodDao=new GoodDaoImp();
        Good good=new Good();
        good.setGoodId("3");
        good.setGoodName("梨子");
        good.setGoodPrice(30);
        good.setGoodNum(123);
        goodDao.addGood(good);
    }*/
   /* @org.junit.Test
    public void findGoodByNameTest(){
        GoodDao goodDao=new GoodDaoImp();
        List<Good> goodList=goodDao.findByName("苹果");
        for (Good good:goodList
             ) {
            System.out.println("id:"+good.getGoodId()+"name:"+good.getGoodName()+"price:"+good.getGoodPrice()+"num:"+good.getGoodNum());
        }
    }*/
}
