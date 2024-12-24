package com.example.demo.services;

import com.example.demo.entities.Test;
import com.example.demo.repositories.TestRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.InputStreamReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoadService {

    private final TestRepository testRepository;

    public DataLoadService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void loadCsvData(String s) throws IOException {
        ClassPathResource resource = new ClassPathResource("static/data.csv");

        try (Reader reader = new InputStreamReader(resource.getInputStream());
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("id", "first_name", "last_name", "email", "gender", "ip_address", "country"))) {

            List<Test> tests = new ArrayList<>();

            for (CSVRecord csvRecord : csvParser) {
                Test test = new Test();
                test.setFirst_name(csvRecord.get("first_name"));
                test.setLast_name(csvRecord.get("last_name"));
                test.setEmail(csvRecord.get("email"));
                test.setGender(csvRecord.get("gender"));
                test.setIp_address(csvRecord.get("ip_address"));
                test.setCountry(csvRecord.get("country"));

                tests.add(test);
            }

            testRepository.saveAll(tests);
        }
    }

    public void loadJsonData(String filePath) {
    }
}

