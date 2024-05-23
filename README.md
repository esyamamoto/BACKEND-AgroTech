# Projeto Agrotech


<details>
<summary><strong>👨‍💻 O que foi desenvolvido</strong></summary><br />
AgroTech, uma empresa especializada em tecnologias para melhorar a eficiência no cultivo de plantações. Isso visa reduzir o desperdício de recursos em geral e de alimentos em específico, fazendo um uso mais responsável da terra disponível para plantio.

O primeiro produto dessa empresa será o Agrix, um sistema que permitirá a gestão e o monitoramento das fazendas participantes,. Esse produto será desenvolvido em fases.
  
 </details>

<details>
  <summary><strong>:memo: Habilidades</strong></summary><br />

  Neste projeto:
- Aplicar o conhecimento do ecossistema Spring para criar rotas da API.
- Aplicar a injeção de dependência para conectar as camadas de controle, serviço e persistência.
- Utilizar o Spring Data JPA para implementar entidades e repositórios para a persistência em banco de dados.
- Implementar gerenciamento de erros no Spring Web.
- Criar o Dockerfile para configurar a aplicação para execução no Docker.
- Aplicar o conhecimento sobre Spring Security para adicionar autenticação ao projeto.
- Garantir que diferentes rotas atenda a regras específicas de autorização.
- Utilizar campos de data nas rotas da API e no banco de dados
- Criar testes unitários para garantir a qualidade e funcionamento correto da implementação, com cobertura de código adequada.

</details>

<details>
Nesse modelos, temos as seguintes tabelas:
- `farm`: representa uma fazenda
- `crop`: representa uma plantação, e está em relacionamento `n:1` ("muitos para um") com a tabela `farm`
- `fertilizer` : esta nova tabela representa um fertilizante, e está em um relacionamento n:n ("muitos para muitos") com a tabela crop. Esse relacionamento é realizado através da tabela crop_fertilizer.
</details>

