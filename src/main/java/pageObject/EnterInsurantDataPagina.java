package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import massaTeste.MassaEnterInsurantData;

public class EnterInsurantDataPagina extends ClasseBasePageObjec {
	public EnterInsurantDataPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "firstname")
	private WebElement firstName;
	
	@FindBy(id = "lastname")
	private WebElement lastName;
	
	@FindBy(id = "birthdate")
	private WebElement birthdateInput;
	
	@FindBy(id = "opendateofbirthcalender")
	private WebElement birthdateCalender;
	
	@FindBy(id = "gendermale")
	private WebElement genderMale;
	
	@FindBy(id = "genderfemale")
	private WebElement genderFemale;
	
	@FindBy(id = "streetaddress")
	private WebElement streetAddress;
	
	@FindBy(id = "country")
	private WebElement country;
	
	@FindBy(id = "zipcode")
	private WebElement zipcode;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "occupation")
	private WebElement occupation;
	
	@FindBy(id = "speeding")
	private WebElement hobbySpeeding;
	
	@FindBy(id = "bungeejumping")
	private WebElement hobbyBungeeJumping;
	
	@FindBy(id = "cliffdiving")
	private WebElement hobbyCliffDiving;
	
	@FindBy(id = "skydiving")
	private WebElement hobbySkydiving;
	
	@FindBy(id = "other")
	private WebElement hobbyOther;
	
	@FindBy(id = "website")
	private WebElement website;
	
	@FindBy(id = "picture")
	private WebElement pictureInput;
	
	@FindBy(id = "open")
	private WebElement openButton;
	
	@FindBy(id = "nextenterproductdata")
	private WebElement nextButton;
	
	public void preencher() {
		firstName.sendKeys(MassaEnterInsurantData.FIRST_NAME);
		
		lastName.sendKeys(MassaEnterInsurantData.LAST_NAME);
		
		birthdateInput.sendKeys(MassaEnterInsurantData.DATE_OF_BIRTH);
		
		genderMale.click();
		
		streetAddress.sendKeys(MassaEnterInsurantData.STREET_ADDRESS);
		
		Select select = new Select(country);
		select.selectByVisibleText(MassaEnterInsurantData.COUNTRY);
		
		zipcode.sendKeys(MassaEnterInsurantData.ZIP_CODE);
		
		city.sendKeys(MassaEnterInsurantData.CITY);
		
		select = new Select(occupation);
		select.selectByVisibleText(MassaEnterInsurantData.OCCUPATION);
		
		hobbyBungeeJumping.click();
		
		hobbySkydiving.click();
		
		website.sendKeys(MassaEnterInsurantData.WEBSITE);
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
		
		Boolean enterProductDataSelecinado = true;
		String paginaSelecionada = driver.findElement(By.xpath("li.idealsteps-step-active a")).getAttribute("id");
		
		if (paginaSelecionada == "enterproductdata") {
			enterProductDataSelecinado = true;
		} else {
			enterProductDataSelecinado = false;
		}
		
		return enterProductDataSelecinado;
	}
}
