package br.com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.generation.blogpessoal.model.Postagem;


@Repository
public interface PostagemRepository extends JpaRepository <Postagem , Long> {

	public List <Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
	@Query(value = "select count(tema_id) from tb_postagens where tema_id = :id", nativeQuery = true)
	public int countPosts2(@Param("id") long id); //consulta nativa - conta o numero de postagens por tema
}
