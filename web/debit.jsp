<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>EAW</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/main.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>


        <!-- =======================================================
        * Template Name: NiceAdmin - v2.5.0
        * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>

    <body>

        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="#" class="logo d-flex align-items-center">
                    <img src="assets/img/logo.png" alt="">
                    <span class="d-none d-lg-block">EAW</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div><!-- End Logo -->

            <div class="search-bar">
                <form class="search-form d-flex align-items-center" method="POST" action="#">
                    <input type="text" name="query" placeholder="Search" title="Enter search keyword">
                    <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                </form>
            </div><!-- End Search Bar -->

            <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">

                    <li class="nav-item d-block d-lg-none">
                        <a class="nav-link nav-icon search-bar-toggle " href="#">
                            <i class="bi bi-search"></i>
                        </a>
                    </li><!-- End Search Icon-->

                    <section class="row flex">

                        <ul class="header__top-list" >             
                            <c:if test="${sessionScope.acc == null}">
                                <li class="header__top-item" style="margin-left: 20px">
                                    <a href="login.jsp" class="header__top-link">Đăng nhập</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc != null}">

                                <li class="nav-item dropdown pe-3">

                                    <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                                        <img alt="Gravatar for minhtnhe161392@fpt.edu.vn" src="//www.gravatar.com/avatar/589e47159568f5492f5dcc2dc79a7fea?d=retro&amp;r=g&amp;s=40" srcset="//www.gravatar.com/avatar/589e47159568f5492f5dcc2dc79a7fea?d=retro&amp;r=g&amp;s=80 2x" height="40" width="40" class="react-gravatar img-avatar">
                                        <span class="d-none d-md-block dropdown-toggle ps-2">${sessionScope.acc.usename}</span>
                                    </a><!-- End Profile Iamge Icon -->

                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                                        <li class="dropdown-header">
                                            <h6>${sessionScope.acc.usename}</h6>

                                        </li>
                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>

                                        <li>
                                            <a class="dropdown-item d-flex align-items-center" href="updateinfom?sid=${sessionScope.acc.getId()}">
                                                <i class="bi bi-person"></i>
                                                <span>My Profile</span>
                                            </a>
                                        </li>
                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>

                                        <li>
                                            <a class="dropdown-item d-flex align-items-center" href="logout">
                                                <i class="bi bi-box-arrow-right"></i>
                                                <span>Sign Out</span>
                                            </a>
                                        </li>
                                    </ul><!-- End Profile Dropdown Items -->
                                </li><!-- End Profile Nav -->
                            </c:if>
                        </ul>
                    </section>

                </ul>
            </nav><!-- End Icons Navigation -->

        </header><!-- End Header -->

        <!-- ======= Sidebar ======= -->
        <aside id="sidebar" class="sidebar">

            <ul class="sidebar-nav" id="sidebar-nav">

                <li class="nav-item">
                    <a class="nav-link " href="home.jsp">
                        <i class="bi bi-house-fill"></i>
                        <span>Trang chủ</span>
                    </a>
                </li><!-- End Dashboard Nav -->

                <li class="nav-item">
                    <a class="nav-link " href="home?aid=${sessionScope.acc.getId()}&index=${1}">
                        <i class="bi bi-menu-button-wide"></i>
                        <span>Sổ ghi nợ</span>
                    </a>
                </li><!-- End Dashboard Nav -->
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#components-nav1" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-cash"></i><span>Quản lý thanh toán</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="components-nav1" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="card.jsp">
                                <i class="bi bi-circle"></i><span>Nạp tiền</span>
                            </a>
                        </li>
                        <li>
                            <a href="components-accordion.html">
                                <i class="bi bi-circle"></i><span>Lịch sử giao dịch</span>
                            </a>
                        </li>

                    </ul>
                </li><!-- End Components Nav -->
                <li class="nav-heading">Pages</li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="updateinfom?sid=${sessionScope.acc.getId()}">
                        <i class="bi bi-person"></i>
                        <span>Profile</span>
                    </a>
                </li><!-- End Profile Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#">
                        <i class="bi bi-question-circle"></i>
                        <span>F.A.Q</span>
                    </a>
                </li><!-- End F.A.Q Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#">
                        <i class="bi bi-envelope"></i>
                        <span>Contact</span>
                    </a>
                </li><!-- End Contact Page Nav -->

            </ul>

        </aside><!-- End Sidebarr-->

        <main id="main" class="main">
            <div class="mt-4 container-fluid">
                <c:if test="${sessionScope.acc == null}">
                    <div class="pagetitle">
                        <h3>
                            Chào mừng bạn đến với
                            <i>EAW</i>
                        </h3>
                    </div>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <section class="section">
                        <div class="row">
                            <div class="">

                                <div class="card">

                                    <div class="card-header bg-light">
                                        <div class="row">
                                            <div class="col-md-10">

                                                <h4><b>Danh sách người nợ</b></h4>
                                            </div>
                                            <div class="col-md-2 ">

                                                <button type="button" class=" btn btn-success" data-bs-toggle="modal" data-bs-target="#addpeople"><i class="bi bi-plus-circle"></i> Thêm người nợ</button>
                                            </div>

                                        </div>
                                    </div>


                                    <div class="card-body">

                                        <form action="">
                                            <div id="table" class="mt-3" style="text-align: center;">

                                                <table class="table table-striped  ">

                                                    <thead class="">

                                                        <tr>

                                                            <th scope="col">ID</th>

                                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Tên</th>
                                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Địa chỉ</th>
                                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">SĐT</th>
                                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Email</th>
                                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Tổng nợ</th>
                                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Ngày tạo</th>
                                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Cập nhật</th>
                                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Action</th>
                                                        </tr>
                                                        <tr style="text-align: center;" >
                                                            <td>
                                                                <label>
                                                                    <input type="text" class="form-control" placeholder="From"/>
                                                                </label>
                                                                <label style="margin-top: 5px">
                                                                    <input type="text" class="form-control" placeholder="To"/>
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <label><input type="text" class="form-control"/></label>
                                                                <label></label>

                                                            </td>
                                                            <td>
                                                                <label><input type="text" class="form-control"/></label>
                                                                <label></label>

                                                            </td>
                                                            <td>
                                                                <label><input type="text" class="form-control"/></label>
                                                                <label></label>

                                                            </td>
                                                            <td>
                                                                <label><input type="text" class="form-control"/></label>
                                                                <label></label>

                                                            </td>
                                                            <td>
                                                                <label>
                                                                    <input type="text" class="form-control" placeholder="From"/>
                                                                </label>
                                                                <label style="margin-top: 5px">
                                                                    <input type="text" class="form-control" placeholder="To"/>
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <label>
                                                                    <input type="datetime-local" placeholder="From" class="form-control"
                                                                           value="">
                                                                </label>
                                                                <label style="margin-top: 5px">
                                                                    <input type="datetime-local" placeholder="To" class="form-control" value="">
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <label>
                                                                    <input type="datetime-local" class="form-control" placeholder="From"/>
                                                                </label>
                                                                <label style="margin-top: 5px">
                                                                    <input type="datetime-local" class="form-control" placeholder="To"/>
                                                                </label>
                                                            </td>
                                                            <td>

                                                                <div>
                                                                    <input type="button" class="form-control btn btn-outline-danger btn-block" value="Clear filter" onclick="clearInputs()"/>
                                                                </div>
                                                                <div style="padding-top:  5px">
                                                                    <input type="button" class="form-control btn btn-outline-primary btn-block" value=" Hide>>" onclick="hide()"/>
                                                                </div>
                                                            </td>
                                                        </tr>

                                                    </thead>

                                                    <tbody>           

                                                        <c:forEach items="${requestScope.listPA}" var="o"> 
                                                            <tr>
                                                                <td class="${o.total lt 0 ? 'text-danger' : ''} debit-id" scope="row" style="flex: 100 0 auto; width: 200px;">${o.id}</td>

                                                                <td class="${o.total lt 0 ? 'text-danger' : ''} debit-name" style="flex: 100 0 auto; width: 200px;">${o.name}</td>

                                                                <td class="${o.total lt 0 ? 'text-danger' : ''} debit-address" style="flex: 100 0 auto; width: 200px;">${o.address} </td>

                                                                <td class="${o.total lt 0 ? 'text-danger' : ''} debit-phone" style="flex: 100 0 auto; width: 200px;">${o.phone}</td>
                                                                <td class="${o.total lt 0 ? 'text-danger' : ''} debit-email" style="flex: 100 0 auto; width: 200px;" >${o.email}</td>
                                                                <td class="${o.total lt 0 ? 'text-danger' : ''} debit-total" style="flex: 100 0 auto; width: 200px;"><fmt:formatNumber value="${o.total}" pattern="#,##0.##"/> </td>
                                                                <td class="${o.total lt 0 ? 'text-danger' : ''}" style="flex: 100 0 auto; width: 200px;">${o.crday}</td>
                                                                <td class="${o.total lt 0 ? 'text-danger' : ''}" style="flex: 100 0 auto; width: 200px;">${o.uday}</td>

                                                                <td  style="flex: 100 0 auto; width: 200px;" id="myTd">
                                                                    <div class="myDiv" style="right: 0px; flex: 332 0 auto; width: 270px; max-width: 270px;">
                                                                        <button class="btn btn-primary" type="button"  title="Chi tiết" data-bs-toggle="modal" data-bs-target="#detail" onclick='detailDebit("${o.email}")'><i class="bi bi-info-circle-fill"> Chi tiết</i></button>
                                                                        <button class="btn btn-success" type="button" title="Thêm phiếu nợ" data-bs-toggle="modal" data-bs-target="#adddept"><i class="bi bi-plus-circle" onclick="getId('${o.id}', '${o.name}', '${o.total}')"> Thêm </i></button>
                                                                        <button class="btn btn-warning" type="button" title="Sửa" data-bs-toggle="modal" data-bs-target="#updatepeople" onclick="clickOpenUpdateDebitModal(this)"><i class="bi bi-pen-fill">Sửa</i></button>
                                                                    </div>
                                                                    <div class="otherDiv"  style="display:none; right: 0px; flex: 135 0 auto; width: 135px; max-width: 135px;">
                                                                        <button class="btn btn-primary" type="button"  title="Chi tiết" data-bs-toggle="modal" data-bs-target="#detail" onclick='detailDebit("${o.email}")'><i class="bi bi-info-circle-fill"></i></button>
                                                                        <button class="btn btn-success" type="button" title="Thêm phiếu nợ" data-bs-toggle="modal" data-bs-target="#adddept" ><i class="bi bi-plus-circle" onclick="getId('${o.id}', '${o.name}', '${o.total}')"></i></button>
                                                                        <button class="btn btn-warning" type="button" title="Sửa" data-bs-toggle="modal" data-bs-target="#updatepeople" onclick="clickOpenUpdateDebitModal(this)"><i class="bi bi-pen-fill"></i></button>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>




                                                    </tbody>




                                                </table>



                                            </div>
                                            <c:forEach begin="1" end="${endP}" var="i">
                                                <ul class="pagination">
                                                    <li class="page-item ${tag == i ? "active":""}">
                                                        <a href="home?aid=${sessionScope.acc.getId()}&index=${i}" class="page-link">${i}</a>
                                                    </li>
                                                </ul>
                                            </c:forEach>



                                        </form>




                                    </div>

                                </div>

                            </div>
                        </div>
                    </section>
                </c:if>
            </div>

        </main>
        <!-- ======= Modal ======= -->
        <div class="modal modal-lg" id="addpeople" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-light">
                        <h5 class="modal-title "><b>Thêm người nợ</b></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="" method="post">
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>Họ và tên(*): </b> </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control col-md-9" id="txtname" name="name" required="">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>Địa chỉ:</b></label>
                                <div class="col-sm-10">
                                    <textarea rows="8" placeholder="" class="form-control" name="address"></textarea>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>SĐT:</b></label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control col-md-9" id="txtsdt" name="phone">

                                </div>
                            </div>
                            <div class="form-group row">
                                <label  class="col-md-2 col-form-label"><b>Email</b></label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="txtemail" name="email">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>Tổng nợ</b></label>
                                <div class="col-sm-10">
                                    <input style="background-color: #e9ecef;        " type="number" class="form-control col-md-9" id="txtsum" name="total" value="0" readonly="">
                                </div>
                            </div>
                            <div style="display: flex; justify-content: center; align-items: center;">
                                <button type="submit" class="mr-1 btn btn-success" onclick="getal()"><i class="bi bi-plus-circle"></i> Thêm </button></div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

                    </div>
                </div>
            </div>
        </div><!-- End add-->


        <div class="modal modal-lg" id="adddept" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-light">
                        <h5 class="modal-title " id="deptName"><b>Thêm người nợ</b></h5>

                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
                        <form action="adddept" method="post">
                            <div class="form-group row">

                                <input type="hidden" class="form-control " name="id2" value="${sessionScope.acc.getId()}"  >

                            </div>
                            <div class="form-group row">

                                <input type="hidden" class="form-control" name="index" value="${endP}">

                            </div>

                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>Ghi chú:</b></label>
                                <div class="col-sm-10">
                                    <textarea rows="8" name="note" placeholder="" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="position-relative row form-group">
                                <div class="form-label-horizontal col-md-2">
                                    <label class=""><b>Loại nợ (*)</b></label>
                                </div>
                                <div class="col-md-10">

                                    <input hidden="true" name="idConNo" id="idConNo"/>
                                    <input hidden="true" name="abtract2"  value="false"  type="text" id="abtract2"  >
                                    <input hidden="true" name="plus2" value="true" type="text" id="plus2" >
                                    <button name="abtract"   type="button" id="abtract" class="btn btn-secondary btn-block " onclick="selectOptionAbtract()" style="width: 50%; ">-</button>
                                    <button name="plus" value="true" type="button" id="plus" class="btn btn-primary btn-block" onclick="selectOptionPlus()" style="width: 49%;">+</button>
                                </div>

                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>Số tiền(*):</b></label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control " id="inputNumber" name="money" oninput="showValue()" >
                                    <p id="displayNumber">không</p>
                                </div>

                            </div>
                            <div class="form-group row">
                                <label  class="col-md-2 col-form-label"><b>Ngày lập phiếu</b></label>
                                <div class="col-sm-10">
                                    <input type="datetime-local" name="updateday" value="date" class="form-control" id="txtdate" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>Hình ảnh chứng minh: </b></label>
                                <div class="col-sm-10">
                                    Select images: <input type="file" name="img" multiple>
                                    <input type="submit">
                                </div>
                            </div>
                            <div style="display: flex; justify-content: center; align-items: center;">
                                <button type="submit" class="mr-1 btn btn-success" onclick="getconfirm()"><i class="bi bi-plus-circle"></i> Thêm </button>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

                    </div>
                </div>
            </div>
        </div><!-- End adddept-->

        <div class="modal modal-xl" id="detail" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-light">
                        <h5 class="modal-title "><b>Tên</b></h5>
                        <div class="myDiv  ">

                            <button type="button" class=" btn btn-success" data-bs-toggle="modal" data-bs-target="#adddept"><i class="bi bi-plus-circle" ></i> Tạo phiếu</button>
                        </div>
                        <div class="otherDiv  " style="display: none; ">

                            <button type="button" class=" btn btn-success" data-bs-toggle="modal" data-bs-target="#adddept"><i class="bi bi-plus-circle"></i></button>
                        </div>
                    </div>
                    <div class="modal-body">
                        <form action="">
                            <div id="table" class="mt-3" style="text-align: center;">

                                <table class="table">

                                    <thead class="thead-dark">

                                        <tr>

                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">ID</th>

                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Ghi chú</th>

                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Loại nợ</th>
                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Số tiền</th>

                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Ngày tạo</th>
                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Cập nhật</th>
                                            <th style="flex: 100 0 auto; width: 200px;" scope="col">Action</th>
                                        </tr>
                                        <tr style="text-align: center;" >
                                            <td>
                                                <label>
                                                    <input type="number" class="form-control"/>
                                                </label>
                                                <label > </label>
                                            </td>
                                            <td>
                                                <label><input type="text" class="form-control"/></label>
                                                <label></label>

                                            </td>
                                            <td>
                                                <label><select style="flex: 100 0 auto; width: 100px; margin-bottom: 25px; padding:6px 12px; border: 1px solid #ced4da;">
                                                        <option value="All">All</option>
                                                        <option value="+">+</option>
                                                        <option value="-">-</option>
                                                    </select></label>
                                                <label></label>

                                            </td>
                                            <td style="flex: 100 0 auto; width: 200px;">
                                                <label>
                                                    <input type="text" class="form-control" placeholder="From"/>
                                                </label>
                                                <label style="margin-top: 5px">
                                                    <input type="text" class="form-control" placeholder="To"/>
                                                </label>
                                            </td>
                                            <td style="flex: 100 0 auto; width: 200px;">
                                                <label>
                                                    <input type="datetime-local" placeholder="From" class="form-control"
                                                           value="">
                                                </label>
                                                <label style="margin-top: 5px">
                                                    <input type="datetime-local" placeholder="To" class="form-control" value="">
                                                </label>
                                            </td>
                                            <td style="flex: 100 0 auto; width: 200px;">
                                                <label>
                                                    <input type="datetime-local" class="form-control" placeholder="From"/>
                                                </label>
                                                <label style="margin-top: 5px">
                                                    <input type="datetime-local" class="form-control" placeholder="To"/>
                                                </label>
                                            </td>
                                            <td>

                                                <div>
                                                    <input type="button" class="form-control btn btn-outline-danger btn-block" value="Clear filter" onclick="clearInputs()"/>
                                                </div>
                                                <div style="padding-top:  5px">
                                                    <input type="button" class="form-control btn btn-outline-primary btn-block" value=" Hide>>" onclick="hide()"/>
                                                </div>
                                            </td>
                                        </tr>

                                    </thead>

                                    <tbody id="fillData">           



                                    </tbody>

                                </table>

                            </div>
                            </tr>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

                    </div>
                </div>
            </div>
        </div><!-- End detail-->

        <div class="modal modal-lg" id="updatepeople" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-light">
                        <h5 class="modal-title "><b>Thêm người nợ</b></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="debit" method="post">
                            <input type="hidden" name="id" class="debit-update-id"/>
                            <input type="hidden" name="curPage" class="debit-update-curPage"/>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>Họ và tên(*): </b> </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control col-md-9 debit-update-name" id="txtname" name="name">
                                </div>
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>Địa chỉ:</b></label>
                                <div class="col-sm-10">
                                    <textarea rows="8" placeholder="" class="form-control debit-update-address" name="address"></textarea>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>SĐT:</b></label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control col-md-9 debit-update-phone" id="txtsdt" name="phone">

                                </div>
                            </div>
                            <div class="form-group row">
                                <label  class="col-md-2 col-form-label"><b>Email</b></label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control debit-update-email" id="txtemail" name="email">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-label"><b>Tổng nợ</b></label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control col-md-9 debit-update-total" id="txtsum" disabled="" value="0" >
                                </div>
                            </div>
                            <div style="display: flex; justify-content: center; align-items: center;">
                                <button type="submit" class="mr-1 btn btn-success" onclick="getal()" ><i class="bi bi-upload"></i> Cập nhật</button></div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

                    </div>
                </div>
            </div>
        </div><!-- End update-->



        <!--Date time picker-->
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
        <script>
                                    config = {
                                        enableTime: true,
                                        dateFormat: "Y-m-d H:i",
                                    }
                                    flatpickr("input[type=datetime-local]", config);
        </script>
        <script>
            function hide() {
                var divs = document.querySelectorAll(".myDiv");
                var otherDivs = document.querySelectorAll(".otherDiv");
                var button = document.getElementsByTagName("input")[14];
                var td = document.getElementById("myTd");

                for (var i = 0; i < divs.length;
                        i++
                        ) {
                    if (divs[i].style.display !== "none") {
                        divs[i].style.display = "none";
                        otherDivs[i].style.display = "block";
                        button.value = "<<Show";

                        td.className = "col-sm-2";

                    } else {
                        divs[i].style.display = "block";
                        otherDivs[i].style.display = "none";
                        button.value = " Hide>>";


                        td.className = "col-md-3";
                    }
                }
            }

            function getconfirm() {
                if (confirm("Bạn có chắc chắn muốn tạo phiếu nợ này?")) {
                    // Submit the form
                    document.getElementById("adddept").submit();
                    // Show a success alert
                    alert("Tạo phiếu nợ thành công!");
                    // Redirect to the home page

                } else {
                    // Do nothing
                }
            }

            var getal = function () {
                alert("Success");
            }

            function getId(id, name, money) {

                document.getElementById("idConNo").value = id;
                document.getElementById("deptName").innerHTML = "Tên người nợ: " + name + "- Số tiền nợ: " + money + " VND";


            }

            function clearInputs() {
                const inputs = document.querySelectorAll('tr input');
                for (let i = 0; i < inputs.length; i++) {
                    if (inputs[i].value !== 'Clear filter' && inputs[i].value !== ' Hide>>' && inputs[i].value !== '<<Show') {
                        inputs[i].value = '';
                    }
                }
            }
            function showValue() {
                // Lấy giá trị từ input
                let inputNumber = document.getElementById("inputNumber").value;
                let input = document.getElementById("inputNumber");
                var number = parseFloat(input.value.replace(/\D/g, ''));
                if (isNaN(number) || number === "") {
                    number = 0;
                }
                input.value = number.toLocaleString('en-US');

                // Chuyển đổi số thành chữ bằng hàm số sang chữ
                let text = convertNumberToVietnameseWords(number);

                // Hiển thị giá trị trong thẻ div
                let display = document.getElementById("displayNumber");
                display.textContent = text + " đồng";
            }


            function convertNumberToVietnameseWords(number) {
                const ones = ['', 'một', 'hai', 'ba', 'bốn', 'năm', 'sáu', 'bảy', 'tám', 'chín'];
                const tens = ['', 'mười', 'hai mươi', 'ba mươi', 'bốn mươi', 'năm mươi', 'sáu mươi', 'bảy mươi', 'tám mươi', 'chín mươi'];

                if (number === 0) {
                    return 'không';
                }

                if (number < 0) {
                    return 'âm ' + convertNumberToVietnameseWords(Math.abs(number));
                }

                let words = '';

                if (number < 10) {
                    words += ones[number];
                } else if (number < 20) {
                    words += 'mười ' + ones[number % 10];
                } else if (number < 100) {
                    words += tens[Math.floor(number / 10)];
                    if (number % 10 !== 0) {
                        words += ' ' + ones[number % 10];
                    }
                } else if (number < 1000) {
                    words += ones[Math.floor(number / 100)] + ' trăm';
                    if (number % 100 !== 0) {
                        words += ' ' + convertNumberToVietnameseWords(number % 100);
                    }
                } else if (number < 1000000) {
                    words += convertNumberToVietnameseWords(Math.floor(number / 1000)) + ' nghìn';
                    if (number % 1000 !== 0) {
                        words += ' ' + convertNumberToVietnameseWords(number % 1000);
                    }
                } else if (number < 1000000000) {
                    words += convertNumberToVietnameseWords(Math.floor(number / 1000000)) + ' triệu';
                    if (number % 1000000 !== 0) {
                        words += ' ' + convertNumberToVietnameseWords(number % 1000000);
                    }

                } else {
                    words += convertNumberToVietnameseWords(Math.floor(number / 1000000000)) + ' tỷ';
                    if (number % 1000000 !== 0) {
                        words += ' ' + convertNumberToVietnameseWords(number % 1000000000);
                    }
                }

                return words.trim();
            }

            function detailDebit(i) {
                $.ajax({
                    url: "detailDebitServlet",
                    type: 'POST',
                    data: {
                        email: i
                    },
                    success: function (data, textStatus, jqXHR) {
                        $('#fillData').html(data);
                    }
                })
            }
            function clickOpenUpdateDebitModal(event) {
                let id = event.closest('tr').querySelector('.debit-id').innerHTML
                let curPage = document.querySelector('.pagination .active a').innerHTML
                let name = event.closest('tr').querySelector('.debit-name').innerHTML
                let address = event.closest('tr').querySelector('.debit-address').innerHTML
                let phone = event.closest('tr').querySelector('.debit-phone').innerHTML
                let email = event.closest('tr').querySelector('.debit-email').innerHTML
                let total = event.closest('tr').querySelector('.debit-total').innerHTML
                let totalX =  +(total.includes('.') ? total.split('.').join('') : total.split(',').join(''))
                

                let updateDebitModal = document.getElementById('updatepeople')
                updateDebitModal.querySelector('.debit-update-id').value = id
                updateDebitModal.querySelector('.debit-update-curPage').value = curPage
                updateDebitModal.querySelector('.debit-update-name').value = name
                updateDebitModal.querySelector('.debit-update-address').value = address
                updateDebitModal.querySelector('.debit-update-phone').value = phone
                updateDebitModal.querySelector('.debit-update-email').value = email
                updateDebitModal.querySelector('.debit-update-total').value = totalX
                
                

            }

        </script>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.umd.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
        <script src="assets/js/debit.js"></script>



    </body>

</html>