package daoimp;

import Util.XmlRead;
import Util.XmlWrite;
import dao.ManagerDao;
import entity.Manager;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcl on 2017/3/11.
 */
public class ManagerImp implements ManagerDao{



    @Override
    public void addManager(Manager manager) {
        Document document=null;
        Element rootElement=null;
        if(new File("manager.xml").exists())
        {
            document = XmlRead.readManagerXml();
            rootElement=document.getRootElement();
        }
        else {
            document= DocumentHelper.createDocument();
            rootElement= document.addElement("managersList");
        }
        Element elementManager= rootElement.addElement("manager");
        elementManager.addAttribute("userName",manager.getUserName());
        elementManager.addElement("passWorld").setText(manager.getPassWorld());

        XmlWrite.writeManagerXml(document);
    }

    @Override
    public void deleteManager(String userName) {
        Document document=XmlRead.readManagerXml();
        Element element=(Element)document.selectSingleNode("//manager[@userName='"+userName+ "']");


        if (element!=null){
            element.detach();
        }
        XmlWrite.writeManagerXml(document);
    }

    @Override
    public void updateManger(Manager manager) {
        Document document=XmlRead.readManagerXml();
        Element element=(Element)document.selectSingleNode("//manager[@userName='"+manager.getUserName()+"']");
        element.attribute("userName").setText(manager.getUserName());
        element.element("passWorld").setText(manager.getPassWorld());
        XmlWrite.writeManagerXml(document);
    }

    @Override
    public Manager findByUserName(String userName) {
        Document document=XmlRead.readManagerXml();
        Element element=(Element)document.selectSingleNode("//manager[@userName='"+userName+"']");
        Manager manager=new Manager();
        manager.setUserName(element.attributeValue("userName"));
        manager.setPassWorld(element.elementText("passWorld"));
        return manager;
    }

    @Override
    public List<Manager> findAllManagers() {
        Document document=XmlRead.readManagerXml();
        List<Manager> managerList=new ArrayList<>();
        List<Element> list=(List<Element>)document.selectNodes("//manager");
        for (Element element:list
             ) {
            Manager manager=new Manager();
            manager.setUserName(element.attributeValue("userName"));
            manager.setPassWorld(element.elementText("passWorld"));
            managerList.add(manager);
        }
        return managerList;
    }

}
