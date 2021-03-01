import javax.swing.*;
import java.awt.*;

public class JFrameLogin extends JFrame
{
   Login log = new Login();
   
   public JFrameLogin()
   {     
      initComponents();
   }
   
   private void initComponents()
   {
      setSize(400, 200);
      setLocationRelativeTo(null);
      setTitle("Login Agenda");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(log);
      setVisible(true);
   }   
}