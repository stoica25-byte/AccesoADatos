 package sesion_4;

public class Alumno {
    private int id;
    private String nombre;
    private String email;

    public Alumno(){


    }

    public Alumno(int id,String nombre,String email){
        this.id  =id;
        this.nombre  =nombre;
        this.email  =email;
        
    }

    @Override 
    public String toString(){
        return id +","+nombre+","+email;
    }

   public void setNombre(String nombre){
    this.nombre = nombre;
   }

   public int getId() {
    return this.id;

}

   public void setEmail(String email) {
        this.email = email;
    }
    
}