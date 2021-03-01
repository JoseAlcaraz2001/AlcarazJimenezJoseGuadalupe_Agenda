import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel implements ActionListener
{
   private JButton btnIngresar, btnSalir;
   private JTextField txtUser;
   private JPasswordField contra;
   
   public Login()
   {
      setLayout(new GridLayout(3, 2));
      JLabel lblUser = new JLabel("Nombre de Usuario:   ", JLabel.RIGHT);
      txtUser = new JTextField(20);
      add(lblUser);
      add(txtUser);
      
      JLabel lblContra = new JLabel("Contrasena:   ", JLabel.RIGHT);
      contra = new JPasswordField(20);
      contra.setToolTipText("Ingrese Contrasena");
      add(lblContra);
      add(contra);
      
      btnIngresar = new JButton("Ingresar");
      btnIngresar.addActionListener(this);
      btnIngresar.setMnemonic('I');
      
      btnSalir = new JButton("Salir");
      btnSalir.addActionListener(this);
      btnSalir.setMnemonic('S');
      
      add(btnIngresar);
      add(btnSalir);
   }
   
   public void actionPerformed(ActionEvent e)
   {
      String usuario = txtUser.getText();
      String password = new String(contra.getPassword());
      
      if(e.getSource() == btnIngresar)
      {
         if(usuario.isEmpty() && password.isEmpty())
         {
            JOptionPane.showMessageDialog(null, "Debe ingresar su nombre de usuario y password");
            txtUser.requestFocus();
         }
         else
         {
            if(usuario.equals("JoseGpe") && password.equals("12345"))
            {
               JOptionPane.showMessageDialog(null, "Bienvenido a la Agenda");
               JFramePanel panel = new JFramePanel();
            }
            else 
            {
               JOptionPane.showMessageDialog(null, "Usuario o Password Incorrecto","Warning", JOptionPane.WARNING_MESSAGE);
               txtUser.setText(null);
               contra.setText(null);
               txtUser.requestFocus();
            }
         }
      } // Boton Ingresar
      
      if(e.getSource() == btnSalir)
      {
         System.exit(0);
      } // Boton Salir
   }
}