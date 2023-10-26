package br.com.sa4.situacao4.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.sa4.situacao4.excecao.LivroNaoEncontradoExcecao;
import br.com.sa4.situacao4.modelo.Livro;
import br.com.sa4.situacao4.servico.ILivroServico;

@Controller
@RequestMapping("/livro")
public class LivroControlador {

	@Autowired
	private ILivroServico service;

	@GetMapping("/")
	public String exibirPaginaInicial() {
		return"paginaInicio";
	}

	@GetMapping("/adicionar")
	public String exibirFormularioAdicao() {
		return "adicionarLivro";
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Livro livro, Model modelo) {
		service.salvarLivro(livro);
		Long id = service.salvarLivro(livro).getId();
		String tituloDoLivro = livro.getTituloDoLivro();
		String mensagem = "Livro " + id + " - " + tituloDoLivro + " salvo com sucesso!";
		modelo.addAttribute("message", mensagem);
		return "adicionarLivro";
	}

	@GetMapping("/listar")
	public String buscarTodosLivros(@RequestParam(value = "message", required = false) String mensagem, Model modelo) {
		List<Livro> livros = service.buscarTodosLivros();
		modelo.addAttribute("listagem", livros);
		modelo.addAttribute("message", mensagem);
		return "listarLivros";
	}

	@GetMapping("/editar")
	public String exibirFormularioEdicao(Model modelo, RedirectAttributes atributos, @RequestParam Long id) {
		String pagina = null;
		try {
			Livro livro = service.bucarLivroPorId(id);
			modelo.addAttribute("livro", livro);
			pagina = "editarLivro";
		} catch (LivroNaoEncontradoExcecao e) {
			e.printStackTrace();
			atributos.addAttribute("message", e.getMessage());
			pagina = "redirect:listar";
		}
		return pagina;
	}

	@PostMapping("/atualizar")
	public String atualizarLivro(@ModelAttribute Livro livro, RedirectAttributes atributos) {
		service.atualizarLivro(livro);
		Long id = livro.getId();
		String tituloDoLivro = livro.getTituloDoLivro();
		atributos.addAttribute("message", "Livro " + id + " - " + tituloDoLivro + " atualizado com sucesso!");
		return "redirect:listar";
	}

	@GetMapping("/deletar")
	public String deletarLivro(@RequestParam Long id, RedirectAttributes atributos) {
		try {
			Livro livro = service.bucarLivroPorId(id);
			String tituloDoLivro = livro.getTituloDoLivro();
			service.deletarLivroPorId(id);
			atributos.addAttribute("message", "Livro " + id + " - " + tituloDoLivro + " excluído com sucesso!");
		} catch (LivroNaoEncontradoExcecao e) {
			e.printStackTrace();
			atributos.addAttribute("message", e.getMessage());
		}
		return "redirect:listar";
	}
}