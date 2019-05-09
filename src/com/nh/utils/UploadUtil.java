package com.nh.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {
	private String uploadPath = "uploads/"; // 存在路径
	private String uploadTmp = "tmp/"; // 上传临时路径
	private String[] fileType = new String[] { ".jpg", ".gif", ".png", ".jpeg" };// 上传文件类型
	private int sizeMax = 3; // 上传文件最大值
	private String serverPath;
	private List<FileItem> items;
	private ServletContext servletContext;
	private HttpServletRequest request;
	private ServletFileUpload upload;

	/**
	 * 上传文件时调用该构造方法
	 * 
	 * @param inservletContext
	 * @param inrequest
	 */
	public UploadUtil(ServletContext inservletContext,
			HttpServletRequest inrequest) {
		servletContext = inservletContext;
		request = inrequest;

		serverPath = servletContext.getRealPath("/");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4 * 1024);// 缓存区
		factory.setRepository(new File(serverPath + uploadTmp));// 设置临时文件夹

		upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		upload.setSizeMax(sizeMax * 1024 * 1024);
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件时调用该构造方法
	 * 
	 * @param inservletContext
	 */
	public UploadUtil(ServletContext inservletContext) {
		servletContext = inservletContext;
		serverPath = servletContext.getRealPath("/");
	}

	/**
	 * 获取表单中其它非文件域的值
	 * 
	 * @param paraName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getParameter(String paraName)
			throws UnsupportedEncodingException {
		String value = null;
		for (FileItem item : items) {
			if (item.isFormField()
					&& item.getFieldName().equalsIgnoreCase(paraName)) {
				value = item.getString("UTF-8");
				break;
			}
		}
		return value;

	}

	/**
	 * 上传文件
	 * 
	 * @return 返回多个上传文件的名称（名称为重命名）
	 * @throws Exception
	 */
	public List<String> upload() throws Exception {
		List<String> paths = new ArrayList<String>();
		String initFileName = "";
		if (!checkFileType()) {
			throw new Exception(
					"上传失败：存在不允许的类型。上传文件类型只能是：（jpg, gif, png, jpeg）！");
		}
		try {
			for (FileItem item : items) {
				if (!item.isFormField()&&!item.getName().isEmpty()) {
					initFileName = item.getName().toLowerCase();
					String uuid = UUID.randomUUID().toString();
					String fileName = uuid + getFileTypeName(initFileName);
					String filePath = serverPath + uploadPath + fileName;
					item.write(new File(filePath));
					paths.add(fileName);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("上传失败：检查文件" + initFileName + "，是否超过最大上传大小"
					+ sizeMax + "M。");
		}
		return paths;
	}
/**
 * 删除文件
 * @param fileName：提供所要删除的文件名称(如：355656dfrre.jpg)
 */
	public void deleteFile(String fileName) {
		File file = new File(serverPath + uploadPath + fileName);
		file.delete();
	}

	private String getFileTypeName(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	private boolean checkFileType() {
		boolean result = true;
		for (FileItem item : items) {
			if (!item.isFormField()&&!item.getName().isEmpty()) {
				String iniFileName = item.getName().toLowerCase();
				String typeName = getFileTypeName(iniFileName);
				boolean flag = false;
				for (int i = 0; i < fileType.length; i++) {
					if (fileType[i].equalsIgnoreCase(typeName)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					result = flag;
					break;
				}
			}
		}
		return result;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUploadTmp() {
		return uploadTmp;
	}

	public void setUploadTmp(String uploadTmp) {
		this.uploadTmp = uploadTmp;
	}

}
