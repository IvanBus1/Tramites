
package Entidades;

import GUI.Inicial;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

    
    public static void main(String[] args) {
//       Inicial a= new  Inicial();
//       a.setVisible(true);


        EntityManagerFactory enti = Persistence.createEntityManagerFactory("ConexionPU");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        //Transacion

        entity.getTransaction().begin();

        entity.getTransaction().commit();

        entity.close();


        

       
    }
    
}
