package arquiteturawebAC1.AC1.Interface;

import java.util.List;
import java.util.Optional;
import arquiteturawebAC1.AC1.Model.Curso;

public interface CursoInterface {
    List<Curso> listarTodos();
    Optional<Curso> buscarPorId(Long id);
    Curso salvar(Curso curso);
    Curso atualizar(Long id, Curso cursoAtualizado);
    void deletar(Long id);
}
