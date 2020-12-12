package com.DAOImpl;

import java.sql.Connection;
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

public class DepartmentDAOImpl implements CRUDDAO<DepartmentDTO> {

	private Connection con = null;
	private static Logger logger = Logger.getLogger(DepartmentDAOImpl.class.getName());
	private static String ID = "id";
	private static String NAME = "name";
	private static String MANAGER = "manager";
	private static String LOCATION = "name";

	public DepartmentDAOImpl() throws SQLException {
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
	}

	@Override
	public DepartmentDTO save(DepartmentDTO dto) {

		long id = 0;
		String getSql = "SELECT MAX(id) FROM department;";
		String sql = "INSERT INTO department(id,name,manager,location) value(?,?,?,?);";
		PreparedStatement ps = null;
		ResultSet rs = null;
		DepartmentDTO result = null;

		try {
			con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
			ps = con.prepareStatement(getSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getLong(ID) + 1;
			}
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int) id);
			ps.setString(2, dto.getName());
			ps.setInt(3, (int) dto.getManager().getId());
			ps.setString(4, dto.getLocation());

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
	public DepartmentDTO update(DepartmentDTO dto) {

		String sql = "UPDATE department set name=?,manager=?,location=? where id=?";
		PreparedStatement ps = null;
		DepartmentDTO result = null;
		try {
			con.setTransactionIsolation(con.TRANSACTION_REPEATABLE_READ);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, (int) dto.getManager().getId());
			ps.setString(3, dto.getLocation());
			ps.setInt(4, (int) dto.getId());
			if (ps.execute()) {
				con.commit();
				logger.log(Level.INFO, "Update success");
			} else {
				con.rollback();
				logger.log(Level.WARNING, "Update unsuccess");
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
		return dto;
	}

	@Override
	public DepartmentDTO retrieveById(long id) {

		String sql = "select department.id as departmentId,department.name as departmentName,department.location as location,employee.id as managerId,employee.name as managerName from department,employee where id = ? and employee.id = department.manager";
		PreparedStatement ps = null;
		DepartmentDTO result = null;
		ResultSet rs = null;
		EmployeeDTO emp = null;
		try {
			con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int) id);
			rs = ps.executeQuery();
			if (rs != null) {

				while (rs.next()) {
					result.setId(rs.getInt(1));
					result.setName(rs.getString(2));
					result.setLocation(rs.getString(3));
					emp = new EmployeeDTO();
					emp.setId(rs.getInt(4));
					emp.setName(rs.getString(5));
					result.setManager(emp);
				}
				con.commit();
				logger.log(Level.INFO, id + " retrieved from db");
			}
			else {
				logger.log(Level.INFO, id + " not retrieved from db");
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
	public ArrayList<DepartmentDTO> retrieveAll() {

		String sql = "select department.id,department.name,department.location,employee.id,employee.name from department,employee where employee.id = department.id;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		DepartmentDTO result = null;
		EmployeeDTO emp = null;
		ArrayList<DepartmentDTO> arrList = new ArrayList<DepartmentDTO>();

		try {
			con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					result.setId(rs.getInt(1));
					result.setName(rs.getString(2));
					result.setLocation(rs.getString(3));
					emp = new EmployeeDTO();
					emp.setId(rs.getInt(4));
					emp.setName(rs.getString(5));
					result.setManager(emp);
					arrList.add(result);
				}
				logger.log(Level.INFO, "Retrieved from the db");
				con.commit();
			}
			else {
				logger.log(Level.INFO, "not retrieved from the db");
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
		return arrList;
	}

	@Override
	public DepartmentDTO retrieveByName(String name) {
		String sql = "select department.id as departmentId,department.name as departmentName,department.location as location,employee.id as managerId,employee.name as managerName from department,employee where name = ? and employee.id = department.manager";
		PreparedStatement ps = null;
		DepartmentDTO result = null;
		ResultSet rs = null;
		EmployeeDTO emp = null;
		try {
			con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs != null) {

				while (rs.next()) {
					result.setId(rs.getInt(1));
					result.setName(rs.getString(2));
					result.setLocation(rs.getString(3));
					emp = new EmployeeDTO();
					emp.setId(rs.getInt(4));
					emp.setName(rs.getString(5));
					result.setManager(emp);
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
	public boolean remove(DepartmentDTO dto) {
		String sql = "delete from department where id = ?;";
		PreparedStatement ps = null;
		boolean result = false;
		try {
			con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int) dto.getId());
			if (ps.execute()) {
				logger.log(Level.INFO, dto.getId() + " remove from db");
				con.commit();
				result = true;
			}
			else {
				con.rollback();
				logger.log(Level.INFO, dto.getId() + " not remove from db");

			}
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}
		return result;
	}

	

}
