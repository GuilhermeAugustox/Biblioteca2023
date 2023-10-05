package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import application.model.Autor;
import application.model.Genero;

@Entity
@Table(name="Livros")
public class Livro {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titulo;



    @ManyToOne
    @JoinColumn(name="id_genero")
    private Genero genero;
    public void set Genero (Genero, genero){
        this.genero(genero);
    }
    public Genero.getGenero(){
        return.this.genero;
    }

    @ManyToOne
    @JoinColumn(name="id_autor")
    private Autor autor;
    public void set Autor (Autor, autor){
        this.autor(autor);
    }
    public Autor.getAutor(){
        return.this.autor;
    }

    public void setId(int Id){
        this.id = id;
    }public int getId(){
        return id;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitulo(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}

