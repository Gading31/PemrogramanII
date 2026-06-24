<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>

<%
Connection conn = Koneksi.getConnection();

Statement st =
        conn.createStatement();

ResultSet rs =
        st.executeQuery(
                "SELECT * FROM customer");
%>

<!DOCTYPE html>
<html>
<head>
<title>Laporan Customer</title>
</head>
<body>

<h2 align="center">
LAPORAN DATA CUSTOMER
</h2>

<table border="1"
       width="100%"
       cellpadding="5">

<tr>
<th>ID</th>
<th>Nama</th>
<th>Alamat</th>
<th>Telepon</th>
</tr>

<%
while(rs.next()){
%>

<tr>
<td><%=rs.getInt("id_customer")%></td>
<td><%=rs.getString("nama")%></td>
<td><%=rs.getString("alamat")%></td>
<td><%=rs.getString("telepon")%></td>
</tr>

<%
}
%>

</table>

</body>
</html>