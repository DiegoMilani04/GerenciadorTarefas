package com.a3springboot.gerenciador_tarefas.resources;

import com.a3springboot.gerenciador_tarefas.entities.TarefaEntities;
import com.a3springboot.gerenciador_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaResources {
    
    @Autowired
    TarefaRepository tarefaRepository;
    
    public TarefaEntities adicionar(TarefaEntities tarefa) {    
        return null;
    } 
    
}
