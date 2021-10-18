package teste;

import org.openqa.selenium.WebDriver;

import configuracoes.DriverFactory;
import configuracoes.Configuracoes;
import pageObject.EnterVehicleDataPagina;
import pageObject.EnterInsurantDataPagina;
import pageObject.EnterProductDataPagina;
import pageObject.SelectPriceOptionPagina;
import pageObject.SendQuotePagina;

public class ClasseBaseTeste {
	protected WebDriver driver;
	protected EnterVehicleDataPagina enterVehicleDataPagina;
	protected EnterInsurantDataPagina enterInsurantDataPagina;
	protected EnterProductDataPagina enterProductDataPagina;
	protected SelectPriceOptionPagina selectPriceOptionPagina;
	protected SendQuotePagina sendQuotePagina;
	
	
	public void iniciaAplicacao() {
		driver = DriverFactory.createDriver(Configuracoes.BROWSER);
		driver.manage().window().maximize();
		driver.get(Configuracoes.URL);
		
		enterVehicleDataPagina = new EnterVehicleDataPagina(driver);
		enterInsurantDataPagina = new EnterInsurantDataPagina(driver);
		enterProductDataPagina = new EnterProductDataPagina(driver);
		selectPriceOptionPagina = new SelectPriceOptionPagina(driver);
		sendQuotePagina = new SendQuotePagina(driver);
	}
	
	public void finalizaAplicacao() {
		driver.quit();
	}
}
