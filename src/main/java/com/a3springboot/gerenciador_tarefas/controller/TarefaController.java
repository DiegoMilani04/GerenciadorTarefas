package com.a3springboot.gerenciador_tarefas.controller;

import com.a3springboot.gerenciador_tarefas.entities.TarefaEntities;
import com.a3springboot.gerenciador_tarefas.services.TarefaService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService; 
    
    @PostMapping
    public ResponseEntity<TarefaEntities> adicionar(@RequestBody TarefaEntities tarefa){
        tarefa = tarefaService.adicionar(tarefa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tarefa.getId()).toUri();
        return ResponseEntity.created(uri).body(tarefa);
    }
    
    // Busca todas as tarefas
    @GetMapping
    public ResponseEntity<List<TarefaEntities>> listar() {
        List<TarefaEntities> tarefas = tarefaService.listar();
        return ResponseEntity.ok(tarefas);
    }

    // Edita uma tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<TarefaEntities> editar(@PathVariable Long id, @RequestBody TarefaEntities novaTarefa) {
        TarefaEntities tarefaEditada = tarefaService.editar(id, novaTarefa);
        return ResponseEntity.ok(tarefaEditada);
    }
    
    // Remove do bd
    @DeleteMapping("/{id}")
    public ResponseEntity<TarefaEntities> remover(@PathVariable Long id){
        tarefaService.remover(id);
        return ResponseEntity.noContent().build();
    }
    
    // Move para a proxima coluna
    @PutMapping("/id/{id}")
    public ResponseEntity<TarefaEntities> moverProxima(@PathVariable Long id) {
        TarefaEntities tarefaMovida = tarefaService.moverProxima(id);
        return ResponseEntity.ok(tarefaMovida);
    }
    
    // Move para a proxima coluna
    @PutMapping("/id/id/{id}")
    public ResponseEntity<TarefaEntities> moverAnterior(@PathVariable Long id) {
        TarefaEntities tarefaMovida = tarefaService.moverAnterior(id);
        return ResponseEntity.ok(tarefaMovida);
    }
}

