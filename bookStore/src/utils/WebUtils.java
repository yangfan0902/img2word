package utils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.BusinessService;
import domain.Book;
import domain.Category;
import service.impl.BusinessServiceImpl;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		try{
			T bean=beanClass.newInstance();
			Map map=request.getParameterMap();
			BeanUtils.populate(bean, map);
			return bean;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public static Book upload(HttpServletRequest req,String uploadPath){
		try{
			Book b=new Book();
			DiskFileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			upload.setHeaderEncoding(req.getCharacterEncoding());
			List<FileItem> list=upload.parseRequest(req);
			
			for(FileItem item:list){
				if(item.isFormField()){
					String inputName=item.getFieldName();
					String value=item.getString("UTF-8");
					if("category_id".equals(inputName)){
						BusinessService service=new BusinessServiceImpl();
						Category c=service.findCategory(value);
						b.setCategory(c);
					}else{
						BeanUtils.setProperty(b, inputName, value);
					}
				}else{
					String filename=item.getName();
					String savepath=uploadPath;
					String saveFilename=UUID.randomUUID().toString()+filename;
					InputStream in=item.getInputStream();
					FileOutputStream out=new FileOutputStream(savepath+"\\"+saveFilename);
				
					int len=0;
					byte buffer[]=new byte[1024];
					while((len=in.read(buffer))>0){
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					
					b.setImage(saveFilename);
				}
			}
			b.setId(UUID.randomUUID().toString());
			return b;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
