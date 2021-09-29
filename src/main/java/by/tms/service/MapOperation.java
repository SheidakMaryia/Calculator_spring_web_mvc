package by.tms.service;

import by.tms.service.operations.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public class MapOperation {
    public static final Map<String , MathOperation> MAP_OPERATION = new HashMap();

    static{
        MAP_OPERATION.put("addition", new Addition());
        MAP_OPERATION.put("subtraction", new Subtraction());
        MAP_OPERATION.put("multiplication", new Multiplication());
        MAP_OPERATION.put("division", new Division());
    }
}
