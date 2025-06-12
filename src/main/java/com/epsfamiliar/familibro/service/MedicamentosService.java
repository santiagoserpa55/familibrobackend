package com.epsfamiliar.familibro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epsfamiliar.familibro.model.MedicamentosModel;
import com.epsfamiliar.familibro.repository.MedicamentosRepository;


@Service
public class MedicamentosService {

	// en el servicio inyectamos el repositorio
	private final MedicamentosRepository repository;

	public MedicamentosService(MedicamentosRepository medRepository) {
		this.repository = medRepository;
	}

	public List<MedicamentosModel> getAllMedicamentos() {
		return repository.getMedicamentos();
	}

	public List<MedicamentosModel> filtroMedicamentosCum() {
		return repository.filtroCum();
	}
	

	public List<MedicamentosModel> filtroMedicamentosAtc() {
		return repository.filtroAtc();
	}

}
