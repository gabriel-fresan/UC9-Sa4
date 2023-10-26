package br.com.sa4.situacao4.implementacao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sa4.situacao4.excecao.LivroNaoEncontradoExcecao;
import br.com.sa4.situacao4.modelo.Livro;
import br.com.sa4.situacao4.repositorio.LivroRepositorio;
import br.com.sa4.situacao4.servico.ILivroServico;
 
@Service
public class LivroServicoImpl implements ILivroServico {
 
	@Autowired
	private LivroRepositorio repositorio;
	@Override
	public Livro salvarLivro(Livro livro) {
		return repositorio.save(livro);
	}
 
	@Override
	public List<Livro> buscarTodosLivros() {
		return repositorio.findAll();
	}
 
	@Override
	public Livro bucarLivroPorId(Long id) {
		Optional<Livro> opcional = repositorio.findById(id);
		if (opcional.isPresent()) {
			return opcional.get();
		} else {
			throw new LivroNaoEncontradoExcecao("Livro com código: " + id + " não encontrado.");
		}
	}
 
	@Override
	public void deletarLivroPorId(Long id) {
		repositorio.delete(bucarLivroPorId(id));
	}
 
	@Override
	public void atualizarLivro(Livro invoice) {
		repositorio.save(invoice);
	}
}