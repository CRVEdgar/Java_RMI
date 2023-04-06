package services;

import interfaces.AlunoService;
import model.Aluno;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.*;

public class AlunoServiceImpl extends UnicastRemoteObject implements AlunoService{

    private static final String URL = "jdbc:postgresql://localhost/escola";

    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public AlunoServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Aluno getAluno(String matricula) throws RemoteException {
        Aluno aluno = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM aluno WHERE matricula = ?");
            ps.setString(1, matricula);
            rs = ps.executeQuery();
            if (rs.next()) {
                aluno = new Aluno(rs.getInt("idaluno"), rs.getString("nome"), rs.getString("curso"), rs.getString("matricula"));
            }
        } catch (SQLException e) {
            throw new RemoteException("Erro ao obter aluno", e);
        } finally {
            close(rs, ps, conn);
        }
        return aluno;
    }

    @Override
    public List<Aluno> getAlunos() throws RemoteException {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM aluno");
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("idaluno"), rs.getString("nome"), rs.getString("curso"), rs.getString("matricula"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RemoteException("Erro ao obter alunos", e);
        } finally {
            close(rs, ps, conn);
        }
        return alunos;
    }

    private void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
