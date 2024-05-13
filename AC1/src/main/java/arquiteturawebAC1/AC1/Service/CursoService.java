package arquiteturawebAC1.AC1.Service;

import java.util.List;
import java.util.Optional;

import arquiteturawebAC1.AC1.Model.Curso;
import arquiteturawebAC1.AC1.Model.Aluno;

public interface CursoService {
    List<Curso> listarTodos();
    Optional<Curso> buscarPorId(Long id);
    Curso salvar(Curso curso);
    Curso atualizar(Long id, Curso cursoAtualizado);
    void deletar(Long id);
    Curso criarCurso(Curso curso);
    List<Aluno> buscarAlunosDoCurso(Long idCurso);
    List<Curso> listarCursos();
    Curso buscarCursoPorId(Long id);
    Curso atualizarCurso(Long id, Curso cursoAtualizado);
    void deletarCurso(Long id);
    Aluno registrarAlunoNoCurso(Long idCurso, Long aluno);
}
