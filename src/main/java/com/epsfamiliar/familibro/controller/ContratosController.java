package com.epsfamiliar.familibro.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epsfamiliar.familibro.model.DataModel;
import com.epsfamiliar.familibro.model.FiltersDTO;
import com.epsfamiliar.familibro.service.DataService;

@RestController
public class ContratosController {

	private DataService dataService;

	public ContratosController(DataService controlador) {
		this.dataService = controlador;
	}
/*funciona OK*/
//	@GetMapping("/tecnologias")
//	public Map<String, Object> getContratos(
//	        @RequestParam(defaultValue = "0") int page,
//	        @RequestParam(defaultValue = "10") int size) {
//	    return dataService.getContratos(page, size);
//	}

	@GetMapping("/getRazonUnica")
	public List<DataModel> getRazones() {
		return dataService.getRazones();
	}
	
	@GetMapping("/getDeps")
	public List<String> getDeps(){
		return dataService.getDeps();
	}
	
	@PostMapping("/tecnologias/search")
	public Map<String, Object> searchContratos(
	        @RequestBody FiltersDTO filtros,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {
	    return dataService.searchContratos(filtros, page, size);
	}
}
