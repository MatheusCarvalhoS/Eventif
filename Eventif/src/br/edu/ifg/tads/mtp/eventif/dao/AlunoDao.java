package br.edu.ifg.tads.mtp.eventif.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.ifg.tads.mtp.eventif.bd.ConnectionFactory;
import br.edu.ifg.tads.mtp.eventif.model.AlunoModel;

public class AlunoDao {
	public boolean adiconaAluno(AlunoModel aluno){
			boolean retorno=true;
			String sql = "insert into aluno (idPessoa, senha) values(?,?)";
			Connection con = null;
			try{
				con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setInt(1, aluno.getIdPessoa());
				stmt.setString(2, aluno.getSenha());
				
				stmt.execute();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Não foi possível inserir. "+e.getMessage());
			} finally{
				try{
					con.close();
				}catch(SQLException e){
					JOptionPane.showMessageDialog(null, "Impossível fechar conexão");
				}
			}
			return retorno;
		}
}

