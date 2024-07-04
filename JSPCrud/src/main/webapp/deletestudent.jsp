<jsp:useBean class="model.Student" id="e" />

<%@page import="dao.StudentDao"%>

<jsp:setProperty name="e" property="*" />


<%
StudentDao.deleteStudent(e);

response.sendRedirect("viewallstudent.jsp");
%>