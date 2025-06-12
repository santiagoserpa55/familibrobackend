package com.epsfamiliar.familibro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epsfamiliar.familibro.model.MedicamentosModel;
import com.epsfamiliar.familibro.service.MedicamentosService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MedicamentosController {
	private MedicamentosService medicamentosService;

	public MedicamentosController(MedicamentosService controlador) {
		this.medicamentosService = controlador;
	}

	@GetMapping("/medicamentos")
	public List<MedicamentosModel> getMedicamentos() {
		return medicamentosService.getAllMedicamentos();
	}
	
	@GetMapping("/filtroMedCum")
	public List<MedicamentosModel> filtroMedicamentosCum() {
		return medicamentosService.filtroMedicamentosCum();
	}
	
	@GetMapping("/filtroMedAtc")
	public List<MedicamentosModel> filtroMedicamentosAtc() {
		return medicamentosService.filtroMedicamentosAtc();
	}
}
