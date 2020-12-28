package com.ServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.DAOImpl.DepartmentDAOImpl;
import com.DAOImpl.ProjectDAOImpl;
import com.DTO.DepartmentDTO;
import com.DTO.ProjectDTO;
import com.Service.CRUDService;

public class ProjectServiceImpl implements CRUDService<ProjectDTO>{

	ProjectDAOImpl projectDAOImpl;
	private static Logger logger = Logger.getLogger(ProjectServiceImpl.class.getName());

	public ProjectServiceImpl() throws SQLException {
		
		projectDAOImpl = new ProjectDAOImpl();
		
	}

	@Override
	public ProjectDTO save(ProjectDTO dto) {
		try {
			return this.projectDAOImpl.save(dto);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

	@Override
	public ProjectDTO update(ProjectDTO dto) {
		try {
			return this.projectDAOImpl.update(dto);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

	@Override
	public List<ProjectDTO> retrieveAll() {
		
		try {
			return this.projectDAOImpl.retrieveAll();
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

	@Override
	public boolean remove(ProjectDTO dto) {
		try {
			return this.projectDAOImpl.remove(dto);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return false;
		}
	}

	@Override
	public ProjectDTO getUsingID(long id) {
		try {
			return this.projectDAOImpl.retrieveById(id);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

	@Override
	public ProjectDTO retrieveByName(String name) {
		try {
			return this.projectDAOImpl.retrieveByName(name);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}
}
