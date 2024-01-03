package data;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaflix", "root", "mysql");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }

    public int salvar(Filme filme) {
        int status;
        try {
            st = conn.prepareStatement
			  ("INSERT INTO filmes (nome, datalancamento, categoria) VALUES(?,?,?)");
				
            
            st.setString(1, filme.getNome());
            st.setDate(2, filme.getData());
            st.setString(3, filme.getCategoria());
            status = st.executeUpdate();
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public int atualizar(Filme filme) {
        int status;
        try {
			  
            st = conn.prepareStatement
					("UPDATE filmes SET  nome=?, datalancamento=?, categoria=? WHERE id=?");
				
            st.setInt(4, filme.getId());
            st.setString(1, filme.getNome());
            st.setDate(2, filme.getData());
            st.setString(3, filme.getCategoria());
				
            status = st.executeUpdate();
            return status; //retornar 1
				
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar: " + ex.getErrorCode());
            return ex.getErrorCode();
        }
    }

    public boolean excluir(String nome) {
        try {
            st = conn.prepareStatement("DELETE FROM filmes WHERE nome = ?");
            st.setString(1, nome);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            //pode-se deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }

    public Filme consultar(String nome) {

        try {
            Filme filme = new Filme();
            st = conn.prepareStatement("SELECT * from filmes WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();
            //verificar se a consulta encontrou o funcionário com a matrícula informada
            if (rs.next()) { // se encontrou o funcionário, vamos carregar os dados
					
					filme.setId(rs.getInt("id"));
               filme.setNome(rs.getString("nome"));
               filme.setData(rs.getDate("datalancamento"));
               filme.setCategoria(rs.getString("categoria"));
					
                return filme;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }

    public List<Filme> listagem(String filtro) {
        String sql = "select * from filmes";
        if (!filtro.isEmpty()) {
            sql = sql + " where nome like?";
        }
        try {
            st = conn.prepareStatement(sql);
            if (!filtro.isEmpty()) {
                st.setString(1, "%" + filtro + "%");
            }
            rs = st.executeQuery();
            List<Filme> listaFilmes = new ArrayList<>();
            //verificar se a consulta encontrou o funcionário com a matrícula informada
            while (rs.next()) { // se encontrou o funcionário, vamos carregar os dados
					
                Filme filme = new Filme();
					 filme.setId(rs.getInt("id"));
                filme.setNome(rs.getString("nome"));
                filme.setData(rs.getDate("datalancamento"));
                filme.setCategoria(rs.getString("categoria"));
                listaFilmes.add(filme);

            }
            return listaFilmes;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }

}
