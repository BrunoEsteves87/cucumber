package steps;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;
import ruuner.Executa;

public class FuncionalidadeLoginTeste {

    LoginPage login = new LoginPage();

    @After
    public void finalizarTeste() {
        Executa.fecharNavegador();
    }

    @Given("que esteja na tela de login")
    public void que_esteja_na_tela_de_login() {
        Executa.abrirNavegador();
        login.metodos.capturarEvidencia(); // Captura evidência da tela de login
    }

    @When("enviar os dados de login")
    public void enviar_os_dados_de_login() {
        login.login("standard_user", "secret_sauce");
        login.metodos.capturarEvidencia(); // Captura evidência após envio dos dados de login
    }

    @Then("Login realizado com sucesso")
    public void login_realizado_com_sucesso() {
        login.validaLogin();
        login.metodos.capturarEvidencia(); // Captura evidência do login realizado
    }

    @When("enviar dados de login inválidos")
    public void enviar_dados_de_login_invalidos() {
        login.login("usuario_invalido", "senha_invalida");
        login.metodos.capturarEvidencia(); // Captura evidência após envio de login inválido
    }

    @Then("Exibir mensagem de erro de login")
    public void exibir_mensagem_de_erro_de_login() {
        login.validaMensagemErro("Epic sadface: Username and password do not match any user in this service");
        login.metodos.capturarEvidencia(); // Captura evidência da mensagem de erro
    }

    @When("não preencher os campos de login")
    public void nao_preencher_os_campos_de_login() {
        login.login("", "");
        login.metodos.capturarEvidencia(); // Captura evidência após envio de campos em branco
    }

    @Then("Exibir mensagem solicitando preenchimento dos campos")
    public void exibir_mensagem_solicitando_preenchimento_dos_campos() {
        login.validaMensagemErro("Epic sadface: Username is required");
        login.metodos.capturarEvidencia(); // Captura evidência da mensagem de erro
    }
}
