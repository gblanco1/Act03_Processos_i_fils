package matrices;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GuardadorArchivo {

	public static void guardar(Matriz m, String nombreArchivo) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
			for (int i = 0; i < m.getAltura(); i++) {
				for (int j = 0; j < m.getAncho(); j++) {
					bw.write(String.valueOf(m.obtener(i, j)));
					if (i != m.getAltura() - 1 || j != m.getAncho() - 1) {
						bw.write(" ");
					}
				}
			}
		}
	}
}
