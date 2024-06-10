package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.modelos.Materias;

public class ListadoMaterias {
	
	public static List<Materias> materias = new ArrayList<Materias>();
	
	public static List<Materias> listarMaterias() {
		return materias;
	}
	public static Materias buscarMateriasPorCod(String cod) {
		for (Materias materia : materias) {
			if (materia.getCod().equals(cod)) {
				return materia;
		    }
		}
		return null;
	}
	
	public static void agregarMaterias(Materias materia) {
		materias.add(materia);
	}
	
	public static void modificarMaterias(Materias materiaModificado) {
		for (int i = 0; i < materias.size(); i++){
			Materias materia = materias.get(i);
			if (materia.getCod().equals(materiaModificado.getCod())) {
				materias.set(i, materiaModificado);
				break;
			}
		}
	}
	public static void eliminarMaterias(String cod) {
		materias.removeIf(materia -> materia.getCod().equals(cod));
	}

}
