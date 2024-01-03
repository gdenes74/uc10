package br.com.cenaflix.dados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class DadosDAO {
    
    public void Cadastrar(Dados d){
        EntityManager EM = Utilidades.getEntityManager();
        try{
            EM.getTransaction().begin();
            EM.persist(d);
            EM.getTransaction().commit();
        }catch(Exception e){
            EM.getTransaction().rollback();
            throw e;
        }
        finally{
            Utilidades.closeEntityManager();
        }
    }
    
    public List<Dados> listar(){
        EntityManager EM = Utilidades.getEntityManager();
        try{
            Query consulta = EM.createQuery("SELECT d FROM Dados d");
            List<Dados> dados = consulta.getResultList();
            return dados;
        }finally{
            Utilidades.closeEntityManager();
        }
    }
    
        
    public List<Dados> listado(String filtroPesquisar){
        EntityManager EM = Utilidades.getEntityManager();
        List dados = null;
        try{
            String textoQuery = "SELECT d FROM Dados d " +
                                "WHERE (:produtor is null OR d.produtor LIKE :produtor)";
            
            Query consulta = EM.createQuery(textoQuery);
            
            consulta.setParameter("produtor", filtroPesquisar.isEmpty() ? null : "%" + filtroPesquisar + "%");
            
            dados = consulta.getResultList();
        }finally{
            Utilidades.closeEntityManager();
        }
        return dados;
    }
    
    public void excluir(int id){
      EntityManager EM = Utilidades.getEntityManager();
      try{
          Dados d = EM.find(Dados.class, id);
          if(d != null){
              EM.getTransaction().begin();
              EM.remove(d);
              EM.getTransaction().commit();
          }
      }catch(Exception e){
          EM.getTransaction().rollback();
          throw e;
      }
      finally{
          Utilidades.closeEntityManager();
      }
    }  
    
}
