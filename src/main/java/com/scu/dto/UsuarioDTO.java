package com.scu.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.scu.model.Usuario;
import com.scu.service.validation.UsuarioInsert;

@UsuarioInsert
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String login;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, message="A senha  deve ter no minímo 5 caracteres")
	private String senha;
	
	public  UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		login = obj.getLogin();
		senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
