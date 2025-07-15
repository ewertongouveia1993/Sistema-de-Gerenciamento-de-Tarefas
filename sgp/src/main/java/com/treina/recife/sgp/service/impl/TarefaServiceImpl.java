package Sistema-de-Gerenciamento-de-Tarefas.sgp.src.main.java.com.treina.recife.sgp.service.impl;

import com.treina.recife.sgp.model.Tarefa;
import com.treina.recife.sgp.repository.TarefaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TarefaServiceImpl implements TarefaService{

    @Autowired
    TarefaRepository tarefaRepository;

    @Override
    public Page<Tarefa> getTarefas(Object pageable) {
        return tarefaRepository.findAll(pageable);
    }

    @Override
    public Optional<Tarefa> getTarefaById(long tarefaId) {
        return tarefaRepository.findById(tarefaId);
    }

    @Override
    public Tarefa createTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @Override
    public void deleteTarefaById(long tarefaId) {
        tarefaRepository.deleteById(tarefaId);
        
    }

    @Override
    public Tarefa upDatTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @Override
    public List<Tarefa> findByProjetoProjectId(long projetoId) {
        return tarefaRepository.findByProjetoProjectId(projetoId);
    }


}
