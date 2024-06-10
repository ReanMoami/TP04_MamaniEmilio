package ar.edu.unju.fi.modelos;
import org.springframework.stereotype.Component;

@Component
public class Docentes {
	private String legajo;
	private String dni;
	private String nombre;
	private String apellido;
	private String gmail;
	private String telefono;
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Docentes(String legajo, String nombre, String apellido, String gmail, String telefono, String direc) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.gmail = gmail;
		this.telefono = telefono;
	}
	public Docentes() {
		super();
	}

}
