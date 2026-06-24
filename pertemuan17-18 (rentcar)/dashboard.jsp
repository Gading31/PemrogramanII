<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <title>Dashboard Rent Car</title>

    <style>

        body{ font-family: Arial, sans-serif; 
              margin: 0; 
              background-color: #f4f4f4; }

        .header{
            background:#1f2937;
            color:white;
            padding:15px;
        }
        
        .header h2{ 
            margin: 0; }

        .sidebar{
            width:220px;
            height:100vh;
            background:#374151;
            float:left;
        }
        
        .sidebar h3{ 
            color: white; 
            padding-left: 15px; 
            margin-top: 20px; }

        .sidebar a{
            display:block;
            color:white;
            text-decoration:none;
            padding:12px 15px;
        }

        .sidebar a:hover{
            background:#4b5563;
        }

        .content{
            margin-left:220px;
            padding:20px;
        }
        
        .card{ background-color: white; 
              padding: 20px; 
              border-radius: 5px; 
              box-shadow: 0px 0px 5px rgba(0,0,0,0.2); }

    </style>

</head>
<body>

<div class="header"> <h2>APLIKASI RENT CAR</h2> </div> <div class="sidebar"> <h3>Master Data</h3> <a href="mobil/data.jsp">Data Mobil</a> <a href="customer/data.jsp">Data Customer</a> <h3>Transaksi</h3> <a href="sewa/data.jsp">Data Sewa</a> <a href="pengembalian/data.jsp">Data Pengembalian</a> <h3>Laporan</h3> <a href="laporan/mobil.jsp">Laporan Mobil</a> <a href="laporan/customer.jsp">Laporan Customer</a> <a href="laporan/sewa.jsp">Laporan Sewa</a> <a href="laporan/pengembalian.jsp">Laporan Pengembalian</a> </div> <div class="content"> <div class="card"> <h2>Dashboard</h2> <p> Selamat Datang di Sistem Informasi Penyewaan Mobil (Rent Car). </p> <p> Gunakan menu di sebelah kiri untuk mengelola data Mobil, Customer, Penyewaan, Pengembalian, dan Laporan. </p> </div> </div>

</body>
</html>