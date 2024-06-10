package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.modelos.Alumnos;

public class ListadoAlumnos {
	
	public static List<Alumnos> alumnos = new ArrayList<Alumnos>();
	
	public static List<Alumnos> listarAlumnos() {
		return alumnos;
	}
	public static Alumnos buscarAlumnosPorDni(String dni) {
		for (Alumnos alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
		    }
		}
		return null;
	}
	
	public static void agregarAlumnos(Alumnos alumno) {
		alumnos.add(alumno);
	}
	
	public static void modificarAlumnos(Alumnos alumnoModificado) {
		for (int i = 0; i < alumnos.size(); i++){
			Alumnos alumno = alumnos.get(i);
			if (alumno.getDni().equals(alumnoModificado.getDni())) {
				alumnos.set(i, alumnoModificado);
				break;
			}
		}
	}
	public static void eliminarAlumnos(String dni) {
		alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
	}

}