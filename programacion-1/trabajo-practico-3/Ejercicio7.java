public class Ejercicio7 {
/*
Realizar un programa que dado dos números enteros y un
carácter (todos ingresados por el usuario) muestre por pantalla el
resultado de una operación matemática básica según el valor del
carácter ingresado. Si se ingresó el carácter ‘a’ debe realizar la
suma, para ‘b’ la resta, para ‘c’ la multiplicación y para ‘d’ la
división entre ambos números.
*/ 
    public static void main(String[] args) {

        /* ERRORES DE RAZONAMIENTO
            1. no revisar que pasa si ingresa un 0 al dividir
            2. PARSEAR TODA LA OPERACION DIVISION A DOUBLE O ME COMO EL NUM DESPUES DEL .
            3. NO REVISAR QUE EFECTIVAMENTE INGRESE UN CARACTER VALIDO
            4. OBTENER NUMERO PODRIA SER UN METODO Y NO REPIDO 4 LINEAS
        */
        
        int num1 = obtenerNumero();
        int num2 = obtenerNumero();

        System.out.println("ingrese una opcion: a: suma, b:resta, c:multiplicacion, d:division");
        char opcion = Utils.leerChar();

        while(opcion != 'a' && opcion != 'b' && opcion != 'c' && opcion != 'd'){
            System.out.println("error, ingrese una opcion valida");
            opcion = Utils.leerChar();
        }

        switch (opcion) {
            case 'a':
                operacionSuma(num1, num2);
                break;
            case 'b':
                operacionResta(num1, num2);
                break;
            case 'c':
                operacionMultiplicacion(num1, num2);
                break;
            case 'd':
                if(num2 != 0){
                    operacionDivision(num1, num2);
                }
                else
                    System.out.println("no se puede realizar dicha division");
                break;
            default:
                break;
        }
    }

    public static int obtenerNumero(){

        int numero = 0;
        System.out.println("Ingrese un numero:");
        numero = Utils.leerInt();
        return numero;
    }

    public static void operacionSuma(int numero1, int numero2){


        System.out.println("el resultado de la operacion suma es: " + (numero1 + numero2));
    }

    public static void operacionResta(int numero1, int numero2){

        System.out.println("el resultado de la operacion resta es: " + (numero1 - numero2));
    }

    public static void operacionMultiplicacion(int numero1, int numero2){

        System.out.println("el resultado de la operacion multiplicacion es: " + (numero1 * numero2));
    }

    public static void operacionDivision(int numero1, int numero2){

        System.out.println("el resultado de la operacion division es: " + ((double)numero1 / numero2));
    }
}
