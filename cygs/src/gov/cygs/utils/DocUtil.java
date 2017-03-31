package gov.cygs.utils;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class DocUtil {

	private Configuration configure = null;
	static final int wdFormatPDF = 17;// PDF 格式    
	
	public DocUtil(){
	       configure= new Configuration();
	       configure.setDefaultEncoding("utf-8");
	       ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	       configure.setServletContextForTemplateLoading(servletContext,"/WEB-INF/templates");
	}
	public void  createDoc(Map<String, String> dataMap, String downloadType, String savePath) throws Exception{
        //加载需要装填的模板
        Template template  = null;
        //加载模板文件
        //configure.setClassForTemplateLoading(this.getClass(),"/userspace/templates");
        //设置对象包装器
        //configure.setObjectWrapper(new DefaultObjectWrapper());
        //设置异常处理器
        //configure.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        //定义Template对象,注意模板类型名字与downloadType要一致
        template= configure.getTemplate(downloadType);
        //输出文档
        File outFile = new File(savePath);
        Writer out = null;
        out= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"utf-8")); 
        template.process(dataMap,out);
        out.flush();
        out.close();
        //outFile.delete();
	}
	
	// UTF-8编码  
    public static String toUTF8(String s) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < s.length(); i++) {  
            char c = s.charAt(i);  
            if (c >= 0 && c <= 255) {  
                sb.append(c);  
            } else {  
                byte[] b;  
                try {  
                    b = Character.toString(c).getBytes("utf-8");  
                } catch (Exception ex) {  
                    System.out.println(ex);  
                    b = new byte[0];  
                }  
                for (int j = 0; j < b.length; j++) {  
                    int k = b[j];  
                    if (k < 0)  
                        k += 256;  
                    sb.append("%" + Integer.toHexString(k).toUpperCase());  
                }  
            }  
        }  
        return sb.toString();  
    }  
	
	public static void downLoad(String filePath, HttpServletResponse response,  
            boolean isOnLine) throws Exception {  
        File f = new File(filePath);  
        /*  
         * if (!f.exists()) { response.sendError(404, "File not found!");  
         * return; }  
         */  
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));  
        byte[] buf = new byte[1024];  
        int len = 0;  
        response.reset(); // 非常重要  
        // 在线打开方式  
        if (isOnLine) {  
            URL u = new URL(filePath);  
            response.setContentType(u.openConnection().getContentType());  
            response.setHeader("Content-Disposition", "inline; filename="  
                    + toUTF8(f.getName()));  
            // 文件名应该编码成UTF-8  
        }  
        // 纯下载方式  
        else {  
            response.setContentType("application/x-msdownload");  
            response.setHeader("Content-Disposition", "attachment; filename="  
                    + toUTF8(f.getName()));  
        }  
        OutputStream out = response.getOutputStream();  
        while ((len = br.read(buf)) > 0)  
            out.write(buf, 0, len);  
        out.flush();  
        br.close();  
        out.close();  
    }
	

    public void wordToPDF(String path, String docFileName){    

        //System.out.println("启动Word...");      
        long start = System.currentTimeMillis();      
        ActiveXComponent app = null;  
        Dispatch doc = null;  
        String sfileName = path + docFileName + ".doc";
        String toFileName = path + docFileName + ".pdf";
        
        try {      
            app = new ActiveXComponent("Word.Application");      
            app.setProperty("Visible", new Variant(false));  
            Dispatch docs = app.getProperty("Documents").toDispatch();    

            //String path =  this.getSession().getServletContext().getRealPath("/")+"attachment/";


            doc = Dispatch.call(docs,  "Open" , sfileName).toDispatch();  
          //  System.out.println("打开文档..." + sfileName);  
          //  System.out.println("转换文档到PDF..." + toFileName);      
            File tofile = new File(toFileName);      
            if (tofile.exists()) {      
                tofile.delete();      
            }      
            Dispatch.call(doc,      
                          "SaveAs",      
                          toFileName, // FileName      
                          wdFormatPDF);      
            long end = System.currentTimeMillis();      
            System.err.println("转换完成..用时：" + (end - start) + "ms.");
            
           

        } catch (Exception e) {      
            System.out.println("========Error:文档转换失败：" + e.getMessage());      
        } finally {  
            Dispatch.call(doc,"Close",false);  
            //System.out.println("关闭文档");  
            if (app != null)      
                app.invoke("Quit", new Variant[] {});      
            }  
          //如果没有这句话,winword.exe进程将不会关闭  
           ComThread.Release();
           Utils.deleteFile(sfileName); //转换完成后，删除word文件。
    }
    
    public void addWaterMark(String path, String fileName){
    	PdfReader reader;
		try {
			reader = new PdfReader(path + fileName+".pdf");
			int n = reader.getNumberOfPages();
			
	    	PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(path + fileName+".pdf"));  
	    	  
	    	Image img = Image.getInstance(Utils.getPath()+"resource/watermark.jpg");  
	    	img.setAbsolutePosition(0, 0);  
	    	
	    	for(int i=1;i<=n;i++){
		    	PdfContentByte under = stamp.getUnderContent(i);  
		    	// under.addImage(img);
		    	
		    	
		    	PdfContentByte over = stamp.getOverContent(i);
		    	over.addImage(img);
//		    	over.beginText();
//		    	BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI,  
//		    	        BaseFont.EMBEDDED);  
//		    	over.setFontAndSize(bf, 18);  
//		    	over.setTextMatrix(30, 30);
//		    	
//		    	over.showTextAligned(Element.ALIGN_LEFT, "WaterMark", 30, 30, 45);  
//		    	over.endText();
		    	
	    	}
	    	
	    	stamp.close();  
	    	reader.close();
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

    	
    }
    
    public void waterMark(String path, String fileName){
        try {

	    	PDDocument realDoc = PDDocument.load(new File(path + fileName+".pdf"));
	        //the above is the document you want to watermark
	        //for all the pages, you can add overlay guide, indicating watermark the original pages with the watermark document.
	
	        HashMap<Integer, String> overlayGuide = new HashMap<Integer, String>();
	        for(int i=0; i<realDoc.getNumberOfPages(); i++){
	            overlayGuide.put(i+1, Utils.getPath()+"resource/watermark.pdf");
	            //watermark.pdf is the document which is a one page PDF with your watermark image in it. 
	            //Notice here, you can skip pages from being watermarked.
	        }
	        Overlay overlay = new Overlay();
	        overlay.setInputPDF(realDoc);
	        overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
			overlay.overlay(overlayGuide);

			String ownerPassword = "09-e52D-4bD";
		    String userPassword = "";

		    AccessPermission ap = new AccessPermission();
		    ap.setCanModify(false);

		    StandardProtectionPolicy spp = new StandardProtectionPolicy(ownerPassword, userPassword, ap);
		    realDoc.protect(spp);

	        realDoc.save(path + fileName+".pdf");
	        overlay.close();
	        realDoc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
    }
	
}
