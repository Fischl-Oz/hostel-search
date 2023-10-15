<%-- 
    Document   : login
    Created on : Jun 22, 2023, 3:09:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/css/style1.css" rel="stylesheet">
    </head>
    <body>
        <section class="vh-100" style="color: #d39e00;" >
            <div class="container py-5 h-100 ">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card shadow-2-strong" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">
                                <h3 style="color: yellow" class="mb-5">Ðăng nhập</h3>
                                <h6 style="color: red">Tên tài khoản hoặc mật khẩu không chính xác.</h6>
                                <form method="" action="">
                                    <div class="form-outline mb-4">
                                        <input type="text" id="typeEmailX-2" class="form-control form-control-lg" name="ustxt" placeholder="Tên tài khoản"/>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" id="typePasswordX-2" class="form-control form-control-lg" name="pwdtxt" placeholder="Mật khẩu" />

                                    </div>

                                    <!-- Checkbox -->
                                    <div class="row mb-4">
                                        <div class="col d-flex justify-content-center">
                                            <!-- Checkbox -->
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="form2Example31" name="remember" checked />
                                                <label class="form-check-label" for="form2Example31"> Ghi nhớ đăng nhập </label>
                                            </div>
                                        </div>

                                        <div class="col">
                                            <!-- Simple link -->
                                            <a href="">Quên tài khoản?</a>
                                            <br/>
                                            <a style="margin-right: 13px;" href="">Tạo tài khoản.</a>
                                        </div>
                                    </div>


                                    <button class="btn btn-primary btn-lg btn-block" type="submit" value="Submit" name="signinSubmit">Ðăng nhập</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
