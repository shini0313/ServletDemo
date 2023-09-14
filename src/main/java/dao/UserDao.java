package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import obj.User;

public class UserDao {
	final String url = "jdbc:postgresql://localhost:5432/wang";
	final String user = "postgres";
	final String dbPassword = "postgres";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;

	/**
	 * ユーザー情報全獲得
	 * @return
	 */
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();

		try {

			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, dbPassword);
			stmt = conn.createStatement();

			String sql = "SELECT * FROM rakuten";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setEmail(rs.getString("email"));
				user.setLastName(rs.getString("last_name"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastNameKana(rs.getString("last_name_kana"));
				user.setFirstNameKana(rs.getString("first_name_kana"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return users;
	}

	/**
	 * ユーザー情報登録
	 * @param u
	 */
	public void insertUser(User u) {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, dbPassword);
			stmt = conn.createStatement();

			String sql = "INSERT INTO public.rakuten (user_id, email, password, last_name, first_name, last_name_kana, first_name_kana) "
					+ "VALUES ('" + u.getUserId()+ "', '" + u.getEmail() + "', '" + u.getPassword() + "', '"
					+ u.getLastName()
					+ "', '" + u.getFirstName() + "', '" + u.getLastNameKana() + "', '" + u.getFirstNameKana() + "')";
			System.out.println(sql);

			stmt.executeUpdate(sql);

			stmt.close();
			conn.close();

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();

		}
	}

	public User userIdUser(String userId) {
		User u = new User();
		try {

			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, dbPassword);
			stmt = conn.createStatement();

			String sql = "SELECT * FROM rakuten WHERE user_id = '" + userId + "'";
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				u.setUserId(rset.getString("user_id"));
				System.out.println(sql);

			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return u;
	}

}
