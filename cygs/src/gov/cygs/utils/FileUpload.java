package gov.cygs.utils;

import java.io.File;
import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;

import org.primefaces.model.UploadedFile;
import gov.cygs.utils.FileUpload;
import gov.cygs.utils.Utils;

public class FileUpload{
    public static boolean Upload(UploadedFile fileUp, String fullName) {
    	String filename=fileUp.getFileName();
		
		byte[] data = fileUp.getContents();
    	FileImageOutputStream imageOutput;
		try {
			String filePath = fullName.substring(0, fullName.lastIndexOf(File.separator));
			Utils.createDirectory(filePath);
		
			imageOutput = new FileImageOutputStream(new File(fullName));
			imageOutput.write(data, 0, data.length);
            imageOutput.close();
	    	FacesMessage message = new FacesMessage("消息", filename + "上传为" +fullName );
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}catch (Exception e) {
			FacesMessage message = new FacesMessage("错误", "不能上传"+filename  );
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return true;
	}
    
    public static boolean Upload(UploadedFile fileUp, String fullName, String convertPdf) {
    	String filename=fileUp.getFileName();
		
		byte[] data = fileUp.getContents();
    	FileImageOutputStream imageOutput;
		try {
    			imageOutput = new FileImageOutputStream(new File(fullName));
    			imageOutput.write(data, 0, data.length);
                imageOutput.close();
		    	FacesMessage message = new FacesMessage("消息", filename + "上传为" +fullName );
		        FacesContext.getCurrentInstance().addMessage(null, message);
		}catch (IOException e) {
			FacesMessage message = new FacesMessage("错误", "不能上传"+filename  );
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}catch(Exception e ){
			FacesMessage message = new FacesMessage("错误", "转换"+filename + "为PDF失败" );
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return true;
	}
    
    public static String Upload(UploadedFile file, String cat, String fileType, boolean convert) {
    	String sysPath= Utils.getPath();
    	String reName= file.getFileName();
    	
    	String newName=sysPath + cat + File.separator+ reName;
   		FileUpload.Upload(file, newName, null);
    	return reName;
    }
    
    public static String SaveData(byte[] data, String filename){
    	FileImageOutputStream imageOutput;
        try {
			String filePath = filename.substring(0, filename.lastIndexOf(File.separator));
			Utils.createDirectory(filePath);
			Utils.deleteFile(filename);
			
            imageOutput = new FileImageOutputStream(new File(filename));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        }
        catch(Exception e) {
            throw new FacesException("Error in writing captured image.", e);
        }
        return filename;
    }
}
