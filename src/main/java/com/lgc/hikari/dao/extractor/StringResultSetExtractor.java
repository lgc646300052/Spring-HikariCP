package com.lgc.hikari.dao.extractor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StringResultSetExtractor implements ResultSetExtractor<String> {

	@Override
	public String extractData(ResultSet rs) throws SQLException, DataAccessException {
		StringBuilder buffer = new StringBuilder("result:[");
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rs.next()) {
			buffer.append("\n\t{");
			// 列序号从1开始
			for (int i = 1; i <= columnCount; i++) {
				String columnName = metaData.getColumnName(i);
				Object value = rs.getObject(i);
				buffer.append(columnName)
						.append(":")
						.append(value.toString())
						.append(",");
			}
			buffer.append("}");
		}
		
		buffer.append("]");
		return buffer.toString();
	}

}
