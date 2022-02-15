package assinatura_test.web;

import assinatura_test.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CadastroPage extends PageObject {

    private static final String URL_CADASTRO = "https://acesso.estadao.com.br/login/cadastrar/";

    public CadastroPage(WebDriver browser){
        super(browser);
    }

    public void preencherCamposDeCadastros(String nome, String sobrenome, String celular, String email, String senha){
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("sobrenome")).sendKeys(sobrenome);
        this.browser.findElement(By.id("telefone")).sendKeys(celular);
        this.browser.findElement(By.id("email_login")).sendKeys(email);
        this.browser.findElement(By.id("senha")).sendKeys(senha);
    }

    public LoginEfetivadoPage irCadastradoNoArtigo(){
        try {
            browser.findElement(By.id("btn-cadastrar")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) browser;
            executor.executeScript("arguments[0].click();", browser.findElement(By.id("btn-cadastrar")));
        }
        return new LoginEfetivadoPage(browser);
    }
}
