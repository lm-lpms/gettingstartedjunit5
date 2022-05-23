package patientintake;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

    private ClinicCalendar calendar;

    @BeforeEach
    void setup(){
        calendar = new ClinicCalendar(LocalDate.of(2022, 5,23));
    }

    @Test
    public void allowEntryOfAnAppointment() {
        calendar.addAppointment("Luiz", "Santos", "avery", "05/20/2022 2:00 pm");
        List<PatientAppointment> appointments = calendar.getAppointments();
        PatientAppointment appointment = appointments.get(0);
        assertNotNull(appointments);
        assertEquals(1, appointments.size());
        assertEquals("Luiz", appointment.getPatientFirstName());
        assertEquals("Santos", appointment.getPatientLastName());
        assertEquals(Doctor.avery, appointment.getDoctor());
        assertEquals("05/20/2022 2:00 PM",
                appointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("MM/d/yyyy h:mm a")));
    }

    @Test
    public void hasAppointment_valid() {
        calendar.addAppointment("Luiz", "Santos", "avery", "05/20/2022 2:00 pm");
        assertTrue(calendar.hasAppointment(LocalDate.of(2022, 5, 20)));
    }

    @Test
    public void hasAppointment_invalid() {
        assertFalse(calendar.hasAppointment(LocalDate.of(2022, 5, 20)));
    }

    @Test
    public void getTodayAppointment() {
        calendar.addAppointment("Luiz", "Santos", "avery", "05/23/2022 2:00 pm");
        calendar.addAppointment("Esteban", "Strange", "avery", "05/23/2022 2:00 pm");
        calendar.addAppointment("Esteban", "Strange", "avery", "05/24/2022 2:00 pm");
        assertEquals(2, calendar.getTodayAppointments().size());
    }



}