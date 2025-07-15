package com.treina.recife.sgp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treina.recife.sgp.model.Projeto;
import com.treina.recife.sgp.model.Tarefa;
import com.treina.recife.sgp.model.Usuario;
import org.springframework.data.domain.Page;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

    List<Tarefa>findByResponsavelProjectId(long id);

    List<Tarefa>findByUsuario(Usuario usuario);

    List<Tarefa>findByUsuarioUserId(long userId);

    boolean existsByTitulo(String title);

    boolean existsByUsuarioUserId(long userId);

    public Page<Tarefa> findAll(Object pageable);

}
