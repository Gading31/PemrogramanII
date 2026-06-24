<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Connection conn =
        Koneksi.getConnection();

String sql =
        "SELECT s.*, "
        + "c.nama, "
        + "m.merk "
        + "FROM sewa s "
        + "JOIN customer c "
        + "ON s.id_customer=c.id_customer "
        + "JOIN mobil m "
        + "ON s.id_mobil=m.id_mobil";

Statement st =
        conn.createStatement();

ResultSet rs =
        st.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Data Sewa</title>
</head>
<body>

<h2>Data Penyewaan</h2>

<a href="tambah.jsp">
    Tambah Sewa
</a>

<br><br>

<table border="1" cellpadding="10">

<tr>

    <th>ID</th>
    <th>Customer</th>
    <th>Mobil</th>
    <th>Tanggal</th>
    <th>Lama</th>
    <th>Total</th>

</tr>

<%
while(rs.next()){
%>

<tr>

<td><%=rs.getInt("id_sewa")%></td>

<td><%=rs.getString("nama")%></td>

<td><%=rs.getString("merk")%></td>

<td><%=rs.getDate("tgl_sewa")%></td>

<td><%=rs.getInt("lama_sewa")%></td>

<td><%=rs.getDouble("total")%></td>

</tr>

<%
}
%>

</table>

</body>
</html>