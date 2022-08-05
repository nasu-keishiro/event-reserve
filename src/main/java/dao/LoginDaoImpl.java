package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import domain.Admin;

public class LoginDaoImpl implements LoginDao {

	private DataSource ds;

	// DaoFactoryのdsの呼び出し
	public LoginDaoImpl(DataSource ds) {
		super();
		this.ds = ds;
	}

	@Override
	public List<Admin> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Admin findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Admin admin) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Admin admin) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Admin admin) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Admin findByLoginIdAndLoginPass(String loginId, String loginPass) throws Exception {
		//
		Admin admin = null;
		try (Connection con = ds.getConnection()) {
			// DBでIdと入力された(=?)ものがあるか検索する機能
			String sql = "SELECT * FROM admins WHERE login_id=?";
			// 実行準備
			PreparedStatement stmt = con.prepareStatement(sql);
			// ?に受け取ったIdをセットする
			stmt.setString(1, loginId);
			// SQL文の実行
			ResultSet rs = stmt.executeQuery();
			//.nextで次の空欄、つまり１件分を呼び出す
			//複数繰り返すの場合はwhile文
			if (rs.next()) {
				if (loginPass.equals(rs.getString("login_pass"))) {
					// ↑Stringでの＝は.rqualsで処理する
					admin = mapToAdmin(rs);
				}

			}

		} catch (Exception e) {
			throw e;
		}

		return admin;
	}

	private Admin mapToAdmin(ResultSet rs) throws Exception {

		Admin admin = new Admin();
		admin.setId((Integer) rs.getObject("id"));
		admin.setLoginId(rs.getString("login_id"));
		admin.setLoginPass(rs.getString("login_pass"));

		return admin;
	}

}
