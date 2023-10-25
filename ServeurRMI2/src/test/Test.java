/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;
import util.HibernateUtil;

/**
 *
 * @author Lachgar
 */
public class Test {
    
    public static void main(String[] args) {
        try {
            IDao<Salle> dao2 = new SalleService();
            IDao<Machine> dao = new MachineService();
            
            dao2.create(new Salle("ER44"));
            dao.create(new Machine("ER44", "HP", 1000));
            dao.create(new Machine("ER46", "MENOVO", 5000));
            dao.create(new Machine("ER48", "HP", 5000));
            
            for(Machine  m : dao.findAll())
                System.out.println(m);
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
