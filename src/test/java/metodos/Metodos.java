package metodos;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import drivers.Drivers;

public class Metodos extends Drivers {

    private int contadorEvidencias = 1; // Contador para nomear as evidências automaticamente

    // Método para criar o diretório de evidências
    public void criarDiretorioEvidencias() {
        File diretorio = new File("./evidencias");
        if (!diretorio.exists()) {
            diretorio.mkdir();
            System.out.println("Diretório de evidências criado: " + diretorio.getAbsolutePath());
        }
    }

    // Método para capturar e salvar evidências
    public void capturarEvidencia() {
        criarDiretorioEvidencias(); // Certifica-se de que o diretório existe
        try {
            TakesScreenshot ts = (TakesScreenshot) Drivers.driver; // Certifique-se de que 'driver' está inicializado
            File src = ts.getScreenshotAs(OutputType.FILE); // Captura a screenshot
            File destino = new File("./evidencias/evidencia" + contadorEvidencias + ".png");
            FileUtils.copyFile(src, destino); // Copia o arquivo para o destino
            System.out.println("Evidência salva com sucesso: " + destino.getAbsolutePath());
            contadorEvidencias++; // Incrementa o contador após salvar a evidência
        } catch (NullPointerException e) {
            System.out.println("Erro: o driver não foi inicializado.");
        }
    }

    // Método para escrever em um elemento
    public void escrever(By elemento, String texto) {
        try {
            Drivers.driver.findElement(elemento).sendKeys(texto); // Escreve no elemento indicado
            System.out.println("Texto escrito com sucesso no elemento: " + elemento.toString());
        } catch (Exception e) {
            System.out.println("Erro ao escrever no elemento: " + e.getMessage());
        }
    }

    // Método para clicar em um elemento
    public void clicar(By elemento) {
        try {
            this.extracted().findElement(elemento).click(); // Clica no elemento indicado
            System.out.println("Clique realizado com sucesso no elemento: " + elemento.toString());
        } catch (Exception e) {
            System.out.println("Erro ao clicar no elemento: " + e.getMessage());
        }
    }

	private WebDriver extracted() {
		return driver;
	}

    // Método para validar o texto de um elemento
    public void validarTexto(By elemento, String textoEsperado) {
        try {
            String textoAtual = Drivers.driver.findElement(elemento).getText(); // Obtém o texto do elemento
            if (textoAtual.equals(textoEsperado)) {
                System.out.println("Texto validado com sucesso!");
            } else {
                System.out.println("Texto diferente do esperado. Atual: " + textoAtual);
            }
        } catch (Exception e) {
            System.out.println("Erro ao validar o texto: " + e.getMessage());
        }
    }

    // Método para validar a URL atual
    public void validarUrl(String urlEsperada) {
        try {
            String urlAtual = Drivers.driver.getCurrentUrl(); // Obtém a URL atual
            if (urlAtual.equals(urlEsperada)) {
                System.out.println("URL validada com sucesso!");
            } else {
                System.out.println("URL diferente do esperado. Atual: " + urlAtual);
            }
        } catch (Exception e) {
            System.out.println("Erro ao validar a URL: " + e.getMessage());
        }
    }
}


