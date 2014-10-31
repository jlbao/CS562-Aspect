package aspects;

import java.awt.Point;

public aspect FixArgumentsAspect {
	pointcut captureCallParameters(Point from, Point to) : 
	      call(void hw4.ChessBoard.move(Point, Point)) && args(from, to);

	// Advice declaration
	before(Point from, Point to) : captureCallParameters(from, to){
		if (from.x < 0 || from.x > 7) {
			from.x = 0;
		}
		if (from.y < 0 || from.y > 7) {
			from.y = 0;
		}
		if (to.x < 0 || to.x > 7) {
			from.x = 0;
		}
		if (to.y < 0 || to.y > 7) {
			to.y = 0;
		}
	}
}
