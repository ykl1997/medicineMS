package com.medi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.medi.model.ViewOrder;
import com.medi.tool.Dbtool;

public class ViewOrderDao {
	public static List<ViewOrder> findOrders() {
		Connection connection = Dbtool.getConnection();
		List<ViewOrder> viewOrders = new ArrayList<ViewOrder>();
		Statement statement = null;
		ResultSet query = null;
		String sql = "select * from V_ORDER";
		try {
			statement = connection.createStatement();
			query = statement.executeQuery(sql);
			while (query.next()) {
				ViewOrder viewOrder = new ViewOrder();
				viewOrder.setCusName(query.getString(1));
				viewOrder.setMediName(query.getString(2));
				viewOrder.setNum(query.getInt(3));
				viewOrder.setTotalPrince(query.getDouble(4));
				viewOrders.add(viewOrder);
			}
			return viewOrders;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				query.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<ViewOrder> findOrdersByNane(String name) {
		Connection connection = Dbtool.getConnection();
		List<ViewOrder> viewOrders = new ArrayList<ViewOrder>();
		Statement statement = null;
		ResultSet query = null;
		String sql = "select * from V_ORDER where name ='" + name + "'";
		try {
			statement = connection.createStatement();
			query = statement.executeQuery(sql);
			while (query.next()) {
				ViewOrder viewOrder = new ViewOrder();
				viewOrder.setCusName(query.getString(1));
				viewOrder.setMediName(query.getString(2));
				viewOrder.setNum(query.getInt(3));
				viewOrder.setTotalPrince(query.getDouble(4));
				viewOrders.add(viewOrder);
			}
			return viewOrders;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				query.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
