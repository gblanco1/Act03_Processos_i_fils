package matrices;

public class Matriz {
    private int[][] matriz;
    private int ancho;
    private int altura;
    
    public Matriz(int ancho, int altura) {
        this.ancho = ancho;
        this.altura = altura;
        this.matriz = new int[altura][ancho];
    }
    
    public int getAncho() {
        return ancho;
    }
    
    public int getAltura() {
        return altura;
    }
    
    public void establecer(int fila, int columna, int valor) {
        matriz[fila][columna] = valor;
    }
    
    public int obtener(int fila, int columna) {
        return matriz[fila][columna];
    }
    
    public void mostrar() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < ancho; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
