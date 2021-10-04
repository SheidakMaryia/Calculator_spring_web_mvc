package by.tms.utils;

import by.tms.dto.OperationDTO;
import by.tms.dto.UserAllFieldsDTO;
import by.tms.dto.UserLoginPasswordDTO;
import by.tms.entity.Operation;
import by.tms.entity.User;

public class ConversionOfDTO {
    public static User getUserWithAllField(UserAllFieldsDTO userAllFieldsDTO){
        return new User(userAllFieldsDTO.getName(), userAllFieldsDTO.getLogin(), userAllFieldsDTO.getPassword());
    }

    public static User getUserWithLoginPassword(UserLoginPasswordDTO userLoginPasswordDTO){
        return new User(userLoginPasswordDTO.getLogin(), userLoginPasswordDTO.getPassword());
    }

    public static Operation getMathOperation(OperationDTO operationDTO){
        return new Operation(operationDTO.getNum1(), operationDTO.getNum2(), operationDTO.getTypeOfOperation());
    }
}
