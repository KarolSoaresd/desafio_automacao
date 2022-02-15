package assinatura_test.web;

import assinatura_test.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginEfetivadoPage extends PageObject {

    By travaArtigo = By.id("digitalCompleta");

    private static final String URL_ARTIGOLOGADO = "https://cultura.estadao.com.br/noticias/cinema,morre-o-cineasta-arnaldo-jabor-aos-81-anos,70003979587";

    public LoginEfetivadoPage(WebDriver browser){
        super(browser);
    }

    public void navegaNaPaginaDeArtigo(){
        this.browser.navigate();
    }

    public boolean paginaDeArtigoTravada(){
        if(this.browser.findElement(travaArtigo) != null){
            return true;
        }else
            return false;
    }

    public boolean isPaginaDeArtigo(){
        return this.browser.getCurrentUrl().contentEquals(URL_ARTIGOLOGADO);
    }

    public boolean isPaginaDeArtigoCadastrado(){
        return this.browser.getCurrentUrl().contentEquals
                ("https://cultura.estadao.com.br/noticias/cinema,morre-o-cineasta-arnaldo-jabor-aos-81-anos,70003979587");
    }

    public MeuPerfilPage irParaMeuPerfil(){
        try {
            browser.findElement(By.xpath("/html/body/header/div/div[2]/a[2]")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) browser;
            executor.executeScript("arguments[0].click();",
                    browser.findElement(By.xpath("/html/body/header/div/div[2]/a[2]")));
        }
        return new MeuPerfilPage(browser);
    }
}
