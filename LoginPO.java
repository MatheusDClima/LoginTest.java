package automatizado.Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail; //Quando eu precisar esse método vai lá no HTML capturar esse elemento e disponibilizar pra mim.

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span") //Esse é diferente pq foi capturado por um document.querySelector no Console da página de login
    public WebElement spanMensagem;

    /**
     * CONSTRUTOR PADRÃO PARA CRIAÇÃO DE UMA NOVA PÁGINA DE LOGIN.
     * @param driver DRIVER DA PÁGINA DE LOGIN.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }   

    public void escrever(WebElement input, String texto){ //Método 'escrever' que vai receber um webElement que vai ser um input qualquer, e o texto.
        input.clear(); // vai garantir que o campo esteja limpo antes de executar o próximo teste.
        input.sendKeys(texto + Keys.TAB); //mandar escrever e dar um TAB logo em seguida.
    }

    public String obterMensagem(){
        return this.spanMensagem.getText();
    }

    public String obterTituloPagina(){
        return driver.getTitle();
    }
}
