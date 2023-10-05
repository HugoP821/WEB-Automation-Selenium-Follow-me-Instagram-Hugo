package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class basepage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;
    static {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Metodo para evitar el Time Out
    public basepage(WebDriver driver){
        basepage.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    //Metodo para ingresar a la url y cerrar Google
    public static void navigateTo(String url){
        driver.manage().window().maximize();
        driver.get(url);
        System.out.print("\033[H\033[2J");
        System.err.println("Error al buscar el metodo seleccionado.");
        System.out.flush();
    }
    public void BusquedaCliente(String URL){
        driver.switchTo();
        System.out.println("Búsqueda cliente");
    }
    //Metodo para cerrar navegador
    public static void closeBrowser(){
        driver.quit();
    }
    //Metodo para dar pausa en cada búsqueda de elemento
    private WebElement find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    //Metodo para dar clic en la página
    public void clickElement(String locator){
        find(locator).click();
    }
    //Metodo para escribir
    public void write(String locator, String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    //Metodo para buscar en listas desplegables por VALOR
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);
    }
    //Metodo para buscar en listas desplegables por NÚMERO
    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(valueToSelect);
    }
    //Metodo para buscar en listas desplegables por TEXTO
    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }
    //Si en un caso el SELECT no existe en el HTML se debe primero; crear una función para dar clic en el BUTTON y sucesivo seleccionar la opción a desear

    //Función para pasar por arriba de un elemento
    public void hoverOverElement(String locator){
        actions.moveToElement(find(locator));
    }
    //Función para doble clic
    public void doubleClick(String locator){
        actions.doubleClick(find(locator));
    }
    //Función para clic derecho
    public void rightClick(String locator){
        actions.contextClick(find(locator));
    }
    //Metodo para devolver el valor de una celda
    public String getValueFromTable(String locator, int row, int column){
        String cellNeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return find(cellNeed).getText();
    }
    //Devolver valor de celda
    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        find(cellToFill).sendKeys(stringToSend);
        find(cellToFill).sendKeys(stringToSend);
    }
    //Metodo para validar las alertas de las paginas
    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
        driver.switchTo().frame(iFrameIndex);
    }
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    //Rechazar las alertas de la página
    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }
    //Metodo para devolver el texto de un Web Element
    public  String textFromElement (String locator){
        return find(locator).getText();
    }
    //Metodo para validar si existe un elemento
    public boolean elementIsDisplayed (String locator){
        return find(locator).isDisplayed();
    }
    //Validar si un elemento está seleccionado
    public boolean elementIsSelected(String locator){
        return find(locator).isSelected();
    }
    //Metodo para buscar en una lista
    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }
    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}