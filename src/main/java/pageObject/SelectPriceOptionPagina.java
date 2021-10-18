package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPriceOptionPagina extends ClasseBasePageObjec {
	public SelectPriceOptionPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "selectsilver")
	private WebElement selectOptionSilver;
	
	@FindBy(id = "selectgold")
	private WebElement selectOptionGold;
	
	@FindBy(id = "selectplatinum")
	private WebElement selectOptionPlatinum;
	
	@FindBy(id = "selectultimate")
	private WebElement selectOptionUltimate;
	
	@FindBy(id = "nextsendquote")
	private WebElement nextButton;
	
	public void selecionar() {
		selectOptionUltimate.click();
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
		
		Boolean sendQuoteSelecinado = true;
		String paginaSelecionada = driver.findElement(By.xpath("li.idealsteps-step-active a")).getAttribute("id");
		
		if (paginaSelecionada == "sendquote") {
			sendQuoteSelecinado = true;
		} else {
			sendQuoteSelecinado = false;
		}
		
		return sendQuoteSelecinado;
	}
}
