package assinatura_test.web;

import assinatura_test.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class AssinaturaPage extends PageObject{

    private static final String URL_PRINCIPAL=
            "https://cultura.estadao.com.br/noticias/cinema,morre-o-cineasta-arnaldo-jabor-aos-81-anos,70003979587";

    public AssinaturaPage() {
        super(null);
        browser.navigate().to(URL_PRINCIPAL);
    }

    public PagamentoPage escolherAssinatura(){

        try {
            browser.findElement(By.id
                    ("openLandingPage")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) browser;
            executor.executeScript("arguments[0].click();", browser.findElement(By.id("openLandingPage")));
        }
//        browser.findElement(By.xpath("//*[@id=\"app-root\"]/div/main/section[1]/div[2]/div[1]/div[1]/div[4]/button")).click();
        return new PagamentoPage(browser);
    }

    public void navegaNaPagina(){
        browser.navigate();
    }

    public LoginPage loginAssinantes(){

        try {
            browser.findElement(By.id
                    ("openLogin")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) browser;
            executor.executeScript("arguments[0].click();", browser.findElement(By.id("openLogin")));
        }
        return new LoginPage(browser);
    }

}
