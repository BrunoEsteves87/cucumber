package page;

import org.openqa.selenium.By;
import metodos.Metodos;

public class LoginPage {
    public Metodos metodos = new Metodos();

    By usuario = By.id("user-name");
    By senha = By.id("password");
    By btnLogin = By.id("login-button");
    String urlLogado = "https://www.saucedemo.com/inventory.html";

    public void login(String usuario, String senha) {
        metodos.escrever(this.usuario, usuario);
        metodos.escrever(this.senha, senha);
        metodos.clicar(this.btnLogin);
    }

    By mensagemErro = By.cssSelector(".error-message-container");

    public void validaMensagemErro(String mensagemEsperada) {
        metodos.validarTexto(mensagemErro, mensagemEsperada);
    }

    public void validaLogin() {
        metodos.validarUrl(urlLogado);
    }
}
