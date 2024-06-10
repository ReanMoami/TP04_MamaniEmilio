package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.modelos.Docentes;

public class ListadoDocentes {
	
	public static List<Docentes> docentes = new ArrayList<Docentes>();
	
	public static List<Docentes> listarDocentes() {
		return docentes;
	}
	public static Docentes buscarDocentesPorLegajo(String leg) {
		for (Docentes Docentes : docentes) {
			if (Docentes.getLegajo().equals(leg)) {
				return Docentes;
		    }
		}
		return null;
	}
	
	public static void agregarDocentes(Docentes Docentes) {
		docentes.add(Docentes);
	}
	
	public static void modificarDocentes(Docentes DocentesModificado) {
		for (int i = 0; i < docentes.size(); i++){
			Docentes Docentes = docentes.get(i);
			if (Docentes.getLegajo().equals(DocentesModificado.getLegajo())) {
				docentes.set(i, DocentesModificado);
				break;
			}
		}
	}
	public static void eliminarDocentes(String leg) {
		docentes.removeIf(Docentes -> Docentes.getLegajo().equals(leg));
	}

}

