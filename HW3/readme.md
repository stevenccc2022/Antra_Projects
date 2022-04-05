## Homework 3:
Given a dummy link:
http://dummy.restapiexample.com/api/v1/employees
<p>@TODO:<br>
&nbsp;&nbsp;&nbsp;&nbsp;1. create two url <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;get all employee  (group by age)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;get all employee by age <br>
&nbsp;&nbsp;&nbsp;&nbsp;2. controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;service  ->  link<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;pojo<br>
&nbsp;&nbsp;&nbsp;&nbsp;3. rest template<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;retry feature<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;swagger<br></p>
  
  The homework uses one entity: Employee, which was inherited from HW2.
  <p>I created restTemplate in EmployeeController, created two functions implementation for retrieving eployee data in domain/Employee.java using Stream.<br>
  I added dependency in pom.xml for restTemplate, pojo, and retry. I read through articles about POJO which implements serilizable and I am not quite sure the implementation for swagger and retry.<br></p>
