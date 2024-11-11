package com.a3springboot.gerenciador_tarefas.services;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import com.a3springboot.gerenciador_tarefas.entities.TarefaEntities; 
import com.a3springboot.gerenciador_tarefas.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    
    public TarefaEntities adicionar(TarefaEntities tarefa) {
        return tarefaRepository.save(tarefa);
    } 
    
    public long editar(long id) {
        return tarefaRepository.update(id);
    } 
}
