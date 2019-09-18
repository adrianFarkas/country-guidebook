package com.codecool.countryguidebook;

import com.codecool.countryguidebook.dao.CountryDaoMem;
import com.codecool.countryguidebook.dao.TmptestDao;
import com.codecool.countryguidebook.model.FilterCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CountryGuidebookApplication {

    @Autowired
    private TmptestDao tmp;

    public static void main(String[] args) {
        SpringApplication.run(CountryGuidebookApplication.class, args);
    }

    @PostConstruct
    public void temp(){
        tmp.testDao();

    }
}
