package ua.edu.knu;

import org.kie.api.runtime.KieSession;
import ua.edu.knu.config.DroolsBeanFactory;
import ua.edu.knu.entities.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
    // Створення нової сесії Drools
        KieSession ksession = new DroolsBeanFactory().getKieSession();

    // Створення нового об'єкту Car для запитань та відповідей
        Car car = new Car();

    // Задання питань про характеристики автомобіля та запис в об'єкт Car
        System.out.println("Який розмір вашого автомобіля? (small, medium, large)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String size = reader.readLine();
        car.setSize(size);

        System.out.println("Яка вартість вашого автомобіля? (введіть число)");
        double cost = Double.parseDouble(reader.readLine());
        car.setCost(cost);

        System.out.println("Скільки дверей у вашому автомобілі?");
        int doors = Integer.parseInt(reader.readLine());
        car.setDoors(doors);

        System.out.println("Скільки місць у вашому автомобілі?");
        int seats = Integer.parseInt(reader.readLine());
        car.setSeats(seats);

        System.out.println("Скільки коліс у вашому автомобілі?");
        int wheels = Integer.parseInt(reader.readLine());
        car.setWheels(wheels);

        System.out.println("Який тип двигуна у вашому автомобілі? (gasoline, diesel)");
        String engineType = reader.readLine();
        car.setEngineType(engineType);

    // Виконання правил в режимі експерта та визначення типу автомобіля
        ksession.insert(car);
        ksession.fireAllRules();

    // Закриття сесії Drools
        ksession.dispose();
    }

}
