# Projeto Agrotech


<details>
<summary><strong>👨‍💻 O que foi desenvolvido</strong></summary><br />
AgroTech, uma empresa especializada em tecnologias para melhorar a eficiência no cultivo de plantações. Isso visa reduzir o desperdício de recursos em geral e de alimentos em específico, fazendo um uso mais responsável da terra disponível para plantio.

O primeiro produto dessa empresa será o Agrix, um sistema que permitirá a gestão e o monitoramento das fazendas participantes,. Esse produto será desenvolvido em fases.
  
 </details>

<details>
  <summary><strong>:memo: Tecnologias Utilizadas:</strong></summary><br />

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Docker
- JUnit
- Mockito

</details> 

<details>
  <summary><strong>:memo: Habilidades Desenvolvidas:</strong></summary><br />

- **Arquitetura em Camadas**
- **Injeção de Dependência**
- **Spring Data JPA**
- **Manipulação de Datas**
- **Spring Security**
- **Execução em Docker**
- **Testes Unitários**

</details>

<details>
Nesse modelos, temos as seguintes tabelas:
- `farm`: representa uma fazenda
- `crop`: representa uma plantação, e está em relacionamento `n:1` ("muitos para um") com a tabela `farm`
- `fertilizer` : esta nova tabela representa um fertilizante, e está em um relacionamento n:n ("muitos para muitos") com a tabela crop. Esse relacionamento é realizado através da tabela crop_fertilizer.
</details>

