package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static final String[] MONTHS = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};//constante en java se usa Final


    public static void showMenu() {
        System.out.println("Bienvenido al sistema de citas");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Paciente");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine()); //Necesario para leer un dato de teclado

            switch (response) {
                case 1:
                    System.out.println("Bienvenido Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    System.out.println("Bienvenido Pacient@");
                    response = 0;
                    authUser(2);

                    break;
                case 0:
                    System.out.println("Gracias por la visita");
                    break;
                default:
                    System.out.println("Por favor digite una opcion correcta ");
            }
        } while (response != 0);
    }

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1.Agendar Cita");
            System.out.println("2. Mis Citas");
            System.out.println("0. Regresar");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Libro de citas");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i + "." + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::Mis Citas");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void authUser(int userType) {
        //userType = 1
        // userType = 2
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martinez", "Alejandro@mail.com"));
        doctors.add(new Doctor("Karen Sosa", "Karen@mail.com"));
        doctors.add(new Doctor("Rocio Gomez", "Rocio@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Uriel Cruz", "Uriel@mail.com"));
        patients.add(new Patient("Roberto Rodriguez", "Roberto@mail.com"));
        patients.add(new Patient("Carlos Sanchez", "Carlos@mail.com"));

        //Verificacion
        boolean emailCorrect = false;
        do {
            System.out.println("Inserta un correo electronico Ejemplo: [example@mail.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1){
                for (Doctor d: doctors){
                    if (d.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener los datos
                        doctorLogged = d;
                        //Show doctor menu
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }

            if (userType == 2){
                for (Patient p: patients){
                    if (p.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener los datos
                        patientLogged = p;
                        //Show doctor menu
                        UiPatientMenu.showPatientMenu();
                    }
                }

            }
        } while (!emailCorrect);
    }


}