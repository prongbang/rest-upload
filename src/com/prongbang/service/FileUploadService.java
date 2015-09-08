package com.prongbang.service;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import com.prongbang.dto.Properties;
import com.prongbang.dto.WelcomeForm;

public interface FileUploadService {

	public WelcomeForm welcome(WelcomeForm welcomeFormObject);

	public Boolean upload(Properties properties);

	public String get();

	public String uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail);
}
