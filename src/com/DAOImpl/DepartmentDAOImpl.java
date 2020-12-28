package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
		
	}

	@Override
	public DepartmentDTO save(DepartmentDTO dto) throws SQLException {

		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		long id = 1;
		String getSql = "SELECT MAX(id) as id FROM department;";
		String sql = "INSERT INTO department(id,name,manager,location) value(?,?,?,?);";
		PreparedStatement ps = null;
		ResultSet rs = null;
		DepartmentDTO result = null;

		
			con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
			ps = con.prepareStatement(getSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getLong("id") + 1;
			}
			System.out.println(dto.toString());
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ps.setString(2, dto.getName());
			ps.setLong(3, (long) dto.getManager().getId());
			ps.setString(4, dto.getLocation());
			
			if (ps.executeUpdate()>0) {
				logger.log(Level.INFO, "Insertion success");
				con.commit();

				result = dto;

			} else {
				result = null;
				con.rollback();
				logger.log(Level.WARNING, "Insertion unsuccess");

			}

		
				ps.close();
				con.close();
			
		return result;
	}

	@Override
	public DepartmentDTO update(DepartmentDTO dto) throws SQLException {

		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "UPDATE department set name=?,manager=?,location=? where id=?";
		PreparedStatement ps = null;
		DepartmentDTO result = null;
		
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

		
			
				ps.close();
				con.close();
			

		
		return dto;
	}

	@Override
	public DepartmentDTO retrieveById(long id) throws SQLException {

		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		String sql = "select department.id as departmentId,department.name as departmentName,department.location as location,employee.id as managerId,employee.name as managerName from department,employee where id = ? and employee.id = department.manager";
		PreparedStatement ps = null;
		DepartmentDTO result = null;
		ResultSet rs = null;
		EmployeeDTO emp = null;
		
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


		
				rs.close();
				ps.close();
				con.close();
			

		
		return result;
	}

	@Override
	public List<DepartmentDTO> retrieveAll() throws SQLException {

		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		String sql = "select department.id,department.name,department.location,employee.id,employee.name from department,employee where employee.id = department.id;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		DepartmentDTO result = null;
		EmployeeDTO emp = null;
		List<DepartmentDTO> arrList = new ArrayList<DepartmentDTO>();

		
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
			

	
				rs.close();
				ps.close();
				con.close();
			

		
		return arrList;
	}

	@Override
	public DepartmentDTO retrieveByName(String name) throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		String sql = "select department.id as departmentId,department.name as departmentName,department.location as location,employee.id as managerId,employee.name as managerName from department,employee where name = ? and employee.id = department.manager";
		PreparedStatement ps = null;
		DepartmentDTO result = null;
		ResultSet rs = null;
		EmployeeDTO emp = null;
		
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


		
				rs.close();
				ps.close();
				con.close();
		

		
		return result;
	}
	
	@Override
	public boolean remove(DepartmentDTO dto) throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		String sql = "delete from department where id = ?;";
		PreparedStatement ps = null;
		boolean result = false;
		
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
			
			ps.close();
			con.close();
		
		return result;
	}

	

}
