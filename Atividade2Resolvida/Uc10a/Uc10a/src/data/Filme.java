package data;

import java.sql.Date;

public class Filme {

    private int id;
    private String nome;
    private Date data;
    private String categoria;
    
    public Filme(){
    }
     public Filme(int id, String nome, Date data, String categoria) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

   
}
