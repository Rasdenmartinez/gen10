package ms.tienda.service.impl;

import ms.tienda.entity.Example;
import ms.tienda.repository.ExampleRepository;
import ms.tienda.service.IExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService implements IExampleService {
    @Autowired
    ExampleRepository exampleRepository;

    @Override
    public List<Example> read() {
        return exampleRepository.findAll();
    }
}
