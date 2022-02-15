package assinatura_test.web;

import assinatura_test.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PagamentoPage extends PageObject {

    By btnContinua = By.xpath("//*[@id=\"form_login\"]/div[2]/button");
    By btnIrPagamentos = By.xpath("//*[@id=\"form_login\"]/div[2]/button");
    By btnContinuarJS = By.cssSelector("#form_login > div.btn-submit > button");
    By btnContinuarID = By.id("payment_phone");

    private static final String URL_PAGAMENTO=
            "https://assine.estadao.com.br/subscribe/new/estadao-digital-basica-490-990-am101172?canal=PAY&referrer_url=https://cultura.estadao.com.br/noticias/cinema,morre-o-cineasta-arnaldo-jabor-aos-81-anos,70003979587&paywall_dinamico=paywall_dinamico_continue_lendo&checkout_step=login";

    public PagamentoPage(WebDriver browser) {
        super(browser);
        this.browser.navigate().to(URL_PAGAMENTO);
    }

    public void preencherDados(String name, String email, String telefone){
        this.browser.findElement(By.id("nome")).sendKeys(name);
        this.browser.findElement(By.id("email_login")).sendKeys(email);
        this.browser.findElement(By.id("payment_phone")).sendKeys(telefone);
    }

    public CartoesPage irParaPagamento(){
        try {
            browser.findElement(btnContinua).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) browser;
            executor.executeScript("arguments[0].click();", browser.findElement(btnContinua));
        }
        return new CartoesPage(browser);
    }

    public boolean isPaginaPagamento() {
        return browser.getCurrentUrl().equals(URL_PAGAMENTO);
    }

    public boolean mensagemPaginaPagamento(){
        return this.browser.getPageSource().contains("Nos diga um pouco sobre você");
    }
}
