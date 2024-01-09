package br.com.matheus.naturaSSP.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_categoria")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;
    @Column(name = "nome_categoria", length = 100, nullable = false, unique = true)
    private String name;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
