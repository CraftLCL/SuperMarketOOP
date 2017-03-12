package dao;

import entity.Manager;

import java.util.List;

/**
 * Created by lcl on 2017/3/11.
 */
public interface ManagerDao {
    void addManager(Manager manager);
    void deleteManager(String userName);
    void updateManger(Manager manager);
    Manager findByUserName(String userName);
    List<Manager> findAllManagers();
}
