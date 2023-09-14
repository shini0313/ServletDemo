
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import obj.User;

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

	}

	/**
	 * 確認画面の表示
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("kakunin.jsp");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	/**
	 * 完了画面へ移る
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String email = (String) request.getSession().getAttribute("email");
		    String userId = (String) request.getSession().getAttribute("userId");
		    String password = (String) request.getSession().getAttribute("password");
		    String lastname = (String) request.getSession().getAttribute("lname");
		    String firstname = (String) request.getSession().getAttribute("fname");
		    String lastnameKana = (String) request.getSession().getAttribute("lnameKana");
		    String firstnameKana = (String) request.getSession().getAttribute("fnameKana");
		System.out.println(userId);

		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		user.setEmail(email);
		user.setLastName(lastname);
		user.setFirstName(firstname);
		user.setLastNameKana(lastnameKana);
		user.setFirstNameKana(firstnameKana);

		UserDao userDao = new UserDao();
		userDao.insertUser(user);
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("kanryou.jsp");
		dispatcher.forward(request, response);

		response.sendRedirect("kakunin.jsp");

	}

}
