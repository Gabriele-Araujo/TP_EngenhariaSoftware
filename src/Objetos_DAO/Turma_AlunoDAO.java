package objetos_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectionFactory;
import java.sql.ResultSet;
import java.util.ArrayList;
import objetos.Aluno;
import objetos.Turma_Aluno;

public class Turma_AlunoDAO {


    public Turma_AlunoDAO() {
    }
	
    public void adiciona(Turma_Aluno turma) throws Exception {
        String sql =    "INSERT INTO public.\"Turma_Aluno\"" +
                        "(\"id_Turma\", \"CPF_Aluno\")" +
                        "values (?,?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        try {

            stmt.setInt(1, turma.getTurma().getId());
            stmt.setString(2, turma.getAluno().getCPF());
           
//            System.out.println(stmt);
            
            stmt.execute();
          
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public void remove(Turma_Aluno turmaAluno) throws Exception {
        String sql =   "DELETE " +
                        "FROM public.\"Turma_Aluno\" " + 
                        "WHERE \"id_Turma\"=? AND \"CPF_Aluno\"=?";  
         
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
     	
        try {
            stmt.setInt(1, turmaAluno.getTurma().getId()); 
            stmt.setString(2, turmaAluno.getAluno().getCPF());

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public ArrayList<Aluno> getAlunos (int idTurma) throws Exception{
        String sql =    "SELECT \"CPF_Aluno\" " +
                        "FROM public.\"Turma_Aluno\" " + 
                        "WHERE \"id_Turma\"=?"; 
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        
        try {
            Aluno aluno;
            
            stmt.setInt(1, idTurma);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AlunoDAO adao = new AlunoDAO();
                aluno = adao.getAluno(rs.getString("CPF_Aluno"));
                
                alunos.add(aluno);
            }
            rs.close();

            return alunos;
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
        
    }
    
    public int qtdAlunos (int idTurma) throws Exception {
        String sql =    "SELECT COUNT(*) as qtd " +
                        "FROM public.\"Turma_Aluno\" " + 
                        "WHERE \"id_Turma\"=?"; 
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        int qtd = 0;
        
        try {
            stmt.setInt(1, idTurma);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                qtd = rs.getInt("qtd");
            }
            rs.close();
            return qtd;
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
        
    }
    
     public ArrayList<Aluno> getAlunosExternos (int idTurma) throws Exception{
        String sql =    "SELECT \"CPF\" " +
                        "FROM public.\"Aluno\" " +
                        "EXCEPT " +
                        "SELECT \"CPF_Aluno\" " +
                        "FROM public.\"Turma_Aluno\" " +
                        "WHERE \"id_Turma\" = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        
        try {
            Aluno aluno;
            
            stmt.setInt(1, idTurma);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AlunoDAO adao = new AlunoDAO();
                aluno = adao.getAluno(rs.getString("CPF"));
                
                alunos.add(aluno);
            }
            rs.close();

            return alunos;
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
        
    }
    
}
