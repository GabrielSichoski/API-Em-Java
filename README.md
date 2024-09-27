# Projeto API em Java

## Desenvolvedor

- Gabriel Sichoski Rodrigues

## Descrição

Este é um projeto de API desenvolvido como parte do trabalho acadêmico AC2. A API é construída usando Java com Spring Boot e permite o gerenciamento de cursos e alunos, incluindo a associação de alunos a cursos.

## Funcionalidades

- Criar, listar, atualizar e deletar alunos.
- Criar, listar, atualizar e deletar cursos.
- Associar alunos a cursos.

## Tecnologias Utilizadas

- Java
- Spring Boot
- JPA (Java Persistence API)
- Postgres (Banco de dados)
- Jakarta Bean Validation

## EndPoints

### Alunos

- GET /alunos: Lista todos os alunos.
- GET /alunos/{id}: Busca um aluno pelo ID.
- POST /alunos: Cria um novo aluno.
- PUT /alunos/{id}: Atualiza um aluno existente.
- DELETE /alunos/{id}: Deleta um aluno pelo ID.

### Cursos

- GET /cursos: Lista todos os cursos.
- GET /cursos/{id}: Busca um curso pelo ID.
- POST /cursos: Cria um novo curso.
- PUT /cursos/{id}: Atualiza um curso existente.
- DELETE /cursos/{id}: Deleta um curso pelo ID.

### Associação entre curso e aluno

- POST /alunos/{idAluno}/cursos/{idCurso}: Associa um aluno a um curso.

## Validações

### Alunos Validações

- Nome: Não pode estar em branco.
- Email: Não pode estar em branco e deve ser um email válido.
- RA: Não pode estar em branco.
- Número de Celular: Não pode estar em branco.

### Cursos Validações

- Nome: Não pode estar em branco.
- Descrição: Não pode estar em branco.


## Prints do Funcionamento 

### Post e Get Novo Curso

![image](https://github.com/GabrielSichoski/AC2WebProjeto/assets/104863390/e717eba4-a90c-4142-980a-6d8ab5aeb8e7)

### Associar Aluno com Curso (Post e get)

![image](https://github.com/GabrielSichoski/AC2WebProjeto/assets/104863390/34ec5da7-348b-404b-921f-c7632ad1d3a8)

![image](https://github.com/GabrielSichoski/AC2WebProjeto/assets/104863390/39efe3c2-506d-4d77-a0c1-4c0819300cf2)


### Varios Alunos Associados ao mesmo Curso

![image](https://github.com/GabrielSichoski/AC2WebProjeto/assets/104863390/bc8ca2d5-0ee0-4a65-a603-17813ef9c028)

### Bean Validation

![image](https://github.com/GabrielSichoski/AC2WebProjeto/assets/104863390/4a2c57c9-e584-4ff2-abe8-0b9e890e2ab7)



  
