package service;

import java.io.File;
import java.util.Map;

public interface QcodeService {
	public String admin(String username,String password);
	public String makeQcode(Integer num);
	public Map<String,String> qcode(String uuid);
	public String upload(String uuid,String savePath,String uploadFileName,File upload) throws Exception;
	public Map<String,Object> download(String portAndIndex) throws Exception;
}
