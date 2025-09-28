package com.educandoweb.course.resources.exception;

import java.io.Serializable; // Permite que a classe seja serializada (convertida em bytes)
import java.time.Instant;    // Representa um ponto no tempo (timestamp)

import com.fasterxml.jackson.annotation.JsonFormat; // Anotação para formatar datas no JSON

// Classe que padroniza a estrutura de erro para respostas da API
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L; // Versão para serialização

    // Formata a data no JSON como string no padrão ISO 8601 (ex: 2025-09-28T11:00:00Z)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")	
    private Instant timestamp; // Momento em que o erro ocorreu
    
    private Integer status;    // Código HTTP do erro (ex: 404, 500)
    private String error;      // Descrição curta do erro (ex: "Not Found")
    private String message;    // Mensagem detalhada do erro
    private String path;       // Caminho da requisição que causou o erro (ex: /users/5)
	
    // Construtor vazio (necessário para frameworks que instanciam objetos via reflexão)
    public StandardError() {
    }

    // Construtor completo para criar o objeto com todos os dados do erro
    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // GETTERS E SETTERS
    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

