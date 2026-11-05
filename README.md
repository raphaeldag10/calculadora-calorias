# CalcCalorias

Projeto Java com Spring Boot, Maven e Oracle Database.

## Configuracao

1. Instale um JDK 21 ou superior.
2. Abra o arquivo `CalcCalorias/pom.xml` como projeto Maven no IntelliJ.
3. Copie `CalcCalorias/src/main/resources/application.properties.example` para `application.properties` na mesma pasta.
4. Configure as variaveis de ambiente `DB_URL`, `DB_USERNAME` e `DB_PASSWORD` na configuracao de execucao do IntelliJ. Use uma URL JDBC Oracle em `DB_URL`.

O arquivo `application.properties` fica fora do Git para manter os dados de acesso locais. Tambem e possivel preencher os valores diretamente nesse arquivo local.

## Execucao

Execute a classe `com.example.calccalorias.CalcCaloriasApplication` no IntelliJ.

No terminal do Windows, entre na pasta interna `CalcCalorias` e execute `./mvnw.cmd spring-boot:run`.

Para compilar e gerar o JAR sem executar o teste de integracao com Oracle, use `./mvnw.cmd clean package -DskipTests` na mesma pasta.
