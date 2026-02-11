package matrices;

public class MultiplicadorMatrices {
    
    public static Matriz multiplicar(Matriz matriz1, Matriz matriz2) throws InterruptedException {
        // Crear matriz resultado (altura1 x ancho2)
        int alturaResultado = matriz1.getAltura();
        int anchoResultado = matriz2.getAncho();
        Matriz resultado = new Matriz(anchoResultado, alturaResultado);
        
        // Crear array para almacenar los hilos
        HiloCalculoElemento[][] hilos = new HiloCalculoElemento[alturaResultado][anchoResultado];
        
        // Crear e iniciar todos los hilos
        for (int i = 0; i < alturaResultado; i++) {
            for (int j = 0; j < anchoResultado; j++) {
                hilos[i][j] = new HiloCalculoElemento(matriz1, matriz2, resultado, i, j);
                hilos[i][j].start();
            }
        }
        
        // Esperar a que todos los hilos terminen
        for (int i = 0; i < alturaResultado; i++) {
            for (int j = 0; j < anchoResultado; j++) {
                hilos[i][j].join();
            }
        }
        
        return resultado;
    }
}
