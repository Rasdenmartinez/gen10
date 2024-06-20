package ms.tienda.controller;

import ms.tienda.entity.Example;
import ms.tienda.service.IExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ExampleController {
    @Autowired
    IExampleService exampleService;

    @GetMapping("/example")
    public List<Example> read(){
        return exampleService.read();
    }
}
