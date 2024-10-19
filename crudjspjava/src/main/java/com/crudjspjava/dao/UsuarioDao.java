package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Usuario;

public class UsuarioDao {
	private static final String url = "jdbc:mysql://localhost:3306/crudjspjava";
	private static final String user = "root";
	private static final String password = "Kamenriderv3";
	
	public static Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static int salvarUsuario(Usuario u) throws ClassNotFoundException {
		int status = 0;
		String insert = "insert into usuario(nome, password, email, sexo, pais) values(?,?,?,?,?)";
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static Usuario getRegistroByID(int id) throws ClassNotFoundException {
		Usuario usuario = null;
		String usuarioID = "select * from usuario where id = ?";
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(usuarioID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public static int updateUsuario(Usuario u) throws ClassNotFoundException {
		int status = 0;
		String update = "update usuario set nome=?, password=?, email=?, sexo=?, pais=? where id=?";
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			ps.setInt(6, u.getId());
			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static List<Usuario> getAllUsuarios() throws ClassNotFoundException{
		List<Usuario> list = new ArrayList<Usuario>();
		String read = "select * from usuario";
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(read);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				list.add(usuario);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
}
