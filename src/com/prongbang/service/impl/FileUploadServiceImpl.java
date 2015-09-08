package com.prongbang.service.impl;

import java.io.IOException;
import java.io.InputStream;

import com.prongbang.dto.Properties;
import com.prongbang.dto.WelcomeForm;
import com.prongbang.file.ManageFile;
import com.prongbang.service.FileUploadService;
import com.sun.jersey.core.header.FormDataContentDisposition;

public class FileUploadServiceImpl implements FileUploadService {

	private ManageFile manageFile;
	final private String uploadedFileLocation = "D:\\Work\\Workspace\\RESTUPLOAD\\rest-upload\\WebContent\\data\\";

	public FileUploadServiceImpl() {
		manageFile = new ManageFile();
	}

	@Override
	public WelcomeForm welcome(WelcomeForm welcomeFormObject) {
		WelcomeForm form = new WelcomeForm();
		form.title = " Connected ... ";
		System.out.println("welcomeFormObject *** " + welcomeFormObject.title);
		return form;
	}

	@Override
	public Boolean upload(Properties properties) {
		Boolean status = false;
		System.out.println("Filename : " + properties.getFilename());

		// save it
		try {
			manageFile.convertByte2File(properties.getFileBytes(),
					uploadedFileLocation + properties.getFilename());
			status = true;
			System.out.println("Upload Success :) -> " + uploadedFileLocation
					+ properties.getFilename());
		} catch (IOException e) {
			System.out.println("Upload Fail :(");
			e.printStackTrace();
		}
		// return Response.status(200).entity(output).build();
		return status;
	}

	@Override
	public String get() {
		return "OK";
	}

	@Override
	public String uploadFile(InputStream uploadedInputStream,FormDataContentDisposition fileDetail) {
		// save it
		manageFile.writeToFile(uploadedInputStream, uploadedFileLocation + fileDetail.getFileName());
		String output = "File uploaded to : " + uploadedFileLocation;
		return output;
	}
}
