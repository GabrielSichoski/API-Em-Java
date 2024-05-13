package arquiteturawebAC1.AC1.Repository;

import arquiteturawebAC1.AC1.Model.Aluno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findById(long id);
       
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
    
    List<Aluno> findByEmail(String email);
    
    List<Aluno> findByNumeroCel(String numeroCel);
    
    List<Aluno> findByRA(String ra);
}