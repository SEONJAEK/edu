package base;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/getHTML", "/getXML", "/getJSON", "/getImage" }) //"/getHTML", "/getXML", "/getJSON", "/getImage"라고 해도 이 서블릿이 작동한다. //여러개의 PATH지정가능
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//사용하는 URI만 꺼내기
		String uri = request.getRequestURI();
		System.out.println(uri);
		String filename = "";
		String contentType = "";
			//추출된 uri의 끝이 getHTML로 끝나냐?
		if (uri.endsWith("getHTML")) {
			filename = "c:/Temp/sample.html";	
			//html 문서를 읽어서 줄거다
			contentType = "text/html; charset=utf-8";
			//추출된 uri의 끝이 getXML로 끝나냐?
		} else if (uri.endsWith("getXML")) {
			filename = "c:/Temp/sample.xml";	
			//xml 로 읽을거다
			contentType = "application/xml; charset=utf-8";
			//추출된 uri의 끝이 getJSON로 끝나냐?
		} else if (uri.endsWith("getJSON")) {
			filename = "c:/Temp/sample.json";	
			//json으로 읽을거다
			contentType = "text/json; charset=utf-8";
			//추출된 uri의 끝이 나머지로 끝나냐?=>이미지로 줄거임
		} else {
			filename = "c:/Temp/trans_duke.png";	
			//image중 png로 읽을거다
			contentType = "image/png";
		}
		//file inputStream으로 열어야한다. 이미지는... 
		//api명이 inputstream이나 output 바이트단위로 io하는 애다 -> 이미지는 반드시 바이트단위로 읽어야 한다. 
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		response.setContentType(contentType);
		//이미지로 시작한다면 , 이미지라 바이트스트림 써야해서 getoutputstream 을 써서 servletoutputstream객체로 받아와서 사용
		if(contentType.startsWith("image")) {
			byte[] content = new byte[(int)f.length()];
			ServletOutputStream sos = response.getOutputStream();
			fis.read(content);
			sos.write(content);			
			sos.close();
		} else {
			//바이트스트림을 문자스트림으로 바꿔주는 애 왜냐면 한글같은 경우 반드시 문자스트림으로 읽어저야함, 영어는 노상관
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			//io의 성능을 위해 bufferedreader를 씀
			BufferedReader br = new BufferedReader(isr);
			PrintWriter out = response.getWriter();
			String line = null; 
			while((line = br.readLine()) != null) 
				out.println(line);
			out.close();
			br.close();
			isr.close();			
		}		
		fis.close();
	}
}
