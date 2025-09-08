package com.epsfamiliar.familibro.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epsfamiliar.familibro.model.DataModel;

import javax.sql.DataSource;

@Repository
public class DataRepository {
	// repositorio -> objeto que se encarga de hacer la conex con la DB y enviarlos
	// un poco mas arriba en tu logica

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final DataMapper mapper = new DataMapper();
	private final RazonMapper mapperRazones = new RazonMapper(); 

	// inyeccion de dependencias asi que ya podemos usar el objeto
	public DataRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<DataModel> getContratos(int page, int size) {
	    int offset = page * size;
		String sql = "SELECT nit, razon_social,"
				+ "numero_contrato, estado, departamento, tipo_contrato,"
				+ "codigo_tarifa, codigo_propio, descripcion_tarifa,"
				+ "valor FROM public.contratos ORDER BY nit LIMIT :size OFFSET :offset";
		/*
		 * debemos mapear los campos que estan en la base de datos para que existan en
		 * java, usamos un mapper
		 */
	    Map<String, Object> params = new HashMap<>();
	    params.put("size", size);
	    params.put("offset", offset);
	    return jdbcTemplate.query(sql, params, mapper);
	}
	
	public int countContratos() {
	    String sql = "SELECT COUNT(*) FROM public.contratos";
	    Integer count = jdbcTemplate.queryForObject(sql, Map.of(), Integer.class);
	    return count != null ? count : 0;
	}

	private static class DataMapper implements RowMapper<DataModel> {

		@Override
		public DataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			String nit = rs.getString("nit");
			String razonSocial = rs.getString("razon_social");
			String numContrato = rs.getString("numero_contrato");
			String estado = rs.getString("estado");
			String departamento = rs.getString("departamento");
			String tipoContrato = rs.getString("tipo_contrato");
			String codTarifa = rs.getString("codigo_tarifa");
			String codPropio = rs.getString("codigo_propio");
			String descTarifa = rs.getString("descripcion_tarifa");
			String valor = rs.getString("valor");
		
			return new DataModel(nit, razonSocial, numContrato, estado, departamento, tipoContrato,codTarifa, codPropio,descTarifa, valor);
		}
	}
	
	private static class RazonMapper implements RowMapper<DataModel> {

		@Override
		public DataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			String razonSocial = rs.getString("razon_social");
			return new DataModel(razonSocial);
		}
	}
	
	public List<DataModel> filtroRazones() {
		String razonesUnicas = "SELECT DISTINCT(razon_social) FROM contratos";
		return jdbcTemplate.query(razonesUnicas, mapperRazones);
	}

}
