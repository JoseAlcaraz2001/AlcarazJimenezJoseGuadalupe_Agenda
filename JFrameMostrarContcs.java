import javax.swing.*;
import java.awt.*;

public class JFrameMostrarContcs extends JFrame
{
   MostrarContactos mostrar = new MostrarContactos();
   
   public JFrameMostrarContcs()
   {     
      initComponents();  
   }
   
   private void initComponents()
   {
      setSize(250, 300);
      setLocationRelativeTo(null);
      setTitle("Contactos Registrados");
      setResizable(false);
      setContentPane(mostrar);
      setVisible(true);
   }   
}
