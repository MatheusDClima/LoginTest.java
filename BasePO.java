package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**Classe base para criação das novas pageObjects
 * Todas as pages devem ser herdadas desta classe
*/

public abstract class BasePO {

    /**Driver base que será usada pelas pages. */
    protected WebDriver driver;

    /**
     * Construtor base para criação da fábrica de elementos.(PageFactory)
     * @param driver (driver da página atual)
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }

}

