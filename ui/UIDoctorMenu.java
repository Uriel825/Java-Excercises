package ui;

import model.Doctor;
import ui.UiMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {
    public static ArrayList<Doctor> doctoresAvailableAppointment = new ArrayList<>();
    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Hola Doctor");
            System.out.println("Sea Bienvenid@ "+ UiMenu.doctorLogged.getName());
            System.out.println("1. Agregar una cita");
            System.out.println("2. Mis citas");
            System.out.println("0. Logout");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response){
                case 1:
                    showAdvailableAppointmentMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
            }



        }while (response != 0);
    }
    private static void showAdvailableAppointmentMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println("Agregar cita disponible");
            System.out.println("Seleccione un mes");
            for (int i = 0; i < 3 ; i++) {
                int j = i+1;
                System.out.println(j+"."+UiMenu.MONTHS[i]);

            }
            System.out.println("0.Regresar");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            if (response > 0 &&  response < 4 ){
                int monthSelected = response;
                System.out.println(monthSelected+"."+UiMenu.MONTHS[monthSelected-1]);
                System.out.println("Inserte la fecha disponible: [dd/mm/yy/] ");
                String date = sc.nextLine();
                System.out.println("La cita es"+date+"\n1.Correcto \n2.Cambiar cita");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue; //evita la sig linea no se sale del ciclo
                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Inserte la hora para esta fecha:" +date+ "[16:00]");
                    time= sc.nextLine();
                    System.out.println("La hora es" +time+ "\n1.Correcto \n2.Cambiar hora");

                }while (responseTime == 2);

                UiMenu.doctorLogged.addAvailableAppointment(date,time);
                checkDoctorAvailable(UiMenu.doctorLogged);


            }else if (response == 0){
                showDoctorMenu();
            }
        }while (response != 0);
    }

    private static void checkDoctorAvailable(Doctor doctor){
        if (doctor.getAvailableAppointments().size()>0 && !doctoresAvailableAppointment.contains(doctor)){
            doctoresAvailableAppointment.add((doctor));
        }
    }
}
