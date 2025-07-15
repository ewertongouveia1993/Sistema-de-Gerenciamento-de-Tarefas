package com.treina.recife.sgp.service;

import com.treina.recife.sgp.model.Tarefa;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TarefaService {

    Page<Tarefa> getTarefas(Pageable pageable);

    Optional<Tarefa> getTarefaById(long tarefaId);

    Tarefa createTarefa(Tarefa tarefa);

    void deleteTarefaById(long tarefaId);

    Tarefa upDatTarefa(Tarefa tarefa);

    List<Tarefa>findByProjetoProjectId(long projetoId);


}
