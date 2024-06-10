package ar.edu.unju.fi.modelos;

import org.springframework.stereotype.Component;

@Component
public class Alumnos {
	
    private String nombre;
    private String apellido;
    private String dni;
    private String CU;
    private String gmail;
    private String telefono;
    private String fechaNac;
    private String domicilio;
	public String getNombre() {
		return nombre;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCU() {
		return CU;
	}
	public void setCU(String cU) {
		CU = cU;
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
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Alumnos(String nombre, String apellido, String dni, String cU, String gmail, String telefono,
			String fechaNac, String domicilio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		CU = cU;
		this.gmail = gmail;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.domicilio = domicilio;
	}
	public Alumnos() {
	}
}
