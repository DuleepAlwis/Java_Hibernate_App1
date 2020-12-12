CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_department`(IN name varchar(255),IN manager int,IN location varchar(255))
BEGIN

	SET @id = 0 ;
    SET @managerID = manager;
    SELECT MAX(id) INTO @id from department;
    IF(@id is null OR @id = '') THEN
		SET @id = 0 ;
	END IF; 
	SET @id = @id + 1;
    
    IF (EXISTS (SELECT * FROM employee where id = @managerID)) THEN
		INSERT INTO department(id,name,manager,location) values(@id,name,@managerID,location);
    END IF;
		
END