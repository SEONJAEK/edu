package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//응답시 설정 client할때 응답할때
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//string 가져오기
		String arr[] = request.getParameterValues("add_rq");
		String date_string = request.getParameter("a");
		//string -> date format으로 
		LocalDate date = LocalDate.parse(date_string);
	    //패턴
		DateTimeFormatter transformat = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		
		String str = "";
		for(int i=0; i<arr.length; i++) {
			if(i==arr.length-1) {
				str += arr[i];
			}else {
			str += arr[i] +", ";
			}
		}
			out.printf("<h1>%s님의 예약 내용</h1><hr>", request.getParameter("reservationName"));
			out.printf("<ul><li>휴양림 : %s</li>"
					+ "<li>추가 요청 사항 : %s</li>"
					+ "<li>예약날짜: %s</li></ul>", request.getParameter("mountain"), str , transformat.format(date));
		
	}

}
