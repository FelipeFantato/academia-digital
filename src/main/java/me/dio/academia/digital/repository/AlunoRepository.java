package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

  /**
   *
   * @param dataDeNascimento: data de nascimento dos alunos
   * @return lista com todos os alunos com a data de nascimento passada como parâmetro da função
   */
  List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);
  @Query("SELECT a FROM Aluno a WHERE a.nome = :nome")
  List<Aluno> findByNome(@Param("nome") String nome);

  //  Agora, você pode chamar o método findByNome no AlunoRepository para encontrar todos os alunos com um nome específico.
  //  Por exemplo:List<Aluno> alunosComNomeIgual = alunoRepository.findByNome("João");
}
