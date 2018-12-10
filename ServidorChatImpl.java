import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
public class ServidorChatImpl extends java.rmi.server.UnicastRemoteObject implements ServidorChat {
	private ArrayList<String> mensagens;
	private ArrayList<Usuario> usuarios;
	private int nMensagens;
	private boolean auth = true;
	public ServidorChatImpl() throws RemoteException 
	{
		super();
		this.mensagens = new ArrayList<String>();
	}

	public boolean connect(String user, String pass) throws RemoteException
	{
		/*for (int i = 0; i < usuarios.size(); i++)
		{
			if (usuarios.get(i).getName().equals(user))
			{
				auth = usuarios.get(i).authenticate(user, pass);
				break;
			}
			else
				auth = false;
		}
		*/
		if (auth)
			return true;
		else
			return false;
	}

	public void disconnect() throws RemoteException
	{

	}

	public void send_message(String mensagem) throws RemoteException
	{
		mensagens.add(mensagem);
	}

	public int get_num_messages() throws RemoteException
	{
		return mensagens.size();
	}

	public String get_message(int id) throws RemoteException
	{
		return mensagens.get(id);
	}

	public void addUser(Usuario user)
	{
		usuarios.add(user);
	}
}
