package PaperlessMenu;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CheckLogin extends UnicastRemoteObject implements Logininterface
{
    public CheckLogin()throws Exception
    {}
    @Override
    public boolean check(String userId,String pass)throws RemoteException
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","ROOT");
        PreparedStatement ps=con.prepareStatement("select* from chattab where userid=? and password=?");
        ps.setString(1,userId);
        ps.setString(2,pass);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            return true;
        else
            return false;
        }
        catch(Exception ex){
        return false;
        }
    }
    
}