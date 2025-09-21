package com.epsfamiliar.familibro.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.epsfamiliar.familibro.model.DataModel;
import com.epsfamiliar.familibro.model.FiltersDTO;
import com.epsfamiliar.familibro.repository.DataRepository;

@Service
public class DataService {
	// en el servicio inyectamos el repositorio
	private final DataRepository repository;

	public DataService(DataRepository dataRepository) {
		this.repository = dataRepository;
	}

	//obtenemos todos los contratos y luego pasamos con los botones del paginador funciona OK
//	public Map<String, Object> getContratos(int page, int size) {
//	    List<DataModel> contratos = repository.getContratos(page, size);
//	    int totalItems = repository.countContratos();
//	    int totalPages = (int) Math.ceil((double) totalItems / size);
//
//	    Map<String, Object> response = new HashMap<>();
//	    response.put("contratos", contratos);
//	    response.put("currentPage", page);
//	    response.put("totalItems", totalItems);
//	    response.put("totalPages", totalPages);
//
//	    return response;
//	}

	public List<DataModel> getRazones() {
		return repository.filtroRazones();
	}

	public List<String> getDeps() {
		return repository.filtroDeps();
	}

	public Map<String, Object> searchContratos(FiltersDTO filtros, int page, int size) {
	    int totalItems = repository.countContratos();
	    int totalPages = (int) Math.ceil((double) totalItems / size);
		
        List<Map<String, Object>> rows = repository.searchContratos(filtros, page, size);
        Map<String, Object> response = new HashMap<>();
        response.put("data", rows);
        response.put("CurrentPage", page);
        //response.put("size", size);
        //response.put("count", rows.size()); // luego lo mejoras con COUNT(*)
	    response.put("totalItems", totalItems);
	    response.put("totalPages", totalPages);

        return response;
	}

}
