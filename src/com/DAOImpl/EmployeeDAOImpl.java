package com.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
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

public class EmployeeDAOImpl implements CRUDDAO<EmployeeDTO> {

	private Connection con = null;
	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class.getName());

	// id, name, salary, join_date, address, city, district, supervisor, role
	public EmployeeDAOImpl() throws SQLException {
		
	}

	/**
	 * create a new employee record
	 * 
	 * @param EmployeeDTO
	 * 
	 * @return EmployeeDTO
	 * @throws SQLException
	 */
	@Override
	public EmployeeDTO save(EmployeeDTO dto) throws SQLException {
		
		con = DBConnect.getInstance().getConnection(); 
		con.setAutoCommit(false);
		
		long id = 1;
		String getSql = "SELECT MAX(id) as id FROM department;";
		String sql = "INSERT INTO employee(id,name,salary,join_date,address,city,district,supervisor,role) value(?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeDTO result = null;

		con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
		ps = con.prepareStatement(getSql);
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				id = rs.getLong("id") + 1;
			}
		} else {
			id++;
		}

		ps = con.prepareStatement(sql);
		ps.setLong(1,  id);
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

		ps.close();
		con.close();

		return result;
	}

	@Override
	public EmployeeDTO update(EmployeeDTO dto) throws SQLException {
		// id, name, salary, join_date, address, city, district, supervisor, role
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "UPDATE employee set name=?,salary=?,join_date=?,address=?,city=?,district=?,supervisor,role=? where id=?;";
		PreparedStatement ps = null;

		con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setDouble(2, dto.getSalary());
		ps.setDate(3, (Date) dto.getJoin_date());
		ps.setString(4, dto.getAddress());
		ps.setString(5, dto.getCity());
		ps.setString(6, dto.getDistrict());
		ps.setLong(6, dto.getSupervisor());
		ps.setString(7, dto.getRole());
		con.commit();
		ps.close();
		con.close();
		return dto;

	}

	@Override
	public EmployeeDTO retrieveById(long id) throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "select id,name,salary,join_date,address,city,district,supervisor,role from employee where id = ?;";
		PreparedStatement ps = null;
		EmployeeDTO result = new EmployeeDTO();
		ResultSet rs = null;

		con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
		ps = con.prepareStatement(sql);
		ps.setLong(1, id);
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
			logger.log(Level.INFO, id + " retrieved from db");
		} else {
			logger.log(Level.INFO, id + " not retrieved from db");
			con.rollback();
		}

		rs.close();
		ps.close();
		con.close();
		System.out.println("123\n"+result.toString());
		return result;
	}

	@Override
	public EmployeeDTO retrieveByName(String name) throws SQLException {

		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "select id,name,salary,join_date,address,city,district,supervisor,role from employee where name = ?;";
		PreparedStatement ps = null;
		EmployeeDTO result = new EmployeeDTO();
		ResultSet rs = null;
		EmployeeDTO emp = null;

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
		} else {
			logger.log(Level.INFO, name + " not retrieved from db");
			con.rollback();
		}

		rs.close();
		ps.close();
		con.close();
		System.out.println("123\n"+result.toString());

		return result;
	}

	@Override
	public List<EmployeeDTO> retrieveAll() throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "Select id , name ,salary, join_date,address,city,district,supervisor,role from employee";
		PreparedStatement ps = null;
		ResultSet rs = null;

		con.setTransactionIsolation(con.TRANSACTION_READ_UNCOMMITTED);
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		EmployeeDTO employee = null;
		List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
		if (rs != null) {
			while (rs.next()) {
				employee = new EmployeeDTO();
				employee.setId(rs.getLong("id"));
				employee.setName(rs.getString("name"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setJoin_date((rs.getDate(("join_date"))));
				employee.setAddress(rs.getString("address"));
				employee.setCity(rs.getString("city"));
				employee.setSupervisor(rs.getLong("supervisor"));
				employee.setRole(rs.getString("role"));

				employees.add(employee);
			}

			con.commit();

			rs.close();
			ps.close();
			con.close();
		}
		return employees;
	}

	@Override
	public boolean remove(EmployeeDTO dto) throws SQLException {

		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "delete from employee where id = ?";

		boolean result = false;

		con.setTransactionIsolation(con.TRANSACTION_READ_UNCOMMITTED);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, dto.getId());
		if (ps.execute()) {
			con.commit();
			result = true;
		} else {
			result = false;
		}

		ps.close();
		con.close();
		return result;

	}

}
