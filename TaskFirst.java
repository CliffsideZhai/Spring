
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
             BufferedReader br = new BufferedReader(reader) // ����һ�����������ļ�����ת�ɼ�����ܶ���������
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                // һ�ζ���һ������
                output.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void writeFile() {
	    try {
	        File writeName = new File("C:\\mydircetory\\web_file.txt");
	        writeName.createNewFile(); // �������ļ�,��ͬ�����ļ��Ļ�ֱ�Ӹ���
	        try (FileWriter writer = new FileWriter(writeName);
	             BufferedWriter out = new BufferedWriter(writer)
	        ) {
	            out.write("����ѧϰ�κ쿵��java�У�\r\n"); // \r\n��Ϊ����
	            out.write("����ĺö�\r\n"); // \r\n��Ϊ����
	            out.flush(); // �ѻ���������ѹ���ļ�
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

		    public static void main(String[] args) throws IOException {
		    	writeFile();
//����˽�������		    	
		        ServerSocket server = new ServerSocket(9999);
		        System.out.println("�������������");
		        while (true) {
//���յ�һ������
		            Socket socket = server.accept();
		            System.err.println("���յ�����");
//��ȡ�������������

		            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		            //��ȡ������
		            StringBuilder sb = new StringBuilder();
		            Integer bufferSize = 1024;
		            char[] buffer = new char[bufferSize];
		            Integer count = bufferSize;
		            while (count.equals(bufferSize)) {

		                count = input.read(buffer);

		                sb.append(buffer);

		            }
		            System.err.println("��õ����������£�\n"+sb);
		            //��ȡ��������������
		            PrintStream output = new PrintStream(socket.getOutputStream());
		            System.out.println("��ʼ��Ӧ����");
		            //����ļ�����
		            readFile(output);
		            //���
		            output.close();
		            System.err.println("�ɹ���Ӧ��������\n\n\n");
		        }
		    }

			private static Path Path(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		}