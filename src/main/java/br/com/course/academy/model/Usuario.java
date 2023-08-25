package br.com.course.academy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Email
    private String email;
	
	@Size(min = 3, max = 20, message = "Usuario deve conter entre 3 a 20 caracter")
    private String  user;
    private String senha;

    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getUser() {
        return user;
    }
    public String getSenha() {
        return senha;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    

    
    
}
