import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MostrarContactos extends JPanel
{
   JTable tabla;
   JScrollPane scroll = new JScrollPane();
   ArrayList<Persona> datosCont = ControlPersona.getArrayList();
   
   public MostrarContactos()
   {
      String titulos[] = {"Nombre", "Telefono", "Correo", "Cumple"};
      String info[][] = obtenerDatos();
      setLayout(new GridLayout(1,1));
      
      tabla = new JTable(info, titulos);
      tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      scroll.setViewportView(tabla);
      
      add(scroll);
   }
   
   private String[][] obtenerDatos()
   {
      int x = 0;
      String informacion[][] = new String[datosCont.size()][4]; 
      Iterator<Persona> itrPersona = datosCont.iterator();
      
      while(itrPersona.hasNext())
      {
         Persona persona = itrPersona.next();
         informacion[x][0] = persona.getNombre();
         informacion[x][1] = persona.getTelefono();
         informacion[x][2] = persona.getCorreo();
         informacion[x][3] = persona.getCumple();
         x++;
      }
      
      return informacion;
   }
}