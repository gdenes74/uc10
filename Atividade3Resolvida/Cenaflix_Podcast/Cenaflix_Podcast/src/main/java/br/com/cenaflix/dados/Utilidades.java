package br.com.cenaflix.dados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Utilidades {
    
    private static final String PERSISTENCE_UNIT = "Cenaflix_Podcast";
    private static EntityManager EM;
    private static EntityManagerFactory EMF;
    
    public static EntityManager getEntityManager(){
        if (EMF == null || !EMF.isOpen())
            EMF = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        
        if(EM == null || !EM.isOpen())
            EM = EMF.createEntityManager();
        
        return EM;
    }
    
    public static void closeEntityManager(){
        if(EM.isOpen() && EM != null){
            EM.close();
            EMF.close();
        }
    }
    
}
