package example.techcourse0613.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeLogAop {

    // Advice의 종류 : Before / After returning / After throwing /After / Around
    @Around("execution(* example.techcourse0613..*(..))") // 메서드 호출 전후에 수행. execution이 메서드 실행 조인포인트 매칭
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        System.out.println("START time: " + joinPoint.toString());

        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END time: " + joinPoint.toString() + " " + timeMs + " ms");

        }
    }
}
