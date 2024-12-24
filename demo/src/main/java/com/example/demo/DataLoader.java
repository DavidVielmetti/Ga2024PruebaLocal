package com.example.demo;



import com.example.demo.services.DataLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
@Order(1)
public class DataLoader implements CommandLineRunner {

    private final DataLoadService dataLoadService;

    @Autowired
    public DataLoader(DataLoadService dataLoadService) {
        this.dataLoadService = dataLoadService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Quieres cargar los datos iniciales en la base de datos? (S/N)");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("s")) {
            dataLoadService.loadCsvData("static/data.csv");
            System.out.println("Datos cargados correctamente.");
        } else {
            System.out.println("No se cargaron los datos.");
        }

        scanner.close();
    }
}



