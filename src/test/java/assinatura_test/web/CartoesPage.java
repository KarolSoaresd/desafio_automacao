package assinatura_test.web;

import assinatura_test.PageObject;
import org.openqa.selenium.WebDriver;

public class CartoesPage extends PageObject {

    private static final String URL_CARTOES =
            "https://assine.estadao.com.br/subscribe/new/estadao-digital-basica-490-990-am101172?canal=PAY&referrer_url=https://cultura.estadao.com.br/noticias/cinema,morre-o-cineasta-arnaldo-jabor-aos-81-anos,70003979587&paywall_dinamico=paywall_dinamico_continue_lendo&checkout_step=pagamento";

    public CartoesPage(WebDriver browser) {
        super(browser);
    }

    public boolean paginaDePagamento(){
        return this.browser.getPageSource().contains("Teste Desafio");
    }

    public boolean IsPaginaDeCartoes(){
        return browser.getCurrentUrl().contentEquals(URL_CARTOES);
    }
}
