package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // Indica que essa classe é uma entidade JPA (mapeada para o banco)
@Table(name = "tb_product") // Define o nome da tabela no banco de dados
public class Product implements Serializable {
    private static final Long serialVersionUID = 1L; // Identificador para serialização (boa prática em entidades)

    @Id // Marca o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o id automaticamente (autoincremento)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @Transient // Indica que esse campo NÃO será persistido no banco
    private Set<Categories> categories = new HashSet<>(); // Relação com categorias (simulada por enquanto)

    // Getters e Setters permitem acessar e modificar os atributos da classe
    public Set<Categories> getCategories() { return categories; }
    public void setCategories(Set<Categories> categories) { this.categories = categories; }

    // Construtor vazio (necessário para o JPA)
    public Product(){}

    // Construtor com parâmetros
    public Product(Long id, String name, String description, Double price, String imgUrl){
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    // Métodos Getters e Setters
    // (usados para encapsulamento e acesso controlado aos atributos)

    @Override
	public int hashCode() {
		// Gera um hash baseado no ID (bom para coleções como HashSet)
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// Compara objetos pelo ID (dois produtos são iguais se tiverem o mesmo id)
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
