package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorService {

    @GetMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
   // http://localhost:8080/sum?a=5&b=3

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }
    //http://localhost:8080/subtract?a=10&b=4

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно");
        }
        return a / b;
    }

    @GetMapping("/square-root")
    public double squareRoot(@RequestParam int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Квадратный корень из отрицательного числа невозможен");
        }
        return Math.sqrt(a);
    }

    @GetMapping("/arithmetic-mean")
    public double arithmeticMean(@RequestParam int a, @RequestParam int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Среднее арифметическое не может быть вычислено для двух нулевых чисел");
        }
        return (a + b) / 2.0;
    }
}