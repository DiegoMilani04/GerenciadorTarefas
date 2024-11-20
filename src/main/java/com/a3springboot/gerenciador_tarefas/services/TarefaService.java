package com.a3springboot.gerenciador_tarefas.services;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import com.a3springboot.gerenciador_tarefas.entities.TarefaEntities; 
import com.a3springboot.gerenciador_tarefas.repository.TarefaRepository;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    
    // Adiciona tarefa ao bd
    public TarefaEntities adicionar(TarefaEntities tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // Recebe todos os dados do bd e exibe em lista
    public List<TarefaEntities> listar() {
        return tarefaRepository.findAll();
    }

    // Edita uma tarefa existente
    public TarefaEntities editar(Long id, TarefaEntities novaTarefa) {
        return tarefaRepository.findById(id).map(tarefa -> {
            tarefa.setDescricao(novaTarefa.getDescricao());
            tarefa.setPosicao(novaTarefa.getPosicao());
            return tarefaRepository.save(tarefa);
        }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }
    
    // Remove do bd
    public void remover(Long id) {
        tarefaRepository.deleteById(id);
    }
    
    // Move para a proxima coluna
    public TarefaEntities moverProxima(Long id) {
        return tarefaRepository.findById(id).map(tarefa -> {
            if (tarefa.getPosicao() < 3){
                tarefa.setPosicao(tarefa.getPosicao() + 1);
                System.out.println("Tarefa Movida!");
            }else{
                System.out.println("Tarefa atingiu o limite!");
            }
            
            return tarefaRepository.save(tarefa);
        }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }

    // Move para a coluna anterior
    public TarefaEntities moverAnterior(Long id) {
        return tarefaRepository.findById(id).map(tarefa -> {
            if (tarefa.getPosicao() > 0){
                tarefa.setPosicao(tarefa.getPosicao() - 1);
                System.out.println("Tarefa Movida!");
            }else{
                System.out.println("Tarefa atingiu o limite!");
            }
            
            return tarefaRepository.save(tarefa);
        }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }

    public class TarefaFormatter {
        public static void imprimirTarefas(List<TarefaEntities> tarefas) {
            StringBuilder aFazer = new StringBuilder("A fazer\n-----------------------\n");
            StringBuilder emAndamento = new StringBuilder("Em andamento\n-----------------------\n");
            StringBuilder finalizados = new StringBuilder("Finalizados\n-----------------------\n");

            for (TarefaEntities tarefa : tarefas) {
                switch (tarefa.getPosicao()) {
                    case 1 -> aFazer.append(tarefa).append("\n");
                    case 2 -> emAndamento.append(tarefa).append("\n");
                    case 3 -> finalizados.append(tarefa).append("\n");
                    default -> System.out.println("Posição inválida para tarefa: " + tarefa);
                }
            }

            System.out.println("""
                    Gerenciador de Tarefas
                    -----------------------
                    """);
            System.out.println(aFazer);
            System.out.println(emAndamento);
            System.out.println(finalizados);
        }
    }

}

