# 🏗️ Desafio Fullstack Integrado
🚨 Instrução Importante (LEIA ANTES DE COMEÇAR)

## 🎯 Objetivo

    Resposta ao teste integrado contendo camadas (DB, EJB, Backend, Frontend) e  corrigindo
    bug em EJB

## 📦 Estrutura
    Abrir documento
      EstruturaProjetoTesteIntegrado.txt

## ✅ Tarefas do candidato
1. Executar db/schema.sql e db/seed.sql
    Banco de dados carregado em memória
      target\classes\db\schema.sql

2. Corrigir bug no BeneficioEjbService

3. Implementar backend CRUD + integração com EJB
    src\main\java\com\example\TESTEINTEGRADO\controller\
      BeneficioController.java
      BeneficioEjbService.java

4. Desenvolver frontend Angular consumindo backend
    Pagina index.HmTL
      target\classes\static\index.html

  Acessar link abaixo:
      http://localhost:8080/index.Html

5. Implementar testes
      src\test\java\com\example\
        BeneficioControllerTest.java
        BeneficioServiceTest.java 

      Executar comandos abaixo no terminal do windows ou na IDE desejada.  
        mvn test "-Dtest=BeneficioServiceTest"
        mvn test "-Dtest=BeneficioControllerTest"

6. Documentar (Swagger, README)

7. Enviar link para recrutadora com seu repositório para análise
    https://github.com/h2ciclo-H2/RESPOSTATESTEINTEGRADO.git
