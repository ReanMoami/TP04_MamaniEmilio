package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.modelos.Docentes;

@Controller
public class DocentesController {
	
	@Autowired
	Docentes nuevoDocentes = new Docentes();
	
	@GetMapping("/formularioDocentes")
	public ModelAndView getFormDocentes() {
		//vista formDocentes.html
		ModelAndView modelView = new ModelAndView("/fragments/FormDocente");
		//agrega el objeto
		modelView.addObject("nuevoDocentes", nuevoDocentes);	
		
		return modelView;
	}
	
	@PostMapping("/guardarDocentes")
	public ModelAndView saveDocentes(@ModelAttribute("nuevoDocentes") Docentes DocentesParaGuardar) {
					
		//guardar
		ListadoDocentes.agregarDocentes(DocentesParaGuardar);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("/fragments/listaDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
		
		return modelView;		
	}
	
	@GetMapping("/borrarDocentes/{legajo}")
	public ModelAndView deleteDocentesDelListado(@PathVariable(name="legajo") String legajo) {
		//borrar
		ListadoDocentes.eliminarDocentes(legajo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("/fragments/listaDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarDocentes/{legajo}")
	public ModelAndView editdocente(@PathVariable(name = "legajo") String legajo) {
	    // Buscar la docente por el código
	    Docentes docenteModificada = ListadoDocentes.buscarDocentesPorLegajo(legajo);

	    ModelAndView modelView = new ModelAndView("/fragments/FormDocente");			
	    modelView.addObject("nuevoDocentes", docenteModificada);
	    modelView.addObject("band", true);
	    
	    return modelView;
	}
	
	@PostMapping("/modificarDocentes")
	public ModelAndView modificardocente(@ModelAttribute("nuevoDocentes") Docentes docenteModificada) {
	    // Lógica para modificar la docente
	    ListadoDocentes.modificarDocentes(docenteModificada);

	    ModelAndView modelView = new ModelAndView("/fragments/listaDocentes");
	    modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());

	    return modelView;
	}
	
	@GetMapping("/docentes")
	public ModelAndView mostrarDocentess() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("/fragments/listaDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
		return modelView;		
	}
		 
}
