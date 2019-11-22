package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    //aributos
    //autoincrement
    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>(); //crea una lista de metodos y clases
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Doctor(String name, String email) {
        super(name, email);
    }

    // comportamientos
    //public void showName() {
    //System.out.println(name);
    //}



    public void addAvailableAppointment(String date, String time){   // nuevo metodo para add citas
        availableAppointments.add(new Doctor.AvailableAppointment(date, time)); // generador de citas

    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() { //Devuelve la lista de array
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEspeciality:"+speciality+"\nAvailable:"+availableAppointments.toString();//para traer los datos de la super clase se usa el return super .to string
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del hospital: Quirurgico");
        System.out.println("Departamento: Nutriologia");

    }

    public static class AvailableAppointment {
        private int id;
        private Date date;    /* Clases anidadas necesario repasar*/
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("/dd/MM/yyyy"); //cambia de string a date

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate() {
            return format.format(date);
        }


        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appoinment \nDate:" + date  + "\nTime:"+time;
        }
    }

}

