<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Sheffield Cloud Registration</title>
  <!-- Bootstrap core CSS-->
  <link href="css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="css/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form action="Register" method="post">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="firstname">First name</label>
                <input class="form-control" id="firstname" name="firstname" type="text" aria-describedby="nameHelp" placeholder="Enter first name" required>
              </div>
              <div class="col-md-6">
                <label for="LastName">Last name</label>
                <input class="form-control" id="LastName" name="lastname" type="text" aria-describedby="nameHelp" placeholder="Enter last name" required>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="Email1">Email address</label>
            <input class="form-control" id="Email1" name="email"type="email" aria-describedby="emailHelp" placeholder="Enter email" required>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="Password1">Password</label>
                <input class="form-control" id="Password1" name="password" type="password" placeholder="Password" required>
              </div>
              <div class="col-md-6">
                <label for="ConfirmPassword">Confirm password</label>
                <input class="form-control" id="ConfirmPassword"  type="password" placeholder="Confirm password" required>
              </div>
            </div>
          </div>
          <button class="btn btn-primary btn-block"> Register</button> 
        </form>
        <div class="text-center">
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="css/vendor/jquery/jquery.min.js"></script>
  <script src="css/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="css/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>