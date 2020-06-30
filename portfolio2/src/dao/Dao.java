package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import dto.Dto;
import dto.ScheduleDto;

/**
 * Servlet implementation class Dao
 */
@WebServlet("/Dao")
public class Dao {
	private Connection con;
	private String sql;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<ScheduleDto> list = null;

	/**
	 * testdb�ɐڑ����邽�߂̃R���X�g���N�^
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Dao() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=UTC&useSSL=false";
		String user = "root";
		String pass = "root";
		con = DriverManager.getConnection(url, user, pass);
	}

	/**
	 * DB�ڑ���ؒf����
	 */
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���O�C�����̃f�[�^�ƍ�
	 * 
	 * @param name ���O
	 * @param      pass�@�p�X���[�h
	 * @return ���O�C��������...1 <br>
	 *         ���O�C�����s��...0
	 * @throws SQLException
	 */
	public int getLoginInfo(String name, String pass) throws SQLException {

		int row = 0;
		sql = "SELECT * from login where name = ? and password = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pass);

		try {
			rs = ps.executeQuery();
			rs.last();
			row = rs.getRow();
		} finally {
			ps.close();
		}
		return row;
	}

	public int insertAccount(Dto dto) throws SQLException {
		sql = "INSERT INTO login (name, password) VALUES (?, ?)";
		int n = 0;

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPass());

			n = ps.executeUpdate();
		} finally {
			ps.close();
		}
		return n;
	}

	public int insertSchedule(ScheduleDto dto) throws SQLException {
		sql = "INSERT INTO calendar (start,end,schedule,date) VALUES (?, ?, ?, ?)";
		int n = 0;

		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, dto.getStart());
			ps.setInt(2, dto.getEnd());
			ps.setString(3, dto.getSchedule());
			ps.setString(4, dto.getDate());

			n = ps.executeUpdate();
		} finally {
			ps.close();
		}
		return n;
	}

	public ArrayList<ScheduleDto> getItemsAll() throws SQLException {

		sql = "select * from calendar";
		ps = con.prepareStatement(sql);
		return search(ps);
	}

	public ArrayList<ScheduleDto> getItemsFromDate(String date) throws SQLException {

		sql = "select * from calendar where date = ?";
		// select * from calendar where date like "%-%";
		ps = con.prepareStatement(sql);
		ps.setString(1, date);
		return search(ps);
	}

	public ArrayList<ScheduleDto> getItemsFromMonth(String date) throws SQLException {

		sql = "select * from calendar where date like ?";
		// select * from calendar where date like "%-%";
		ps = con.prepareStatement(sql);
		ps.setString(1, date + "%");
		return search(ps);
	}
	
	public ArrayList<ScheduleDto> getItemsFromSchedule(String schedule) throws SQLException {

		sql = "select * from calendar where schedule like ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, "%" + schedule + "%");
		return search(ps);
	}

	private ArrayList<ScheduleDto> search(PreparedStatement ps) throws SQLException {

		try {
			rs = ps.executeQuery();
			list = new ArrayList<>();
			ScheduleDto dto;
			while (rs.next()) {
				dto = new ScheduleDto();
				dto.setId(rs.getInt("id"));
				dto.setschedule(rs.getString("schedule"));
				dto.setStart(rs.getInt("start"));
				dto.setEnd(rs.getInt("end"));
				dto.setDate(rs.getString("date"));
				list.add(dto);
			}
		} finally {
			ps.close();
		}
		return list;
	}

}