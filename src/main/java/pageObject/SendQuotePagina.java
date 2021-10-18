package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import massaTeste.MassaSendQuote;

public class SendQuotePagina extends ClasseBasePageObjec {
	private String pass = MassaSendQuote.PASSWORD;
	
	public SendQuotePagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "confirmpassword")
	private WebElement confirmPassword;
	
	@FindBy(id = "Comments")
	private WebElement comments;
	
	@FindBy(id = "sendemail")
	private WebElement sendButton;
	
	@FindBy(xpath = "button.confirm")
	private WebElement confirmButton;
	
	public void preencher() {
		email.sendKeys(MassaSendQuote.EMAIL);
		
		phone.sendKeys(MassaSendQuote.PHONE);
		
		username.sendKeys(MassaSendQuote.USERNAME);
		
		password.sendKeys(pass);
		
		confirmPassword.sendKeys(pass);
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
	
	public boolean enviar() {
		sendButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div.sweet-alert")));
		
		Boolean sendEmailSuccessConteinerVivible = true;
		String successIconDisplay = driver.findElement(By.xpath("div.sweet-alert div.sa-success")).getCssValue("display");
		String successMessage = driver.findElement(By.xpath("div.sweet-alert h2")).getText();
		
		if (successIconDisplay == "block" && successMessage == "Sending e-mail success!") {
			sendEmailSuccessConteinerVivible = true;
		} else {
			sendEmailSuccessConteinerVivible = false;
		}
		
		return sendEmailSuccessConteinerVivible;
	}
	
	public void confirmar() {
		confirmButton.click();
	}
}
