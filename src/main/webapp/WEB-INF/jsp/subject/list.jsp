<%@page isELIgnored="false" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!-- saved from url=(0030)http://ace.jeka.by/tables.html -->
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title>货物信息</title>

    <meta name="description" content="Static &amp; Dynamic Tables">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css">

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.com.css">

    <!-- ace styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" class="ace-main-stylesheet"
          id="main-ace-style">

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/css/ace-part2.min.css"
          class="ace-main-stylesheet"/>
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css">

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/js/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script async="" src="${pageContext.request.contextPath}/assets/js/analytics.js"></script>
    <script type="text/javascript" async="" src="${pageContext.request.contextPath}/assets/js/watch.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>
    <style>@keyframes nodeInserted {
               from {
                   outline-color: #fff
               }
               to {
                   outline-color: #000
               }
           }

    @-moz-keyframes nodeInserted {
        from {
            outline-color: #fff
        }
        to {
            outline-color: #000
        }
    }

    @-webkit-keyframes nodeInserted {
        from {
            outline-color: #fff
        }
        to {
            outline-color: #000
        }
    }

    @-ms-keyframes nodeInserted {
        from {
            outline-color: #fff
        }
        to {
            outline-color: #000
        }
    }

    @-o-keyframes nodeInserted {
        from {
            outline-color: #fff
        }
        to {
            outline-color: #000
        }
    }

    .ace-save-state {
        animation-duration: 10ms;
        -o-animation-duration: 10ms;
        -ms-animation-duration: 10ms;
        -moz-animation-duration: 10ms;
        -webkit-animation-duration: 10ms;
        animation-delay: 0s;
        -o-animation-delay: 0s;
        -ms-animation-delay: 0s;
        -moz-animation-delay: 0s;
        -webkit-animation-delay: 0s;
        animation-name: nodeInserted;
        -o-animation-name: nodeInserted;
        -ms-animation-name: nodeInserted;
        -moz-animation-name: nodeInserted;
        -webkit-animation-name: nodeInserted
    }</style>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
    <![endif]-->

    <script>

        function doPost(url, args) {
            var form = $("<form method='post'></form>"),
                input;
            form.attr({"action": url});
            $.each(args, function (key, value) {
                input = $("<input type='hidden'>");
                input.attr({"name": key});
                input.val(value);
                form.append(input);
            });
            $(document.body).append(form);
            form.submit();
        }

        function onUpdateClick(gradeId) {
            doPost(
                '${pageContext.request.contextPath}/subject/toUpdate.do',
                {
                    "id": gradeId
                }
            );
        }


        var deleteId;

        function onDeleteClick(id) {
            deleteId = id;
        }

        function onSureDeleteClick() {
            doPost(
                '${pageContext.request.contextPath}/subject/delete.do',
                {
                    "id": deleteId
                }
            );
        }

        // function onPageClick(index) {
        //     var pageSize = $('#simple-table-select_length').val();
        //     var dataObj = {
        //         pageIndex:index,
        //         pageSize:pageSize
        //     };
        //     listData(dataObj);
        // }


        // function onPageSizeChange(){
        //     var pageSize = $('#simple-table-select_length').val();
        //     var dataObj = {
        //         pageSize:pageSize
        //     };
        //     listData(dataObj);
        // }

        <%--function listData(dataObj){--%>
            <%--$.ajax({--%>
                <%--type: 'post',--%>
                <%--dataType:'json',--%>
                <%--url: '${pageContext.request.contextPath}/subject/listData.do',--%>
                <%--data:dataObj--%>
            <%--}).done(function (data) {--%>
                <%--console.log(data);--%>
                <%--addTr(data);--%>
            <%--})--%>
        <%--}--%>

        <%--function addTr(data){--%>
            <%--var trHtml = '';--%>
            <%--for(var index = 0; index<data.subjectVoList.length;index++){--%>
                <%--trHtml += "<tr>";--%>
                <%--trHtml += '<td>'+(index+1)+'</td>';--%>
                <%--trHtml += '<td>'+data.subjectVoList[index].name+'</td>';--%>
                <%--trHtml += '<td>'+data.subjectVoList[index].price+'</td>';--%>
                <%--trHtml += '<td>'+data.subjectVoList[index].count+'</td>';--%>
                <%--trHtml += '<td class="center">';--%>
                <%--trHtml += '<div class="action-buttons">';--%>
                <%--trHtml += '<a href="#" class="green bigger-140 show-details-btn" title="Show Details">';--%>
                <%--trHtml += '<i class="ace-icon fa fa-angle-double-down"></i>';--%>
                <%--trHtml += '<span class="sr-only">Details</span>';--%>
                <%--trHtml += '</a>';--%>
                <%--trHtml += '</div>';--%>
                <%--trHtml += '</td>';--%>
                <%--trHtml += '<td>'+data.subjectVoList[index].totalScore+'</td>';--%>
                <%--trHtml += '<td>'+data.subjectVoList[index].stock+'</td>';--%>
                <%--trHtml += '<td>';--%>
                <%--trHtml += '<div class="hidden-sm hidden-xs action-buttons">';--%>
                <%--trHtml += '<a class="green" href="javascript:void(0);" onclick="onUpdateClick(';--%>
                <%--trHtml += data.subjectVoList[index].id;--%>
                <%--trHtml += ')"> <i class="ace-icon fa fa-pencil bigger-130"></i> </a>';--%>
                <%--trHtml += '<a class="red" href="#modal-message" role="button" onclick="onDeleteClick(';--%>
                <%--trHtml += data.subjectVoList[index].id;--%>
                <%--trHtml += ')" data-toggle="modal"><i class="ace-icon fa fa-trash-o bigger-130"></i> </a></div>';--%>
                <%--trHtml += '<div class="hidden-md hidden-lg">';--%>
                <%--trHtml += '<div class="inline pos-rel">';--%>
                <%--trHtml += '<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">';--%>
                <%--trHtml += '<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i> </button>';--%>
                <%--trHtml += '<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">';--%>
                <%--trHtml += '<li><a href="javascript:void(0);"  onclick="onUpdateClick(';--%>
                <%--trHtml += data.subjectVoList[index].id;--%>
                <%--trHtml += ')" class="tooltip-success" data-rel="tooltip" title="" data-original-title="修改">';--%>
                <%--trHtml += '<span class="green"> <i class="ace-icon fa fa-pencil-square-o bigger-120"></i> </span></a> </li>';--%>
                <%--trHtml += '<li> <a class="tooltip-error" data-rel="tooltip"title="" href="#modal-message" role="button" onclick="onDeleteClick(';--%>
                <%--trHtml += data.subjectVoList.id;--%>
                <%--trHtml += ')" data-toggle="modal" data-original-title="删除">';--%>
                <%--trHtml += '<span class="red"> <i class="ace-icon fa fa-trash-o bigger-120"></i> </span></a> </li> </ul> </div> </div> </td>';--%>
                <%--trHtml += "</tr>";--%>
                <%--trHtml += "<tr class=\"detail-row\">";--%>
                <%--trHtml += '<td colspan="13">';--%>
                <%--trHtml += '<div class="table-detail">';--%>
                <%--trHtml += '<div class="row">';--%>
                <%--trHtml += '<div class="col-xs-12 col-sm-10">';--%>
                <%--trHtml += '<div class="space visible-xs"></div>';--%>
                <%--trHtml += '<div class="profile-user-info profile-user-info-striped">';--%>
                <%--trHtml += '<c:forEach var="scoreVo" items="${subjectVoList.get(index).scoreVoList}">';--%>
                <%--trHtml += '<div class="profile-info-row">';--%>
                <%--trHtml += '<div class="profile-info-name" style="background-color: #bce2e8;">';--%>
                <%--trHtml += '<c:out value="${scoreVo.studentName}"/>';--%>
                <%--trHtml += '</div>';--%>
                <%--trHtml += '<div class="profile-info-value">';--%>
                <%--trHtml += '<span>';--%>
                <%--trHtml += '<c:out value="${scoreVo.score}"/>';--%>
                <%--trHtml += '</span>';--%>
                <%--trHtml += '</div>';--%>
                <%--trHtml += '</div>';--%>
                <%--trHtml += '</c:forEach>';--%>
                <%--trHtml += '</div>';--%>
                <%--trHtml += '</div>';--%>
                <%--trHtml += '</div>';--%>
                <%--trHtml += '</div>';--%>
                <%--trHtml += '</td>';--%>
                <%--trHtml += "</tr>"--%>
            <%--}--%>

            <%--$('#tbody').html(trHtml);--%>

            <%--x();--%>
            <%--var pageHtml = '';--%>

            <%--if (!data.pageVo.hasPrevious){--%>
                <%--pageHtml += '<li class="prev disabled"><a>';--%>
            <%--}else{--%>
                <%--pageHtml += '<li class="prev"> <a href="javascript:void(0);" onclick="onPageClick(1)">';--%>
            <%--}--%>
            <%--pageHtml += '<i class="ace-icon fa fa-angle-double-left"></i> </a> </li>';--%>

            <%--for(var index = 1;index <= data.pageVo.pageCount;index++ ){--%>
                <%--if (data.pageVo.pageIndex === index){--%>
                    <%--pageHtml += '<li class="active">';--%>
                <%--}else{--%>
                    <%--pageHtml += '<li>';--%>
                <%--}--%>
                <%--pageHtml += '<a href="javascript:void(0);" onclick="onPageClick(';--%>
                <%--pageHtml += index;--%>
                <%--pageHtml += ')">'+index+'</a></li>';--%>
            <%--}--%>

            <%--if (!data.pageVo.hasNext){--%>
                <%--pageHtml += '<li class="next disabled"><a>';--%>
            <%--}else{--%>
                <%--pageHtml += '<li class="next"> <a href="javascript:void(0);" onclick="onPageClick('+data.pageVo.pageCount+')">';--%>
            <%--}--%>
            <%--pageHtml += '<i class="ace-icon fa fa-angle-double-right"></i> </a> </li>';--%>

            <%--$('#ul-page').html(pageHtml);--%>
        <%--}--%>

    </script>

</head>

<body class="no-skin">
<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="http://ace.jeka.by/index.html" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    客户信息管理系统
                </small>
            </a>
        </div>
    </div><!-- /.navbar-container -->
</div>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
    </script>

    <div id="sidebar" class="sidebar                  responsive                    ace-save-state" data-sidebar="true"
         data-sidebar-scroll="true" data-sidebar-hover="true">
        <script type="text/javascript">
            try {
                ace.settings.loadState('sidebar')
            } catch (e) {
            }
        </script>

        <ul class="nav nav-list" style="top: 0px;">

            <li class="active open">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 信息 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="${pageContext.request.contextPath}/student/list.do">
                            <i class="menu-icon fa fa-caret-right"></i>
                            客户信息
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${pageContext.request.contextPath}/grade/list.do">
                            <i class="menu-icon fa fa-caret-right"></i>
                            地址信息
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/subject/list.do">
                            <i class="menu-icon fa fa-caret-right"></i>
                            货物信息
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> 信息录入 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="${pageContext.request.contextPath}/student/new.do">
                            <i class="menu-icon fa fa-caret-right"></i>
                            录入客户
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${pageContext.request.contextPath}/grade/new.do">
                            <i class="menu-icon fa fa-caret-right"></i>
                            录入地址
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${pageContext.request.contextPath}/subject/new.do">
                            <i class="menu-icon fa fa-caret-right"></i>
                            录入货物
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

        </ul><!-- /.nav-list -->

        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
               data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        主页
                    </li>

                    <li>
                        信息
                    </li>
                    <li class="active">货物信息</li>
                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">

                <div class="page-header">
                    <h1>
                        信息
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            货物信息
                        </small>
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">

                                <span class="btn-group pull-left">
                                    <a href="${pageContext.request.contextPath}/subject/new.do"
                                       class="btn btn-sm btn-primary">添加</a>
                                </span>

                                <%--<div class="row">--%>
                                    <%--<div class="col-xs-6">--%>
                                        <%--<div class="dataTables_length form-inline" id="simple-table_length">--%>
                                            <%--<label>显示<select id="simple-table-select_length" name="simple-table_length" aria-controls="simple-table"--%>
                                                             <%--class="form-control input-sm"--%>
                                                             <%--onchange="onPageSizeChange()"--%>
                                                        <%-->--%>
                                                <%--<option value="30">30</option>--%>
                                                <%--<option value="60">60</option>--%>
                                                <%--<option value="90">90</option>--%>
                                            <%--</select>条--%>
                                            <%--</label>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                        <table id="simple-table" class="table table-striped table-bordered table-hover" style="width: fit-content">
                                            <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>货物名</th>
                                                <th>单价</th>
                                                <th>订货人数</th>
                                                <th>详情</th>
                                                <th>订货总数</th>
                                                <th>剩余库存</th>
                                                <th>修改/删除</th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <c:forEach var="index" begin="0"
                                                       end="${subjectVoList.size()-1}" step="1">
                                                <tr>

                                                    <td>
                                                        <c:out value="${index+1}"/>
                                                    </td>

                                                        <%--<td>--%>
                                                        <%--<c:out value="${studentListVo.studentVoList.get(index).id}"/>--%>
                                                        <%--</td>--%>

                                                    <td>
                                                        <c:out value="${subjectVoList.get(index).name}"/>
                                                    </td>

                                                    <td>
                                                        <c:out value="${subjectVoList.get(index).price}"/>
                                                    </td>

                                                    <td>
                                                        <c:out value="${subjectVoList.get(index).count}"/>
                                                    </td>

                                                    <td class="center">
                                                        <div class="action-buttons">
                                                            <a href="#" class="green bigger-140 show-details-btn"
                                                               title="Show Details">
                                                                <i class="ace-icon fa fa-angle-double-down"></i>
                                                                <span class="sr-only">Details</span>
                                                            </a>
                                                        </div>
                                                    </td>

                                                    <td>
                                                        <c:out value="${subjectVoList.get(index).totalScore}"/>
                                                    </td>

                                                    <td>
                                                        <c:out value="${subjectVoList.get(index).stock}"/>
                                                    </td>

                                                    <td>
                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                        <a class="green" href="javascript:void(0);"
                                                           onclick="onUpdateClick(${subjectVoList.get(index).id})">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                        </a>
                                                        <a class="red" href="#modal-message" role="button"
                                                           onclick="onDeleteClick(${subjectVoList.get(index).id})"
                                                           data-toggle="modal">
                                                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                        </a>
                                                    </div>
                                                    <div class="hidden-md hidden-lg">
                                                        <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle"
                                                                    data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>
                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow
                                                            dropdown-menu-right dropdown-caret dropdown-close">
                                                                <li><a href="javascript:void(0);"
                                                                       onclick="onUpdateClick(${subjectVoList.get(index).id})"
                                                                       class="tooltip-success" data-rel="tooltip" title=""
                                                                       data-original-title="修改">
                                                                    <span class="green">
                                                                        <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                    </span>
                                                                </a>
                                                                </li>
                                                                <li>
                                                                    <a class="tooltip-error" data-rel="tooltip" title=""
                                                                       href="#modal-message" role="button"
                                                                       onclick="onDeleteClick(${subjectVoList.get(index).id})"
                                                                       data-toggle="modal" data-original-title="删除">
                                                                <span class="red">
                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                </span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    </td>
                                                </tr>

                                                <tr class="detail-row">
                                                    <td colspan="13">
                                                        <div class="table-detail">
                                                            <div class="row">

                                                                <div class="col-xs-12 col-sm-10">
                                                                    <div class="space visible-xs"></div>

                                                                    <div class="profile-user-info profile-user-info-striped">

                                                                        <c:forEach var="scoreVo"
                                                                                   items="${subjectVoList.get(index).scoreVoList}">

                                                                            <div class="profile-info-row">
                                                                                <div class="profile-info-name" style="background-color: #bce2e8;">
                                                                                    <c:out value="${scoreVo.studentName}"/>
                                                                                </div>

                                                                                <div class="profile-info-value">
                                                                            <span>
                                                                                <c:out value="${scoreVo.score}"/>
                                                                            </span>
                                                                                </div>
                                                                            </div>

                                                                        </c:forEach>

                                                                    </div>

                                                                </div>

                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>

                                            </c:forEach>
                                            </tbody>
                                        </table>

                                        <div class="modal-footer no-margin-top">

                                            <ul class="pagination pull-right no-margin" id="ul-page">
                                            </ul>
                                        </div>

                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <div class="hr hr-18 dotted hr-double"></div>


                        <div id="modal-message" class="modal fade" tabindex="-1">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header no-padding">
                                        <div class="table-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                <span class="white">×</span>
                                            </button>
                                            警告
                                        </div>
                                    </div>

                                    <div class="modal-body">
                                        <h1>
                                            确定要删除货物信息吗？
                                        </h1>
                                    </div>

                                    <div class="modal-footer no-margin-top">
                                        <button class="btn btn-sm btn-danger pull-left" data-dismiss="modal">
                                            <i class="ace-icon fa fa-times"></i>
                                            取消
                                        </button>
                                        <button class="btn btn-sm btn-danger pull-right" onclick="onSureDeleteClick()">
                                            <i class="ace-icon fa fa-times"></i>
                                            确定
                                        </button>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal-dialog -->
                        </div>

                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">JZ</span>
							Application © 2018-2019
						</span>

                <%--&nbsp; &nbsp;--%>
                <%--<span class="action-buttons">--%>
							<%--<a href="http://ace.jeka.by/tables.html#">--%>
								<%--<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>--%>
							<%--</a>--%>

							<%--<a href="http://ace.jeka.by/tables.html#">--%>
								<%--<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>--%>
							<%--</a>--%>

							<%--<a href="http://ace.jeka.by/tables.html#">--%>
								<%--<i class="ace-icon fa fa-rss-square orange bigger-150"></i>--%>
							<%--</a>--%>
						<%--</span>--%>
            </div>
        </div>
    </div>

    <a href="http://ace.jeka.by/tables.html#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/assets/js/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/buttons.flash.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/buttons.colVis.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dataTables.select.min.js"></script>

<!-- ace scripts -->
<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function ($) {

        // onPageSizeChange();

        //initiate dataTables plugin
        var myTable =
            $('#dynamic-table')
            //.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
                .DataTable({
                    bAutoWidth: false,
                    "aoColumns": [
                        {"bSortable": false},
                        null, null, null, null, null,
                        {"bSortable": false}
                    ],
                    "aaSorting": [],


                    //"bProcessing": true,
                    //"bServerSide": true,
                    //"sAjaxSource": "http://127.0.0.1/table.php"	,

                    //,
                    //"sScrollY": "200px",
                    //"bPaginate": false,

                    //"sScrollX": "100%",
                    //"sScrollXInner": "120%",
                    //"bScrollCollapse": true,
                    //Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
                    //you may want to wrap the table inside a "div.dataTables_borderWrap" element

                    //"iDisplayLength": 50


                    select: {
                        style: 'multi'
                    }
                });


        $.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';

        new $.fn.dataTable.Buttons(myTable, {
            buttons: [
                {
                    "extend": "colvis",
                    "text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
                    "className": "btn btn-white btn-primary btn-bold",
                    columns: ':not(:first):not(:last)'
                },
                {
                    "extend": "copy",
                    "text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "csv",
                    "text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "excel",
                    "text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "pdf",
                    "text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "print",
                    "text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
                    "className": "btn btn-white btn-primary btn-bold",
                    autoPrint: false,
                    message: 'This print was produced using the Print button for DataTables'
                }
            ]
        });
        myTable.buttons().container().appendTo($('.tableTools-container'));

        //style the message box
        var defaultCopyAction = myTable.button(1).action();
        myTable.button(1).action(function (e, dt, button, config) {
            defaultCopyAction(e, dt, button, config);
            $('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
        });

        var defaultColvisAction = myTable.button(0).action();
        myTable.button(0).action(function (e, dt, button, config) {

            defaultColvisAction(e, dt, button, config);


            if ($('.dt-button-collection > .dropdown-menu').length == 0) {
                $('.dt-button-collection')
                    .wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
                    .find('a').attr('href', '#').wrap("<li />")
            }
            $('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
        });

        ////

        setTimeout(function () {
            $($('.tableTools-container')).find('a.dt-button').each(function () {
                var div = $(this).find(' > div').first();
                if (div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
                else $(this).tooltip({container: 'body', title: $(this).text()});
            });
        }, 500);


        myTable.on('select', function (e, dt, type, index) {
            if (type === 'row') {
                $(myTable.row(index).node()).find('input:checkbox').prop('checked', true);
            }
        });
        myTable.on('deselect', function (e, dt, type, index) {
            if (type === 'row') {
                $(myTable.row(index).node()).find('input:checkbox').prop('checked', false);
            }
        });


        /////////////////////////////////
        //table checkboxes
        $('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);

        //select/deselect all rows according to table header checkbox
        $('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function () {
            var th_checked = this.checked;//checkbox inside "TH" table header

            $('#dynamic-table').find('tbody > tr').each(function () {
                var row = this;
                if (th_checked) myTable.row(row).select();
                else  myTable.row(row).deselect();
            });
        });

        //select/deselect a row when the checkbox is checked/unchecked
        $('#dynamic-table').on('click', 'td input[type=checkbox]', function () {
            var row = $(this).closest('tr').get(0);
            if (this.checked) myTable.row(row).deselect();
            else myTable.row(row).select();
        });


        $(document).on('click', '#dynamic-table .dropdown-toggle', function (e) {
            e.stopImmediatePropagation();
            e.stopPropagation();
            e.preventDefault();
        });


        //And for the first simple table, which doesn't have TableTools or dataTables
        //select/deselect all rows according to table header checkbox
        var active_class = 'active';
        $('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function () {
            var th_checked = this.checked;//checkbox inside "TH" table header

            $(this).closest('table').find('tbody > tr').each(function () {
                var row = this;
                if (th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
                else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
            });
        });

        //select/deselect a row when the checkbox is checked/unchecked
        $('#simple-table').on('click', 'td input[type=checkbox]', function () {
            var $row = $(this).closest('tr');
            if ($row.is('.detail-row ')) return;
            if (this.checked) $row.addClass(active_class);
            else $row.removeClass(active_class);
        });


        /********************************/
        //add tooltip for small view action buttons in dropdown menu
        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        //tooltip placement on right or left
        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            //var w2 = $source.width();

            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }


        /***************/
        $('.show-details-btn').on('click', function (e) {
            e.preventDefault();
            $(this).closest('tr').next().toggleClass('open');
            $(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');
        });
        /***************/


        /**
         //add horizontal scrollbars to a simple table
         $('#simple-table').css({'width':'2000px', 'max-width': 'none'}).wrap('<div style="width: 1000px;" />').parent().ace_scroll(
         {
           horizontal: true,
           styleClass: 'scroll-top scroll-dark scroll-visible',//show the scrollbars on top(default is bottom)
           size: 2000,
           mouseWheelLock: true
         }
         ).css('padding-top', '12px');
         */


    })
</script>
<!-- Yandex.Metrika counter -->
<script type="text/javascript">
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function () {
            try {
                w.yaCounter25836836 = new Ya.Metrika({
                    id: 25836836,
                    webvisor: true,
                    clickmap: true,
                    trackLinks: true,
                    accurateTrackBounce: true
                });
            } catch (e) {
            }
        });

        var n = d.getElementsByTagName("script")[0],
            s = d.createElement("script"),
            f = function () {
                n.parentNode.insertBefore(s, n);
            };
        s.type = "text/javascript";
        s.async = true;
        s.src = (d.location.protocol == "https:" ? "https:" : "http:") + "//mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else {
            f();
        }
    })(document, window, "yandex_metrika_callbacks");
</script>
<noscript>&lt;div&gt;&lt;img src="//mc.yandex.ru/watch/25836836" style="position:absolute; left:-9999px;" alt="" /&gt;&lt;/div&gt;</noscript>
<!-- /Yandex.Metrika counter -->
<script>
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o),
            m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-38894584-2', 'auto');
    ga('send', 'pageview');

</script>


</body>
</html>