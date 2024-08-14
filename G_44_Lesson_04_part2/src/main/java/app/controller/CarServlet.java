package app.controller;

import app.model.Car;
import app.repository.CarRepository;
import app.repository.CarRepositoryDB;
import app.repository.CarRepositoryMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CarServlet extends HttpServlet {

    private CarRepository repository = new CarRepositoryDB();
    private ObjectMapper mapper = new ObjectMapper();

    // GET http://10.2.3.34:8080/cars - список всех машин
    // GET localhost:8080/cars?id=1 - получить один автомобиль по id


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Для получения из БД всех или одного(по id) автомобиля

        /*
        Request - это объект запроса. Из него мы можем извлечь все, что прислал клиент
        Response - это объект ответа, который будет направлен клиенту.
        Мы можем в этот объект ответа поместить всю информацию, которую мы хотим отправить клиенту.
         */

        // Устанавливаем тип контента JSON
        response.setContentType("application/json");

        // Берем из реквеста мапу, содержащую все параметры запроса
        Map<String, String[]> params = request.getParameterMap();
        // "id" : ["1"]

        if (params.isEmpty()) {
            // Пришел запрос /cars
            List<Car> cars = repository.getAll();

            // Преобразуем список машин в JSON
            String json = mapper.writeValueAsString(cars);

            response.getWriter().write(json);
        } else {
            // В запросе есть какие-то параметры
            // GET localhost:8080/cars?id=1 - получить один автомобиль по id
            String idFromMap = params.get("id")[0];
            Long id = Long.parseLong(idFromMap);
            Car car = repository.findById(id);
            if (car == null) {
                // Возвращаем 404 код, в случае если car найти не далось
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Car not found");
            } else {
                // Преобразуем java-объект машины в json-объект
                String json = mapper.writeValueAsString(car);
                response.getWriter().write(json);
            }

        }





//        cars.forEach(car -> {
//            try {
//                response.getWriter().write(car.toString() + "\n");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Для сохранения нового автомобиля в БД

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Для изменения существующего автомобиля
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Для удаления автомобиля из БД
        super.doDelete(req, resp);
    }
}
