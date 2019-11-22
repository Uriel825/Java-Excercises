package model;
import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {   //extends permite aplicar herencia
    private String birthday, blood;
    private double height, weight;
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();


    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this ,doctor);
        appointmentDoctor.schedule(date,time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public Patient(String name, String email){
        super(name, email); //es para aplicar herencia metodo constructor al usar el super ya no necesita los this
        //this.name = name;  //de varaibles globales pasan a variables locales
        //this.email = email;//al ser sobre cargado deben de ir datos para evitar  lo nulo

    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return this.weight + "Kg";
    }

    public String getHeight() {
        return this.height + "Mts";
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() +"\nAge:" + birthday + "\nWeight:" + getWeight() + "\nHeight:" + getHeight() +"\nBlood:"+blood ;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial del paciente");
    }
}
