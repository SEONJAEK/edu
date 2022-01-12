package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitordb1")
public class VisitorDBServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String url="jdbc:mysql://localhost:3306/jdbcdb?characterEncoding=UTF-8&serverTimezone=UTC";//JDBC URL//Uniform Resource Locator의 약어//주소를 알려주는 단일화된 형식의 문자열
		//어떤 디비서버를 어떤 형식으로 접속할지 알려주는 것
		String user="root";
		String passwd="1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e){
			System.out.println("드라이버오류 발생");
			out.println("<h2>오류발생</h2>");
			out.close();
			return;
		}
		try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select id, name, "
						+ "date_format(writedate,'%Y년%m월%d일') writedate, memo "
						+ "from visitor order by writedate desc ");){
			out.print("<h1>방명록 리스트</h1><hr>");
			out.print("<table border='1'>");
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>"+rs.getString("id")+"</td>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("<td>"+rs.getString("writedate")+"</td>");
				out.print("<td>"+rs.getString("memo")+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} catch (SQLException e) {
			out.print("<h2>SQLException오류발생!!</h2>");
			e.printStackTrace();
		}
		out.close();
	}

}
