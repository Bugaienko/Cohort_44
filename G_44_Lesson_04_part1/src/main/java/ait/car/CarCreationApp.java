package ait.car;

import ait.car.dto.CarDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarCreationApp {
    // Объект который занимается преобразованием Java -> JSON > Java
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {



        List<String> models = List.of("Polo", "Golf", "Tiguan");
        CarDto carDto = new CarDto("VW", 2020, models);

        // Для преобразования JAVA -> JSON в объекте должны быть шеттера!

        mapper.writeValue(new File("vw.json"), carDto);




    }
}
