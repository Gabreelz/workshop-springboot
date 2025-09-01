package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	// Identificador único da versão da classe para serialização.
	// É padrão colocar esse campo em classes que implementam Serializable.

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	//IDENTITY significa que o banco de dados vai cuidar de gerar o valor 
	//(normalmente com AUTO_INCREMENT em bancos relacionais como MySQL ou SERIAL no PostgreSQL).
	private Long id; // Atributos do usuário: id (identificador único)

	private String name;
	private String email;
	private String phone;
	private String password;

	@OneToMany(mappedBy = "client") // Um usuário pode ter muitos pedidos
	private List<Order> orders = new ArrayList<>();
	
	public User() {
	}
	// Construtor vazio (necessário para algumas ferramentas como o JPA,
	// além de útil quando você quer instanciar e setar depois).

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	// Construtor com todos os argumentos, útil para criar instâncias mais rapidamente.

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	// hashCode é usado em coleções (HashSet, HashMap, etc.).
	// Aqui ele foi implementado usando apenas o "id" como critério.

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // Se for o mesmo objeto na memória, retorna true
			return true;
		if (obj == null) // Se o outro objeto for null, retorna false
			return false;
		if (getClass() != obj.getClass()) // Se as classes forem diferentes, retorna false
			return false;
		User other = (User) obj; // Faz o cast para User
		if (id == null) {
			if (other.id != null)
				return false; // Um tem id null e outro não → não são iguais
		} else if (!id.equals(other.id))
			return false; // Se os ids forem diferentes → não são iguais
		return true; // Se passou por todos os testes → objetos são iguais
	}
	// equals define quando dois objetos User devem ser considerados iguais.
	// Aqui: dois Users são iguais se tiverem o mesmo "id".

	public List<Order> getOrders(){
		return orders;
	}
}
