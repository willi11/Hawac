/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import encryptserver.IEncrypt;
import encryptserver.Protocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author 
 */
public class ModelProxy implements IEncrypt{
    ObjectInputStream in;
    ObjectOutputStream out;

    public ModelProxy() {
        try{
            Socket skt = new Socket(Protocol.SERVER,Protocol.PORT);
            out = new ObjectOutputStream(skt.getOutputStream() );
            out.flush();
            in = new ObjectInputStream(skt.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error de comunicacion");
            System.exit(-1);
        }        
    }
        
    public String encrypt(String text){
        try {
            out.writeInt(Protocol.ENCRYPT);
            out.flush();
            int error;
            error = in.readInt();
            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error de comunicacion");
            return new String();
        }
        
    }
    public String decrypt(String text){
        try {
            out.writeInt(Protocol.DECRYPT);
            out.flush();
            int error = in.readInt();
            return (String) in.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error de comunicacion");
            return new String();
        }
    }
    
}
