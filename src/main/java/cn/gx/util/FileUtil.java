package cn.gx.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

/**
 * Created by always_w_u on 2014/12/10.
 */
public class FileUtil {

	private static final String fileseparator = File.separator;
	
	private static Logger log=Logger.getLogger(FileUtil.class);
	/*
	 * private String
	 * webrootUrl=request.getSession().getServletContext().getRealPath("/");
	 */
	public static void deleteWebFile(String url) {

		/**
		 * String string="java/java";
		 * System.out.println(string.replaceAll("\\/", "\\\\"));
		 * System.out.println(string.replace("/", "\\"));
		 * System.out.println(string.replace("/", File.separator));
		 */
		String path = url.replace("/", FileUtil.fileseparator);
		System.out.println("url:" + path);
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			file.delete();
		}

	}

	public static String toRelativePath(String absolutePath) {
		absolutePath = absolutePath.replace('\\', '/');
		return absolutePath.substring(absolutePath.indexOf("/upload"));
	}

	/**
	 * * 源文件：要上传的文件 source.txt 目标文件：已经上传的文件 target 时间-source.txt
	 * 
	 * @param targetDirName
	 *            要上传文件的目录
	 * @param sourceFile
	 *            上传的源文件
	 * @return
	 */
	public static Path uploadFile(Path sourceFile, String sourceFileName,
			String targetDirName) {

		Path dir;
		Path target = null;
		try {
			dir = createUploadTargetDir(targetDirName);
			Path targerFile = createUploadTargetFile(sourceFileName, dir);

			/*
			 * String ext=sourceFileName
			 * .substring(sourceFileName.lastIndexOf(".") + 1);
			 */

			target = Files.move(sourceFile, targerFile,
					StandardCopyOption.REPLACE_EXISTING);

			System.out.println("上传的目录路径：" + dir + ",文件路径�?" + targerFile);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return target;

	}

	/**
	 * 
	 * @param targetDirName
	 *            要上传文件的目录
	 * @return
	 * 
	 * @throws IOException
	 */
	private static Path createUploadTargetDir(String targetDirName)
			throws IOException {

		Path dir = Paths.get(FileUtil
				.toAbsolutePath("/upload/" + targetDirName));

		if (Files.notExists(dir)) {
			dir = Files.createDirectories(dir);

		}
		// TODO Auto-generated method stub
		return dir;
	}

	/**
	 * 
	 * @param sourceFile
	 *            源文�?
	 * @param targetDirName
	 * 
	 * @return
	 */
	private static Path createUploadTargetFile(String sourceFileName,
			Path targetDirName) {

		Path target = Paths.get(targetDirName + "", System.currentTimeMillis()
				+ "-" + sourceFileName);

		return target;
	}

	/**
	 * 
	 * @param filePath
	 *            例子�? "/upload" 只包含前 �?/�?
	 * @return
	 */
	public static String toAbsolutePath(String filePath) {

		String root = ServletActionContext.getServletContext().getRealPath("/");

		return root + filePath;
	}

	/**
	 * 解决struts2 �?(IE,Firefox)下载文件名乱�?
	 * 
	 * @param filename
	 *            文件�?
	 * @return
	 * @throws Exception
	 */
	public static String toEncode(String filename) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		System.out.println("解决struts2�?(IE,Firefox)下载文件名乱�?:" + filename);
		String Agent = request.getHeader("User-Agent");
		if (null != Agent) {
			Agent = Agent.toLowerCase();
			if (Agent.indexOf("firefox") != -1) {
				filename = new String(filename.getBytes(), "iso8859-1");
			} else if (Agent.indexOf("msie") != -1) {
				filename = java.net.URLEncoder.encode(filename, "UTF-8");
			} else {
				filename = java.net.URLEncoder.encode(filename, "UTF-8");
			}
		}
		return filename;
	}

	public static boolean deleteFileByRelativePath(String relavtivePath) {

		String absolutePath = FileUtil.toAbsolutePath(relavtivePath);

		try {
			Files.delete(Paths.get(absolutePath));
			return true;
		} catch (IOException e) {
			log.error("删除文件出错�?", e);
		}

		return false;
	}
}
