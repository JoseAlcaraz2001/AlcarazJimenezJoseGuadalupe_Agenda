import java.io.Serializable;

public class Persona implements Serializable
{
   private String nombre;
   private String telefono;
   private String correo;
   private String cumple;
    
   public void setNombre(String nombre)
   {
      this.nombre = nombre;
   }
    
   public String getNombre()
   {
      return nombre;
   }
    
   public void setTelefono(String telefono)
   {
      this.telefono = telefono;
   }
    
   public String getTelefono()
   {
      return telefono;
   }
   
   public void setCorreo(String correo)
   {
      this.correo = correo;
   }
     
   public String getCorreo()
   {
      return correo;
   }
    
   public void setCumple(String cumple)
   {
      this.cumple = cumple;
   }
    
   public String getCumple()
   {
      return cumple;
   }
}
