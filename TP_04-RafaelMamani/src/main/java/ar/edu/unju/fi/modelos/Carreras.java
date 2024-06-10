package ar.edu.unju.fi.modelos;
import org.springframework.stereotype.Component;

@Component
public class Carreras {
	private String cod;
	private String nombre;
	private Boolean estado;
	private int cantAños;
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public int getCantAños() {
		return cantAños;
	}
	public void setCantAños(int cantAños) {
		this.cantAños = cantAños;
	}
	public Carreras(String cod, String nombre, Boolean estado, int cantAños) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.estado = estado;
		this.cantAños = cantAños;
	}
	public Carreras() {
	}
}
