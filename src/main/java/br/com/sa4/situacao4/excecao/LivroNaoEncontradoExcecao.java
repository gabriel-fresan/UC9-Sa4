
package br.com.sa4.situacao4.excecao;

public class LivroNaoEncontradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LivroNaoEncontradoExcecao() {
		super();
	}

	public LivroNaoEncontradoExcecao(String mensagemPersonalizada) {
		super(mensagemPersonalizada);
	}
}