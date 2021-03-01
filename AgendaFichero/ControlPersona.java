import java.util.*;
import java.io.*;

public class ControlPersona
{
   private File agenda = new File("Contactos.dat");
   private static ArrayList<Persona> contactos = new ArrayList<Persona>();
   private Persona objPersona;
   private int indice;
   private boolean modif = false; // Para saber si se realizaron modificaciones, 
                                  // si no es asi no es necesario reescribir el fichero.
   
   public ControlPersona() // Al crear el objeto revisa si se ha creado el fichero.
   {
      try{
         if(agenda.exists())
         {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(agenda));
            contactos = (ArrayList<Persona>) ois.readObject();
            ois.close();
         }          
      }
      catch(FileNotFoundException e){}
      catch(IOException e){}
      catch(ClassNotFoundException e) {}
   }
   
   public void actualizarFichero()
   {
      try{
         if(modif) // Si hay modificaciones se reescribe el fichero.
         {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(agenda));
            oos.writeObject(contactos);
            oos.close(); 
         }
      }
      catch(FileNotFoundException e){}
      catch(IOException e){}
   }
   
   public void agregar(String nom, String tel, String corr, String cumple)
   {
      objPersona = new Persona();
      objPersona.setNombre(nom);
      objPersona.setTelefono(tel);
      objPersona.setCorreo(corr);
      objPersona.setCumple(cumple);
      contactos.add(objPersona); 
      modif = true;
   }
   
   public static ArrayList getArrayList()
   {
      return contactos;
   }
   
   public Persona buscarContacto(String nombre)
   {
      Iterator<Persona> itrPersona = contactos.iterator();
      indice = -1;
      
      while(itrPersona.hasNext())
      {
         indice++;
         Persona objPersona = itrPersona.next();
         if(objPersona.getNombre().equals(nombre)) 
            return objPersona;
      }
      return null;
   }
   
   public void modificarContacto(String nom, String tel, String corr, String cumple)
   {
      objPersona = contactos.get(indice);
      objPersona.setNombre(nom);
      objPersona.setTelefono(tel);
      objPersona.setCorreo(corr);
      objPersona.setCumple(cumple);
      modif = true;
   }
   
   public void eliminarContacto()
   {
      contactos.remove(indice);
      modif = true;
   }
}
