package com.example.mvctest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Rest API 연동을 위한 컨트롤러 : 문자열 형태로 리턴
public class TestController {

    @GetMapping("/test2")
    public Person test2(@RequestParam("name") String name, @RequestParam("age") int age)  {
        Person p = new Person();
        p.setName(name);
        p.setAge(age);
        return p;
    }

    /* static 클래스 형태로 리턴되는 JSON 객체 생성 */
    static class Person {
        private String name;
        private int age;

        public String getName() { return name; }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

    }

    @GetMapping("/test1")
    public String test1() {
        return "api test1~~";
    }
}
