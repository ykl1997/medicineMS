package com.medi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medi.model.Medicine;
import com.medi.tool.Dbtool;

public class MedicineDao {
	public static int addMedicine(Medicine medicine) {
		Connection connection = Dbtool.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into MEDI_INFO values(SEQ_MEDI.nextval,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, medicine.getMediName());
			preparedStatement.setString(2, medicine.getMunifac());
			Date muniDate = new Date(medicine.getMuniDate().getTime());
			preparedStatement.setDate(3, muniDate);
			preparedStatement.setString(4, medicine.getFaction());
			preparedStatement.setDouble(5, medicine.getPrice());
			Date deadLine = new Date(medicine.getDeadLine().getTime());
			preparedStatement.setDate(6, deadLine);
			preparedStatement.setInt(7, 0);
			preparedStatement.setString(8, medicine.getPosition());
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

	public static List<Medicine> findMedicineByNameOrFinction(String mediNameOrFinc) {
		Connection connection = Dbtool.getConnection();
		PreparedStatement preparedStatement = null;
		List<Medicine> medicines = new ArrayList<Medicine>();
		ResultSet query = null;
		String sql = "select * from MEDI_INFO where MEDI_NAME like ? or FACTION like ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + mediNameOrFinc + "%");
			preparedStatement.setString(2, "%" + mediNameOrFinc + "%");
			query = preparedStatement.executeQuery();
			while (query.next()) {
				Medicine medicine = new Medicine();
				medicine.setMediId(query.getInt(1));
				medicine.setMediName(query.getString(2));
				medicine.setMunifac(query.getString(3));
				medicine.setMuniDate(query.getDate(4));
				medicine.setFaction(query.getString(5));
				medicine.setPrice(query.getDouble(6));
				medicine.setDeadLine(query.getDate(7));
				medicine.setNum(query.getInt(8));
				medicine.setPosition(query.getString(9));
				medicines.add(medicine);
			}
			return medicines;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				query.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
