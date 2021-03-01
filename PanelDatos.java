import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelDatos extends JPanel implements ActionListener
{
   JButton btnAlta, btnBuscar, btnModificar, btnEliminar, btnContactos, btnSalir, btnFinalizar;
   JTextField txtNombre, txtTelefono, txtCorreo, txtCumple;
   ControlPersona contactos = new ControlPersona();
   Persona contacto;
   JFrameMostrarContcs jfmc;
   boolean ban = true;
  
   public PanelDatos()
   { 
      setLayout(new GridLayout(9,2));
      JLabel lblNombre = new JLabel("Nombre:   ", JLabel.RIGHT);
      txtNombre = new JTextField(30);
      txtNombre.setEditable(false);
      add(lblNombre);
      add(txtNombre);
     
      JLabel lblTelefono = new JLabel("Telefono:   ", JLabel.RIGHT);
      txtTelefono = new JTextField(30);
      txtTelefono.setEditable(false);
      add(lblTelefono);
      add(txtTelefono);
     
      JLabel lblCorreo = new JLabel("Correo:   ", JLabel.RIGHT);
      txtCorreo = new JTextField(30);
      txtCorreo.setEditable(false);
      add(lblCorreo);
      add(txtCorreo);
     
      JLabel lblCumple = new JLabel("Cumple:   ", JLabel.RIGHT);
      txtCumple = new JTextField(30);
      txtCumple.setEditable(false);
      add(lblCumple);
      add(txtCumple);
      
      btnFinalizar = new JButton("Finalizar");
      btnFinalizar.addActionListener(this);
      btnFinalizar.setMnemonic('F');
      
      btnSalir = new JButton("Salir");
      btnSalir.addActionListener(this);
      btnSalir.setMnemonic('S');
      
      btnAlta = new JButton("Alta");
      btnAlta.addActionListener(this);
      btnAlta.setMnemonic('A');
      
      btnBuscar = new JButton("Buscar");
      btnBuscar.addActionListener(this);
      btnBuscar.setMnemonic('B');
      
      btnModificar = new JButton("Modificar");
      btnModificar.addActionListener(this);
      btnModificar.setMnemonic('M');
      
      btnEliminar = new JButton("Eliminar");
      btnEliminar.addActionListener(this);
      btnEliminar.setMnemonic('E');
      
      btnContactos = new JButton("Contactos");
      btnContactos.addActionListener(this);
      btnContactos.setMnemonic('C');
      
      JLabel espacio = new JLabel();
      JLabel espacio2 = new JLabel();
     
      add(btnFinalizar);
      add(btnSalir);
      add(espacio);
      add(espacio2);
      add(btnAlta);
      add(btnBuscar);
      add(btnModificar);
      add(btnEliminar);
      add(btnContactos);
   }
  
   public void actionPerformed(ActionEvent e)
   {
      txtNombre.requestFocus();
      if(e.getSource() == btnFinalizar)
      {
         activarBtns(true);
         activarCampos(false);
         limpiarCampos();
         ban = true;
      } // Boton Finalizar
      
      if(e.getSource() == btnSalir)
      {
         contactos.actualizarFichero(); // Se actualiza el fichero al salir.
         System.exit(0);
      } // Boton Salir
      
      if (e.getSource() == btnAlta) 
      {    
         if(ban) // La bandera es para saber si es la primera vez que se toca el boton, si es asi solo se activan los campos requeridos.
         {       
            activarBtns(false);
            activarCampos(true);
            btnAlta.setEnabled(true);
            ban = false;
         }
         else // Si no es la primera vez que se presiona el boton se efectuan las operaciones.
         {
            if(txtNombre.getText() == null || txtNombre.getText().isEmpty())
            {
               JOptionPane.showMessageDialog(null, "Se debe colocar el nombre",
               "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            else
               if(txtTelefono.getText() == null || txtTelefono.getText().isEmpty())
               {
                  JOptionPane.showMessageDialog(null, "Se debe de colocar el numero de telefono",
                  "Aviso", JOptionPane.INFORMATION_MESSAGE);
                  txtTelefono.requestFocus();
               }
               else
               {
                  contactos.agregar(txtNombre.getText(), txtTelefono.getText(), txtCorreo.getText(), txtCumple.getText());
                  JOptionPane.showMessageDialog(null, "El contacto ha sido dado de alta", "Alta", JOptionPane.INFORMATION_MESSAGE);	
                  limpiarCampos();
               }
          }
      } // Boton Alta
      
      if(e.getSource() == btnBuscar)
      {
         if(ban)
         {
            activarBtns(false);
            txtNombre.setEditable(true);
            btnBuscar.setEnabled(true);
            ban = false;
         }
         else
         {
            if(txtNombre.getText() == null || txtNombre.getText().isEmpty())
            {
               JOptionPane.showMessageDialog(null, "Se debe colocar el nombre",
               "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
               contacto = contactos.buscarContacto(txtNombre.getText());
               if(contacto != null)
               {
                  txtNombre.setText(contacto.getNombre());
                  txtTelefono.setText(contacto.getTelefono());
                  txtCorreo.setText(contacto.getCorreo());
                  txtCumple.setText(contacto.getCumple());
                  contacto = null;
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "No se encontro el contacto",
                  "BuscarContacto", JOptionPane.INFORMATION_MESSAGE);   
                  limpiarCampos();
               } 
            }  
         } 
      } // Boton Buscar
      
      if(e.getSource() == btnModificar)
      {
         if(ban)
         {
            activarBtns(false);
            txtNombre.setEditable(true);
            btnModificar.setEnabled(true);
            ban = false;
         }
         else
         {
            if(txtNombre.getText() == null || txtNombre.getText().isEmpty())
            {
               JOptionPane.showMessageDialog(null, "Se debe colocar el nombre",
               "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
               if(contacto == null)
               {
                  contacto = contactos.buscarContacto(txtNombre.getText());
                  if(contacto != null)
                  {
                     activarCampos(true);
                     txtNombre.setText(contacto.getNombre());
                     txtTelefono.setText(contacto.getTelefono());
                     txtCorreo.setText(contacto.getCorreo());
                     txtCumple.setText(contacto.getCumple());
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "No se encontro el contacto",
                     "BuscarContacto", JOptionPane.INFORMATION_MESSAGE);   
                     limpiarCampos();
                  } 
               }
               else
                  if(txtNombre.getText() == null || txtNombre.getText().isEmpty())
                  {
                     JOptionPane.showMessageDialog(null, "Se debe colocar el nombre",
                     "Aviso", JOptionPane.INFORMATION_MESSAGE);
                  }
                  else
                     if(txtTelefono.getText() == null || txtTelefono.getText().isEmpty())
                     {
                        JOptionPane.showMessageDialog(null, "Se debe de colocar el numero de telefono",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        txtTelefono.requestFocus();
                     }
                     else
                     {
                        contactos.modificarContacto(txtNombre.getText(), txtTelefono.getText(),
                        txtCorreo.getText(), txtCumple.getText());
                        JOptionPane.showMessageDialog(null, "Se han guardado los cambios",
                        "ModificarContacto", JOptionPane.INFORMATION_MESSAGE);   
                        txtNombre.requestFocus();
                        activarCampos(false);
                        txtNombre.setEditable(true);
                        contacto = null;
                        limpiarCampos();
                     }    
            }
         }
      } // Boton Modificar
      
      if(e.getSource() == btnEliminar)
      {
         if(ban)
         {
            activarBtns(false);
            txtNombre.setEditable(true);
            btnEliminar.setEnabled(true);
            ban = false;
         }
         else
         {
            if(txtNombre.getText() == null || txtNombre.getText().isEmpty())
            {
               JOptionPane.showMessageDialog(null, "Se debe colocar el nombre",
               "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
               contacto = contactos.buscarContacto(txtNombre.getText());
               if(contacto != null)
               {
                  txtNombre.setText(contacto.getNombre());
                  txtTelefono.setText(contacto.getTelefono());
                  txtCorreo.setText(contacto.getCorreo());
                  txtCumple.setText(contacto.getCumple());
                  contacto = null;
                  
                  int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar este contacto?", "Aviso",
                               JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                  if(opcion == JOptionPane.YES_OPTION)
                  {
                     contactos.eliminarContacto();
                     JOptionPane.showMessageDialog(null, "El contacto ha sido removido",
                     "EliminarContacto", JOptionPane.INFORMATION_MESSAGE);
                  }
                  else
                     JOptionPane.showMessageDialog(null, "Se ha cancelado la operacion",
                     "EliminarContacto", JOptionPane.INFORMATION_MESSAGE);
                  limpiarCampos();  
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "No se encontro el contacto",
                  "BuscarContacto", JOptionPane.INFORMATION_MESSAGE);   
                  limpiarCampos();
               } 
            }  
         }   
      } // Boton Eliminar
      
      if(e.getSource() == btnContactos)
      {
         jfmc = new JFrameMostrarContcs();
      } // Boton Contactos
      
   } // Action Performed
    
   public void limpiarCampos()
   {
      txtNombre.setText("");
      txtTelefono.setText("");
      txtCorreo.setText("");
      txtCumple.setText("");
   }
   
   public void activarBtns(boolean ban)
   {
      btnAlta.setEnabled(ban);
      btnBuscar.setEnabled(ban);
      btnModificar.setEnabled(ban);
      btnEliminar.setEnabled(ban);
      btnContactos.setEnabled(ban);
      btnSalir.setEnabled(ban);
   }
   
   public void activarCampos(boolean ban)
   {
      txtNombre.setEditable(ban);
      txtTelefono.setEditable(ban);
      txtCorreo.setEditable(ban);
      txtCumple.setEditable(ban);
   }
}