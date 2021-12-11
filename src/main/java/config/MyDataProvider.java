package config;

import models.Auth;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    private Iterator<Object[]> loginDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"0.0.3", "hog@gmail.com", "12345hoSg!"});
        list.add(new Object[]{"0.0.3", "hog@gmail.com", "12345hoSg!"});
        list.add(new Object[]{"0.0.3", "hog@gmail.com", "12345hoSg!"});

        return list.iterator();
    }

    @DataProvider
    private Iterator<Object[]> loginDto2() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"hog@gmail.com", "12345hoSg!"});
        list.add(new Object[]{"hog@gmail.com", "12345hoSg!"});
        list.add(new Object[]{"hog@gmail.com", "12345hoSg!"});

        return list.iterator();
    }
    @DataProvider
    private Iterator<Object[]> loginModelDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder().email("hog@gmail.com").password("12345hoSg!").build()});
        list.add(new Object[]{Auth.builder().email("hog@gmail.com").password("12345hoSg!").build()});
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> loginCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader
                        (new FileReader
                                (new File
                                        ("E:\\QA30\\POM_Qa30_SuperScheduler\\src\\test\\resources\\data.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Auth.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginNegativeCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader
                        (new FileReader
                                (new File
                                        ("E:\\QA30\\POM_Qa30_SuperScheduler\\src\\test\\resources\\dataNegative.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Auth.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    private Iterator<Object[]> loginNegativeModelDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder().email("hog@gmail.com").password("Ff123456").build()});
        list.add(new Object[]{Auth.builder().email("hog@gmail.com").password("Ff123456").build()});
        list.add(new Object[]{Auth.builder().email("hog@gmail.com").password("Ff123456").build()});
        return list.iterator();
    }
}
