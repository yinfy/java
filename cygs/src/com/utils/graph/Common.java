package com.utils.graph;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
/**
 * 公共的方法
 * @author CSDN's Cannel_2020
 *
 */
public class Common {
	/**
	 * 设置窗口居中
	 * @param window 所要居中的Window对象
	 */
	public static void setCentered(Window window) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation(new Point((screenSize.width - window.getWidth()) / 2,
				(screenSize.height - window.getHeight()) / 2));
	}
	/**
	 * 获得系统中所有的可用字体
	 * @return 系统中所有的可用字体
	 */
	public static String[] getAvailableFontFamilyNames(){
		// 获取系统中的所有可用字体
		GraphicsEnvironment e = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String[] temps = e.getAvailableFontFamilyNames();
		String[] fontFamily = new String[temps.length];
		int i = temps.length-1;
		for(String temp : temps){
			fontFamily[i--] = temp;
		}
		return fontFamily;
	}
	/**
	 * 设置面板中各个组件的字体
	 * @param panel JPanel的一个实例
	 */
	public static void setComponentsFont(JPanel panel, Font font) {
		Component[] components = panel.getComponents();
		for (Component cp : components) {
			cp.setFont(font);
		}
	}
	/**
	 * 
	 * @param filename 文件的名字
	 * @return 文件的后缀名
	 */
	public static String getFileExtension(String filename){
		return filename.substring(filename.lastIndexOf(".")+1).toLowerCase();
	}
	/**
	 * @param filename
	 * @return 图片文件("bmp", "gif", "jpg", "jpeg", "png")返回：true
	 */
	public static boolean isImageFile(String filename){
		String imageExtendsion[] = {"bmp", "gif", "jpg", "jpeg", "png"};
		String fileExtendsion = getFileExtension(filename);
		for(int i = 0; i < imageExtendsion.length; ++i){
			if(imageExtendsion[i].equals(fileExtendsion)){
				return true;
			}
		}
		return false;
	}
	/**
	 * 获得一个文件夹下的所有图片文件
	 * @param filepath 文件夹的路径
	 * @return 文件夹下的所有图片文件的绝对路径
	 */
	public static ArrayList<String> getImageFiles(String filepath){
		ArrayList<String> imgFileList = new  ArrayList<String>();
		File file = new File(filepath);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory()) {
				String filename = files[i].getName();
				if(Common.isImageFile(filename)){
					imgFileList.add(filepath + "\\"+filename);
				}
			}
		}
		return imgFileList;
	}
	/**
	 * @return 加水印后的文件名或文件夹名字
	 */
	public static String getNewFileorDirName(String filepath) {
		String new_Filename = "\\New_"
				+ filepath.substring(filepath.lastIndexOf("\\") + 1);
		return new_Filename;
	}

}
