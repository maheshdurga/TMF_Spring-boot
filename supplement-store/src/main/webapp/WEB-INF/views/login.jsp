<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
  <link rel="stylesheet" href="style.css">
  <link href="/css/loginstyle.css" rel="stylesheet">
</head>
<body>
  <div class="background">
    <div class="login-box">
      <h2>Login</h2>
      <form method="post" action="/auth/login">
        <div class="input-group">
         <label for="lastname">Email</label>
         <input type="email" id="email" name="email" required="required" value="user2@example.com" />
          <i class="fas fa-user"></i>
        </div>
        <div class="input-group">
         <label for="lastname">Password</label>
          <input type="password" id="password" name="password" value="password2" required="required"/>
          <i class="fas fa-lock"></i>
        </div>
        <div class="options">
          <label><input type="checkbox"> Remember me</label>
          <a href="#">Forgot password?</a>
        </div>
        <button type="submit">Login</button>
        <p class="register-text">Don't have an account? <a href="#">Register</a></p>
      </form>
    </div>
  </div>
</body>
</html>
