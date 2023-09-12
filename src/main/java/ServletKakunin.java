
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletKakunin
 */
@WebServlet("/kakunin")
public class ServletKakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	final String url = "jdbc:postgresql://localhost:5432/wang";
	final String user = "postgres";
	final String dbPassword = "postgres";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletKakunin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		response.sendRedirect("kakunin.jsp");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String userId = session.getAttribute("userID").toString();
		String password = session.getAttribute("password").toString();
		String lastname = session.getAttribute("lname").toString();
		String firstname = session.getAttribute("fname").toString();
		String lastnameKana = session.getAttribute("lnameKana").toString();
		String firstnameKana = session.getAttribute("fnameKana").toString();
		System.out.println(email);
		
		System.out.println(userId);
		System.out.println(password);
		System.out.println(lastname);
		System.out.println(firstname);
		System.out.println(lastnameKana);
		System.out.println(firstnameKana);
		
		

		try {
			  // 创建数据库连接
            Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, dbPassword);
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO public.rakuten (user_id, email, password, last_name, first_name, last_name_kana, first_name_kana) "
					+ "VALUES ('" + userId + "', '" + email + "', '" + password + "', '" + lastname
					+ "', '" + firstname + "', '" + lastnameKana + "', '" + firstnameKana + "')";

			System.out.println(sql);
            stmt.executeUpdate(sql);
            
            stmt.close();
            conn.close();


			// 请求转发到另一个JSP页面
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("last.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			response.sendRedirect("kakunin.jsp");
		}
	}

}
