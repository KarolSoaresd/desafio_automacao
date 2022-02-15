package assinatura_test.web;

import assinatura_test.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MeuPerfilPage extends PageObject {

    By naoAssinante = By.xpath
            ("//*[@id=\"root\"]/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/span/ul/li[1]");

    private static final String URL_MEUPERFIL = "https://meu.estadao.com.br/";

    public MeuPerfilPage(WebDriver browser){
        super(browser);
    }

    public void navegaNoPerfil(){
        this.browser.navigate();
    }

    public boolean mensagemDeNaoAssinante(){
        return this.browser.getPageSource().contains("O Estadão não entra em contato por telefone para renovar assinatura. A renovação é automática e os avisos são enviados previamente por e-mail;");
    }

    public boolean naoAssinanteMeuPerfil(){
        if(this.browser.findElement(naoAssinante) != null){
            return true;
        }else
            return false;
    }

    public boolean isPaginaDePerfil(){
        return this.browser.getCurrentUrl().contentEquals(URL_MEUPERFIL);
    }


}
