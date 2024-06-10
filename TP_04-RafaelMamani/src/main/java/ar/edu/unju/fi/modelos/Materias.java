package ar.edu.unju.fi.modelos;
import org.springframework.stereotype.Component;

@Component
public class Materias {
    private String cod;
    private String nombres;
    private String curso;
	private boolean estado;
    private int cantHoras;
    private Carreras carrera;
    private Docentes docente;
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getCantHoras() {
		return cantHoras;
	}
	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}
	public Carreras getCarrera() {
		return carrera;
	}
	public void setCarrera(Carreras carrera) {
		this.carrera = carrera;
	}
	public Docentes getDocente() {
		return docente;
	}
	public void setDocente(Docentes docente) {
		this.docente = docente;
	}
	public Materias(String cod, String nombres, String curso, boolean estado, int cantHoras, Carreras carrera,
			Docentes docente) {
		super();
		this.cod = cod;
		this.nombres = nombres;
		this.curso = curso;
		this.estado = estado;
		this.cantHoras = cantHoras;
		this.carrera = carrera;
		this.docente = docente;
	}
	public Materias() {
		super();
	}
    
}
