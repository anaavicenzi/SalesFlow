# SalesFlow

Projeto simples de exemplo para gerenciar categorias, produtos, fornecedores, clientes, pedidos e itens de pedido.

O que faz

- Expondo uma API REST com endpoints para CRUD de:
  - Categoria
  - Produto
  - Fornecedor
  - Cliente
  - Pedido
  - ItemPedido
- Regras importantes:
  - Não é possível excluir uma categoria que tenha produtos associados.
  - Não é possível excluir um cliente que tenha pedidos.
  - Não é possível excluir um fornecedor se houver pedidos atrelados a produtos dele.
  - Não é possível excluir um produto que esteja em pedidos.

Como rodar (modo rápido)

Pré-requisitos:
- Java 17+ instalado
- Maven wrapper incluído no projeto (já existe `mvnw.cmd`)
- PostgreSQL acessível conforme `src/main/resources/application.properties` ou ajuste as propriedades para seu banco

Passos:
1. Abra o PowerShell na pasta do projeto (onde está `mvnw.cmd`).
2. Ajuste `src/main/resources/application.properties` se precisar mudar a URL/usuário/senha do banco.
3. Inicie a aplicação:

```powershell
.\mvnw.cmd spring-boot:run
```

4. A aplicação vai iniciar na porta padrão (8080). Verifique os logs para ver se o Hibernate criou/atualizou as tabelas (propriedade `spring.jpa.hibernate.ddl-auto=update`).

Comandos úteis:
- Compilar empacotar:

```powershell
.\mvnw.cmd package
```

- Rodar testes:

```powershell
.\mvnw.cmd test
```

Endpoints (exemplos)
- Categorias: `/categorias` (GET, POST), `/categorias/{id}` (GET, PUT, DELETE)
- Produtos: `/produtos` (GET, POST), `/produtos/{id}` (GET, PUT, DELETE)
- Fornecedores: `/fornecedores` (POST), `/fornecedores/{id}` (GET, PUT, DELETE)
- Clientes: `/clientes` (GET, POST), `/clientes/{id}` (GET, PUT, DELETE)
- Pedidos: `/pedidos` (GET, POST), `/pedidos/{id}` (GET, PUT, DELETE)
- Itens de pedido: `/itens-pedido` (GET, POST), `/itens-pedido/{id}` (GET, PUT, DELETE)

Testando endpoints

Use Postman, curl ou httpie. Exemplo com curl para listar categorias:

```powershell
curl http://localhost:8080/categorias
```

Observações finais

- As validações de exclusão estão implementadas nos serviços e retornam HTTP 400 com mensagem quando a operação é impedida.
- Se preferir, posso adicionar um script de inicialização com dados de exemplo (seed) ou testes automatizados.

Limpeza e dependências

- Removi dependências não usadas do `pom.xml` (H2 e Lombok) para simplificar o projeto — a aplicação usa PostgreSQL conforme `application.properties`.
- O arquivo `OpenApiConfig.java` foi removido/limpo porque o Springdoc OpenAPI starter auto-configura a documentação. A documentação Swagger estará disponível em `/swagger-ui/index.html` após iniciar a aplicação.
