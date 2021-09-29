package by.tms.dao;

import by.tms.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryOperationDaoImpl implements OperationDao{
    private final static List<Operation> operations = new ArrayList<>();

    @Override
    public void saveOperations(Operation operation) {
        operations.add(operation);
    }

    @Override
    public List<Operation> showHistory() {
        return operations;
    }

    @Override
    public List<Operation> showHistoryByLogin(String login) {
        return operations.stream().filter(x -> x.getUser().getLogin().equals(login)).collect(Collectors.toList());
    }
}
