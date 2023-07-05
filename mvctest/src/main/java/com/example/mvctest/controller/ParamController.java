package com.example.mvctest.controller;

import com.example.mvctest.dto.ParamDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class ParamController {

    /* @PathVariable을 이용한 파라미터 처리 */
    @GetMapping("param4/{name}/{age}")
    public String param4(@PathVariable String name, @PathVariable String age, Model model) {

        log.info("name = {}", name);
        log.info("age = {}", age);

        model.addAttribute("title", "param4");
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return"paramResult";
    }

    /* DTO, VO 객체를 이용한 파라미터 처리 */
    @GetMapping("param3")
    public String param3(ParamDto paramDto, Model model) {

        log.info("paramDto.getName() = {}", paramDto.getName());
        log.info("paramDto.getAge() = {}", paramDto.getAge());

        model.addAttribute("title", "param3");
        model.addAttribute("name", paramDto.getName());
        model.addAttribute("age", paramDto.getAge());

        return "paramResult";
    }


    /* @RequestParam 객체를 이용한 파라미터 처리 */
    @GetMapping("param2")
    public String param2(@RequestParam("name") String name,
                         @RequestParam("age") int age,
                         Model model) {

        log.info("name = {} ", name);
        log.info("age = {}", age);

        model.addAttribute("title", "param2");
        model.addAttribute("name", name);
        model.addAttribute("age", age);


        return"paramResult";
    }

    /* HttpServletRequest 객체를 이용한 파라미터 처리 */
    @GetMapping("param1")
    public String param1(HttpServletRequest request, Model model) {
        var name = request.getParameter("name");
        var age = request.getParameter("age");

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "paramResult";
    }

    @GetMapping("param")
    public String param() {
        return "paramTest";
    }
}
