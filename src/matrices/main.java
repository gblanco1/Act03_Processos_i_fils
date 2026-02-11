package matrices;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce el ancho de la matriz 1: ");
        int ancho1 = scanner.nextInt();
        System.out.println("Introduce la altura de la matriz 1: ");
        int altura1 = scanner.nextInt();
        System.out.println("Introduce el ancho de la matriz 2: ");
        int ancho2 = scanner.nextInt();
        System.out.println("Introduce la altura de la matriz 2: ");
        int altura2 = scanner.nextInt();
        
        // Validar los parametros
        if (!Validador.validar(ancho1, altura1, ancho2, altura2)) {
            return;
        }
        
        System.out.println("Parametros validos");
    }
}
