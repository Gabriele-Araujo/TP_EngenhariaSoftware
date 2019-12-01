package objetos_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Funcionario;
import objetos.Instrutor;
import objetos.Turma;

public class InstrutorDAO {
	

    public InstrutorDAO() {
    }
    
    

    public void adiciona(Instrutor instrutor) throws Exception {
        String sql = "INSERT INTO public.\"Instrutor\"" +
                	 "(nome, \"CPF\", email, telefone, salario, especialidade, senha)" +
                	 "values (?,?,?,?,?,?,?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        try {

            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getCPF());
            stmt.setString(3, instrutor.getEmail());
            stmt.setString(4, instrutor.getTelefone());
            stmt.setFloat(5, instrutor.getSalario());
            stmt.setString(6, instrutor.getEspecialidade());   
            
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(instrutor.getSenha().getBytes(), 0, instrutor.getSenha().length());        
            stmt.setString(7, new BigInteger(1,m.digest()).toString(16));
//          System.out.println(stmt);            
            stmt.execute();
            
            new FuncionarioDAO().adiciona((Funcionario)instrutor);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NutricionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public Instrutor getInstrutor(String CPF) throws Exception {
    	String sql =    "SELECT * " +
                        "FROM public.\"Instrutor\"" +
                        "WHERE \"CPF\" = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
    	try {
            Instrutor instrutor = new Instrutor();
             
            stmt.setString(1, CPF);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

               instrutor.setCPF(rs.getString("CPF"));
               instrutor.setNome(rs.getString("nome"));
               instrutor.setEmail(rs.getString("email"));
               instrutor.setTelefone(rs.getString("telefone"));

               instrutor.setSalario(rs.getFloat("salario"));
               instrutor.setEspecialidade(rs.getString("especialidade"));
               instrutor.setSenha(rs.getString("senha"));

            }
            rs.close();

            return instrutor;
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    	
    }
    
    public ArrayList<Instrutor> getLista() throws Exception {
        String sql =    "SELECT * " +
                        "FROM public.\"Instrutor\"";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        try {
            ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Instrutor instrutor = new Instrutor();
            
            	instrutor.setCPF(rs.getString("CPF"));
                instrutor.setNome(rs.getString("nome"));
                instrutor.setEmail(rs.getString("email"));
                instrutor.setTelefone(rs.getString("telefone"));

                instrutor.setSalario(rs.getFloat("salario"));
                instrutor.setEspecialidade(rs.getString("especialidade"));
                instrutor.setSenha(rs.getString("senha"));

                instrutores.add(instrutor);
            }
            rs.close();
            
            return instrutores;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public ArrayList<String> getHorarios(String CPF_Instrutor) throws Exception{
        
        ArrayList<String> horarios = new ArrayList<String>(); 
        
        for(Turma t : new TurmaDAO().getTurmasInstrutor(CPF_Instrutor)){
            horarios.add(t.getHorario());            
        }
        
        return horarios;        
    }
     
    public void altera(Instrutor instrutor) throws Exception {
        new FuncionarioDAO().altera((Funcionario)instrutor);
    }
    
    public void remove(Instrutor instrutor) throws SQLException, Exception {        
    	new FuncionarioDAO().remove((Funcionario)instrutor);
        
    }
}

