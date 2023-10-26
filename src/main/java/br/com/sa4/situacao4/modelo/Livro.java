package br.com.sa4.situacao4.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

	@Id
	@GeneratedValue
	private Long id;
	private String tituloDoLivro;
	private String nomeAutor;
	private String editora;
	private BigInteger isbn;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloDoLivro() {
		return tituloDoLivro;
	}

	public void setTituloDoLivro(String tituloDoLivro) {
		this.tituloDoLivro = tituloDoLivro;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public BigInteger getIsbn() {
		return isbn;
	}

	public void setIsbn(BigInteger isbn) {
		this.isbn = isbn;
	}


}