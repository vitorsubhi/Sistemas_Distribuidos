import javax.swing.*;
public class Usuario {
	private String name;
	private String password;

	Usuario (String name, String password){
		this.name = name;
		this.password = password;
	}
	
	public String getName(){
		return this.name;
	}

	public boolean authenticate(String name, String password){
		if (name.equals(this.name))
			return true;
		else
			return false;
	}
}
