<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><title>Create User</title></head>
<body>
  <form:form action="createUser" commandName="comnd" method="post">
   Enter User Name:<form:input  path="name"/> <br/>
   Enter age :<form:input path="age"/><br/>
   Enter Id :<form:input path="location"/><br/>
   <input type="submit">
   
  </form:form>
  Name : ${name}
Age : ${age}
Id : ${location}
  
</body>
</html>