CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_employees`()
BEGIN
	SET @count = 0;
    SET @id = 0;
    SET @salary = 50000;
    SET @address = "";
    SET @City = "";
    SET @District = "";
    SET @name = "";
    SET @join_date = "";
    SET @mod = 0;
	SELECT MAX(id) INTO @id FROM employee;
    
    WHILE(@count<50) do
    
		SET @id = @id + 1;
		SELECT MOD(@id,5) INTO @mod;
        
        SELECT @id,@mod;
        IF (@mod)=0 THEN
			SELECT (current_date() - INTERVAL 1 DAY) INTO @join_date;
            SELECT @join_date;
			INSERT INTO employee(id,name,salary,join_date,address,city,district,supervisor) values(@id,concat("Nimal",@id),@salary,@join_date,concat("17/V",@id),concat("Bambalapitiya",@mod),concat("Colombo",@mod),null);
		END IF;
        
        IF (@mod)=1 THEN
			SELECT (current_date() - INTERVAL 5 DAY) INTO @join_date;
                        SELECT @join_date;
			INSERT INTO employee(id,name,salary,join_date,address,city,district,supervisor) values(@id,concat("Nimal",@id),@salary,@join_date,concat("17/V",@id),concat("Bambalapitiya",@mod),concat("Colombo",@mod),null);
		END IF;
        
        IF (@mod)=2 THEN
			SELECT (current_date() - INTERVAL 10 DAY) INTO @join_date;
                        SELECT @join_date;
			INSERT INTO employee(id,name,salary,join_date,address,city,district,supervisor) values(@id,concat("Nimal",@id),@salary,@join_date,concat("17/V",@id),concat("Bambalapitiya",@mod),concat("Colombo",@mod),null);
		END IF;
        
        IF (@mod)=3 THEN
			SELECT (current_date() - INTERVAL 15 DAY) INTO @join_date;
                        SELECT @join_date;
			INSERT INTO employee(id,name,salary,join_date,address,city,district,supervisor) values(@id,concat("Nimal",@id),@salary,@join_date,concat("17/V",@id),concat("Bambalapitiya",@mod),concat("Colombo",@mod),null);
		END IF;
        
        IF (@mod)=4 THEN
			SELECT (current_date() - INTERVAL 20 DAY) INTO @join_date;
                        SELECT @join_date;
			INSERT INTO employee(id,name,salary,join_date,address,city,district,supervisor) values(@id,concat("Nimal",@id),@salary,@join_date,concat("17/V",@id),concat("Bambalapitiya",@mod),concat("Colombo",@mod),null);
		END IF;
        
        SET @count = @count +1;
        
	END WHILE;
        
END