package com.jk.util;

import java.io.*;

/**
 * 2017-12-23 于洋整理 上传 下载 删除 大全
 * @spring-mvc @uploadify
 * 
        @Resource
	private  HttpServletRequest request; 
	@Resource
        private  HttpServletResponse response; 
 * 
 * 
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class SpringMvcUpload {
	
	/**
	 * <pre>uploadYy(上传)   
	 * 创建人：于洋 yy_java@126.com     
	 * 创建时间：2017年12月23日 下午9:30:09    
	 * 修改人：于洋 yy_java@126.com      
	 * 修改时间：2017年12月23日 下午9:30:09    
	 * 修改备注：
	 * @param artImg
	 * @param catalog
	 * @return String
	 */
	public static String uploadYy(HttpServletRequest request,MultipartFile artImg,String catalog)
	{
		/*获取原文件名称*/
        String fileName = artImg.getOriginalFilename();//上传图片的name
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//日期格式
        String folderPath = request.getSession().getServletContext().getRealPath("/")+catalog+"/";//文件根目录
        File file = new File(folderPath);//转化为file对象
        /*该目录是否已经存在*/
        if(!file.exists()){
            /*创建文件夹*/
            file.mkdir();
        }
        /*读写流*/
        String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));//新的名字
        try {
			artImg.transferTo(new File(folderPath+onlyFileName));
			/*InputStream is = artImg.getInputStream();
			FTPUtil.uploadFile(is,onlyFileName,"");*/
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//自带读流
		return onlyFileName;
	}
	
	/**
	 * <pre>downloadYy(下载)   
	 * 创建人：于洋 yy_java@126.com     
	 * 创建时间：2017年12月24日 下午12:20:27    
	 * 修改人：于洋 yy_java@126.com      
	 * 修改时间：2017年12月24日 下午12:20:27    
	 * 修改备注： 
	 * @param request
	 * @param response
	 * @param filePath</pre>
	 */
	public static void downloadYy(HttpServletRequest request,HttpServletResponse response,String filePath)
	{
		        // 1. 获得文件的真实路径
				String newPath = request.getSession().getServletContext().getRealPath(filePath);
				// 2. 实例化 文件对象  
				File f = new File(newPath);
				// 3. 获得文件名
				String fileName = f.getName();
				// 4. 定义输入输出流
				BufferedInputStream buffIn = null;
				BufferedOutputStream buffOut = null;
				try {
					// 5. 获得输入流
					buffIn = new BufferedInputStream(new FileInputStream(f));
					// 6. 获得输入流       response.getOutputStream() 是servlet的输出流  浏览器的输出流
					buffOut = new BufferedOutputStream(response.getOutputStream());
					
					// 7. 对浏览器进行设置========================================================
					//解决浏览器兼容问题
			        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
			        	fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
			        } else {
			        	// 对文件名进行编码处理中文问题
			        	fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
			        	fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
			        }
			        response.reset();
			        response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型
				     // inline在浏览器中直接显示，不提示用户下载
				        // attachment弹出对话框，提示用户进行下载保存本地
				        // 默认为inline方式
			        response.setHeader("Content-Disposition", "attachment;filename="+fileName);
					//==========================================================================
					// 8. 循环 读写 赋值
					byte[] b = new byte[1024];
					@SuppressWarnings("unused")
					int s = 0;
					while((s=buffIn.read(b))!=(-1)){
						buffOut.write(b);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					try {
						if(buffIn!=null){
							buffIn.close();
						}
						if(buffOut!=null){
							buffOut.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}
	
	/**
	 * <pre>deletethepicture(删除图片)   
	 * 创建人：于洋 yy_java@126.com     
	 * 创建时间：2017年12月24日 下午12:54:29    
	 * 修改人：于洋 yy_java@126.com      
	 * 修改时间：2017年12月24日 下午12:54:29    
	 * 修改备注： 
	 * @param request
	 * @param filePath
	 * @return Boolean
	 */
	public static Boolean deletethepicture(HttpServletRequest request,String filePath)
	{
		        //获取物理路径
				String newPath = request.getSession().getServletContext().getRealPath(filePath);
				System.out.println(newPath+"============");
				//实例化 文件
				File file = new File(newPath);
				//判断路径 和  文件是否存在
				if(file.exists() && file.isFile()){
					if(file.delete()){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}      
	}
	/**
	 * <pre>downloadYy(下载完删除)
	 * 创建人：于洋 yy_java@126.com
	 * 创建时间：2017年12月24日 下午12:20:27
	 * 修改人：于洋 yy_java@126.com
	 * 修改时间：2017年12月24日 下午12:20:27
	 * 修改备注：
	 * @param request
	 * @param response
	 * @param filePath</pre>
	 */
	public static void downloadYyDelete(HttpServletRequest request,HttpServletResponse response,String filePath)
	{
		// 1. 获得文件的真实路径
		String newPath = request.getSession().getServletContext().getRealPath(filePath);
		// 2. 实例化 文件对象
		File f = new File(newPath);
		// 3. 获得文件名
		String fileName = f.getName();
		// 4. 定义输入输出流
		BufferedInputStream buffIn = null;
		BufferedOutputStream buffOut = null;
		try {
			// 5. 获得输入流
			buffIn = new BufferedInputStream(new FileInputStream(f));
			// 6. 获得输入流       response.getOutputStream() 是servlet的输出流  浏览器的输出流
			buffOut = new BufferedOutputStream(response.getOutputStream());

			// 7. 对浏览器进行设置========================================================
			//解决浏览器兼容问题
			if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
				fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
			} else {
				// 对文件名进行编码处理中文问题
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
				fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
			}
			response.reset();
			response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型
			// inline在浏览器中直接显示，不提示用户下载
			// attachment弹出对话框，提示用户进行下载保存本地
			// 默认为inline方式
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			//==========================================================================
			// 8. 循环 读写 赋值
			byte[] b = new byte[1024];
			@SuppressWarnings("unused")
			int s = 0;
			while((s=buffIn.read(b))!=(-1)){
				buffOut.write(b);
			}
			System.out.println("下载成功！！");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(buffIn!=null){
					buffIn.close();
				}
				if(buffOut!=null){
					buffOut.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Boolean aBoolean = deletethepicture(request, filePath);
		}
	}
	
	
}
