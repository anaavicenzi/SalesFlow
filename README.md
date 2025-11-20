# SalesFlow

## Como rodar

Pré-requisitos:
- Java 17+
- `mvnw.cmd` presente na raiz do projeto
- Banco de dados configurado conforme `src/main/resources/application.properties` (ajuste URL/usuário/senha se necessário)

Rodando em modo de desenvolvimento (PowerShell):

```powershell
cd C:\source\repos\SalesFlow
.\mvnw.cmd spring-boot:run
```

A aplicação inicia por padrão na porta 8080.

Rodando o JAR após empacotar:

```powershell
cd C:\source\repos\SalesFlow
.\mvnw.cmd package
java -jar target\*.jar
```

Acessando o Swagger UI:

- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

Se você alterou a porta (`server.port`) ou o `context-path` em `application.properties`, ajuste as URLs acima de acordo.
