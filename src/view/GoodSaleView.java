package view;

import dao.GoodDao;
import daoimp.GoodDaoImp;
import entity.Good;

import java.util.List;

/**
 * Created by lcl on 2017/3/11.
 */
public class GoodSaleView extends BaseView{

    @Override
    public void run() {
        GoodDao goodDao=new GoodDaoImp();
        System.out.println("显示所有商品\n\n");
        System.out.println("今日售出商品：");
        List<Good> goodList=goodDao.showAllSaleGoods();
        int i=1;
        System.out.println("商品序号    "+"商品名称                "+"商品价格                 "+"商品数量           "+"销量              "+"备注");
        for (Good good:goodList
                ) {
            String out=i+"            "+ good.getGoodName()+"                      "+good.getGoodPrice()+"                     "+good.getGoodNum()
                    +"               "+good.getGoodSale();
            if (good.getGoodNum()<10)
            {
                out+="                  "+"该商品已经不足10件";
            }

            System.out.println(out);
            i++;
        }
    }
}
