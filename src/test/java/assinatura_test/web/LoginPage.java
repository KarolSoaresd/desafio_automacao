package assinatura_test.web;

import assinatura_test.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject {

    private static final String URL_LOGIN =
            "https://acesso.estadao.com.br/login/?r=https://cultura.estadao.com.br/noticias/cinema,morre-o-cineasta-arnaldo-jabor-aos-81-anos,70003979587";

    public LoginPage(WebDriver browser){
        super(browser);
    }

    public void preencherLogin(String email, String senha){
        this.browser.findElement(By.id("email_login")).sendKeys(email);
        this.browser.findElement(By.id("senha")).sendKeys(senha);
    }

    public LoginEfetivadoPage irParaArtigo(){
        try {
            browser.findElement(By.id("btn-login")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) browser;
            executor.executeScript("arguments[0].click();",
                    browser.findElement(By.id("btn-login")));
        }
        return new LoginEfetivadoPage(browser);
    }

    public CadastroPage irParaCadastro(){
        try {
            browser.findElement(By.xpath("//*[@id=\"form-login\"]/div[8]/div/p/a")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) browser;
            executor.executeScript("arguments[0].click();",
                    browser.findElement(By.xpath("//*[@id=\"form-login\"]/div[8]/div/p/a")));
        }
        return new CadastroPage(browser);
    }
}
