package dao;

import entity.Good;

import java.util.List;

public interface GoodDao {
     void addGood(Good good);
     void deleteGood(String id);
     void updateGood(Good good);
     Good findById(String id);
     List<Good> findByName(String name);
     List<Good> findAll();
     List<Good> showAllSaleGoods();
}
