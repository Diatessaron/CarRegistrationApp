package ru.fazlyev.carregistrationservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.fazlyev.carregistrationservice.dto.CarDto;
import ru.fazlyev.carregistrationservice.service.CarServiceImpl;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarServiceImpl carService;

    @Test
    void positiveTestGetByNameByStatus() throws Exception {
        final CarDto carDto = CarDto.builder()
                .id(1L)
                .brand("VW")
                .color("White")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(carDto);

        doNothing().when(carService).registerCar(carDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    void negativeTestGetByNameByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cars"))
                .andExpect(status().is4xxClientError());
    }
}
