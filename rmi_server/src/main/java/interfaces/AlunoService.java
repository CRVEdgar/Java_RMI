package interfaces;
import model.Aluno;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
public interface AlunoService extends Remote {
    public Aluno getAluno(String id) throws RemoteException;

    public List<Aluno> getAlunos() throws RemoteException;
}
