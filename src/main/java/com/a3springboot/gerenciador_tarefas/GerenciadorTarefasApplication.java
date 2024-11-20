package com.a3springboot.gerenciador_tarefas;

import com.a3springboot.gerenciador_tarefas.entities.TarefaEntities;
import com.a3springboot.gerenciador_tarefas.services.TarefaService;
import com.a3springboot.gerenciador_tarefas.services.TarefaService.TarefaFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner; 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class GerenciadorTarefasApplication implements CommandLineRunner {

        @Autowired
        private TarefaService tarefaService;
    
	public static void main(String[] args) {
            SpringApplication.run(GerenciadorTarefasApplication.class, args);
        }
            @Override
            public void run(String... args) {
                Scanner sc = new Scanner(System.in);
                String escolha = "";

                while (!escolha.equals("7")) {
                    System.out.println("""

                        Digite uma das opcoes:

                         1 - Adicionar
                         2 - Editar
                         3 - Remover
                         4 - Visualizar
                         5 - Mover para a proxima coluna
                         6 - Mover para a coluna anterior 
                         7 - Sair
                        """);

                    System.out.print("Opcao: ");
                    escolha = sc.nextLine();

                    switch (escolha) {
                        case "1":  // Opção "Adicionar"
                            System.out.print("Digite o nome da tarefa: ");
                            String nomeTarefa = sc.nextLine();
                            tarefaService.adicionar(new TarefaEntities(nomeTarefa, 1));
                            System.out.println("Tarefa adicionada!");
                            break;
                        case "2": // Opção "Editar"
                            System.out.print("Digite o ID da tarefa: ");
                            long id = sc.nextLong();
                            sc.nextLine();
                            System.out.print("Digite o nome da nova tarefa: ");
                            nomeTarefa = sc.nextLine();
                            System.out.print("Digite a nova posicao da tarefa: ");
                            int posicao = sc.nextInt();
                            sc.nextLine();
                            tarefaService.editar(id, new TarefaEntities(nomeTarefa, posicao));
                            System.out.println("Tarefa editada!");
                            break;
                        case "3": // Opção "Remover"
                            System.out.print("Digite o ID da tarefa: ");
                            id = sc.nextLong();
                            sc.nextLine(); 
                            tarefaService.remover(id);
                            System.out.print("Tarefa Removida!");
                            break;
                        case "4": // Opção "Visualizar"
                            List <TarefaEntities> tarefas = tarefaService.listar();
                            TarefaFormatter.imprimirTarefas(tarefas);
                            break;
                        case "5": // Opção "Mover para a Proxima coluna"
                            System.out.print("Digite o ID da tarefa: ");
                            id = sc.nextLong();
                            sc.nextLine();
                            tarefaService.moverProxima(id);
                            break;
                        case "6": // Opção "Mover para a coluna anterior"
                            System.out.print("Digite o ID da tarefa: ");
                            id = sc.nextLong();
                            sc.nextLine();
                            tarefaService.moverAnterior(id);
                            break;
                        case "7": // Opção "Sair"
                            System.out.println("Processo encerrado!");
                            break;
                        default: // Opção diferente das demais
                            System.out.println("Opcao invalida. Tente novamente.");
                    }
                }           
                sc.close();
            }
}
