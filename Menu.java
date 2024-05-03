import java.util.Scanner;

public class Menu {
    // Inserir Novo Elemento
    public static void opt1() throws Exception {
        Scanner reader = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("1 - Inserir no Inicio");
            System.out.println("2 - Inserir no Fim");
            System.out.println("3 - Inserir Por posição");
            try {
                option = reader.nextInt();
            } catch (Exception e) {
                System.out.println("Opção escolhida deve ser numérica.");
                continue;
            }
            System.out.print("Insira um numero: ");
            Object elementToAdd;
            try {
                elementToAdd = reader.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor insira um número.");
                continue;
            }

            switch (option) {
                case 1:
                    lista.addToStart(elementToAdd);
                    break;
                case 2:
                    lista.addToEnd(elementToAdd);
                    break;
                case 3:
                    int positionToAdd;
                    try {
                        positionToAdd = reader.nextInt();
                    } catch (Exception e) {
                        System.out.println("Posição para adicionar deveria ser um número.");
                        continue;
                    }
                    try {
                        lista.insert(elementToAdd, positionToAdd);
                    } catch (Exception e) {
                        System.out.println("Índice inválido.");
                        continue;
                    }
                    break;
                default:
                    break;
            }
        } while (option == 0);
    }
    
    // Remover Elemento
    public static void opt2() throws Exception {
        Scanner reader = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("1 - Remover no Inicio");
            System.out.println("2 - Remover no Fim");
            System.out.println("3 - Remover por Valor");
            System.out.println("4 - Remover por Posição");
            try {
                option = reader.nextInt();
            } catch (Exception e) {
                System.out.println("Opção escolhida deve ser numérica.");
                continue;
            }
            

            switch (option) {
                case 1:
                    try {
                        lista.removeAtStart();
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                case 2:
                try {
                    lista.removeAtEnd();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                    break;
                case 3:
                    int positionToRemove;
                    System.out.print("Insira uma posição para deletar: ");
                    try {
                        positionToRemove = reader.nextInt();
                    } catch (Exception e) {
                        System.out.println("Por favor insira um número.");
                        continue;
                    }
                    try {
                        lista.removeAtIndex(positionToRemove);
                    } catch (Exception e) {
                        System.out.println("Índice inválido.");
                    }
                    break;
                default:
                    break;
            }
        } while (option == 0);
    }

    // Buscar Elemento
    public static void opt3() {
        
    }
    
    // Imprimir Elementos
    public static void opt4() {
        System.out.println(lista.toString());
    }

    private static Lista lista = new Lista();

    private static void clear() {
        int count = 0;
        while(count < 50) {
            System.out.println("");
            count++;
        }
    }

    public static void main(String[] args) throws Exception {
        
        Scanner reader = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("1 - Inserir Novo Elemento");
            System.out.println("2 - Remover Elemento");
            System.out.println("3 - Buscar Elemento");
            System.out.println("4 - Imprimir elementos");
            System.out.println("0 - Sair");
            try {
                option = reader.nextInt(); 
                System.out.println();
            } catch (Exception e) {
                System.out.println("Insira um número.");
                continue;
            }
            switch (option) {
                
                case 1:
                    Menu.opt1();
                    break;
                case 2:
                    Menu.opt2();
                    break;
                case 4:
                    Menu.opt4();
                default:
                    break;
            }
        } while (option != 0);
        reader.close();
    }
}
