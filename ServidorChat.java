import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface ServidorChat extends Remote
{
	public boolean connect(String user, String pass) throws RemoteException;
	public void disconnect() throws RemoteException;
	public void send_message(String mensagem) throws RemoteException;
	public int get_num_messages() throws RemoteException;
	public String get_message(int id) throws RemoteException;
	public void addUser(Usuario user) throws RemoteException;
}
