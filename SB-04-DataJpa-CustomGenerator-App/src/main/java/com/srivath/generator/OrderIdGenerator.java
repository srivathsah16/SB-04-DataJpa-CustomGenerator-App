package com.srivath.generator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String prefix = "OD";
		String suffix = "";
		try {
			System.out.println("Inside OrderIdGenerator:: generate method");
			JdbcConnectionAccess conAccess = session.getJdbcConnectionAccess();
			Connection connection = conAccess.obtainConnection();
			Statement statement = connection.createStatement();
			String sqlSelect = "SELECT s.next_val FROM order_seq s;";
			ResultSet rSet = statement.executeQuery(sqlSelect);
			if (rSet.next()) {
				int seqNo = rSet.getInt(1);
				suffix = String.valueOf(seqNo);
				System.out.println("Current PK value = " + suffix);
				// updating next_val after reading current PK
				String updateSql = "UPDATE order_seq SET next_val=next_val+1;";
				statement.executeUpdate(updateSql);
			}

		} catch (Exception e) {
			System.err.println("Error in generate method :" + e.getMessage());
		}
		System.out.println("prefix + suffix=" + (prefix + suffix));
		return prefix + suffix;

	}

}
