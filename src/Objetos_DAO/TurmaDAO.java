package objetos_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import objetos.Turma;

public class TurmaDAO {


    public TurmaDAO() {
    }
	//
    public void adiciona(Turma turma) throws Exception {
        String sql =    "INSERT INTO public.\"Turma\"" +
                        "(quantidade, horarios, \"CPF_Instrutor\")" +
                        "values (?,?,?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        try {

            stmt.setInt(1, turma.getQuantidade());
            stmt.setString(2, turma.getHorario());
            stmt.setString(3, turma.getInstrutor().getCPF());
           
            System.out.println(stmt);
            
            stmt.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public ArrayList<Turma> getLista() throws Exception {
        String sql =    "SELECT * " +
                        "FROM public.\"Turma\"";   
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        try {
            ArrayList<Turma> turmas = new ArrayList<Turma>();
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Turma turma = new Turma();
            
            	turma.setId(rs.getInt("id"));
                turma.setQuantidade(rs.getInt("quantidade"));
                turma.setHorario(rs.getString("horarios"));                
                turma.setInstrutor(new InstrutorDAO().getInstrutor(rs.getString("CPF_Instrutor")));

                turmas.add(turma);
            }
            rs.close();
            
            return turmas;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public void remove(Turma turma) throws Exception {
        String sql ="DELETE " +
                	 "FROM public.\"Turma\" " + 
                	 "WHERE \"id\"=?";  
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
   	
        try {
            stmt.setInt(1, turma.getId());

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
   }
    
    public void altera(Turma turma) throws Exception {
        String sql =    "UPDATE public.\"Turma\" " +
                        "SET quantidade=?," +
                            "horarios=?, "+
                            "\"CPF_Instrutor\"=? " + 
                        "WHERE \"id\"=?";  
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
   	
        try {
            stmt.setInt(1, turma.getQuantidade());
            stmt.setString(2, turma.getHorario());
            stmt.setString(3, turma.getInstrutor().getCPF());
            
            stmt.setInt(4, turma.getId());

            System.out.println(stmt);
            
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
   }
    
    public ArrayList<Turma> getTurmasInstrutor(String CPF) throws Exception {
    	
        String sql =    "SELECT * " +
                        "FROM public.\"Turma\"" +
                        "WHERE \"CPF_Instrutor\" = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ArrayList<Turma> turmas = new ArrayList();		
	try {
            Turma turma = new Turma();
            
            stmt.setString(1, CPF);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	 
            	turma.setId(rs.getInt("id"));
             	turma.setQuantidade(rs.getInt("quantidade"));
                turma.setHorario(rs.getString("horarios"));
                turma.setInstrutor(new InstrutorDAO().getInstrutor(rs.getString("CPF_Instrutor")));
                turmas.add(turma);
            }
            rs.close();
             
            return turmas;
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }		
    }
	
    public Turma getTurma(int id) throws Exception {
		
        String sql =    "SELECT * " +
                        "FROM public.\"Turma\" " +
                        "WHERE \"id\" = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        Turma turma = null;
		
        try {            
            stmt.setInt(1, id);            
            System.out.println(stmt);            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                turma = new Turma();
                turma.setId(rs.getInt("id"));
                turma.setQuantidade(rs.getInt("quantidade"));
                turma.setHorario(rs.getString("horarios"));
                turma.setInstrutor(new InstrutorDAO().getInstrutor(rs.getString("CPF_Instrutor")));

            }
            rs.close();
            return turma;
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
		
    }
    
    public ArrayList<String> equipamentosTurmas(int id_Turma) throws Exception{
        String sql =    "SELECT EQ.nome " +
                        "FROM ((public.\"Turma\" as TU JOIN public.\"Turma_Aluno\" as TA ON TU.id = TA.\"id_Turma\") " +
                                "JOIN public.\"Exercicio\" as EX ON TA.\"CPF_Aluno\" = EX.\"CPF_Aluno\") " +
                                "JOIN public.\"Equipamento\" as EQ ON EX.\"id_Equipamento\" = EQ.id " +
                        "WHERE TU.id = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ArrayList<String> turmaEquip = new ArrayList<String>();
		
        try {
            stmt.setInt(1, id_Turma);  
            ResultSet rs = stmt.executeQuery();            
            System.out.println(stmt);
                
            while (rs.next()) {
                turmaEquip.add(rs.getString("nome"));
            }
            rs.close();

            return turmaEquip;
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }        
    }
    
}
	