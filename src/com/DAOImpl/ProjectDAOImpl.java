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
import com.DTO.ProjectDTO;
import com.Database.DBConnect;

public class ProjectDAOImpl implements CRUDDAO<ProjectDTO> {

	
	private Connection con = null;
	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class.getName());

	public ProjectDAOImpl() throws SQLException {
		
	}
	
	@Override
	public ProjectDTO save(ProjectDTO dto) throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		long id = 1;
		String getSql = "SELECT MAX(id) as id FROM project;";
		String sql = "INSERT INTO project(id,name,description,budget,start_date,end_date,est_end_date) value(?,?,?,?,?,?,?);";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProjectDTO result = null;

		
			con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
			ps = con.prepareStatement(getSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getLong("id") + 1;
			}
			ps = con.prepareStatement(sql);
			ps.setLong(1,  id);
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getDescription());
			ps.setDouble(4, dto.getBudget());
			ps.setDate(5, (Date) dto.getStart_date());
			ps.setDate(6, (Date) dto.getEnd_date());
			ps.setDate(7, (Date) dto.getEst_end_date());

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
	public ProjectDTO update(ProjectDTO dto) throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "UPDATE project set name=?,description=?,budget=?,start_date=?,end_date=?,est_end_date=? where id=?;";
		PreparedStatement ps = null;

		con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2,dto.getDescription());
		ps.setDouble(3, dto.getBudget());
		ps.setDate(4, (Date) dto.getStart_date());
		ps.setDate(5, (Date) dto.getEnd_date());
		ps.setDate(6, (Date) dto.getEst_end_date());
		ps.setLong(7, dto.getId());
		con.commit();
		ps.close();
		con.close();
		return dto;
	}

	@Override
	public ProjectDTO retrieveById(long id) throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "Select id,name,decription, budget, start_date,end_date,est_end_date from project where id=?";
		ProjectDTO result = new ProjectDTO();
		con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
		PreparedStatement ps = con.prepareStatement(sql);
	
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				result.setId(rs.getLong("id"));
				result.setName(rs.getString("name"));
				result.setDescription(rs.getString("description"));
				result.setBudget(rs.getDouble("budget"));
				result.setStart_date(rs.getDate("start_date"));
				result.setEnd_date(rs.getDate("end_date"));
				result.setEst_end_date(rs.getDate("est_end_date"));
				
			}
		}
		
		
		con.commit();
		ps.close();
		con.close();
		return result;

	}

	@Override
	public ProjectDTO retrieveByName(String name) throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "Select id,name,decription, budget, start_date,end_date,est_end_date from project where name=?";
		ProjectDTO result = new ProjectDTO();
		con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
		PreparedStatement ps = con.prepareStatement(sql);
	
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				result.setId(rs.getLong("id"));
				result.setName(rs.getString("name"));
				result.setDescription(rs.getString("description"));
				result.setBudget(rs.getDouble("budget"));
				result.setStart_date(rs.getDate("start_date"));
				result.setEnd_date(rs.getDate("end_date"));
				result.setEst_end_date(rs.getDate("est_end_date"));
				
			}
		}
		
		
		con.commit();
		ps.close();
		con.close();
		return result;

	}

	@Override
	public List<ProjectDTO> retrieveAll() throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "Select id,name,decription, budget, start_date,end_date,est_end_date from project?";
		ProjectDTO dto = new ProjectDTO();
		List<ProjectDTO> prjList = new ArrayList<ProjectDTO>();
		
		con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
		PreparedStatement ps = con.prepareStatement(sql);
	
		
		ResultSet rs = ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				dto.setId(rs.getLong("id"));
				dto.setName(rs.getString("name"));
				dto.setDescription(rs.getString("description"));
				dto.setBudget(rs.getDouble("budget"));
				dto.setStart_date(rs.getDate("start_date"));
				dto.setEnd_date(rs.getDate("end_date"));
				dto.setEst_end_date(rs.getDate("est_end_date"));
				prjList.add(dto);
			}
		}
		
		
		
		con.commit();
		ps.close();
		con.close();
		return prjList;

	}

	@Override
	public boolean remove(ProjectDTO dto) throws SQLException {
		
		con = DBConnect.getInstance().getConnection();
		con.setAutoCommit(false);
		
		String sql = "delete from project where id = ?";
		boolean result = false;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, dto.getId());
		
		if(ps.execute()) {
			result = true;
		}
		
		con.commit();
		ps.close();
		con.close();
		return result;
			
	}

}
