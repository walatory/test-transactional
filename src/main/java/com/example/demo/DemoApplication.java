package com.example.demo;

import com.example.demo.mapper.TMapper;
import com.example.demo.service.TSEntity;
import com.example.demo.service.TService;
import com.example.demo.util.Utils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sun.misc.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@EnableAutoConfiguration
@MapperScan("com.example.demo.mapper.**")
@SpringBootApplication
public class DemoApplication {

    private static final List<TSEntity> results = new ArrayList<>(512);

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        TMapper tMapper = run.getBean(TMapper.class);

        TService bean = run.getBean(TService.class);

        List<Consumer<TSEntity>> tras = Arrays.asList(bean::rd, bean::ss, bean::mt, bean::rn, bean::ns, bean::nr, bean::ne, bean::none);
        List<String> trasNames = Arrays.asList("rd", "ss", "mt", "rn", "ns", "nr", "ne", "none");
        List<Boolean> bools = Arrays.asList(true, false);

        FATHER:
        for (int i = 0; i < tras.size(); i++) {
            Consumer<TSEntity> father = tras.get(i);
            for (Boolean fatherThrow : bools) {
                SUN:
                for (int i1 = 0; i1 < tras.size(); i1++) {
                    Consumer<TSEntity> sun = tras.get(i1);
                    for (Boolean sunThrow : bools) {

                        List<Boolean> bools1 = bools;
                        if (!sunThrow){
                            bools1 = new ArrayList<>();
                            bools1.add(null);
                        }
                        for (Boolean fatherCatch : bools1) {
                            TSEntity en = new TSEntity();
                            en.setFatherName(trasNames.get(i));
                            en.setSunName(trasNames.get(i1));
                            en.setFather(father);
                            en.setSun(sun);
                            en.setSunThrow(sunThrow);
                            en.setFatherCatch(fatherCatch);
                            en.setFatherThrow(fatherThrow);
                            run(tMapper, en);
                            if (!en.isCanCallFather()) {
                                continue FATHER;
                            }
                            if (!en.isCanCallSun()) {
                                continue SUN;
                            }
                        }
                    }
                }
            }
        }
        for (TSEntity result : results) {
            System.out.println(result);
        }
        List<String> collect = results.stream().map(e -> Arrays.asList(e.getFatherName(), e.getSunName(), e.isFatherThrow(), e.isSunThrow(), e.isFatherCatch(), e.isCanCallFather(), e.isCanCallSun(), e.getSunCanSeeFather(), e.getFatherCanSeeSun(), String.join("|", e.getResult())))
                .map(x -> x.stream().map(y -> String.valueOf(y)).collect(Collectors.toList()))
                .map(x -> String.join(",", x))
                .collect(Collectors.toList());
        collect.add(0, "father,sun,fatherthrow,sunthrow,fathercatch,cancallfather,cancallsun,suncanseefather,fathercanseesun,result");
        Files.write(Paths.get("d://x.csv"), String.join("\n", collect).getBytes());
    }

    private static void run(TMapper tMapper, TSEntity en) throws InterruptedException {
        tMapper.init1();
        tMapper.init2();
        Thread thread = new Thread(() -> {
            try {
                en.getFather().accept(en);
            } catch (Exception e) {
                // ignore
            } finally {
                en.setResult(tMapper.select());
                results.add(en);
            }
        });
        thread.start();
        thread.join();
    }
}
