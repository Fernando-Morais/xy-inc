package br.com.xy_inc.test;

import java.util.List;

import org.junit.Test;

import br.com.xy_inc.model.PoiModel;
import br.com.xy_inc.service.PoiService;

public class PoiTeste {

	PoiService poiService = new PoiService();
	PoiModel poiModel = new PoiModel();

	@Test
	public void testCadastrar() {
		poiModel.setNome("Lanchonete");
		poiModel.setX(27);
		poiModel.setY(12);
		poiService.cadastrar(poiModel);

	}

	@Test
	public void testListar() {
		List<PoiModel> poiModels = poiService.listar();
		if (poiModels.size() != 0) {
			for (PoiModel poi : poiModels) {
				System.out.println(poi);
			}
		}
	}

	@Test
	public void testListarPOIs() {
		List<PoiModel> poiModels = poiService.listarPOIs(20, 10, 10);
		if (poiModels.size() != 0) {
			for (PoiModel poi : poiModels) {
				System.out.println(poi);
			}
		}
	}

}
