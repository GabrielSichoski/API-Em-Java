package arquiteturawebAC1.AC1.Service;

import java.util.List;

import arquiteturawebAC1.AC1.Model.Aluno;

public interface AlunoService {
    List<Aluno> listarTodos();
    Aluno buscarPorId(Long id);
    List<Aluno> buscarPorNome(String nome);
    List<Aluno> buscarPorEmail(String email);
    List<Aluno> buscarPorNumeroCel(String numeroCel);
    List<Aluno> buscarPorRA(String ra);
    Aluno salvar(Aluno aluno);
    Aluno atualizar(Long id, Aluno alunoAtualizado);
    void deletar(Long id);
    void registrarAlunoEmCurso(Long idAluno, Long idCurso);
}
