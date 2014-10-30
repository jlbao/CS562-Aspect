package aspects;

public aspect ObserverReporterAspect {
	pointcut captureObserverMethod(Object subject, Object event) : 
	      call(void hw4.Observer.update(Object, Object)) && args(subject, event);

	// Advice declaration
	before(Object subject, Object event) : captureObserverMethod(subject, event){
		StringBuilder sb = new StringBuilder();
		sb.append("Method call to ");
		sb.append(subject);
		sb.append(" from");
		sb.append(thisJoinPoint.getStaticPart().getSourceLocation());
		System.out.println(sb.toString());
	}

	pointcut executionPointcut(Object subject, Object event) : 
		execution(void hw4.Observer.update(Object, Object)) && args(subject, event);

	// Advice declaration
	before(Object subject, Object event) : executionPointcut(subject, event){
		StringBuilder sb = new StringBuilder();
		sb.append(" >> executing void ");
		sb.append(thisJoinPoint.getStaticPart().getSignature());
		sb.append(" at line (");
		sb.append(thisJoinPoint.getStaticPart().getSourceLocation());
		sb.append(") with event: [");
		sb.append(event);
		sb.append("]");
		System.out.println(sb.toString());
	}

}
