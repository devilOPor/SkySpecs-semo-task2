package com.skyspecs.task2.repo;

import com.skyspecs.task2.entity.SemoDispatchDownEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppRepositoryImpl implements AppRepository {


    public List<SemoDispatchDownEntity> loadFromCsv() {

        List<SemoDispatchDownEntity> list = new ArrayList<>();
        try {
            Resource resource = new ClassPathResource("/csv/SemoDispatchDown.csv");
            File file = resource.getFile();
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                SemoDispatchDownEntity entity = new SemoDispatchDownEntity();
                entity.setId(Long.parseLong(csvRecord.get("id")));
                entity.setStartTime(Timestamp.valueOf(csvRecord.get("start_time")));
                entity.setEndTime(Timestamp.valueOf(csvRecord.get("end_time")));
                entity.setQboa(Double.parseDouble(csvRecord.get("qboa")));
                list.add(entity);
            }
        } catch(Exception exception){
                System.out.println(exception);
            }
        return list;
    }
}
