package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order") // Define o nome da tabela (evita conflito com palavra reservada ORDER)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // Chave primária 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento no banco
    private Long id;
    private Instant moment; // Data/hora do pedido em UTC

    @ManyToOne // Muitos pedidos para um cliente
    @JoinColumn(name = "client_id") // Nome da coluna de chave estrangeira
    private User client; // Cliente dono do pedido

    public Order(){
    }

    // Construtor completo para facilitar criação de pedidos
    public Order(Long id, Instant moment, User client){
        super();
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Instant moment(){
        return moment;
    }
    public void setMoment(Instant moment){
        this.moment = moment;
    }

    public User getCliente(){
        return client;
    }
    public void setClient(User client){
        this.client = client;
    }

    // hashCode: usado em coleções (HashSet, HashMap, etc.)
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

    // equals: dois pedidos são iguais se tiverem o mesmo id
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
