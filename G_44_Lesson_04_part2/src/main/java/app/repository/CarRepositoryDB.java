package app.repository;

import app.constants.Constants;
import app.model.Car;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

import static app.constants.Constants.*;

/**
 * @author Sergey Bugaenko
 * {@code @date} 13.08.2024
 */

public class CarRepositoryDB implements CarRepository{

    private Connection getConnection() {
        // jdbc:postgresql://localhost:5432/g_44_cars?user=postgres&password=pos1234
        try {
            Class.forName(DB_DRIVER_PATH);
            String dbUrl = String.format("%s/%s?user=%s&password=%s",
                    DB_ADDRESS, DB_NAME, DB_USER, DB_PASSWORD);

            return DriverManager.getConnection(dbUrl);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Car> getAll() {
        //TODO Homework
        try (Connection connection = getConnection()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }

    @Override
    public Car save(Car car) {

        try (Connection connection = getConnection()) {
            String query = String.format("INSERT INTO car (brand, price, year) VALUES ('%s', '%s', %d);",
                    car.getBrand(), car.getPrice(), car.getYear());

            // Интерфейс, который умеет осуществлять запросы в БД
            Statement statement = connection.createStatement();

            // execute() - для внесения изменений в БД
            // executeQuery() - для получение данных

            statement.execute(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = statement.getGeneratedKeys();

            // Вытаскиваю значение из первой строчки Result-сета, в колонке "id" и преобразую его в формат Long;
            resultSet.next();
            Long id = resultSet.getLong("id");

            car.setId(id);

            return car;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Car findById(long id) {
        try (Connection connection = getConnection()) {

            String query = String.format("SELECT * FROM car WHERE id = %d;", id);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                // пришла строка с автомобилем
                String brand = resultSet.getString("brand");
                BigDecimal price = resultSet.getBigDecimal("price");
                int year = resultSet.getInt("year");

                return new Car(id, brand, price, year);


            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Car update(Car car) {
        //TODO Homework
        try (Connection connection = getConnection()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(Car car) {
        try (Connection connection = getConnection()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //TODO Homework
    }
}
