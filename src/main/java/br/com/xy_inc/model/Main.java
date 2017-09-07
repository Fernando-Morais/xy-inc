package br.com.xy_inc.model;

import java.util.List;

import br.com.xy_inc.service.PoiService;

public class Main {

	static PoiService poiService = new PoiService();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PoiModel poiModel = new PoiModel();
		poiModel.setNome("Lanchonete");
		poiModel.setX(27);
		poiModel.setY(12);
		poiService.cadastrar(poiModel);
		
		/*PoiModel poiModel2 = new PoiModel();
		poiModel2.setNome("Posto");
		poiModel2.setX(31);
		poiModel2.setY(18);
		poiService.cadastrar(poiModel2);
		
		PoiModel poiModel3 = new PoiModel();
		poiModel3.setNome("Joalheria");
		poiModel3.setX(15);
		poiModel3.setY(12);
		poiService.cadastrar(poiModel3);
		
		PoiModel poiModel4 = new PoiModel();
		poiModel4.setNome("Floricultura");
		poiModel4.setX(19);
		poiModel4.setY(21);
		poiService.cadastrar(poiModel4);
		
		PoiModel poiModel5 = new PoiModel();
		poiModel5.setNome("Pub");
		poiModel5.setX(12);
		poiModel5.setY(8);
		poiService.cadastrar(poiModel5);
		
		PoiModel poiModel6 = new PoiModel();
		poiModel6.setNome("Supermercado");
		poiModel6.setX(23);
		poiModel6.setY(6);
		poiService.cadastrar(poiModel6);
		
		PoiModel poiModel7 = new PoiModel();
		poiModel7.setNome("Churrascaria");
		poiModel7.setX(28);
		poiModel7.setY(2);
		poiService.cadastrar(poiModel7);*/

		List<PoiModel> poiModels = poiService.listar();
		if (poiModels != null) {
			for (PoiModel poi : poiModels) {
				System.out.println(poi);
			}
		}
		
		List<String> poiModels2 = poiService.listarPOIs(20, 10, 10);
		if (poiModels2 != null) {
			for (String poi2 : poiModels2) {
				System.out.println(poi2);
			}
		}

	}

}
