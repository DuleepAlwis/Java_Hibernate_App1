package com.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.DAO.CRUDDAO;
import com.DTO.DepartmentDTO;
import com.DTO.EmployeeDTO;
import com.Database.DBConnect;

public class EmployeeDAOImpl implements CRUDDAO<EmployeeDTO> {

	private Connection con = null;
	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class.getName());

	// id, name, salary, join_date, address, city, district, supervisor, role
	public EmployeeDAOImpl() throws SQLException {
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
	}

	@Override
	public EmployeeDTO save(EmployeeDTO dto) {
		long id = 0;
		String getSql = "SELECT MAX(id) FROM department;";
		String sql = "INSERT INTO employee(id,name,salary,join_date,address,city,district,supervisor,role) value(?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeDTO result = null;

		try {
			con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
			ps = con.prepareStatement(getSql);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					id = rs.getLong("id") + 1;
				}
			}
			else {
				id++;
			}
			
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int) id);
			ps.setString(2, dto.getName());
			ps.setDouble(3, dto.getSalary());
			ps.setDate(4, (Date) dto.getJoin_date());
			ps.setString(5, dto.getAddress());
			ps.setString(6, dto.getCity());
			ps.setString(7, dto.getDistrict());
			ps.setInt(8, (int) dto.getSupervisor());
			ps.setString(9, dto.getRole());

			if (ps.execute()) {
				logger.log(Level.INFO, "Insertion success");
				con.commit();

				result = dto;

			} else {
				con.rollback();
				logger.log(Level.WARNING, "Insertion unsuccess");

			}

		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
			}

		}
		return result;
	}

	@Override
	public EmployeeDTO update(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO retrieveById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO retrieveByName(String name) {
		String sql = "select id,name,salary,join_date,address,city,district,supervisor,role from employee where name = ?;";
		PreparedStatement ps = null;
		EmployeeDTO result = null;
		ResultSet rs = null;
		EmployeeDTO emp = null;
		try {
			con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs != null) {

				while (rs.next()) {
					result.setId(rs.getLong(1));
					result.setName(rs.getString(2));
					result.setSalary(rs.getDouble(3));
					result.setJoin_date(rs.getDate(4));
					result.setAddress(rs.getString(5));
					result.setCity(rs.getString(6));
					result.setDistrict(rs.getString(7));
					result.setSupervisor(rs.getLong(8));
					result.setRole(rs.getString(9));
					
				}
				con.commit();
				logger.log(Level.INFO, name + " retrieved from db");
			}
			else {
				logger.log(Level.INFO, name + " not retrieved from db");
				con.rollback();
			}


		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
			}

		}
		return result;
	}

	@Override
	public ArrayList<EmployeeDTO> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

}
