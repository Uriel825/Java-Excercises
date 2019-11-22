package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UiPatientMenu {
    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Hola Paciente");
            System.out.println("Sea Bienvenid@ " + UiMenu.patientLogged.getName());
            System.out.println("1. Agrendar una cita");
            System.out.println("2. Mis citas");
            System.out.println("0. Logout");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientAppointments();
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
            }
        } while (response != 0);

    }

    private static void showBookAppointmentMenu() {
        int response = 0;

        do {
            System.out.println("Libro de citas");
            System.out.println("Selecciona una fecha");
            //Recorrer un arbol
            //Integer Numeracion de la lista de fechas
            //INdice de la fecha seleccionada
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctoresAvailableAppointment.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctoresAvailableAppointment.get(i).getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + "." + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctoresAvailableAppointment.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }

            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelect = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelect = doctors.get(responseDateSelect);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");
            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelect.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    "Date" + doctorSelected.getAvailableAppointments().get(indexDate).getDate()
                    + "Hora:" + doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("Confirma la cita \n1.Si \n2.Cambiar fecha");
            response = Integer.valueOf(sc.nextLine());
            if (response == 1) {
                UiMenu.patientLogged.addAppointmentDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }
        } while (response != 0);


    }
    private static void showPatientAppointments(){
        int response = 0;
        do{
            System.out.println("Mis citas");
            if(UiMenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("NO tienes citas");
                break;
            }
            for (int i = 0; i <UiMenu.patientLogged.getAppointmentDoctors().size() ; i++) {
                int j = i+1;
                System.out.println(j + "." +
                        "Fecha" + UiMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        "Hora" + UiMenu.patientLogged.getAppointmentDoctors().get(i).getTime()+
                        "Doctor" + UiMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
                );
            }
            System.out.println("0. Regresar");
        }while (response !=0);
    }
}
