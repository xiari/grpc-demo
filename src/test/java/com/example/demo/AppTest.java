package com.example.demo;

import com.example.functionInterface.PeoplObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTest {

    public static void main(String[] args){

        Runnable r = () -> System.out.println("hello world");
        Thread t = new Thread(r);
        t.start();

        Thread t1 = new Thread( () -> System.out.println(" thread t1 ..."));
        t1.start();

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println("fadf"+ list.stream().map(x -> x*x ).reduce((a,b)-> a+b).get());

        System.out.println(list.stream().flatMap(item -> list.stream()).findFirst().isPresent());

        List<PeoplObject.People> peoplObjectList = Arrays.asList(
                new PeoplObject.People(PeoplObject.CareerType.Dockor,12),
                new PeoplObject.People(PeoplObject.CareerType.Student,12),
                new PeoplObject.People(PeoplObject.CareerType.Teacher,12),
                new PeoplObject.People(PeoplObject.CareerType.Teacher,10),
                new PeoplObject.People(PeoplObject.CareerType.Teacher,8),
                new PeoplObject.People(PeoplObject.CareerType.Teacher,6)
        );

        // 求和
        System.out.println(peoplObjectList
                .stream()
                .filter(people -> people.getCareerType().equals(PeoplObject.CareerType.Teacher))
                .mapToInt(PeoplObject.People::getAge)
                .sum()
        );

        // 分组
        System.out.println(peoplObjectList
                .stream()
                .collect(Collectors.groupingBy(PeoplObject.People::getCareerType)));


        // 文件读取
        final Path path = new File("/Users/xiayuanyuan/devpath/demo/src/test/java/com/example/demo/DemoApplicationTests.java").toPath();
        try {
            Stream<String> lines =  Files.lines(path, Charset.defaultCharset());
            lines.forEach(line -> System.out.println(line));
            lines.onClose(() -> System.out.println("done!")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("000");
    }
}
