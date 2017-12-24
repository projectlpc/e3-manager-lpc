package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

@Controller
public class PictureController {
	
//	@Autowired
//	private 
	
	@Value("${image.server.url}")
	private String imageServerURL;
	
	@RequestMapping(value="/pic/upload", produces=MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) throws Exception {
		try {
			String originalFilename = uploadFile.getOriginalFilename();
			String extname = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			//使用FAstDFSClient工具类上传问件
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extname);
			url = imageServerURL + url;
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("error", 0);
			result.put("url", url);
			return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "问件上传失败");
			return JsonUtils.objectToJson(result);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
