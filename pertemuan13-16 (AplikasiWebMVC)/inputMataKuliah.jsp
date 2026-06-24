<%-- 
    Document   : inputMataKuliah.jsp
    Created on : May 31, 2026, 12:42:44 AM
    Author     : dingg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Master Mata Kuliah</title>
</head>
<body>

<h2>Form Master Mata Kuliah</h2>

<form action="MataKuliahController" method="post">

<table>

<tr>
<td>Kode Mata Kuliah</td>
<td>
<input type="text"
       name="kodeMataKuliah"
       required>
</td>
</tr>

<tr>
<td>Nama Mata Kuliah</td>
<td>
<input type="text"
       name="namaMataKuliah"
       required>
</td>
</tr>

<tr>
<td>Jumlah SKS</td>
<td>
<input type="number"
       name="jumlahSks"
       required>
</td>
</tr>

<tr>
<td></td>
<td>
<input type="submit"
       value="Simpan">
</td>
</tr>

</table>

</form>

</body>
</html>
