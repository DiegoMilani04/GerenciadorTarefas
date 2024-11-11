package com.a3springboot.gerenciador_tarefas;

import com.a3springboot.gerenciador_tarefas.entities.TarefaEntities;
import com.a3springboot.gerenciador_tarefas.services.TarefaService;
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
                            String NomeTarefa = sc.nextLine();
                            tarefaService.adicionar(new TarefaEntities(NomeTarefa, 1));
                            System.out.print("Tarefa adicionada!");
                            break;
                        case "2": // Opção "Editar"
                            System.out.print("Digite o ID da tarefa: ");
                            long id = sc.nextLong();
                            System.out.print("Digite o nome da nova tarefa: ");
                            NomeTarefa = sc.nextLine();
                            
                            tarefaService.editar(id);
                            System.out.print("Tarefa adicionada!");
                            break;
                        case "3": // Opção "Remover"
                            // Função "Remover"
                            break;
                        case "4": // Opção "Visualizar"
                            // Função "Visualizar"
                            break;
                        case "5": // Opção "Mover para a Proxima coluna"
                            // Função "Mover para a Proxima coluna"
                            break;
                        case "6": // Opção "Mover para a coluna anterior"
                            // Função "Mover para a coluna anterior"
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
