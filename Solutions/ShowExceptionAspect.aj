package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ShowExceptionAspect {
	@AfterThrowing(pointcut = "execution(* hw4.ChessBoard.move(..))", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		StringBuilder sb = new StringBuilder();
		sb.append("Exception thrown at execution(");
		sb.append(joinPoint.getStaticPart().getSignature());
		sb.append(") with message [");
		sb.append(ex.getMessage());
		sb.append("]");
		System.out.println(sb.toString());
	}
}
