package com.braxbeckman.tttspringbootpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
    @RequestMapping("/test")
    public String test() {
        return "test.html";
    }
    @GetMapping("/computer")
    public Map<String, Integer> computer() {
        char[] testBoard = {'X',  'X', 'O', '4', '5', 'O', '7', 'X', '9'};
        Board b = new Board();
        ComputerPlayer cp = new ComputerPlayer('X', b);
        Map<String, Integer> output = new HashMap<>();
        output.put("space", cp.getFirstAvailableMove(testBoard));
        return output;
    }
}
