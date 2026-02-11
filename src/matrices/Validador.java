package matrices;

public class Validador {
    
    public static boolean validar(int ancho1, int altura1, int ancho2, int altura2) {
        // Verificar que todos los valores estan entre 1 y 20
        if (ancho1 < 1 || ancho1 > 20 || altura1 < 1 || altura1 > 20 ||
            ancho2 < 1 || ancho2 > 20 || altura2 < 1 || altura2 > 20) {
            System.out.println("Error: los tamanos deben estar entre 1 y 20");
            return false;
        }
        
        // Para multiplicar matrices: columnas matriz 1 = filas matriz 2
        if (ancho1 != altura2) {
            System.out.println("Error: columnas de matriz 1 deben ser iguales a filas de matriz 2");
            return false;
        }
        
        return true;
    }
}
