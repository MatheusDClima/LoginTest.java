package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest { //Será um método de testes padrão, que todas as classes de testes irão seguir
     
        protected static WebDriver driver;
        private static final String URL_BASE = "file:///C:/Users/Heber/OneDrive/%C3%81rea%20de%20Trabalho/Matheus/sublime/sistema/login.html";   
         private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v10905414";


        @BeforeClass // Estou dizendo que essa classe vai ser chamada antes de qualquer outra classe, vai ser chamado esse método de teste primeiro. Ele é estático, tudo que tem dentro dele tem que ser estático.

         public static void iniciar(){ // Pode deixar protected ou public
            System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER); //Criar o navegador
            driver = new ChromeDriver ();
            driver.manage().window().maximize(); //maximizar o navegador
            driver.get(URL_BASE);
            }

        @AfterClass // Esse método irá rodar no final, depois que todos os casos de testes forem executados.

        public static void finalizar(){
            
        }


}
