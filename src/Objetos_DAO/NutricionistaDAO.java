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
import objetos.Nutricionista;

public class NutricionistaDAO {
	

    public NutricionistaDAO() {

    }
    
    

    public void adiciona(Nutricionista nutricionista) throws Exception {
        String sql =    "INSERT INTO public.\"Nutricionista\"" +
                        "(nome, \"CPF\", email, telefone, salario, especialidade, senha)" +
                        "values (?,?,?,?,?,?,?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        try {

            stmt.setString(1, nutricionista.getNome());
            stmt.setString(2, nutricionista.getCPF());
            stmt.setString(3, nutricionista.getEmail());
            stmt.setString(4, nutricionista.getTelefone());
            stmt.setFloat(5, nutricionista.getSalario());
            stmt.setString(6, nutricionista.getEspecialidade());   
            
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(nutricionista.getSenha().getBytes(), 0, nutricionista.getSenha().length());        
            stmt.setString(7, new BigInteger(1,m.digest()).toString(16));
 //         System.out.println(stmt);
            
            stmt.execute();    
            
            new FuncionarioDAO().adiciona((Funcionario)nutricionista);
            
        } catch (SQLException e) {
            throw new Exception("Não foi possível cadastrar o Nutricionista no banco");
        } catch (NoSuchAlgorithmException ex) {
            throw new Exception("Encriptação da senha falhou");
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public Nutricionista getNutricionista(String CPF) throws Exception {
    	String sql =    "SELECT * " +
                        "FROM public.\"Nutricionista\" " +
                        "WHERE \"CPF\" = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
    	 try {
            Nutricionista nutricionista = null;
             
            stmt.setString(1, CPF);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                nutricionista = new Nutricionista();

                nutricionista.setCPF(rs.getString("CPF"));
                nutricionista.setNome(rs.getString("nome"));
                nutricionista.setEmail(rs.getString("email"));
                nutricionista.setTelefone(rs.getString("telefone"));

                nutricionista.setSalario(rs.getFloat("salario"));
                nutricionista.setEspecialidade(rs.getString("especialidade"));
                nutricionista.setSenha(rs.getString("senha"));

            }
            rs.close();

            return nutricionista;
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    	
    }
    
    public ArrayList<Nutricionista> getLista() throws Exception {
        String sql =    "SELECT * " +
                        "FROM public.\"Nutricionista\"";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        try {
            ArrayList<Nutricionista> nutricionistas = new ArrayList<Nutricionista>();
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Nutricionista nutricionista = new Nutricionista();
            
            	nutricionista.setCPF(rs.getString("CPF"));
                nutricionista.setNome(rs.getString("nome"));
                nutricionista.setEmail(rs.getString("email"));
                nutricionista.setTelefone(rs.getString("telefone"));

                nutricionista.setSalario(rs.getFloat("salario"));
                nutricionista.setEspecialidade(rs.getString("especialidade"));
                nutricionista.setSenha(rs.getString("senha"));

                nutricionistas.add(nutricionista);
            }
            rs.close();
            
            return nutricionistas;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public void altera(Nutricionista nutricionista) throws Exception {
        new FuncionarioDAO().altera((Funcionario)nutricionista);
    }
    
    public void remove(Nutricionista nutricionista) throws Exception {    	 
        new FuncionarioDAO().remove((Funcionario)nutricionista);
    }
    
    
}

