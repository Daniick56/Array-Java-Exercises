import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        double promedioEdades = 0;
        int esMayorEdad = 0;
        int esMenorEdad = 0;
        int personaMayor = 0;
        int personaMenor = 0;

        //pedimos al ususario la cantidad de veces que le pedirá los datos:
        do {
            try {
                System.out.println("Ingresa la cantidad de personas a procesar: ");
                n = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Ingresa un dato numérico.");
            }
            if (n < 0) {
                System.out.println("No se aceptan valores negativos.\n");
            }
        } while (n < 0);

        //inicializando arrays:
        String nombres[]= new String[n];
        int edades[]= new int[n];

        //pidiendo al usuario n cantidad de veces:
        for (int i = 0; i < n; i++) {
            //pidiendo nombre:
            System.out.println("Ingresa el nombre de la persona " + (i+1));
            nombres[i]= scanner.nextLine();

            //pidiendo la edad:
            System.out.println("Ingresa la edad de la persona " + (i+1));
            edades[i]= Integer.parseInt(scanner.nextLine());

            if (edades[i] < 0) {
                System.out.println("No se permiten valores negativos.");
                i--;
                continue;
            }
        }

        //imprimir promedio de edades:
        int sum = 0;
        for (int i = 0; i < edades.length ; i++) {
            sum+= edades[i];
        }
        promedioEdades = (double) sum /edades.length;

        //verificando cuantas personas son mayores de edad y cuales son menores de edad:
        for (int i = 0; i < edades.length; i++) {
            if(edades[i] >= 18) {
                esMayorEdad++;
            } else {
                esMenorEdad++;
            }
        }
        
        //verifiando cual persona es la mayor de todas y cual es la menor:

        personaMayor = edades[0];
        personaMenor = edades[0];
        for (int i = 0; i < edades.length; i++) {
            if(personaMayor <= edades[i]) {
                personaMayor = edades[i];
            }
            if (personaMenor >= edades[i]) {
                personaMenor = edades[i];
            }
        }

        //imprimiendo mensajes:
        System.out.println("El promedio de las edades de las personas registradas es: " + promedioEdades);
        System.out.println("Personas mayores de edad: " + esMayorEdad);
        System.out.println("Personas menores de edad: " + esMenorEdad);
        System.out.println("La cantidad de personas procesadas fueron: " + n);
        System.out.println("Persona con mayor edad: " + personaMayor);
        System.out.println("Persona con menor edad: " + personaMenor);
    }
}