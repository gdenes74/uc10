package br.com.cenaflix.dados;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String produtor;
    private String nomeep;
    private int ndeep;
    private String duracao;
    private String URL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNomeep() {
        return nomeep;
    }

    public void setNomeep(String nomeep) {
        this.nomeep = nomeep;
    }

    public int getNdeep() {
        return ndeep;
    }

    public void setNdeep(int ndeep) {
        this.ndeep = ndeep;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
       
}
