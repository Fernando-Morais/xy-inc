package br.com.xy_inc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.xy_inc.model.PoiModel;
import br.com.xy_inc.service.PoiService;

public class PoiTeste {

	PoiService poiService = new PoiService();
	PoiModel poiModel = new PoiModel();
	PoiModel poiModel2 = new PoiModel();
	PoiModel poiModel3 = new PoiModel();
	PoiModel poiModel4 = new PoiModel();
	PoiModel poiModel5 = new PoiModel();
	PoiModel poiModel6 = new PoiModel();
	PoiModel poiModel7 = new PoiModel();

	/*@Test
	public void testCadastrar() {

		poiModel.setNome("Lanchonete");
		poiModel.setX(27);
		poiModel.setY(12);
		poiService.cadastrar(poiModel);
		
		poiModel2.setNome("Posto");
		poiModel2.setX(31);
		poiModel2.setY(18);
		poiService.cadastrar(poiModel2);
	
		poiModel3.setNome("Joalheria");
		poiModel3.setX(15);
		poiModel3.setY(12);
		poiService.cadastrar(poiModel3);
		
		poiModel4.setNome("Floricultura");
		poiModel4.setX(19);
		poiModel4.setY(21);
		poiService.cadastrar(poiModel4);
		
		poiModel5.setNome("Pub");
		poiModel5.setX(12);
		poiModel5.setY(8);
		poiService.cadastrar(poiModel5);
		
		poiModel6.setNome("Supermercado");
		poiModel6.setX(23);
		poiModel6.setY(6);
		poiService.cadastrar(poiModel6);
		
		poiModel7.setNome("Churrascaria");
		poiModel7.setX(28);
		poiModel7.setY(2);
		poiService.cadastrar(poiModel7);
	}*/

	@Test
	public void testListar() {
		List<PoiModel> poiModels = poiService.listar();
		if (poiModels != null) {
			for (PoiModel poi : poiModels) {
				System.out.println(poi);
			}
		}else{
			assertNull(poiModels);
		}
	}

	@Test
	public void testListarPOIs() {
		List<String> poiModels = poiService.listarPOIs(20, 10, 10);
		if (poiModels != null) {
			for (String poi : poiModels) {
				System.out.println(poi);
			}
		}else{
			assertNull(poiModels);
		}
	}

}
