package fr.isika.cda.presentation.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;


import org.primefaces.model.file.UploadedFile;

public class FileUpload {
	
	private static final String JSF_RESOURCES_DIR_NAME = "resources";
	private static final String IMAGES_DIR_NAME = "/images/";
	
	public static void doUpload(UploadedFile file, final String fileNameToUse) {

		try {
			ServletContext servletContext = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
			String resourcesPath = servletContext.getRealPath(JSF_RESOURCES_DIR_NAME);
			String imagePath = resourcesPath + IMAGES_DIR_NAME;

			File resourcesDir = new File(imagePath);
			if (!resourcesDir.exists()) {
				resourcesDir.mkdirs();
			}

			String fullPath = imagePath + fileNameToUse;

			File newFile = new File(fullPath);
			boolean created = newFile.createNewFile();

			if (!created) {
				throw new RuntimeException("Error uploading image file :  " + fullPath);
			}

			Path newPath = newFile.toPath();
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, newPath, StandardCopyOption.REPLACE_EXISTING);
			inputStream.close();

		} catch (IOException e) {
			throw new RuntimeException();
		}

	}
	
	private FileUpload() {
		throw new IllegalStateException("Utility class");
	}

}
