package br.com.sa4.situacao4.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sa4.situacao4.modelo.Livro;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {

}