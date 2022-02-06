package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/desafiosefaz?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "1234";

	// Método de conexão
	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD CREATE

	public void inserirUsuario(JavaBeans usuario) {
		String create = "insert into usuarios(nome, fone, email, senha) values (?,?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getFone());
			pst.setString(3, usuario.getEmail());
			pst.setString(4, usuario.getSenha());

			// executar a query
			pst.executeUpdate();
			// encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// CRUD READ

	public ArrayList<JavaBeans> listarUsuarios() {
		ArrayList<JavaBeans> usuarios = new ArrayList<>();
		String read = "select * from usuarios order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String idusu = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				String senha = rs.getString(5);
				// popular o ArrayList
				usuarios.add(new JavaBeans(idusu, nome, fone, email, senha));
			}
			con.close();
			return usuarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Verificar liberação do Login
	public boolean validar(JavaBeans usuario) throws ClassNotFoundException {
		boolean status = false;
		Connection con = conectar();

		String logar = "select * from usuarios where email=? and senha=?";
		try {

			PreparedStatement pst = con.prepareStatement(logar);
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getSenha());
			ResultSet rs = pst.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);

		}
		return status;
	}

	// Selecionar Usuario

	public void selecionarUsuario(JavaBeans usuario) {
		String read2 = "select * from usuarios where idusu = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, usuario.getIdusu());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				usuario.setIdusu(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setFone(rs.getString(3));
				usuario.setEmail(rs.getString(4));
				usuario.setSenha(rs.getString(5));

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarUsuario(JavaBeans usuario) {
		String create = "update usuarios set nome=?, fone=?, email=?, senha=? where idusu = ?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getFone());
			pst.setString(3, usuario.getEmail());
			pst.setString(4, usuario.getSenha());
			pst.setString(5, usuario.getIdusu());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD DELETE

	public void deletarUsuario(JavaBeans usuario) {
		String delete = "delete from usuarios where idusu = ?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, usuario.getIdusu());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
