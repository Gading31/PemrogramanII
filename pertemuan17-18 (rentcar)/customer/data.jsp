<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Connection conn =
        Koneksi.getConnection();

Statement st =
        conn.createStatement();

ResultSet rs =
        st.executeQuery(
                "SELECT * FROM customer");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Data Customer</title>
</head>
<body>

<h2>Data Customer</h2>

<a href="tambah.jsp">
    Tambah Customer
</a>

<br><br>

<table border="1" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Nama</th>
    <th>Alamat</th>
    <th>Telepon</th>
    <th>Aksi</th>
</tr>

<%
while(rs.next()){
%>

<tr>

    <td>
        <%=rs.getInt("id_customer")%>
    </td>

    <td>
        <%=rs.getString("nama")%>
    </td>

    <td>
        <%=rs.getString("alamat")%>
    </td>

    <td>
        <%=rs.getString("telepon")%>
    </td>
    
    <td>

    <a href="edit.jsp?id=<%=rs.getInt("id_customer")%>">
        Edit
    </a>

    |

    <a href="../CustomerServlet?action=hapus&id=<%=rs.getInt("id_customer")%>"
       onclick="return confirm('Yakin hapus?')">
        Hapus
    </a>

</td>

</tr>

<%
}
%>

</table>

</body>
</html>