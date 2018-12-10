import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
public class ServidorChatImpl extends java.rmi.server.UnicastRemoteObject implements ServidorChat {
	private ArrayList<String> mensagens;
	private int nMensagens;
	public ServidorChatImpl() throws RemoteException 
	{
		super();
		this.mensagens = new ArrayList<String>();
	}

	public void connect() throws RemoteException
	{
		
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
}
