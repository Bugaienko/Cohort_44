package ait.car;

import ait.car.dto.CarDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CarRestoreApp {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        // Jackson требует наличия пустого конструктора для создания объекта
        CarDto carDto = mapper.readValue(
                new File("vw.json"),
                CarDto.class);

        System.out.println(carDto);
    }
}
