package com.medi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.medi.model.Input;
import com.medi.tool.Dbtool;

public class InputDao {
	public static int addInput(Input input) {
		Connection connection = Dbtool.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into T_INPUT values(SEQ_INPUT.nextval, ?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, input.getMediId());
			preparedStatement.setInt(2, input.getInNum());
			preparedStatement.setInt(3, input.geteId());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				connection.commit();
				preparedStatement.close();
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
