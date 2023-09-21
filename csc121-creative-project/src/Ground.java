import java.util.ArrayList;
import processing.core.PApplet;

class Ground {

	int width = 12000;
	int height = 9500; 

	Vector pos = new Vector(SSConstants.WIDTH/2, SSConstants.HEIGHT/2, 200);
	
	ArrayList<TrackBoards> boards;
	
	Ground() {
		boards = new ArrayList<TrackBoards>();
		boards.add(new TrackBoards(SSConstants.BOARD_INITIAL_Z));
		
		for (int i = 1; i < 30; i++) {
			boards.add(new TrackBoards(boards.get(i-1).pos.z+200));
		} 
	}

	PApplet draw(PApplet c) {
		c.pushMatrix();
		c.rotateX(c.PI/2f);
		c.translate(0, 0, -900);
		c.fill(0, 80, 0);
		c.rectMode(3);       // rectangle is placed with (x,y) at center
		c.rect(pos.x, pos.y, width, height, 25);
		c.popMatrix();

		drawTracks(c);
		drawSides(c);
		
		boards.forEach(board -> board.update());
		boards.forEach(board -> board.draw(c));
		
		return c;
	}

	void drawTracks(PApplet c) {
		int y = SSConstants.ENVIRONMENT_Y;

		c.fill(90);

		c.pushMatrix();
		c.translate(30, y, 0);
		c.box(20, 20, 7000);
		c.popMatrix();

		c.pushMatrix();
		c.translate(170, y, 0);
		c.box(20, 20, 7000);
		c.popMatrix();

		c.pushMatrix();
		c.translate(530, y, 0);
		c.box(20, 20, 7000);
		c.popMatrix();

		c.pushMatrix();
		c.translate(670, y, 0);
		c.box(20, 20, 7000);
		c.popMatrix();

		c.pushMatrix();
		c.translate(1030, y, 0);
		c.box(20, 20, 7000);
		c.popMatrix();

		c.pushMatrix();
		c.translate(1170, y, 0);
		c.box(20, 20, 7000);
		c.popMatrix();

	}
	
	void drawSides(PApplet c) {
		int y = SSConstants.ENVIRONMENT_Y;
		
		c.fill(70, 50, 10);
		c.pushMatrix();
		c.translate(-250, y, 0);
		c.box(100, 60, 7000);
		c.popMatrix();
		
		c.pushMatrix();
		c.translate(1450, y, 0);
		c.box(100, 60, 7000);
		c.popMatrix();
	}
	

}
