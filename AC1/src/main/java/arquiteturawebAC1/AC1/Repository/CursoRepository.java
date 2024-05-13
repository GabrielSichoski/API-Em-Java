package arquiteturawebAC1.AC1.Repository;

import arquiteturawebAC1.AC1.Model.Curso;
import arquiteturawebAC1.AC1.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    List<Curso> findByNome(String nome);   
    List<Aluno> findAlunosById(Long cursoId);
}
