<%-- 
    Document   : inputNilai
    Created on : May 31, 2026, 1:42:29 AM
    Author     : dingg
--%>

<%@page contentType="text/html"
        pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Input Nilai</title>
</head>

<body>

<h2>Input Nilai Mahasiswa</h2>

<form action="NilaiController"
      method="post">

<table>

<tr>
<td>NIM</td>
<td>
<input type="text"
       name="nim"
       required>
</td>
</tr>

<tr>
<td>Kode Mata Kuliah</td>
<td>
<input type="text"
       name="kodeMk"
       required>
</td>
</tr>

<tr>
<td>Nilai Tugas</td>
<td>
<input type="number"
       name="tugas"
       required>
</td>
</tr>

<tr>
<td>Nilai UTS</td>
<td>
<input type="number"
       name="uts"
       required>
</td>
</tr>

<tr>
<td>Nilai UAS</td>
<td>
<input type="number"
       name="uas"
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
