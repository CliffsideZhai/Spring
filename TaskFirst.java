
package first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;

public class TaskFirst {
    public static void readFile(PrintStream output) {
        String pathname = "C:\\mydircetory\\web_file.txt"; 
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                output.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void writeFile() {
	    try {
	        File writeName = new File("C:\\mydircetory\\web_file.txt");
	        writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
	        try (FileWriter writer = new FileWriter(writeName);
	             BufferedWriter out = new BufferedWriter(writer)
	        ) {
	            out.write("还在学习宋红康的java中，\r\n"); // \r\n即为换行
	            out.write("不会的好多\r\n"); // \r\n即为换行
	            out.flush(); // 把缓存区内容压入文件
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

		    public static void main(String[] args) throws IOException {
		    	writeFile();
//服务端建立连接		    	
		        ServerSocket server = new ServerSocket(9999);
		        System.out.println("服务器建立完成");
		        while (true) {
//接收到一个请求
		            Socket socket = server.accept();
		            System.err.println("接收到请求！");
//获取该请求的输入流

		            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		            //获取请求报文
		            StringBuilder sb = new StringBuilder();
		            Integer bufferSize = 1024;
		            char[] buffer = new char[bufferSize];
		            Integer count = bufferSize;
		            while (count.equals(bufferSize)) {

		                count = input.read(buffer);

		                sb.append(buffer);

		            }
		            System.err.println("获得的请求报文如下：\n"+sb);
		            //获取该请求的输出控制
		            PrintStream output = new PrintStream(socket.getOutputStream());
		            System.out.println("开始响应请求");
		            //输出文件内容
		            readFile(output);
		            //完成
		            output.close();
		            System.err.println("成功响应本次请求\n\n\n");
		        }
		    }

			private static Path Path(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		}