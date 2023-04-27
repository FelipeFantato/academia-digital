Novas funcionalidades para o projeto Academia Digital


Este projeto trata-se de um sistema de gestão de alunos de uma academia, desenvolvido utilizando o Spring Boot Framework. Foram adicionadas duas novas funcionalidades ao projeto, que serão detalhadas a seguir.

Busca por alunos matriculados em um bairro específico
Para essa funcionalidade, foi criado um método personalizado no repositório de matrículas, que utiliza a anotação @Query do JPA para executar uma consulta SQL nativa. A consulta retorna uma lista de matrículas cujos alunos residem em um bairro específico. O método recebe como parâmetro o nome do bairro e retorna uma lista de matrículas. Esse método é utilizado no controller da classe Matricula para buscar as matrículas de alunos que moram em um bairro específico.

Busca de alunos com a mesma data de nascimento
Para essa funcionalidade, foi criado um método personalizado no repositório de alunos que utiliza a anotação @Query do JPA para buscar os alunos com a mesma data de nascimento. O método recebe como parâmetro a data de nascimento e retorna uma lista de alunos. Esse método é utilizado no controller da classe Aluno para buscar todos os alunos que nasceram na mesma data.

Além disso, também foi adicionada uma nova funcionalidade do Spring Boot para o projeto, a validação dos campos dos formulários. Essa funcionalidade é ativada pela anotação @Valid, que verifica se os campos do formulário passado
