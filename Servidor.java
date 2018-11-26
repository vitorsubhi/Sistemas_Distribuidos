import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Servidor {
	public Servidor()
	{
		try
		{
			System.out.println("Iniciando Servidor Chat");
			Registry registry = LocateRegistry.createRegistry(1098);
			ServidorChat server = new ServidorChatImpl();
			Naming.rebind("rmi://192.168.20.243:1098/ServidorChat",server);
		}catch (Exception e)
		{
			System.out.println("Trouble: "+e);
		}
	}
	public static void main (String args[]){
		new Servidor();
	}
}
