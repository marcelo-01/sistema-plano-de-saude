# Sistema Plano de Saúde

API REST para manter o cadastro de beneficiários de um plano de saúde, desenvolvida com Spring Boot.

---

## Tecnologias

- **Java 21**
- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **Spring Validation**
- **Spring Security**
- **PostgreSQL**
- **Lombok**
- **Docker / Docker Compose**

---

## Pré-requisitos

- Java 21+
- Maven
- Docker e Docker Compose

---

## Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/marcelo-01/sistema-plano-de-saude.git
cd sistema-plano-de-saude
```

### 2. Suba o banco de dados com Docker

```bash
docker-compose up -d
```

Isso irá subir um container PostgreSQL com as seguintes configurações:

| Propriedade | Valor               |
|-------------|---------------------|
| Host        | localhost           |
| Porta       | 5432                |
| Banco       | sistemaplanodesaude |
| Usuário     | postgres            |
| Senha       | postgres            |

### 3. Rode a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

---

## Endpoints

| Método   | Endpoint                                      | Descrição                                  |
|----------|-----------------------------------------------|--------------------------------------------|
| `POST`   | `/api/public/beneficiario`                    | Cadastrar beneficiário com documentos      |
| `GET`    | `/api/public/beneficiario`                    | Listar todos os beneficiários              |
| `GET`    | `/api/public/beneficiario/documentos/{id}`    | Listar documentos de um beneficiário       |
| `PATCH`  | `/api/public/beneficiario/{id}`               | Atualizar dados de um beneficiário         |
| `DELETE` | `/api/public/beneficiario/{id}`               | Deletar um beneficiário                    |

---

## Exemplos de requisição

### Cadastrar beneficiário

`POST /api/public/beneficiario`

```json
{
  "nome": "João Silva",
  "telefone": "11999999999",
  "dataNascimento": "1990-05-15",
  "documentos": [
    {
      "tipoDocumento": "RG",
      "descricao": "RG do João Silva"
    },
    {
      "tipoDocumento": "CPF",
      "descricao": "CPF do João Silva"
    }
  ]
}
```

**Resposta (201 Created):**
```json
{
  "id": "636e1398-21d8-422d-a763-b28c1fc80b29",
  "nome": "João Silva"
}
```

---

### Listar beneficiários

`GET /api/public/beneficiario`

**Resposta (200 OK):**
```json
[
  {
    "id": "636e1398-21d8-422d-a763-b28c1fc80b29",
    "nome": "João Silva",
    "telefone": "11999999999",
    "dataNascimento": "1990-05-15",
    "documentos": [
      {
        "id": "83842dcf-b99f-4775-9549-c0e209826169",
        "tipoDocumento": "RG",
        "descricao": "RG do João Silva"
      }
    ]
  }
]
```

---

### Listar documentos de um beneficiário

`GET /api/public/beneficiario/documentos/{idBeneficiario}`

**Resposta (200 OK):**
```json
[
  {
    "id": "83842dcf-b99f-4775-9549-c0e209826169",
    "tipoDocumento": "RG",
    "descricao": "RG do João Silva"
  }
]
```

---

### Atualizar beneficiário

`PATCH /api/public/beneficiario/{idBeneficiario}`

```json
{
  "nome": "João Silva Atualizado",
  "telefone": "11988888888",
  "dataNascimento": "1990-05-15"
}
```

---

### Deletar beneficiário

`DELETE /api/public/beneficiario/{idBeneficiario}`

**Resposta: 200 OK**

---

## Respostas de erro

| Status | Descrição                                            |
|--------|------------------------------------------------------|
| 400    | Dados inválidos na requisição                        |
| 404    | Beneficiário não encontrado                          |
| 409    | Já existe um beneficiário cadastrado com esses dados |

**Formato do erro:**
```json
{
  "status": 404,
  "message": "Não existe um beneficiário com esse Id.",
  "timestamp": "2024-01-15T10:30:00"
}
```

---

## Estrutura do banco de dados

```
beneficiarios
├── id (UUID, PK)
├── nome (VARCHAR 100)
├── telefone (VARCHAR 11)
├── data_nascimento (DATE)
├── data_inclusao (DATE)
└── data_atualizacao (DATE)

documento
├── id (UUID, PK)
├── tipo_documento (VARCHAR 100)
├── descricao (VARCHAR 255)
├── data_inclusao (DATE)
├── data_atualizacao (DATE)
└── id_beneficiario (UUID, FK → beneficiarios.id)
```

---

## Estrutura do projeto

```
src/
└── main/
    └── java/
        └── com/marcelo/sistemaplanodesaude/
            ├── beneficiarios/
            │   ├── application/
            │   │   ├── api/          # Controller e interface da API
            │   │   └── service/      # Service e interface do Service
            │   ├── domain/           # Entidade Beneficiario
            │   └── repository/       # BeneficiarioRepository
            └── documentos/
                ├── domain/           # Entidade Documento
                ├── dto/              # DTOs de Request e Response
                └── repository/       # DocumentoRepository
```
