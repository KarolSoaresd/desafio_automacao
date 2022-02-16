package assinatura_test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true, features = "src/test/resources/features/assinaturas.feature", glue = "assinatura_test.runner")
public class AssinaturaRunner {
}
