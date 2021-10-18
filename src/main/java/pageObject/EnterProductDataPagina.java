package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import massaTeste.MassaEnterProductData;

public class EnterProductDataPagina extends ClasseBasePageObjec {
	public EnterProductDataPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "startdate")
	private WebElement startDateInput;
	
	@FindBy(id = "openstartdatecalender")
	private WebElement StartDateCalender;
	
	@FindBy(id = "insurancesum")
	private WebElement insuranceSum;
	
	@FindBy(id = "meritrating")
	private WebElement meritRating;
	
	@FindBy(id = "damageinsurance")
	private WebElement damageInsurance;
	
	@FindBy(id = "EuroProtection")
	private WebElement optionalProductsEuroProtection;
	
	@FindBy(id = "LegalDefenseInsurance")
	private WebElement optionalProductsLegalDefenseInsurance;
	
	@FindBy(id = "courtesycar")
	private WebElement courtesyCar;
	
	@FindBy(id = "nextselectpriceoption")
	private WebElement nextButton;
	
	public void preencher() {
		startDateInput.sendKeys(MassaEnterProductData.START_DATE);
		
		Select select = new Select(insuranceSum);
		select.selectByIndex(MassaEnterProductData.INSURANCE_SUM);
		
		select = new Select(meritRating);
		select.selectByIndex(MassaEnterProductData.MERIT_RATING);
		
		select = new Select(damageInsurance);
		select.selectByIndex(MassaEnterProductData.DAMAGE_INSURANCE);
		
		optionalProductsEuroProtection.click();
		
		optionalProductsLegalDefenseInsurance.click();
		
		select = new Select(courtesyCar);
		select.selectByIndex(MassaEnterProductData.COURTESY_CAR);
	}
	
	public boolean verificaCamposObrigatoriosPreenchidos() {
		Boolean noError = true;
		String errorDisplay = driver.findElement(By.className("error hidden")).getCssValue("display");
		
		if (errorDisplay == "none") {
			noError = true;
		} else {
			noError = false;
		}
		
		return noError;
	}
	
	public boolean proximaPagina() {
		nextButton.click();
		
		Boolean selectPriceOptionSelecinado = true;
		String paginaSelecionada = driver.findElement(By.xpath("li.idealsteps-step-active a")).getAttribute("id");
		
		if (paginaSelecionada == "selectpriceoption") {
			selectPriceOptionSelecinado = true;
		} else {
			selectPriceOptionSelecinado = false;
		}
		
		return selectPriceOptionSelecinado;
	}
}
