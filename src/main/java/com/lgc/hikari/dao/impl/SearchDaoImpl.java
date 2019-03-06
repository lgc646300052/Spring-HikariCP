package com.lgc.hikari.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.HikariDataSource;

@Service
public class SearchDaoImpl extends ResultSetToString {
	@Autowired
	private HikariDataSource ds;
	private static String TABLE = "events_waits_summary_by_thread_by_event_name";
	private static String SQL = "SELECT * FROM "+ TABLE;
	
	public String getAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();
			String resultStr = ResultSetToString(rs);
			return resultStr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "";
	}

}
