package gov.cygs.utils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CsvUtil {
	
	
	public static List<String[]> readCsv(String csvFile){
		List<String[]> table= new ArrayList<String[]>();
		CsvReader r;
		try {
			r = new CsvReader(csvFile, ',',Charset.forName("UTF-8"));
			int count = 0;
			r.readHeaders();
			String[] rec = r.getHeaders();
			table.add(rec);
			count = rec.length;
			
			//逐条读取记录，直至读完
			while (r.readRecord()) {
			   //读取一条记录
			    //System.out.println(r.getRawRecord());
			    //按列名读取这条记录的值
				rec = new String[count];
				for(int i = 0; i<count;i++){
					rec[i]= r.get(i);
				}
				table.add(rec);
			}
			r.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}
	
	public static void writeCsv(List<String []> content,String fileName){
		try {
			CsvWriter wr =new CsvWriter(fileName,',',Charset.forName("UTF-8"));
			
			for(String[] record:content){
				wr.writeRecord(record);
			}
			wr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CsvUtil.readCsv();
		//CsvUtil.writeCsv();
	}
	

}
