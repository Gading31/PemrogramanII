<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
int id =
        Integer.parseInt(
                request.getParameter("id"));

Connection conn =
        Koneksi.getConnection();

PreparedStatement ps =
        conn.prepareStatement(
        "SELECT * FROM customer WHERE id_customer=?");

ps.setInt(1, id);

ResultSet rs =
        ps.executeQuery();

rs.next();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>

<h2>Edit Customer</h2>

<form action="../CustomerServlet" method="post">

<input type="hidden"
       name="id_customer"
       value="<%=rs.getInt("id_customer")%>">

<table>

<tr>
    <td>Nama</td>
    <td>
        <input type="text"
               name="nama"
               value="<%=rs.getString("nama")%>">
    </td>
</tr>

<tr>
    <td>Alamat</td>
    <td>
        <textarea name="alamat"><%=rs.getString("alamat")%></textarea>
    </td>
</tr>

<tr>
    <td>Telepon</td>
    <td>
        <input type="text"
               name="telepon"
               value="<%=rs.getString("telepon")%>">
    </td>
</tr>

<tr>
    <td></td>
    <td>
        <button type="submit"
                name="action"
                value="update">
            Update
        </button>
    </td>
</tr>

</table>

</form>

</body>
</html>