package patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClinicCalendarTest {

    @Test
    public void allowEntryOfAnAppointment() {
        ClinicCalendar calendar = new ClinicCalendar();
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
}