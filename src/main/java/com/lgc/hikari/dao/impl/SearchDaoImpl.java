package com.lgc.hikari.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.HikariDataSource;

@Service()
public class SearchDaoImpl extends ResultSetToString {
	private static Logger log = LoggerFactory.getLogger(SearchDaoImpl.class);
	@Autowired
	private HikariDataSource ds;
	private static String TABLE = "events_waits_summary_by_thread_by_event_name";
	private static String SQL = "SELECT * FROM "+ TABLE;
	
	public HikariDataSource getDs() {
		return ds;
	}

	public void setDs(HikariDataSource ds) {
		this.ds = ds;
	}


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
			log.error(e.getMessage(), e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return "";
	}

}
