package matrices;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        // Verificar que tenga 4 argumentos
        if (args.length != 4) {
            System.out.println("Error: se requieren 4 parametros (ancho1 altura1 ancho2 altura2)");
            return;
        }
        
        try {
            // Convertir argumentos a enteros
            int ancho1 = Integer.parseInt(args[0]);
            int altura1 = Integer.parseInt(args[1]);
            int ancho2 = Integer.parseInt(args[2]);
            int altura2 = Integer.parseInt(args[3]);
            
            // Validar los parametros
            if (!Validador.validar(ancho1, altura1, ancho2, altura2)) {
                return;
            }
            
            System.out.println("Parametros validos");
            
            // Crear las matrices
            Matriz matriz1 = new Matriz(ancho1, altura1);
            Matriz matriz2 = new Matriz(ancho2, altura2);
            
            // Menu para elegir como introducir los valores
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Como deseas introducir los valores?");
            System.out.println("1. Por consola");
            System.out.println("2. Por archivo");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            
            if (opcion == 1) {
                System.out.println("\n--- Matriz 1 ---");
                for (int i = 0; i < altura1; i++) {
                    for (int j = 0; j < ancho1; j++) {
                        System.out.print("[" + i + "][" + j + "]: ");
                        matriz1.establecer(i, j, scanner.nextInt());
                    }
                }
                
                System.out.println("\n--- Matriz 2 ---");
                for (int i = 0; i < altura2; i++) {
                    for (int j = 0; j < ancho2; j++) {
                        System.out.print("[" + i + "][" + j + "]: ");
                        matriz2.establecer(i, j, scanner.nextInt());
                    }
                }
                
            } else if (opcion == 2) {
            
            	// Leer del archivo
                ArrayList<Integer> numeros = new ArrayList<Integer>();
                try {
                    BufferedReader br = new BufferedReader(new FileReader("numeros"));
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] valores = linea.split(" ");
                        for (String valor : valores) {
                            if (!valor.isEmpty()) {
                                numeros.add(Integer.parseInt(valor));
                            }
                        }
                    }
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error: no se pudo leer el archivo");
                    return;
                }
                
                // Validar que hay suficientes numeros
                int totalNecesario = (ancho1 * altura1) + (ancho2 * altura2);
                if (numeros.size() < totalNecesario) {
                    System.out.println("Error: no hay suficientes valores en el archivo de numeros");
                    return;
                }
                
                // Llenar matrices desde archivo
                int indice = 0;
                for (int i = 0; i < altura1; i++) {
                    for (int j = 0; j < ancho1; j++) {
                        matriz1.establecer(i, j, numeros.get(indice));
                        indice++;
                    }
                }
                
                for (int i = 0; i < altura2; i++) {
                    for (int j = 0; j < ancho2; j++) {
                        matriz2.establecer(i, j, numeros.get(indice));
                        indice++;
                    }
                }
            }
            
            else {
                System.out.println("Opcion invalida");
                return;
            }
            
            // Mostrar matrices
            System.out.println("\nMatriz 1:");
            matriz1.mostrar();
            System.out.println("\nMatriz 2:");
            matriz2.mostrar();
            
            // Multiplicar matrices
            System.out.println("\nCalculando multiplicacion...");
            Matriz resultado = MultiplicadorMatrices.multiplicar(matriz1, matriz2);
            
            System.out.println("Resultado:");
            resultado.mostrar();
            
        } catch (NumberFormatException e) {
            System.out.println("Error: los parametros deben ser numeros enteros");
        } catch (InterruptedException e) {
            System.out.println("Error: se interrumpio el calculo de los hilos");
        }
    }
}

