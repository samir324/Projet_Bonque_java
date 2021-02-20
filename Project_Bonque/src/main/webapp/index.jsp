<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.example.Project_Bonque.DAO.DAOAcount" %>
<%@ page import="com.example.Project_Bonque.model.Acount" %>
<%@ page import="com.example.Project_Bonque.database.DataBaseConfi" %>
<%@ page import="java.sql.Connection" %>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<div class="container">



    <table class="table table-striped ">
        <thead >
        <tr>
            <th><a href="/Servlet_2">Liste Et Suprimer</a></th>
            <th><a href="insertEntreprise.jsp">Insert Entreprise</a></th>
            <th><a href="insertPerson.jsp">Insert Presone</a></th>
            <th><a href="update.jsp">update</a></th>
            <%--//<th>numero</th>--%>
        </tr>
        </thead>
        <tbody>
        <%

            List<Acount> x= (List<Acount>) request.getAttribute("acount");
        %>
        <c:forEach var="acount" items="${x}">

            <tr>
                <td><c:out value="${x.acount_id}" /></td>
                <a href="delete?id=<c:out value='${x.acount_id}' />">Delete</a>

            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>