package PaperlessMenu;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Logininterface extends Remote
{
public boolean check(String userId,String pass) throws RemoteException;
}
