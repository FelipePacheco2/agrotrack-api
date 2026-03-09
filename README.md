# 🚜 AgroTrack API

[![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)](https://maven.apache.org/)

## 📝 Visão Geral
O **AgroTrack** é uma solução de Back-end robusta desenvolvida para otimizar o gerenciamento e a pesagem no setor agrícola. O sistema foi projetado para garantir a integridade dos dados de pesagem e facilitar o rastreamento operacional, servindo como uma ferramenta estratégica para o controle de produção.

acessa a documentação: https://drive.google.com/drive/folders/1SXmj6fQdrscj6cIBvDEeROnl3WwI_nfJ?usp=drive_link

## 🛠️ Stack Tecnológica
* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.x
* **Persistência:** Spring Data JPA
* **Banco de Dados:** PostgreSQL (ou MySQL)
* **Segurança/Testes:** JUnit 5 & Mockito (Garantindo a confiabilidade das regras de negócio)
* **Documentação:** Swagger/OpenAPI

## 🏗️ Estrutura do Projeto
O projeto segue o padrão de camadas para facilitar a manutenção e escalabilidade:
- `controller`: Exposição dos endpoints REST.
- `service`: Implementação das regras de negócio e validações.
- `repository`: Interface de comunicação com o banco de dados.
- `model`: Entidades que representam o domínio do sistema.

## 🚀 Como Executar
1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/agrotrack-api.git](https://github.com/seu-usuario/agrotrack-api.git)
   
2. Configure o banco de dados:
   Ajuste as credenciais no arquivo src/main/resources/application.properties.

3. Build e Run:

   ```Bash
   mvn clean install
   mvn spring-boot:run
   ```
## 🛡️ Testes
   Para rodar a suíte de testes unitários com Mockito:
   ```Bash
   mvn test
