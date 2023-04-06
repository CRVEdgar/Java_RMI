package application;
import interfaces.AlunoService;
import services.AlunoServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AlunoServiceServer {

    public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(1099);
            AlunoService alunoService = new AlunoServiceImpl();
            Naming.rebind("//localhost/AlunoService", alunoService);

            System.out.println("*** SERVIDOR INICIADO ***" );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
