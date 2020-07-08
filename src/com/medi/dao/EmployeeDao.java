package com.medi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.medi.model.Employee;
import com.medi.tool.Dbtool;

public class EmployeeDao {
	public static int addEployee(Employee employee) {
		Connection connection = Dbtool.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "inset into EMPLOYEE_INFO values(SEQ_EMP.nextval,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getSex());
			preparedStatement.setString(3, employee.getDegeree());
			preparedStatement.setString(4, employee.getPosition());
			preparedStatement.setInt(5, employee.getAge());
			preparedStatement.setString(6, employee.getPassword());
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

	public static boolean checkemployee(String name, String password) {
		Connection connection = Dbtool.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "select * from EMPLOYEE_INFO where NAME=? and PASSWORD=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			ResultSet executeQuery = preparedStatement.executeQuery();
			return executeQuery.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static String getPosition(String name) {
		Connection connection = Dbtool.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "select POSITION from EMPLOYEE_INFO where NAME=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet executeQuery = preparedStatement.executeQuery();
			executeQuery.next();
			return executeQuery.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}

	}

	public static Employee findEmployeeByName(String name) {
		Connection connection = Dbtool.getConnection();
		String sql = "select * from EMPLOYEE_INFO where name= '" + name + "'";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7));
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
