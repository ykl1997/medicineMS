package com.medi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.medi.model.Customer;
import com.medi.tool.Dbtool;

public class CustomerDao {
	public static int addCutomer(Customer customer) {
		Connection connection = Dbtool.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into CUSTOMER_INFO values(SEQ_CUS.nextval,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getPhone());
			preparedStatement.setString(3, customer.getPassword());
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

	public static Customer findCustomerByName(String name) {
		Connection connection = Dbtool.getConnection();
		String sql = "select * from CUSTOMER_INFO where name= '" + name + "'";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			Customer customer = new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4));
			return customer;
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
