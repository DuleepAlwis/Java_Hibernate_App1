CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_projects`(IN name text,IN description longtext,IN budget text,IN start_date text,IN end_date text,IN est_end_date text )
BEGIN
	
    SET @id = 0;
    SELECT MAX(id) INTO @id FROM project;
    SET @id = @id + 1;
    insert into project(id, name, description, budget, start_date, end_date, est_end_date) values(@id,name,description,budget,start_date,end_date,est_end_date);
    
END