package com.medi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.medi.model.Output;
import com.medi.tool.Dbtool;

public class OutputDao {

	public static int addOutput(Output output) {
		Connection connection = Dbtool.getConnection();
		String sql = "insert into T_OUTPUT values(SEQ_OUT.nextval,?,?,?,?,sysdate)";
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, output.getMediId());
			prepareStatement.setInt(2, output.getOutnum());
			prepareStatement.setInt(3, output.getCid());
			prepareStatement.setDouble(4, output.getTotalPrince());
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				connection.commit();
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public static void callprocedure(int id) {
		Connection connection = Dbtool.getConnection();
		String sql = "{call update_medinum(?)}";
		CallableStatement call = null;
		try {
			call = connection.prepareCall(sql);
			call.setInt(1, id);
			call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				call.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
