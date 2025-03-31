

# Automação de Testes com Cucumber em Java

## Descrição do Projeto
Este projeto foi desenvolvido para validar testes automatizados utilizando a linguagem **Java** e o framework **Cucumber**, rodando na IDE **Eclipse**. O foco está na automação de funcionalidades de login, com diferentes cenários de teste, e inclui a captura automática de evidências (prints de tela).

### Funcionalidades e Cenários Validados:
1. **Login com sucesso:**  
   Valida a autenticação bem-sucedida com credenciais corretas.
   
2. **Login com dados inválidos:**  
   Garante que o sistema exibe mensagens de erro apropriadas ao inserir dados incorretos.

3. **Login com dados em branco:**  
   Certifica que o sistema solicita o preenchimento obrigatório dos campos.

### Coleta de Evidências
Uma funcionalidade principal do projeto é a captura de evidências automáticas (prints de tela) dos passos realizados durante os testes. As evidências são armazenadas automaticamente em um diretório específico chamado `evidencias`, que é gerado na raiz do projeto.

---

## Tecnologias Utilizadas
- **Linguagem:** Java  
- **Framework de Teste:** Cucumber  
- **IDE:** Eclipse  
- **Ferramentas Auxiliares:** Selenium WebDriver e Apache Commons IO  

---

## Estrutura do Projeto
```plaintext
src/
├── drivers/
│   └── Drivers.java           # Classe base para inicializar o WebDriver
├── metodos/
│   └── Metodos.java           # Classe com os métodos utilitários, como capturar evidências
├── features/
│   └── Login.feature          # Arquivo de especificação dos cenários de teste
├── steps/
│   └── LoginSteps.java        # Implementação dos passos do Cucumber para os cenários
