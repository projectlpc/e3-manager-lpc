package cn.e3mall.fastDFS;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class TestDastDFS {

	@Test
	public void testUpload() throws Exception {
		// ClientGlobal.init("D:/workspace/e3_mall/e3-manager-web/src/main/resources/conf/client.conf");
		// TrackerClient trackerClient = new TrackerClient();
		// TrackerServer trackerServer = trackerClient.getConnection();
		// StorageServer storageServer = null;
		// StorageClient storageClient = new StorageClient(trackerServer,
		// storageServer);
		// String[] strings =
		// storageClient.upload_file("C:/Users/Administrator/Desktop/u=513625493,2422582171&fm=27&gp=0.jpg",
		// "jpg", null);
		//
		// for(String string : strings){
		// System.out.println(string);
		// }
		// 1、创建一个配置文件，配置TrackerServer的ip地址及端口号。
		// 2、加载配置文件。
		ClientGlobal.init("D:/workspace/e3_mall/e3-manager-web/src/main/resources/conf/client.conf");
		// 3、创建一个TrackerClient对象。直接new
		TrackerClient trackerClient = new TrackerClient();
		// 4、使用TrackerClient获得一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 5、创建一个StorageClient对象。需要两个参数，一个是TrackerServer对象，一个是StorageServer对象（可以为null）
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6、使用StorageClient对象上传文件。
		// 参数1：文件路径及文件名。 参数2：文件的扩展名，不带"."。 参数3：元数据，可以为null
		String[] strings = storageClient.upload_file("D:/新建文件夹/李鹏程/照片/QQ图片20170630230825.jpg", "jpg",
				null);
		for (String string : strings) {
			System.out.println(string);
		}

	}
	@Test
	public void testFastDFSClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("D:/workspace/e3_mall/e3-manager-web/src/main/resources/conf/client.conf");
		String url = fastDFSClient.uploadFile("D:/新建文件夹/李鹏程/照片/QQ图片20170630230825.jpg");
		System.out.println(url);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
