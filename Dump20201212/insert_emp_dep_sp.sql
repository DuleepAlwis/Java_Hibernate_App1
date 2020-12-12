CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_emp_dep`(IN empId INT,IN depId INT)
BEGIN
	 SET @join_date = '';
     SELECT join_date INTO @join_date from employee where id = empId;
     SELECT (@join_date + INTERVAL 1 DAY) INTO @join_date;

    INSERT INTO emp_dep(employeeId,departmentId,start_date) values(empId,depId,@join_date);
END