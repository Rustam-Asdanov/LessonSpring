package com.aop.after_throwing.aspect;

import com.aop.after_throwing.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
@Aspect
public class AspectDemo {

    @Pointcut("execution(* com.aop.after_throwing.dao.AccountDAO.findAccounts(..))")
    public void pointFunction(){}

    @AfterThrowing(
            pointcut = "pointFunction()",
            throwing = "theExc"
    )
    private void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,
            Throwable theExc
    ){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);
    }

    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(pointcut = "pointFunction()",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result
    ){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n======>>> result is: " + result);

        // let's post-process the data ... let's modify it :-)

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n======>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts

        for(Account theAccount : result) {
            // get uppercase version of name
            String theUpperName = theAccount.getName().toUpperCase(Locale.ROOT);

            // update the name on the account
            theAccount.setName(theUpperName);

        }


    }
}
