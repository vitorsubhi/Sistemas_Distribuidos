import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Servidor {
	private ServidorChat server;

	public Servidor()
	{
		try
		{
			System.out.println("Iniciando Servidor Chat");
			Registry registry = LocateRegistry.createRegistry(1098);
			server = new ServidorChatImpl();
			Naming.rebind("rmi://127.0.0.1:1098/ServidorChat",server);
		}catch (Exception e)
		{
			System.out.println("Trouble: "+e);
		}
	}

	public static void main (String args[]){
		Servidor servidor = new Servidor();
		Usuario a = new Usuario("Vitor", "Subhi");
		/*try
		{
			servidor.server.addUser(a);
		}catch (Exception e)
		{
			System.out.println("Oi");
		}*/
	}
}
