package br.com.senac.financasv2.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UsuarioDAO {

    public Usuario validaLogin(String nome, String senha) {
        Usuario user = null;
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Usuario> consulta = em.createQuery("SELECT u From Usuario u Where u.nome = :nomePar AND u.senha = :senhaPar", Usuario.class);
            consulta.setParameter("nomePar", nome);
            consulta.setParameter("senhaPar", senha);

            if (nome.equals(consulta.getSingleResult().getNome()) && senha.equals(consulta.getSingleResult().getSenha())) {
                user = consulta.getSingleResult();
            }
        } catch (Exception e) {
            System.out.println("Erro na validação " + e.getMessage());
        }
        return user;
    }

}
