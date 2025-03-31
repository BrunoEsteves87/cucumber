package ruuner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import drivers.Drivers;

public class Executa extends Drivers {

    public static void abrirNavegador() {
        String ambiente = "https://saucedemo.com";
        String navegador = "Chrome";

        if (navegador.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver(); 
        } else {
            driver = new EdgeDriver(); 
        }

        driver.get(ambiente);
        driver.manage().window().maximize();
    }

    public static void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
