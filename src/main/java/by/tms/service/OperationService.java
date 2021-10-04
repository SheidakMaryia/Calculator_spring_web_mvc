package by.tms.service;

import by.tms.dao.OperationDao;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.operations.MathOperation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class OperationService {

    private OperationDao operationDao;

    static double result = 0;

    public OperationService(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public void saveMathOperation(Operation operation){
        operationDao.saveOperations(operation);
    }

    public List<Operation> showHistoryByLogin(String login){
        return operationDao.showHistoryByLogin(login);
    }

    public Operation getResult(double num1, double num2, String operation, User user){
        if (MapOperation.MAP_OPERATION.containsKey(operation)){
            MathOperation mathOp = MapOperation.MAP_OPERATION.get(operation);
            result = mathOp.getCalc(num1, num2);
            BigDecimal resultBD = new BigDecimal(result);
            resultBD = resultBD.setScale(3, RoundingMode.DOWN);
            result = resultBD.doubleValue();
        }
        saveMathOperation(new Operation(num1, num2, operation, result, user));
        return new Operation(num1, num2, operation, result, user);
    }
}
