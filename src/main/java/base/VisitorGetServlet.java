package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitorget")
public class VisitorGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//client의 출력객체를 생성
		PrintWriter out = response.getWriter();
		
		String guest=request.getParameter("name");
		//1.첫번째 방법
		Date startDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		String date_format = format.format(startDate);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		String date = LocalDate.now().format(formatter);
		
		
		out.print("<h1>"+guest+" 님이 "+ date_format + "에 남긴 글입니다</h1><br><hr>");
		out.print("내용 : "+request.getParameter("opinion")+"<br>");
		out.print("<a href='/edu/htmlexam/visitorForm.html'>입력화면으로...</a>");
		out.close();
	
	}
}
