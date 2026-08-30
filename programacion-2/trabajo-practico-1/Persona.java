import java.time.LocalDate;
import java.time.Period;

public class Persona{
    
    String nombre;
    String apellido;
    int edad;
    LocalDate fechaDeNacimiento;
    int DNI;
    String sexo;
    double peso;
    double altura;

    public Persona(int dni){
        this.setDni(dni);
    }

    public Persona(int dni, String nom, String ape){
        this.setDni(dni);
        this.setNombre(nom);
        this.setApellido(ape);
        fechaDeNacimiento = LocalDate.of(2000, 1, 1);
    }

    public Persona(int dni, String nom, String ape, LocalDate unaFecha){
        DNI = dni;
        nombre = nom;
        apellido = ape;
        fechaDeNacimiento = unaFecha;
    }

    public void setDni(int dni){
        if(dni > 0){
            this.DNI = dni;
        }else
            this.DNI = 1;
    }

    public void setNombre(String nombre) {
        if(nombre != null){
            this.nombre = nombre;
        }else{
            this.nombre = "N";
        }
    }

    public void setApellido(String apellido) {
        if (apellido != null){
			this.apellido = apellido;
        }else 
		  this.apellido = "N";
    }

    public void setEdad(int edad) {
        if(edad > 0){
            this.edad = edad;
        }else{
            this.edad = 1;
        }
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double CalcIndiceMasaCorporal(){

        double masaCorporal = peso / (altura * altura);
        return masaCorporal;
    }

    public boolean EstaEnForma(){
        
        double imc = CalcIndiceMasaCorporal();
        return (imc > 18.5 && imc < 25);
    }

    public boolean EstaCumpliendoAños(){

        LocalDate hoy = LocalDate.now();

        return (hoy.getMonth() == fechaDeNacimiento.getMonth() && hoy.getDayOfMonth() == fechaDeNacimiento.getDayOfMonth());
    }

    public int ObtenerEdadActual(){
        LocalDate fechaHoy = LocalDate.now();

        Period diferenciaEdad = Period.between(fechaDeNacimiento, fechaHoy);

        int aniosReales = diferenciaEdad.getYears();

        return aniosReales;
    }

    public boolean EsMayorDeEdad(){
        int mayoriaEdad = 18;

        return (ObtenerEdadActual() >= mayoriaEdad);
    }

    public boolean PuedeVotar(){
        int puedeVotar = 16;

        return (ObtenerEdadActual() >= puedeVotar);
    }

    public boolean EsCoherente(){
        int edadSegunFecha = ObtenerEdadActual();

        return (edadSegunFecha == edad);
    }

    public String ObetenerFichaPersona(){

        String ficha = "Ficha de la persona:\n" +
        "nombre completo: " + nombre + " " + apellido + "\n" +
        "DNI: " + DNI + "\n" +
        "masa corporal: " + CalcIndiceMasaCorporal() + "\n" +
        "¿esta en forma?: " + EstaEnForma() + "\n" +
        "¿es mayor de edad?: " + EsMayorDeEdad() + "\n" +
        "¿puede votar?: " + PuedeVotar() + "\n" +
        "¿la edad coincide con su fecha de nacimiento?: " + EsCoherente();

        return ficha;
    }
}