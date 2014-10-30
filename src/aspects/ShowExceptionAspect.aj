package aspects;

import org.aspectj.lang.annotation.AfterThrowing;

public aspect ShowExceptionAspect {
	@AfterThrowing(pointcut = "execution(* hw4.ChessBoard.move(..))", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println(ex.getMessage());
	}
}
