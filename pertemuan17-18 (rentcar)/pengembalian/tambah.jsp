<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Connection conn = Koneksi.getConnection();

String sql =
        "SELECT s.id_sewa, "
        + "c.nama, "
        + "m.merk "
        + "FROM sewa s "
        + "JOIN customer c "
        + "ON s.id_customer=c.id_customer "
        + "JOIN mobil m "
        + "ON s.id_mobil=m.id_mobil";

Statement st = conn.createStatement();

ResultSet rs = st.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Pengembalian Mobil</title>
</head>
<body>

<h2>Pengembalian Mobil</h2>

<form action="../PengembalianServlet"
      method="post">

<table>

<tr>
    <td>Transaksi Sewa</td>
    <td>

        <select name="id_sewa">

        <%
        while(rs.next()){
        %>

        <option
            value="<%=rs.getInt("id_sewa")%>">

            <%=rs.getInt("id_sewa")%>
            -
            <%=rs.getString("nama")%>
            -
            <%=rs.getString("merk")%>

        </option>

        <%
        }
        %>

        </select>

    </td>
</tr>

<tr>
    <td>Tanggal Kembali</td>
    <td>
        <input type="date"
               name="tgl_kembali"
               required>
    </td>
</tr>

<tr>
    <td>Denda</td>
    <td>
        <input type="number"
               name="denda"
               value="0">
    </td>
</tr>

<tr>
    <td></td>
    <td>
        <button type="submit">
            Simpan
        </button>
    </td>
</tr>

</table>

</form>

</body>
</html>