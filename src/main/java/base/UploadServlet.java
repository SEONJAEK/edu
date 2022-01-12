package base;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload") //매핑명 정의 필수(Servlet이니까)
//이것두 필수임 location에 업로드 되는 파일을 저장할 패스정보를 저장, 원하는 디렉토리 위치에 주면 됨
//이 폴더가 이미 존재해야함
@MultipartConfig(location = "c:/Temp/uploadtest")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String path = "c:/Temp/uploadtest";
		//주어진 문자열 경로를 갖는 File 객체를 생성한다
		File isDir = new File(path);
		if (!isDir.isDirectory()) { //isDirectory()실제 폴더가 있는지 확인 이미 존재하냐?
			isDir.mkdirs(); //존재 확인한 뒤 없으면 만들어라
		}
		//getParts를 통해 Body에 넘어온 데이터들을 각각의 Part로 쪼개어 리턴
		//멀티파트로 보낼때 파트 갯수 만큼 파트 객체가 만들어지고 콜렉션에 담아서 리턴해줌
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			//null이 아니면 업로드 된 파트 
			//작성자 이름을 아무것도 안가면 name은 가지만 value가 비어있음
			//myfile도 안써도 myfile은 가지만 value는 비어잇음
			//getSubmittedFileName():업로드한 파일의 이름을 구함
			//null문자열 : "", null문자열 길이가 0인 객체임... null은 객체가 없는 것, null문자열은 객체임
			String fileName = part.getSubmittedFileName();
			//업로드한 파일아무것도 없으면 출력 안함
			//!fileName.equals("")만 쓰면 안되노
			if (fileName != null && !fileName.equals("")) {
				//현재시간 추출+파일이름 (1970년 1월 1일기준 밀리세컨드로 셈)//파일일때
				part.write(System.currentTimeMillis()+"_"+fileName); 
				out.print("업로드한 파일 이름: " + fileName + "<br>");
				out.print("크기: " + part.getSize() + "<br>");
			} else if (fileName == null){//일반 쿼리에 대한 파트: 작성자 이름, 작성자 번호
				String partName = part.getName();
				String fieldValue = request.getParameter(partName);
				out.print(partName + " : " + fieldValue + "<br>");
			}
		}
		out.close();
	}
}
