package org.example;

import java.util.Scanner;

public class Menu {

    private String nombre = null;
    double saldo = 0.0;
    Scanner leer = new Scanner(System.in);

    public void menuPrincipal() {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        do{
            try{
                System.out.println("----Menu----");
                System.out.println("1. Introducir nombre de usuario: ");
                System.out.println("2. Añadir ingreso: ");
                System.out.println("3. Añadir gasto: ");
                System.out.println("4. Mostrar saldo: ");
                System.out.println("5. Salir: ");
                opcion = leer.nextInt();

                switch(opcion){
                    case 1:
                        System.out.println("Opcion 1: Introducir nombre de usuario.");
                        añadirUsuario();
                        break;
                    case 2:
                        System.out.println("Opcion 2: Añadir ingreso.");
                        añadirIngreso();
                        break;
                    case 3:
                        System.out.println("Opcion 3: Añadir gasto.");
                        añadirGasto();
                        break;
                    case 4:
                        System.out.println("Opcion 4: Mostrar saldo.");
                        mostrarNomina();
                        break;
                    case 5:
                        System.out.println("Apagando sistema...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error. Opcion no valida.");
            }
        } while(opcion != 5);{
            System.out.println("Fin del programa");
        }

    }

    public void añadirUsuario(){
        System.out.println("Introduce el nombre del usuario: ");
        nombre = leer.nextLine();
        System.out.println("Bienvenido " + nombre );
    }

    public boolean verificarUsuario(){
        if (nombre == null){
            System.out.println("Introduzca un nombre para el usuario");
            return false;
        }
        return true;
    }

    public void añadirIngreso(){
        if (!verificarUsuario()){
            return;
        }
        double cantidad;
        System.out.println("Introduzca la cantidad que desea ingresar: ");
        cantidad = leer.nextDouble();
        saldo += cantidad;
        System.out.println("Cantidad ingresada: " + cantidad);
        System.out.println("Nomina: " + saldo);
    }

    public void añadirGasto(){
        int opcion = 0;
        String concepto;
        double cantidad;

        if(!verificarUsuario()){
            return;
        }

        do{
            try{
                System.out.println("----Menu de gastos----");
                System.out.println("1. Vacaciones");
                System.out.println("2. Alquiler");
                System.out.println("3. Vicios Variados");
                System.out.println("4. Salir");
                opcion = leer.nextInt();

                switch(opcion){
                    case 1:
                        concepto = "Vacaciones";
                        System.out.println("Introduzca el gasto: ");
                        cantidad = leer.nextDouble();
                        if(cantidad <= saldo){
                            saldo -= cantidad;
                            System.out.println("Gasto realizado con exito");
                            System.out.println(concepto + ": " + cantidad + "€");
                            System.out.println("Saldo actual: " + saldo + "€");
                        } else{
                            System.out.println("Saldo insuficiente para realizar el gasto");
                        }
                        break;
                    case 2:
                        concepto = "Alquiler";
                        System.out.println("Introduzca el gasto: ");
                        cantidad = leer.nextDouble();
                        if(cantidad <= saldo){
                            saldo -= cantidad;
                            System.out.println("Gasto realizado con exito");
                            System.out.println(concepto + ": " + cantidad + "€");
                            System.out.println("Saldo actual: " + saldo + "€");
                        } else{
                            System.out.println("Saldo insuficiente para realizar el gasto");
                        }
                        break;
                    case 3:
                        concepto = "Vicios Variados";
                        System.out.println("Introduzca el gasto: ");
                        cantidad = leer.nextDouble();
                        if(cantidad <= saldo){
                            saldo -= cantidad;
                            System.out.println("Gasto realizado con exito");
                            System.out.println(concepto + ": " + cantidad + "€");
                            System.out.println("Saldo actual: " + saldo + "€");
                        } else{
                            System.out.println("Saldo insuficiente para realizar el gasto");
                        }
                        break;
                    case 4:
                        System.out.println("Saliendo del menu de gastos...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida");
                leer.next();
            }
        } while(opcion != 4);
    }

    public void mostrarNomina(){
        if(!verificarUsuario()){
            return;
        }
        System.out.println("Usuario: " + nombre + ". Saldo: " + saldo + "€");
    }

}
