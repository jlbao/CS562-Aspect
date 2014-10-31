package aspects;

import java.awt.Point;

public aspect PointValidatorAspect {
	pointcut pointConstructorPointcut(int x, int y) : 
		call(Point.new(int, int)) && args(x, y);;

	before(int x, int y): pointConstructorPointcut(x, y){
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			throw new IllegalArgumentException();
		}
	}
}
