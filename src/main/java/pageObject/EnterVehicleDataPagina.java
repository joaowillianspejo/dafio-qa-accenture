package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import massaTeste.MassaEnterVehicleData;

public class EnterVehicleDataPagina extends ClasseBasePageObjec {
	public EnterVehicleDataPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "make")
	private WebElement make;
	
	@FindBy(id = "model")
	private WebElement model;
	
	@FindBy(id = "cylindercapacity")
	private WebElement cylinderCapacity;
	
	@FindBy(id = "engineperformance")
	private WebElement enginePerformance;
	
	@FindBy(id = "dateofmanufacture")
	private WebElement dateOfManufactureInput;
	
	@FindBy(id = "opendateofmanufacturecalender")
	private WebElement dateOfManufactureCalender;
	
	@FindBy(id = "numberofseats")
	private WebElement numberOfSeats;
	
	@FindBy(id = "righthanddriveyes")
	private WebElement rightHandDriveYes;
	
	@FindBy(id = "righthanddriveno")
	private WebElement rightHandDriveNo;
	
	@FindBy(id = "numberofseatsmotorcycle")
	private WebElement numberOfSeatsMotorcycle;
	
	@FindBy(id = "fuel")
	private WebElement fuelType;
	
	@FindBy(id = "payload")
	private WebElement payload;
	
	@FindBy(id = "totalweight")
	private WebElement totalWeight;
	
	@FindBy(id = "listprice")
	private WebElement listPrice;
	
	@FindBy(id = "licenseplatenumber")
	private WebElement licensePlateNumber;
	
	@FindBy(id = "annualmileage")
	private WebElement annualMileage;
	
	@FindBy(id = "nextenterinsurantdata")
	private WebElement nextButton;
	
	public void preencher() {
		Select select = new Select(make);
		select.selectByVisibleText(MassaEnterVehicleData.MAKE);
		
		select = new Select(model);
		select.selectByVisibleText(MassaEnterVehicleData.MODEL);
		
		cylinderCapacity.sendKeys(MassaEnterVehicleData.CYLINDER_CAPACITY);
		
		enginePerformance.sendKeys(MassaEnterVehicleData.ENGINE_PERFORMANCE);
		
		dateOfManufactureInput.sendKeys(MassaEnterVehicleData.DATE_OF_MANUFACTURE);
		
		select = new Select(numberOfSeats);
		select.selectByVisibleText(MassaEnterVehicleData.NUMBER_OF_SEATS);
		
		rightHandDriveYes.click();
		
		select = new Select(numberOfSeatsMotorcycle);
		select.selectByVisibleText(MassaEnterVehicleData.NUMBER_OF_SEATS_MOTORCYCLE);
		
		select = new Select(fuelType);
		select.selectByVisibleText(MassaEnterVehicleData.FUEL_TYPE);
		
		payload.sendKeys(MassaEnterVehicleData.PAYLOAD);
		
		totalWeight.sendKeys(MassaEnterVehicleData.TOTAL_WEIGHT);
		
		listPrice.sendKeys(MassaEnterVehicleData.LIST_PRICE);
		
		licensePlateNumber.sendKeys(MassaEnterVehicleData.LICENSE_PLATE_NUMBER);
		
		annualMileage.sendKeys(MassaEnterVehicleData.ANNUAL_MILEAGE);
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
		
		Boolean enterInsurantDataSelecinado = true;
		String paginaSelecionada = driver.findElement(By.xpath("li.idealsteps-step-active a")).getAttribute("id");
		
		if (paginaSelecionada == "enterinsurantdata") {
			enterInsurantDataSelecinado = true;
		} else {
			enterInsurantDataSelecinado = false;
		}
		
		return enterInsurantDataSelecinado;
	}
}
