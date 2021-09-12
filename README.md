# Projeto_catalogo

### API de catalogo interno para consulta e busca de produtos por vendedores de acordo com a permissão de acesso.

## Tecnologias Utilizadas

### Java
### Spring Boot
### Maven
### JWT


# Como executar o projeto:

#### Pré requisito - Java 11

#### Clonar repositório: 
    https://github.com/CarolLopesFavaretto/Projeto_catalogo.git  (branch master)

#### Entrar na pasta do projeto
    cd Projeto_Catalogo

#### Executar seguinte comando para buildar e gerar o jar:
    mvn clean install

#### Acessar a pasta target:
    cd target
    
#### Executar seguinte comando para iniciar a aplicação:
    java -jar Projeto-Catalogo-0.0.1-SNAPSHOT.jar

#### Swagger para chamadas de endpoints da API:
    http://localhost:8080/swagger-ui/

#### Collection do Postaman disponibilizado na raiz do projeto:
    Projeto-Catalogo.postman_collection.json
    
## Detalhes da solução:
#### Desenvolvimento da aplicação em Java
#### Utilização de dependencias Security para a implementação e geração de token JTW para autenticação do User;
#### Utilização da dependecia Google Code Gson para leitura dos arquivos Json em Java;
#### Utilizei como objetivo manipular os arquivos e informações atraves de services.

## Pontos a Melhorar:
#### Teste Unitários/Integrados;
#### Melhoria na construção do service de Product, para deixar menos complexo eliminando for's e if's;
#### Implementar consulta de products considerando a role, pois está apenas considerando a organization.
