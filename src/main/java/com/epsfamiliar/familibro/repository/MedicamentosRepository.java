package com.epsfamiliar.familibro.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epsfamiliar.familibro.model.MedicamentosModel;


@Repository
public class MedicamentosRepository {
	
//repositorio -> objeto que se encarga de hacer la conex con la DB y enviarlos
	// un poco mas arriba en tu logica

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final DataMapper mapper = new DataMapper();
	private final FiltroAtcMapper mapperAtc = new FiltroAtcMapper();
	private final FiltroCumMapper mapperCum = new FiltroCumMapper();

	// inyeccion de dependencias asi que ya podemos usar el objeto
	public MedicamentosRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = namedParameterJdbcTemplate;
	}

	private static class DataMapper implements RowMapper<MedicamentosModel> {

		@Override
		public MedicamentosModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			String cum = rs.getString("cum");
			String atc = rs.getString("atc");
			String descripcion = rs.getString("descripcion");
			String tarifaOferta = rs.getString("tarifa_oferta");
			String estado = rs.getString("estado");
			return new MedicamentosModel(cum, atc, descripcion, tarifaOferta, estado);
		}
	}
	
	private static class FiltroCumMapper implements RowMapper<MedicamentosModel> {
    @Override
    public MedicamentosModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        String cum = rs.getString("cum");
        return MedicamentosModel.porCum(cum);
    }
}

	private static class FiltroAtcMapper implements RowMapper<MedicamentosModel> {
    @Override
    public MedicamentosModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        String atc = rs.getString("atc");
        return MedicamentosModel.porAtc(atc);
    }
}

	
	public List<MedicamentosModel> getMedicamentos() {
		String getQuery = "SELECT cum, atc, descripcion, tarifa_oferta, estado FROM public.medicamentos";
		/*
		 * debemos mapear los campos que estan en la base de datos para que existan en
		 * java, usamos un mapper
		 * 
		 */
		return jdbcTemplate.query(getQuery, mapper);
	}

	// filtro para la columna cum de la tabla medicamentos
	public List<MedicamentosModel> filtroCum() {
		String filtroMedicamentosQuery = "SELECT DISTINCT(cum) FROM public.medicamentos";
		return jdbcTemplate.query(filtroMedicamentosQuery, mapperCum);
	}
	
	// filtro para la columna cum de la tabla medicamentos
	public List<MedicamentosModel> filtroAtc() {
		String filtroMedicamentosQuery = "SELECT DISTINCT(atc) FROM public.medicamentos";
		return jdbcTemplate.query(filtroMedicamentosQuery, mapperAtc);
	}

}
