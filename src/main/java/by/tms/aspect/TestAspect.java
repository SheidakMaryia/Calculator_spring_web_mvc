package by.tms.aspect;

import by.tms.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
public class TestAspect {

    private final Logger logger = LoggerFactory.getLogger(TestAspect.class.getName());

    @Pointcut("execution(public * by.tms.controller.UserController.reg(..)) && args(user, ..))")
    public void registration(User user){}

    @After(value = "registration(user)", argNames = "user")
    public void logOfReg(User user){
        logger.info("Register new user - {}.", user.getName());
    }


    @Pointcut("execution(public * by.tms.controller.UserController.auth(..)) && args(user, ..))")
    public void authorization(User user){}

    @After(value = "authorization(user)", argNames = "user")
    public void logOfAuth(User user){
        logger.info("Successful logIn for user - {}.", user.getName());
    }


//    @Pointcut("execution(public * by.tms.service.UserService.save(..)))")
//    public void loggingOfMethodSave() {}
//
//    @After(value = "loggingOfMethodSave()")
//    public void save(ProceedingJoinPoint jp) throws Throwable {
//        Object proceed = jp.proceed();
//        logger.info("Save new user {} ", user.getName());
//    }



    //from lecture

//    @Pointcut("execution(public * by.tms.service.UserService.save(..))")//срез к чему применяется аспект
//    public void test() {}
//
//    @Before("test()")
//    public void abc(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Hello World!");
//        Object proceed = joinPoint.proceed();// получить то, что возвращает данный метод и обработать
//        System.out.println("Bye");
//    }
//



}
