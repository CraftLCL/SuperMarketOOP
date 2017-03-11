package dao;

import entity.Manager;

/**
 * Created by lcl on 2017/3/11.
 */
public interface ManagerDao {
    void addManager();
    void deleteManager(String userName);
    void updateManger(Manager manager);
    void findByUserName(String userName);
}
