package objetos_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionFactory;
import java.sql.Date;
import java.util.ArrayList;
import objetos.Aluno;
import objetos.Pagamento;

public class PagamentoDAO {

    public PagamentoDAO() {

    }
	
    public void adiciona(Pagamento pagamento) throws Exception {
        String sql =    "INSERT INTO public.\"Pagamento\"" +
                        "(valor, data, \"CPF_Aluno\", multa)" +
                        "values (?,?,?,?)";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        try {

            stmt.setFloat(1,pagamento.getValor());
            stmt.setDate(2, pagamento.getData());
            stmt.setString(3, pagamento.getAluno().getCPF());
            stmt.setBoolean(4, pagamento.isMulta());            
           
            System.out.println(stmt);
            
            stmt.execute();
            
        } catch (SQLException e) {
            throw new Exception("Não foi possível registrar o pagamento no banco");
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public ArrayList<Pagamento> getLista() throws Exception{
        
        String sql =    "SELECT * " +
                        "FROM public.\"Pagamento\"";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        try {
            ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Pagamento pagamento = new Pagamento();
            
            	pagamento.setValor(rs.getFloat("valor"));
                pagamento.setData(rs.getDate("data"));
                pagamento.setAluno(new AlunoDAO().getAluno(rs.getString("CPF_Aluno")));
                pagamento.setMulta(rs.getBoolean("multa"));

                pagamentos.add(pagamento);
            }
            rs.close();
            
            return pagamentos;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
        
    }
    
    public ArrayList<Pagamento> getPagamentos(Aluno aluno) throws Exception{
        
        String sql =    "SELECT * " +
                        "FROM public.\"Pagamento\"" +
                        "WHERE \"CPF_Aluno\" = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        try {
            ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

            stmt.setString(1, aluno.getCPF());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Pagamento pagamento = new Pagamento();
            
            	pagamento.setValor(rs.getFloat("valor"));
                pagamento.setData(rs.getDate("data"));
                pagamento.setAluno(new AlunoDAO().getAluno(rs.getString("CPF_Aluno")));
                pagamento.setMulta(rs.getBoolean("multa"));

                pagamentos.add(pagamento);
            }
            rs.close();
            
            return pagamentos;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
    }
    
    public Pagamento getPagamento(String CPF_Aluno, Date data) throws Exception{
        String sql =    "SELECT * " +
                        "FROM public.\"Pagamento\"" +
                        "WHERE \"CPF_Aluno\" = ? AND data = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        try {
            Pagamento pagamento = new Pagamento();

            stmt.setString(1, CPF_Aluno);
            stmt.setDate(2, data);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

               pagamento.setValor(rs.getFloat("valor"));
               pagamento.setData(rs.getDate("data"));
               pagamento.setAluno(new AlunoDAO().getAluno(rs.getString("CPF_Aluno")));
               pagamento.setMulta(rs.getBoolean("multa"));

            }
            rs.close();

            return pagamento;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
		
    }
    
    public ArrayList<Pagamento> getListaMulta() throws Exception{
        
        String sql =    "SELECT PA.* " +
                        "FROM public.\"Pagamento\" as PA JOIN public.\"Aluno\" as AL ON PA.\"CPF_Aluno\" = AL.\"CPF\" " +
                        "WHERE PA.multa = true " +
                        "ORDER BY PA.data DESC";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        try {
            ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Pagamento pagamento = new Pagamento();
            
            	pagamento.setValor(rs.getFloat("valor"));
                pagamento.setData(rs.getDate("data"));
                pagamento.setAluno(new AlunoDAO().getAluno(rs.getString("CPF_Aluno")));
                pagamento.setMulta(rs.getBoolean("multa"));

                pagamentos.add(pagamento);
            }
            rs.close();
            
            return pagamentos;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
        
    }
    
    public void remove(Pagamento pagamento) throws Exception {
    	
        String sql =    "DELETE " +
                        "FROM public.\"Pagamento\"" +
                        "WHERE \"CPF_Aluno\" = ? AND data = ?";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        try {

            stmt.setString(1, pagamento.getAluno().getCPF());
            stmt.setDate(2, pagamento.getData());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close(); 
            connection.close();            
        }
		
    }
	
}
