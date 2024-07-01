package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.modelos.Carreras;

public class ListadoCarreras {
	
	public static List<Carreras> carreras = new ArrayList<Carreras>();
	
	public static List<Carreras> listarCarreras() {
		return carreras;
	}
	public static Carreras buscarCarrerasPorCod(String cod) {
		for (Carreras carrera : carreras) {
			if (carrera.getCod().equals(cod)) {
				return carrera;
		    }
		}
		return null;
	}
	
	public static void agregarCarreras(Carreras carrera) {
		carrera.setEstado(true);
		carreras.add(carrera);
	}
	
	public static void modificarCarreras(Carreras carreraModificada) {
		carreraModificada.setEstado(true);
		for (int i = 0; i < carreras.size(); i++){
			Carreras carrera = carreras.get(i);
			if (carrera.getCod().equals(carreraModificada.getCod())) {
				carreras.set(i, carreraModificada);
				break;
			}
		}
	}
	public static void eliminarCarreras(String cod) {
		carreras.removeIf(carrera -> carrera.getCod().equals(cod));
	}

}
