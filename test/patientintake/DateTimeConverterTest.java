package patientintake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateTimeConverterTest {

    @Test
    public void convertStringToDateTime_today() {
        LocalDateTime result = DateTimeConverter.convertStringToDateTime("today 5:00 pm",
                LocalDate.of(2022, 5, 23));
        assertEquals(result, LocalDateTime.of(2022, 5, 23, 17, 0));
    }

    @Test
    public void convertStringToDateTime_dateInput() {
        LocalDateTime result = DateTimeConverter.convertStringToDateTime("05/23/2022 5:00 pm",
                LocalDate.of(2022, 5, 23));
        assertEquals(result, LocalDateTime.of(2022, 5, 23, 17, 0));
    }

    @Test
    public void convertStringToDateTime_exception() {
        Throwable error = assertThrows(RuntimeException.class, () ->
                DateTimeConverter.convertStringToDateTime("05 23 2022", LocalDate.of(2021, 05, 23)));
        assertEquals("Unable to create date time from: [05 23 2022], please enter with format [M/d/yyyy h:mm a], Text '05 23 2022' could not be parsed at index 2",
                error.getMessage());
    }


}