
package br.com.senac.financasv2;

import br.com.senac.financasv2.persistencia.Despesa;
import br.com.senac.financasv2.persistencia.DespesaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
//Uma vez criada uma tabela no banco de dados mysql, no caso "Despesa", faz-se o primeiro é criar uma fábrica na classe main,
//(em financasJPA.  e apartir dai criar um EntityManager(que fará o gerenciamento dos dados) PU=unidade de persistencia

public class FinancasV2 {

    public static void main(String[] args) {
       
    DespesaDAO despesaDao = new DespesaDAO();
    
    Despesa d = new Despesa();
    d.setDescricao("Compras de farmácia");
    d.setValor(65.70);
    d.setData(LocalDate.of(2022, 11, 15));
    
    despesaDao.cadastrar(d);
  }   /* EntityManagerFactory fabricaEntidade = Persistence.createEntityManagerFactory("Financas-PU");
        EntityManager manager = fabricaEntidade.createEntityManager();
        //manager é 1 objeto da conexao
        Despesa gasto = new Despesa();
        gasto.setDescricao("Primeira despesa");
        gasto.setValor(10.50);
        gasto.setData(LocalDate.of(2022, 5, 30));
        // aqui temos o objeto da classe despesa....

        // agora precisamos fazer o link usando as classes atraves do obj manager
        manager.getTransaction().begin();//abro conexao
        manager.persist(gasto);//enviar para inserir
        manager.getTransaction().commit();//executar no banco

        manager.close();//fecha conexao 
        fabricaEntidade.close();//fecha persistencia

        /*
        //Metodo encontrar find()
        Despesa gasto = manager.find(Despesa.class, 1);
        System.out.println(gasto.getDescricao());

        manager.close();
        fabricaEntidade.close();
         
        //operação de atualização 
        Despesa gasto = manager.find(Despesa.class, 1);
        manager.getTransaction().begin();
        gasto.setDescricao("Despesa atualizada");
        manager.getTransaction().commit();//atualiza
        

        manager.close();
        fabricaEntidade.close();
        //por último o metodo remover.Assim como nas operações de atualização, é necessário informar ao método remove() um objeto gerenciado. Por isso, utiliza-se o find() para recuperar o objeto do banco de dados. O método main() completo fica desta forma:
        Despesa gasto = manager.find(Despesa.class, 1);
        manager.getTransaction().begin();
        manager.remove(gasto);
        manager.getTransaction().commit();

        manager.close();
        fabricaEntidade.close();*/
    
}
