package arquiteturawebAC1.AC1.Interface;
import java.util.List;
import arquiteturawebAC1.AC1.Model.Aluno;

public interface AlunoInterface {
    List<Aluno> listarTodos();
    Aluno buscarPorId(Long id);
    Aluno salvar(Aluno aluno);
    Aluno atualizar(Long id, Aluno alunoAtualizado);
    void deletar(Long id);
}
