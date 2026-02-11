package matrices;

public class HiloCalculoElemento extends Thread {
    private Matriz matriz1;
    private Matriz matriz2;
    private Matriz resultado;
    private int fila;
    private int columna;
    
    public HiloCalculoElemento(Matriz matriz1, Matriz matriz2, Matriz resultado, int fila, int columna) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.resultado = resultado;
        this.fila = fila;
        this.columna = columna;
    }
    
    public void run() {
        int suma = 0;
        
        // Multiplicacion: resultado[fila][columna] = suma de (matriz1[fila][k] * matriz2[k][columna])
        for (int k = 0; k < matriz1.getAncho(); k++) {
            suma += matriz1.obtener(fila, k) * matriz2.obtener(k, columna);
        }
        
        // Guardar resultado
        resultado.establecer(fila, columna, suma);
    }
}
