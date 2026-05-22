# ONG de Adoção de Animais — API RESTful

## Dados do Aluno
**Nome:** Igor  
**Instituição:** SERRATEC — Turma 37  
**Tema:** ONG de Adoção de Animais  

---

## Descrição do Projeto

API RESTful desenvolvida com Java e Spring Boot para gerenciar uma ONG de adoção de animais. O sistema permite cadastrar animais disponíveis para adoção, pessoas interessadas, endereços, características físicas dos animais, registrar interesses de adoção e apadrinhar animais.

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Swagger / OpenAPI (springdoc)
- Bean Validation (Jakarta)

---

## Pré-requisitos

- Java 17+
- PostgreSQL instalado e rodando
- Maven 3.8+

---

## Como Executar

**1. Criar o banco de dados no PostgreSQL:**
```sql
CREATE DATABASE ong_db;
```

**2. Configurar credenciais em `src/main/resources/application.properties`:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ong_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

**3. Rodar a aplicação:**
```bash
mvn spring-boot:run
```

**4. Acessar o Swagger UI:**
```
http://localhost:8080/swagger-ui.html
```

---

## Estrutura de Pacotes

```
src/main/java/org/serratec/ONG/
├── Controller/     — Recebe as requisições HTTP
├── Service/        — Lógica de negócio
├── Repository/     — Comunicação com o banco via JPA
├── Domain/         — Entidades JPA
├── DTO/            — Objetos de transferência (Request / Response)
├── Exception/      — Exceções customizadas e handler global
└── Config/         — Configuração do Swagger
```

---

## Relacionamentos JPA

| Tipo | Entidades | Descrição |
|------|-----------|-----------|
| `@OneToOne` | Animal ↔ Caracterisca | Cada animal tem uma característica física |
| `@OneToMany` | Pessoa → Endereco | Uma pessoa pode ter vários endereços |
| `@OneToMany` | Pessoa → InteresseAdocao | Uma pessoa pode registrar vários interesses |
| `@ManyToMany` | Pessoa ↔ Animal | Uma pessoa pode apadrinhar vários animais |

---

## Endpoints

### Animais — `/animais`
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/animais` | Lista todos os animais |
| GET | `/animais/{id}` | Busca animal por ID |
| POST | `/animais` | Cadastra novo animal |
| PUT | `/animais/{id}` | Atualiza animal |
| DELETE | `/animais/{id}` | Remove animal |

**Body POST/PUT:**
```json
{
  "nome": "Rex",
  "especie": "Cachorro",
  "raca": "Labrador",
  "idade": 3,
  "dataChegada": "2025-01-15"
}
```

### Pessoas — `/pessoas`
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/pessoas` | Lista todas as pessoas |
| GET | `/pessoas/{id}` | Busca pessoa por ID |
| POST | `/pessoas` | Cadastra nova pessoa |
| PUT | `/pessoas/{id}` | Atualiza pessoa |
| DELETE | `/pessoas/{id}` | Remove pessoa |
| POST | `/pessoas/{idPessoa}/apadrinhar/{idAnimal}` | Pessoa apadrinha animal |

**Body POST/PUT:**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "telefone": "(21) 98765-4321"
}
```

### Endereços — `/enderecos`
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/enderecos` | Lista todos os endereços |
| GET | `/enderecos/{id}` | Busca endereço por ID |
| POST | `/enderecos` | Cadastra novo endereço |
| PUT | `/enderecos/{id}` | Atualiza endereço |
| DELETE | `/enderecos/{id}` | Remove endereço |

**Body POST/PUT:**
```json
{
  "pessoaId": 1,
  "logradouro": "Rua das Flores",
  "complemento": "Apto 201",
  "bairro": "Centro",
  "cidade": "Nova Friburgo",
  "uf": "RJ",
  "cep": "28610-000"
}
```

### Características — `/caracteristicas`
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/caracteristicas` | Lista todas as características |
| GET | `/caracteristicas/{id}` | Busca por ID |
| POST | `/caracteristicas` | Cadastra características de um animal |
| PUT | `/caracteristicas/{id}` | Atualiza características |
| DELETE | `/caracteristicas/{id}` | Remove características |

**Body POST/PUT:**
```json
{
  "animalId": 1,
  "porte": "Grande",
  "peso": 30.5,
  "altura": 0.70,
  "pelo": "curto",
  "idade": 5
}
```

### Interesses de Adoção — `/interesses-adocao`
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/interesses-adocao` | Lista todos os interesses |
| GET | `/interesses-adocao/{id}` | Busca por ID |
| POST | `/interesses-adocao` | Registra interesse |
| PUT | `/interesses-adocao/{id}` | Atualiza interesse |
| DELETE | `/interesses-adocao/{id}` | Remove interesse |

**Body POST/PUT:**
```json
{
  "pessoaId": 1,
  "animalId": 2,
  "dataInteresse": "2025-05-01",
  "descricao": "Tenho espaço e amor para dar."
}
```

---

## Tratamento de Erros

A API retorna erros padronizados:

```json
{
  "status": 404,
  "mensagem": "Animal com ID 5 não encontrado",
  "timestamp": "2025-05-22T10:30:00",
  "erros": null
}
```

| Status | Situação |
|--------|----------|
| 400 | Dados inválidos (falha na validação) |
| 404 | Recurso não encontrado |
| 409 | Conflito de dados (ex: email duplicado) |
| 500 | Erro interno inesperado |
