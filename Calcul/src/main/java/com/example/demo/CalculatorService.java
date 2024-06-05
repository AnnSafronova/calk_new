package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorService {

    @GetMapping("/sum")
    public int sum(@RequestParam String numbers) {
        String[] nums = numbers.split(",");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num.trim());
        }
        return sum;
    }
    //http://localhost:8080/sum?numbers=5,3,2

    @GetMapping("/subtract")
    public int subtract(@RequestParam String numbers) {
        String[] nums = numbers.split(",");
        int result = Integer.parseInt(nums[0].trim());
        for (int i = 1; i < nums.length; i++) {
            result -= Integer.parseInt(nums[i].trim());
        }
        return result;
    }
    // http://localhost:8080/subtract?numbers=10,4,2

    @GetMapping("/multiply")
    public int multiply(@RequestParam String numbers) {
        String[] nums = numbers.split(",");
        int result = 1;
        for (String num : nums) {
            result *= Integer.parseInt(num.trim());
        }
        return result;
    }
    //http://localhost:8080/multiply?numbers=2,3,4

    @GetMapping("/divide")
    public double divide(@RequestParam String numbers) {
        String[] nums = numbers.split(",");
        double result = Double.parseDouble(nums[0].trim());
        for (int i = 1; i < nums.length; i++) {
            double divisor = Double.parseDouble(nums[i].trim());
            if (divisor == 0) {
                throw new IllegalArgumentException("Деление на ноль невозможно");
            }
            result /= divisor;
        }
        return result;
    }
    //http://localhost:8080/divide?numbers=20,5,2

    @GetMapping("/square-root")
    public double squareRoot(@RequestParam int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Квадратный корень из отрицательного числа невозможен");
        }
        return Math.sqrt(number);
    }
    //http://localhost:8080/square-root?number=16

    @GetMapping("/arithmetic-mean")
    public double arithmeticMean(@RequestParam String numbers) {
        String[] nums = numbers.split(",");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num.trim());
        }
        if (sum == 0 && nums.length == 0) {
           throw new IllegalArgumentException("Среднее арифметическое не может быть вычислено для пустого набора чисел");
        }
         return (double) sum / nums.length;
         }
        //http://localhost:8080/arithmetic-mean?numbers=5,7,3,9
    }

