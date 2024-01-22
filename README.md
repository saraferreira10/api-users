# Projeto CRUD API com Spring, MySQL e Java 🚀

## Descrição do Projeto
Este projeto é uma API para realizar operações CRUD (Create, Read, Update, Delete) em um banco de dados MySQL utilizando o framework Spring e a linguagem de programação Java. A aplicação fornece endpoints para gerenciar entidades, como **Usuários** e **Departamentos**, dependendo das necessidades do seu projeto.

## Tecnologias Utilizadas
- **Spring Boot**: Framework Java para criação de aplicativos Spring.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional.
- **Java**: Linguagem de programação utilizada para desenvolver a aplicação.

## Configuração do Ambiente de Desenvolvimento
1. Certifique-se de ter o Java e o Maven instalados em sua máquina.
2. Configure um banco de dados MySQL e ajuste as configurações no arquivo `application.properties` conforme necessário.
3. Clone este repositório em sua máquina local.

## Configuração do Banco de Dados
1. Crie o banco de dados do projeto.
2. Atualize as configurações do banco de dados no arquivo `application.properties` com suas credenciais.

## Execução da Aplicação
1. Navegue até o diretório do projeto.
2. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.
3. Acesse `http://localhost:8080` para interagir com a API.

## Endpoints Disponíveis
A API possui os seguintes endpoints:

### Usuários
- `GET /users`: Obter todos os usuários.
- `GET /users/{id}`: Obter um usuário específico por ID.
- `POST /users`: Criar um novo usuário.
- `PUT /users/{id}`: Atualizar um usuário existente.
- `DELETE /users/{id}`: Excluir um usuário.

### Departamentos
- `GET /departments`: Obter todos os departamentos.
- `GET /departments/{id}`: Obter um departamento específico por ID.
- `POST /departments`: Criar um novo departamento.
- `PUT /departments/{id}`: Atualizar um departamento existente.
- `DELETE /departments/{id}`: Excluir um departamento.

Adapte os endpoints conforme necessário para o seu domínio específico.

## Exemplo de Requisição JSON (POST /users) 📝
```json
{
    "nome": "Maria Abreu",
    "email": "maria.a@gmail.com",
    "department": {
        "id": 1
    }
}
