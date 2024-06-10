package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.modelos.Materias;

@Controller
public class MateriasController {
	@Autowired
	Materias nuevaMaterias = new Materias();
	
	@GetMapping("/formularioMaterias")
    public ModelAndView getFormMaterias() {
		//vista de formDocente
		ModelAndView modelView = new ModelAndView("/fragments/FormMateria");
		modelView.addObject("nuevaMaterias", nuevaMaterias);
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		modelView.addObject("band",false);
        return modelView;
    }
	
	@PostMapping("/guardarMaterias")
	public ModelAndView saveMaterias(@ModelAttribute("nuevaMaterias") Materias materiaAGuardar) {
		ListadoMaterias.agregarMaterias(materiaAGuardar);
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("/fragments/listaMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());	
		return modelView;	
	}
	
	@GetMapping("/borrarMaterias/{codigo}")
	public ModelAndView deleteMateriasDelListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoMaterias.eliminarMaterias(codigo);
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("/fragments/listaMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());	
		return modelView;		
	}
	
	@GetMapping("/modificarMaterias/{codigo}")
	public ModelAndView editmateria(@PathVariable(name="cod") String cod) {
		//seleccionar el docente para modificar
		Materias materiaAModificar = ListadoMaterias.buscarMateriasPorCod(cod);
		
		//mostrar el formulario de modificacion
		ModelAndView modelView = new ModelAndView("/fragments/FormMaterias");
		modelView.addObject("nuevaMaterias", materiaAModificar);	
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		modelView.addObject("band", true);
		return modelView;		
		}
	
	
	@PostMapping("/modificarMaterias")
	public ModelAndView updatemateria(@ModelAttribute("nuevaMaterias") Materias materiaModificada) {
		
		materiaModificada.setDocente(ListadoDocentes.buscarDocentesPorLegajo(materiaModificada.getDocente().getLegajo()));
		materiaModificada.setCarrera(ListadoCarreras.buscarCarrerasPorCod(materiaModificada.getCarrera().getCod()));
		//modificar el docente
		ListadoMaterias.modificarMaterias(materiaModificada);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("/fragments/listaMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());	
		return modelView;	
	}
	
	
	@GetMapping("/materias")
	public ModelAndView showMateriass() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("/fragments/listaMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());
		return modelView;		
	}
}
