package model;

public class JavaBeans {
	
	private String idusu;
	private String nome;
	private String fone;
	private String email;
	private String senha;
	
		
	public JavaBeans() {
		super();
		
	}
	
	
	public JavaBeans(String idusu, String nome, String fone, String email, String senha) {
		super();
		this.idusu = idusu;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.senha = senha;
	}


	public String getIdusu() {
		return idusu;
	}
	public void setIdusu(String idusu) {
		this.idusu = idusu;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
