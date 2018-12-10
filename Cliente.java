import java.rmi.*;
import javax.swing.*;
import java.util.Scanner;
import java.lang.Thread.*;
import java.util.ArrayList;
import java.rmi.RemoteException;
public class Cliente {
	public static void main( String args[] ) {
		try 
		{
			System.out.println("Iniciando conex√£o com o servidor...");
			final ServidorChat chat = (ServidorChat) Naming.lookup( "//192.168.20.243:1098/ServidorChat" );
			String nome;
			String msg = "";
			Scanner scanner = new Scanner(System.in);
			System.out.print("Digite seu nome:");
			nome = scanner.nextLine();
			int mensagenslidas = 0;
			Thread thread = new Thread(new Runnable() {
				int cont = 0;//chat.lerMensagem().size();
				@Override
				public void run()
				{
					chat.connect();
					try 
					{
						while(true)
						{
							if (chat.get_num_messages() > cont)
							{
								System.out.println(chat.get_message(cont));
								cont++;
							}
						}
					} catch (RemoteException e)
					{
						System.out.println("Tentando reestabelecer conex√o com o servidor");
						e.printStackTrace();
					}
				}
			});
			thread.start();
			while(!msg.equals("exit"))
			{
				msg = scanner.nextLine();
				if (msg.equals("exit"))
				{
					chat.disconnect();
					System.exit(0);
				}
				else
					chat.send_message(nome+": "+msg);
			}
		}catch( Exception e )
		{
			e.printStackTrace();
		}
	}
}
