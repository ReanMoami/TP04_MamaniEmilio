package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.modelos.Alumnos;
@Controller
public class AlumnosController {
	@Autowired
	Alumnos nuevoAlumnos = new Alumnos();
	
	@GetMapping("/formularioAlumnos")
    public ModelAndView getFormularioAlumnos() {
		//vista de formDocente
		ModelAndView modelView = new ModelAndView("/fragments/FormAlumno");
		modelView.addObject("nuevoAlumnos", nuevoAlumnos);
        return modelView;
    }
	
	@PostMapping("/guardarAlumnos")
	public ModelAndView saveAlumnos(@ModelAttribute("nuevoAlumnos") Alumnos alumnoAGuardar) {
		//guardar
		ListadoAlumnos.agregarAlumnos(alumnoAGuardar);
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("/fragments/listaAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
		System.out.println(alumnoAGuardar.getDni());
		return modelView;	
	}
	
	@GetMapping("/borrarAlumnos/{dni}")
	public ModelAndView deleteAlumnosDelListado(@PathVariable(name="dni") String dni) {
		//borrar
		ListadoAlumnos.eliminarAlumnos(dni);
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("/fragments/listaAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
		return modelView;		
	}
	
	@GetMapping("/modificarAlumnos/{dni}")
	public ModelAndView editAlumnos(@PathVariable(name="dni") String dni) {
		//seleccionar el docente para modificar
		Alumnos alumnoAModificar = ListadoAlumnos.buscarAlumnosPorDni(dni);
		
		//mostrar el formulario de modificacion
		ModelAndView modelView = new ModelAndView("/fragments/FormAlumno");
		modelView.addObject("nuevoAlumnos", alumnoAModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}
	
	@PostMapping("/modificarAlumnos")
	public ModelAndView updateAlumnos(@ModelAttribute("nuevoAlumnos") Alumnos alumnoModificado) {
					
		//modificar el docente
		ListadoAlumnos.modificarAlumnos(alumnoModificado);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("/fragments/listaAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
		return modelView;		
	}
	
	@GetMapping("/alumnos")
	public ModelAndView showAlumnoss() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("/fragments/listaAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
		return modelView;		
	}

}
