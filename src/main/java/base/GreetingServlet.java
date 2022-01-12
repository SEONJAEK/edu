package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		LocalDate localDate = LocalDate.now();
		String date = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
		String guest ="손";
		if (request.getParameter("guestname") != null) {
			guest = request.getParameter("guestname");
		}
		out.print("<h1>"+guest+"님! 반가워요.. 오늘은 "+ date + "입니다!!</h1>");
	}
}
