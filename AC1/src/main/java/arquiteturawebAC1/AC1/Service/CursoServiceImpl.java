package arquiteturawebAC1.AC1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arquiteturawebAC1.AC1.Model.Curso;
import arquiteturawebAC1.AC1.Model.Aluno;
import arquiteturawebAC1.AC1.Repository.AlunoRepository;
import arquiteturawebAC1.AC1.Repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> buscarPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso atualizar(Long id, Curso cursoAtualizado) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            curso.setNome(cursoAtualizado.getNome());
            curso.setDescricao(cursoAtualizado.getDescricao());
            return cursoRepository.save(curso);
        } else {
            throw new RuntimeException("Curso não encontrado com o ID: " + id);
        }
    }

    @Override
    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Aluno> buscarAlunosDoCurso(Long idCurso) {
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            return curso.getAlunos();
        } else {
            throw new RuntimeException("Curso não encontrado com o ID: " + idCurso);
        }
    }
    @Override
    public Curso buscarCursoPorId(Long id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        return cursoOptional.orElse(null);
    }
    @Override
    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {
        return atualizar(id, cursoAtualizado);
    }
    @Override
    public void deletarCurso(Long id) {
        deletar(id);
    }
    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
    @Override
    public Aluno registrarAlunoNoCurso(Long idCurso, Long aluno) {
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        
        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            List<Aluno> alunosDoCurso = curso.getAlunos();
            Aluno alunoToAdd = alunoRepository.findById(aluno).orElseThrow();
            alunosDoCurso.add(alunoToAdd); 
            curso.setAlunos(alunosDoCurso); 
            cursoRepository.save(curso); 
            return alunoToAdd; 
        } else {
            throw new RuntimeException("Curso não encontrado com o ID: " + idCurso);
        }
    }
}
