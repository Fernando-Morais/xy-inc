package br.com.xy_inc.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.xy_inc.EntityManager.JpaEntityManager;
import br.com.xy_inc.model.PoiModel;

@Path("/poi")
public class PoiService {

	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();
	
	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	public Response cadastrar(PoiModel objPoi) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objPoi);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro realizado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<PoiModel> listar() {
		List<PoiModel> poiModels = null;
		try {
			String query = "SELECT p FROM PoiModel p";
			poiModels = objEM.createQuery(query, PoiModel.class)
					.getResultList();
			objEM.close();
			return poiModels;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/listarPOIs")
	@Produces("application/json")
	public List<PoiModel> listarPOIs(@QueryParam("x") int x, @QueryParam("y") int y, @QueryParam("d_max") int d_max) {
		List<PoiModel> poiModels2 = new ArrayList<PoiModel>(); 
		List<PoiModel> poiModels = null;

		try {
			String query = "SELECT p FROM PoiModel p";
			poiModels = objEM.createQuery(query, PoiModel.class)
					.getResultList();
			objEM.close();
			int aux = 0;
			int aux2 = 0;
			int result = 0;
			int result2 = 0;

			for (PoiModel poi : poiModels) {
				aux = poi.getX();
				aux2 = poi.getY();
				result = aux - x;
				result2 = aux2 - y;

				if ((result <= d_max) && (result2 <= d_max)) {
					poiModels2.add(poi);
				}
			}
			return poiModels2;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
