package teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UndefinedInsuranceTeste extends ClasseBaseTeste {
	@Before
	public void antesDoTeste() {
		iniciaAplicacao();
	}
	
	@Test
	public void SolicitandoSeguroVeicular() {
		enterVehicleDataPagina.preencher();
		Assert.assertTrue(enterVehicleDataPagina.verificaCamposObrigatoriosPreenchidos());
		Assert.assertTrue(enterVehicleDataPagina.proximaPagina());
		
		enterInsurantDataPagina.preencher();
		Assert.assertTrue(enterInsurantDataPagina.verificaCamposObrigatoriosPreenchidos());
		Assert.assertTrue(enterInsurantDataPagina.proximaPagina());
		
		enterProductDataPagina.preencher();
		Assert.assertTrue(enterProductDataPagina.verificaCamposObrigatoriosPreenchidos());
		Assert.assertTrue(enterProductDataPagina.proximaPagina());
		
		selectPriceOptionPagina.selecionar();
		Assert.assertTrue(selectPriceOptionPagina.verificaCamposObrigatoriosPreenchidos());
		Assert.assertTrue(selectPriceOptionPagina.proximaPagina());
		
		sendQuotePagina.preencher();
		Assert.assertTrue(sendQuotePagina.verificaCamposObrigatoriosPreenchidos());
		Assert.assertTrue(sendQuotePagina.enviar());
		sendQuotePagina.confirmar();
		
	}
	
}
