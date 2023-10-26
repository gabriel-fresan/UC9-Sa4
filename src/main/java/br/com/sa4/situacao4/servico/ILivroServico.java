package br.com.sa4.situacao4.servico;

import java.util.List;
import br.com.sa4.situacao4.modelo.Livro;

public interface ILivroServico {

	public Livro salvarLivro(Livro livro);

	public List<Livro> buscarTodosLivros();

	public Livro bucarLivroPorId(Long id);

	public void deletarLivroPorId(Long id);

	public void atualizarLivro(Livro livro);

}