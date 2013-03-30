package by.easyandroid.service.datasource.impl;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;

import by.easyandroid.service.datasource.IApplicationResultService;
import by.easyandroid.service.exception.ApplicationServiceException;

/**
 * Stores result applications in web available local file system directory.
 * @author kslisenko
 */
// TODO unit-test
public class FileSystemApplicationResultService implements IApplicationResultService {

	private File apkDirectory;
	private String wepAccessDirectoryPath;
	
	public FileSystemApplicationResultService(String apkDirectory, String wepAccessDirectoryPath) {
		this.apkDirectory = new File(apkDirectory);
		this.wepAccessDirectoryPath = wepAccessDirectoryPath;
	}
	
	public String uploadResultApk(File apkToUpload) throws ApplicationServiceException {
		try {
			FileUtils.copyFile(apkToUpload, new File(apkDirectory, generateApkFileName()));
		} catch (IOException e) {
			throw new ApplicationServiceException("can not copy result apk to directory '" + apkDirectory.getAbsolutePath() + "'", e);
		}
		return null;
	}
	
	protected String generateApkFileName() {
		return String.format("conference%d.apk", new GregorianCalendar().getTimeInMillis());
	}
	
	public String getWepAccessDirectoryPath() {
		return wepAccessDirectoryPath;
	}

	public File getApkDirectory() {
		return apkDirectory;
	}
}