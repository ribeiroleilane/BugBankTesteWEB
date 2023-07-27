# Teste de Transferência entre Contas - Selenium e JUnit

Este repositório contém um conjunto de testes automatizados para verificar a funcionalidade de transferência de valores entre contas no BugBank, um sistema bancário fictício. Os testes foram desenvolvidos usando a linguagem Java, o framework de automação Selenium WebDriver e o framework de testes JUnit. Além disso, os relatórios dos testes foram gerados com o auxílio do ExtentReports.

## Pré-requisitos

Antes de executar os testes, certifique-se de ter instalado os seguintes componentes:

1.  Java Development Kit (JDK): Certifique-se de ter o JDK instalado no seu sistema e configurado corretamente.
    
2.  Maven: O Maven é usado para gerenciar as dependências do projeto e para executar os testes. Certifique-se de ter o Maven instalado e configurado no seu sistema.
    
3.  Drivers do Selenium: É necessário ter os drivers do Selenium adequados para o navegador que deseja testar. Neste projeto, estamos usando o ChromeDriver, portanto, certifique-se de ter a versão adequada do ChromeDriver instalada e adicionada ao PATH do sistema.
    

## Configuração do Projeto

1.  Clone o repositório em sua máquina local.
    
2.  Importe o projeto em sua IDE favorita como um projeto Maven.
    
3.  Certifique-se de que todas as dependências do Maven foram baixadas e configuradas corretamente.
    

## Executando os Testes

1.  Abra a classe `ValidarTransferencia` no pacote `teste`.
    
2.  Execute a classe como um teste JUnit.
    
3.  Os testes serão executados no navegador Chrome e você poderá acompanhar o progresso no console.
    
4.  Após a conclusão dos testes, um relatório detalhado será gerado e salvo em `test-output/extent-report.html`.
    

## Entendendo a Estrutura do Projeto

-   `driver`: Contém a classe `Drivers`, que é uma classe base para inicializar o driver do Selenium.
    
-   `elementos`: Contém a classe `Elementos`, que contém os elementos da página web usados nos testes.
    
-   `homePage`: Contém a classe `CriarConta`, que possui informações para criar contas fictícias de teste.
    
-   `metodos`: Contém a classe `Metodos`, que possui métodos reutilizáveis para realizar ações comuns durante os testes.
    
-   `teste`: Contém a classe `ValidarTransferencia`, que contém os testes automatizados para a funcionalidade de transferência entre contas.
    
-   `test-output`: Contém o relatório de execução dos testes, `extent-report.html`, gerado pelo ExtentReports.
    

## Observações Importantes

-   Os testes automatizados são executados em um ambiente de teste, portanto, não impactarão dados reais.
    
-   Certifique-se de que as URLs dos sistemas de teste estejam corretas e que os dados fictícios fornecidos estejam atualizados para refletir o ambiente de teste.
    
-   Se necessário, atualize as informações de conta de teste e outras configurações relevantes antes de executar os testes em um novo ambiente.
    

## Contribuindo

Se você encontrar algum problema ou quiser adicionar novos cenários de teste, fique à vontade para contribuir com este projeto enviando uma solicitação pull. Sua contribuição é muito bem-vinda!
