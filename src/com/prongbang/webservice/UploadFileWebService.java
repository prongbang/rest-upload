package com.prongbang.webservice;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.prongbang.dto.Properties;
import com.prongbang.dto.WelcomeForm;
import com.prongbang.service.FileUploadService;
import com.prongbang.service.impl.FileUploadServiceImpl;

@Path("/service/")
public class UploadFileWebService implements FileUploadService {

	private FileUploadServiceImpl fileUploadServiceImpl;

	public UploadFileWebService() {
		fileUploadServiceImpl = new FileUploadServiceImpl();
	}

	@POST
	@Path("wellcome")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// Response Type
	@Override
	public WelcomeForm welcome(WelcomeForm welcomeFormObject) {
		return fileUploadServiceImpl.welcome(welcomeFormObject);

	}

	@POST
	@Path("file")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Boolean upload(Properties properties) {
		return fileUploadServiceImpl.upload(properties);
	}

	@GET
	@Path("get")
	@Override
	public String get() {
		return fileUploadServiceImpl.get();
	}

	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	// Response Type
	@Override
	public String uploadFile(InputStream uploadedInputStream,FormDataContentDisposition fileDetail) {

		return fileUploadServiceImpl.uploadFile(uploadedInputStream, fileDetail);
	}
}

/**
 * @reference 
 * http://coenraets.org/blog/2011/12/restful-services-with-jquery-and-java-using-jax-rs-and-jersey/
 * https://jersey.java.net/documentation/latest/media.html#multipart
 * https://kodingnotes.wordpress.com/2014/10/10/uploading-a-file-to-jersey-rest-api-using-jquery/
 */
