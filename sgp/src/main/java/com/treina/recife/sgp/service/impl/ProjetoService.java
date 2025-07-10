package com.treina.recife.sgp.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.treina.recife.sgp.model.Projeto;


public interface ProjetoService {

     Page<Projeto> getProjetos(Pageable pageable);

    Optional<Projeto> getProjetooById(long projectId);

    Projeto createProject(Projeto projeto);

    Projeto updateProject(Projeto projeto);

    void deleteProjeto(long projectId);







}
