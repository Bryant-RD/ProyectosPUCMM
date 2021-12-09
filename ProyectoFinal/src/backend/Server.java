package backend;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends Thread
{
  
  public static void main (String args[])
  {
    ServerSocket sfd = null;
    FileInputStream bdInput = null;

    
    try
    {
      sfd = new ServerSocket(7000);
      bdInput = new FileInputStream("src\\bd\\bdRespaldo.dat");
      
      System.out.print("SERVER ENCENDIDO");
    }
    catch (IOException ioe)
    {
      System.out.println("Comunicación rechazada."+ioe);
      System.exit(1);
    }

    while (true)
    {
      try
      {
        Socket nsfd = sfd.accept();
        System.out.println("Conexion aceptada de: "+nsfd.getInetAddress());
        DataInputStream entradaSocket = new DataInputStream(new BufferedInputStream(nsfd.getInputStream()));
        FileOutputStream bdOutput = new FileOutputStream("src\\bd\\bdRespaldo.dat");
        Byte unByte;
        while ((unByte = entradaSocket.readByte()) != -1) {
			bdOutput.write(unByte);
			
		}
        
        entradaSocket.close();
        bdOutput.close();
  
        
      }
      catch(IOException ioe)
      {
        System.out.println("Error: "+ioe);
      }
    }
  }
}


