package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.modelos.Carreras;

@Controller
public class CarrerasController {
	
	@Autowired
	Carreras nuevaCarreras = new Carreras();
	
	@GetMapping("/formularioCarreras")
	public ModelAndView getFormCarreras() {
		ModelAndView modelView = new ModelAndView("/fragments/FormCarrera");
		modelView.addObject("nuevaCarreras", nuevaCarreras);	
		modelView.addObject("band", false);
		
		return modelView;
	}
	
	@PostMapping("/guardarCarreras")
	public ModelAndView saveCarreras(@ModelAttribute("nuevaCarreras") Carreras carreraParaGuardar) {
		ListadoCarreras.agregarCarreras(carreraParaGuardar);
		ModelAndView modelView = new ModelAndView("/fragments/listaCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());	
		
		return modelView;		
	}
	
	@GetMapping("/borrarCarreras/{cod}")
	public ModelAndView deleteCarrerasDelListado(@PathVariable(name="cod") String cod) {
		//borrar
		ListadoCarreras.eliminarCarreras(cod);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("/fragments/listaCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras())
		
		;	
		
		return modelView;		
		}
	
	@GetMapping("/modificarCarreras/{cod}")
	public ModelAndView editCarreras(@PathVariable(name = "cod") String cod) {
	    // Buscar la carrera por el código
	    Carreras carreraModificada = ListadoCarreras.buscarCarrerasPorCod(cod);

	    ModelAndView modelView = new ModelAndView("/fragments/FormCarrera");			
	    modelView.addObject("nuevaCarreras", carreraModificada);
	    modelView.addObject("band", true);
	    
	    return modelView;
	}
	
	@PostMapping("/modificarCarreras")
	public ModelAndView modificarCarreras(@ModelAttribute("nuevaCarreras") Carreras carreraModificada) {
	    // Lógica para modificar la carrera
	    ListadoCarreras.modificarCarreras(carreraModificada);

	    ModelAndView modelView = new ModelAndView("/fragments/listaCarreras");
	    modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());

	    return modelView;
	}

	@GetMapping("/carreras")
	public ModelAndView showCarrerass() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("/fragments/listaCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());	
		return modelView;		
	}
}
