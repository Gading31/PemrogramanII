<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Connection conn =
        Koneksi.getConnection();

Statement stCustomer =
        conn.createStatement();

Statement stMobil =
        conn.createStatement();

ResultSet customer =
        stCustomer.executeQuery(
                "SELECT * FROM customer");

ResultSet mobil =
        stMobil.executeQuery(
                "SELECT * FROM mobil WHERE status='Tersedia'");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Transaksi Sewa</title>
</head>
<body>

<h2>Transaksi Penyewaan Mobil</h2>

<form action="../SewaServlet" method="post">

<table>

<tr>
    <td>Customer</td>
    <td>

        <select name="id_customer">

            <%
            while(customer.next()){
            %>

            <option
                value="<%=customer.getInt("id_customer")%>">

                <%=customer.getString("nama")%>

            </option>

            <%
            }
            %>

        </select>

    </td>
</tr>

<tr>
    <td>Mobil</td>
    <td>

        <select name="id_mobil">

            <%
            while(mobil.next()){
            %>

            <option
                value="<%=mobil.getInt("id_mobil")%>">

                <%=mobil.getString("merk")%>
                -
                <%=mobil.getString("plat_nomor")%>

            </option>

            <%
            }
            %>

        </select>

    </td>
</tr>

<tr>
    <td>Tanggal Sewa</td>
    <td>
        <input type="date"
               name="tgl_sewa"
               required>
    </td>
</tr>

<tr>
    <td>Lama Sewa (Hari)</td>
    <td>
        <input type="number"
               name="lama_sewa"
               required>
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