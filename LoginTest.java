package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import automatizado.Page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Para executar os Testes em ordem crescente.
public class LoginTest extends BaseTest{

    private static LoginPO loginPage; 

    private void executarAcaoDeLogar(String email, String senha){ //Vai executar a ação de logar
        loginPage.escrever(loginPage.inputEmail, email);
        loginPage.escrever(loginPage.inputSenha, senha);  // Se essa ação se repetir várias vezes, eu posso jogar dentro do loginPO.java.
              
        loginPage.buttonEntrar.click();
    }

    @BeforeClass 
    public static void prepararTestes(){
        loginPage = new  LoginPO(driver);

    }

    @org.junit.Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){
        
        executarAcaoDeLogar("", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
     }

     @org.junit.Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){
      
        executarAcaoDeLogar("teste", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
     }

     @org.junit.Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){
     
        executarAcaoDeLogar("", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
     }

     @org.junit.Test
    public void TC004_naoDeveLogarNoSistemaComEmailIncorretoESenhaIncorreta(){
     
        executarAcaoDeLogar("teste", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");
     }

     @org.junit.Test
     public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta(){
     
        executarAcaoDeLogar("admin@admin.com", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @org.junit.Test
     public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta(){
     
        executarAcaoDeLogar("Aadmin@admin.com", "admin@123");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

     }

     @org.junit.Test
     public void TC007_deveLogarNoSistemaComEmailCorretoESenhaCorreta(){
     
        executarAcaoDeLogar("admin@admin.com", "admin@123");

        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");

     }
}

