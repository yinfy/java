package gov.cygs.entities;

public class MapPoint {

	private int px;
	private int py;
	
	public MapPoint() {
		// TODO Auto-generated constructor stub
		px = 0;
		py = 0;
	}
	
	public MapPoint(int px,int py){
		this.px = px;
		this.py = py;
	}

	public int getPx() {
		return px;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}

}
