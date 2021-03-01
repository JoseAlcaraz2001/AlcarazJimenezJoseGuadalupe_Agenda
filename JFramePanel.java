import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFramePanel extends JFrame
{
   PanelDatos pd = new PanelDatos();
   
   public JFramePanel()
   {     
      initComponents();
   }
   
   private void initComponents()
   {
      setSize(400, 300);
      setLocationRelativeTo(null);
      setTitle("Datos Personales");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(pd);
      setVisible(true);
      JOptionPane.showMessageDialog(null,
      "1.- Selecciona el boton de la operacion a realizar\n2.- Llena los campos necesarios y pulsa de nuevo el boton\n3.- Presiona Finalizar para cambiar de opcion ",
      "Instrucciones", JOptionPane.INFORMATION_MESSAGE);

      addWindowListener(new WindowAdapter() // Para que se guarden los datos en el fichero si se                                      
      {                                     // cierra la ventana con el boton X en lugar del boton salir.
         public void windowClosing(WindowEvent e)
         {
            pd.contactos.actualizarFichero();
         }
      });
   }   
}
