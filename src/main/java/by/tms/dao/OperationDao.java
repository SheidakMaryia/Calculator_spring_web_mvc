package by.tms.dao;

import by.tms.entity.Operation;

import java.util.List;

public interface OperationDao {
    void saveOperations (Operation operation);

    List<Operation> showHistory();

    List<Operation> showHistoryByLogin(String login);
}
