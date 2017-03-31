package gov.cygs.entities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class MapSection {
	double MINIMUS = 0.000001;
	
	private Set<MapPoint> points;
	
	public MapSection() {
		// TODO Auto-generated constructor stub
		this.points = new LinkedHashSet<MapPoint>();
	}
	
	public void addPoint(MapPoint point){
		this.points.add(point);
	}
	
	public void removePoint(MapPoint point){
		for(MapPoint p:points){
			if(p.getPx() == point.getPx() && p.getPy()== point.getPy() ){
				this.points.remove(point);
				break;
			}
		}
	}
	
	public int [] getArray(String mode){
		int [] cArray = new int[this.points.size()];
		int index = 0;
		for(MapPoint p:points){
			if(mode.equals("x"))
				cArray[index] = p.getPx();
			else
				cArray[index] = p.getPy();
			index ++;
		}
		return cArray;
	}
	
	public int getMaxX(){
		int maxx = 0;
		for(MapPoint p:points){
			if( p.getPx()> maxx){
				maxx = p.getPx();
			}
		}
		return maxx;
	}

	public int getMinX(){
		int minx = 10000;
		for(MapPoint p:points){
			if( p.getPx()< minx){
				minx = p.getPx();
			}
		}
		return minx;
	}

	public int getMaxY(){
		int mv = 0;
		for(MapPoint p:points){
			if( p.getPy()> mv){
				mv = p.getPy();
			}
		}
		return mv;
	}

	public int getMinY(){
		int mv = 10000;
		for(MapPoint p:points){
			if( p.getPy()< mv){
				mv = p.getPy();
			}
		}
		return mv;
	}

	public Set<MapPoint> getPoints() {
		return points;
	}

	public void setPoints(Set<MapPoint> points) {
		this.points = points;
	}
	
	public boolean isOnEdgy(MapPoint point){
		boolean ison = false;
		
		int pCount = 0;
		MapPoint pm=null;
		MapPoint p0 = null;
		for(MapPoint pn:points){
			if(pCount ==0){
				p0 = pn;
				pm = pn;
			}else{
				ison = this.isOnLine(pn, pm, point);
				if(ison){
					return ison;
				}
				pm = pn;
			}
			pCount++;
		}
		ison = this.isOnLine(p0, pm, point);
		return ison;
	}
	
	public boolean isOnLine(MapPoint p1, MapPoint p2, MapPoint pt){
		boolean ison = false;
		
			MapPoint pup = p1;
			MapPoint pdown = p2;
			
			MapPoint pl = p1;
			MapPoint pr = p2;
			
			if(p2.getPy()>p1.getPy()){
				pup = p2;
				pdown = p1;
			}
		
			if(p2.getPx()<p1.getPx()){
				pl = p2;
				pr = p1;
			}
			
			//垂直无斜率时，判断是否在线上
			if(p1.getPx()-p2.getPx()==0){
				if(pt.getPx()-p1.getPx()==0){
					if(pt.getPy()>=pdown.getPy() && pt.getPy()<=pup.getPy()){
						ison = true;
					}
				}
			}else{
				
				if(pt.getPx()-pdown.getPx()!=0){
					double k1=((double)pt.getPy()-(double)pdown.getPy())/((double)pt.getPx()-(double)pdown.getPx());
					double k2=((double)pup.getPy()-(double)pdown.getPy())/((double)pup.getPx()-(double)pdown.getPx());
					
					//斜率极相近时，认为斜率相同，根据横坐标判断是否在线上
					if(Math.abs(k1-k2)<MINIMUS){
						if(pt.getPx()>=pl.getPx()&&pt.getPx()<=pr.getPx()){
							ison = true;
						}
					}
				}
			}
			
			
		
		return ison;
	}
	
	public boolean isInOrNot(MapPoint point){
		
		return isInOrNot(point,this);
		
	}
	
	
	public boolean isInOrNot(MapPoint point, MapSection section){
		int px = point.getPx();
		int py = point.getPy();
        int minX = section.getMinX();
        int minY = section.getMinY();
        int maxX = section.getMaxX();
        int maxY = section.getMaxY();
		
		if (px < minX || px > maxX || py < minY || py > maxY) {
		     return false;
		}
		
		if(section.isOnEdgy(point)){
			return true;
		}
		
		return pnpoly(section.getPoints().size(), section.getArray("x"), section.getArray("y"), point.getPx(), point.getPy());
		
	}

	public static boolean pnpoly (int nvert, int[] vertx, int[] verty, int testx, int testy) {

		boolean isin = false;
	    int i, j;

	    for (i = 0, j = nvert-1; i < nvert; j = i++) {

	        if ( ( (verty[i]>testy) != (verty[j]>testy) ) &&
	        		(testx < (vertx[j]-vertx[i]) * (testy-verty[i]) / (verty[j]-verty[i]) + vertx[i]) )
	            isin = !isin;
	    }
	    return isin;
	    
	    
//	    首先，参数nvert 代表多边形有几个点。浮点数testx, testy代表待测试点的横坐标和纵坐标，
//	    *vertx,*verty分别指向储存多边形横纵坐标数组的首地址。
//
//	    我们注意到，每次计算都涉及到相邻的两个点和待测试点，然后考虑两个问题：
//
//	    1. 被测试点的纵坐标testy是否在本次循环所测试的两个相邻点纵坐标范围之内？即
//
//	    verty[i] <testy < verty[j]
//
//	    或者
//
//	    verty[j] <testy < verty[i]
//
//	    2. 待测点test是否在i,j两点之间的连线之下？看不懂后半短if statement的朋友请自行在纸上写下i,j两点间的斜率公式，
//	    要用到一点初中解析几何和不等式的知识范畴，对广大码农来说小菜一碟。
//
//	    然后每次这两个条件同时满足的时候我们把返回的布尔量取反。
//
//	    可这到底是啥意思啊？
//
//	    这个表达式的意思是说，随便画个多边形，随便定一个点，然后通过这个点水平划一条线，先数数看这条横线和多边形的边相交几次，
//	    （或者说先排除那些不相交的边，第一个判断条件），然后再数这条横线穿越多边形的次数是否为奇数，如果是奇数，那么该点在多边形内，
//	    如果是偶数，则在多边形外。详细的数学证明这里就不做了，不过读者可以自行画多边形进行验证。	    
	    
	}
	
	
}
