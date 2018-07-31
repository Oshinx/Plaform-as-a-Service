package com.sheffieldcloud.developer.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sheffieldcloud.developer.datasource.DeveloperDao;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")
public class Upload extends HttpServlet {
	
	
	String place="/home/michael/1/";
			
			//"/var/lib/tomcat8/Upload_Apps/";
	
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	// location to store file uploaded
	private static final String UPLOAD_DIRECTORY = "upload";

	// upload settings
	private static final int MEMORY_THRESHOLD 	= 1024 * 1024 * 3; 	// 3MB
	private static final int MAX_FILE_SIZE 		= 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE	= 1024 * 1024 * 50; // 50MB  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String app = request.getParameter("nameofapp");
	    HttpSession session = request.getSession();
	    String developerId = session.getAttribute("userId").toString();
	    System.out.println("inside");
		// TODO Auto-generated method stub
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// sets memory threshold - beyond which files are stored in disk 
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// sets temporary location to store files
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// sets maximum size of upload file
		upload.setFileSizeMax(MAX_FILE_SIZE);
		
		// sets maximum size of request (include file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// constructs the directory path to store upload file
		// this path is relative to application's directory
		String uploadPath = getServletContext().getRealPath("")
				+ File.separator + UPLOAD_DIRECTORY;
		
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// parses the request's content to extract file data
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			
				// iterates over form's fields
				for (FileItem item : formItems) {
				    System.out.println("inside c");
					//item.write(new File("/Users/mac/blog/source/"+item.getName()));
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						System.out.println("inside c");
						String fileName = new File(item.getName()).getName();
						String filePath = place + File.separator + fileName;
						File storeFile = new File(filePath);

						// saves the file on disk
						item.write(storeFile);
						System.out.println("Upload successful");
						DeveloperDao developerDao = new DeveloperDao();
						developerDao.getConnection();
						developerDao.registerApp(developerId, app);
						
						request.setAttribute("message",
							"Upload has been done successfully!");
						 
					}
					else {
						System.out.println(item.getFieldName() +" ertt");
					}
				}
		
		} catch (Exception ex) {
			request.setAttribute("message",
					"There was an error: " + ex.getMessage());
		}
		// redirects client to message page
//		getServletContext().getRequestDispatcher("/message.j
		getServletContext().getRequestDispatcher("/message.jsp").forward(
				request, response);
	}
}