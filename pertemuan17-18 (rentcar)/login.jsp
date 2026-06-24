<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <title>Login Rent Car</title>

    <style>

        body{
            font-family: Arial;
            background:#f4f4f4;
        }

        .login-box{
            width:350px;
            margin:100px auto;
            background:white;
            padding:20px;
            border-radius:10px;
            box-shadow:0 0 10px gray;
        }

        h2{
            text-align:center;
        }

        input{
            width:100%;
            padding:10px;
            margin-top:10px;
        }

        button{
            width:100%;
            padding:10px;
            margin-top:15px;
            background:blue;
            color:white;
            border:none;
        }

    </style>

</head>
<body>

<div class="login-box">

    <h2>LOGIN RENT CAR</h2>

    <form action="LoginServlet" method="post">

        <input type="text"
               name="username"
               placeholder="Username"
               required>

        <input type="password"
               name="password"
               placeholder="Password"
               required>

        <button type="submit">
            Login
        </button>

    </form>

</div>

</body>
</html>