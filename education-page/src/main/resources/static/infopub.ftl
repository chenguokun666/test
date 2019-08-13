<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name='viewport'
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <title>Freemarker</title>
    <style type="text/css">
    </style>
</head>
<body>

   <center>
       <h1>课程</h1>
       <table border="1">
           <tr>
               <td>课程ID</td>
               <td>课程名称</td>
               <td>课程关注量</td>
               <td>课程类型</td>
               <td>上线时间</td>
               <td>下线时间</td>
               <td>上线状态</td>
               <td>关联id</td>
               <td>课程简介</td>
               <td>课程点击量</td>
               <td>上传课程的用户</td>
               <td>制作课程的老师</td>

           </tr>
           <#list itemList as item>
               <tr>
                   <td>${item.courseid}</td>
                   <td>${item.coursename}</td>
                   <td>${item.courseattention}</td>
                   <td>${item.coursetype}</td>
                   <td>${item.releasetime}</td>
                   <td>${item.logouttime}</td>
                   <td>${item.inonline}</td>
                   <td>${item.courselabel}</td>
                   <td>${item.coursecomment}</td>
                   <td>${item.coursehits}</td>
                   <td>${item.userid}</td>
                   <td>${item.teacherid}</td>

               </tr>
           </#list>
       </table>
   </center>
</body>
</html>