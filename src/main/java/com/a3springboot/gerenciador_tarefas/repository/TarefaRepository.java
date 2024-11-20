package com.a3springboot.gerenciador_tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.a3springboot.gerenciador_tarefas.entities.TarefaEntities;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntities, Long> {
    
    //public long update(long id, String nomeTarefa);
    
}
