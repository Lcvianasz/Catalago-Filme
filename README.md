# 🎬 Catálogo de Filmes – Backend

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de um catálogo de filmes e seus gêneros.  
Projeto criado com fins educacionais e de portfólio, seguindo boas práticas de arquitetura backend.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Lombok
- MySQL
- Maven

---

## 📂 Estrutura do Projeto

src/main/java/com/example/catalogofilmes
├── controller
│ ├── FilmeController.java
│ └── GeneroController.java
├── service
│ ├── FilmeService.java
│ └── GeneroService.java
├── repository
│ ├── FilmeRepository.java
│ └── GeneroRepository.java
├── model
│ ├── Filme.java
│ └── Genero.java
└── CatalogoFilmesApplication.java


---

## 🧠 Modelo de Domínio

### 🎬 Filme
- id
- titulo
- anoLancamento
- gêneros (ManyToMany)

### 🎭 Gênero
- id
- nome
- filmes (ManyToMany)

---

## ⚙️ Configuração do Banco de Dados

### 1️⃣ Criar banco no MySQL

```sql
CREATE DATABASE catalogo_filmes
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
