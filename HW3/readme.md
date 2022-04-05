##Homework 3:
Given a dummy link:
http://dummy.restapiexample.com/api/v1/employees
@TODO:
	1. create two url 
		get all employee  (group by age)
		get all employee by age 
	2. controller 
	    service  ->  link
   	    pojo
	3. rest template
	* retry feature
	* swagger
  
  The homework uses one entity: Employee, which was inherited from HW2.
  I created restTemplate in EmployeeController, created two functions implementation for retrieving eployee data in domain/Employee.java using Stream.
  I added dependency in pom.xml for restTemplate, pojo, and retry.
  I read through articles about POJO which implements serilizable. And I am not quite sure the implementation for swagger and retry.
