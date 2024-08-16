package app.repository;

import app.model.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 15.08.2024
 */

public class CarRepositoryHibernate implements CarRepository {

    private EntityManager entityManager;

    public CarRepositoryHibernate() {
        entityManager = new Configuration()
                .configure("hibernate/postgres.cfg.xml")
                .buildSessionFactory().createEntityManager();
    }

    @Override
    public List<Car> getAll() {
        //TODO Homework
        return List.of();
    }

    @Override
    public Car save(Car car) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(car);
            transaction.commit();
        } catch (Exception e) {
            // Проверяем открыта ли еще транзакция
            if (transaction.isActive()) {
                // Откатывает транзакцию вручную для более быстрого освобождения ресурсов
                transaction.rollback();
            }
        }

        return car;
    }

    @Override
    public Car findById(long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public Car update(Car car) {
        //TODO Homework
        return null;
    }

    @Override
    public void delete(Car car) {
        //TODO Homework
    }
}
