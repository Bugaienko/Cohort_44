package app.controller;

import app.repository.CarRepository;
import app.repository.CarRepositoryMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CarServlet extends HttpServlet {

    private CarRepository repository = new CarRepositoryMap();

    // GET http://10.2.3.34:8080/cars


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Для получения из БД всех или одного(по id) автомобиля
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Для сохранения нового автомобиля в БД
        super.doPost(req, resp);
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
