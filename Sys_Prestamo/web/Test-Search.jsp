<%-- 
    Document   : Test-Search
    Created on : 28/08/2016, 03:24:37 PM
    Author     : IgorCB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@include file="/WEB-INF/jspf/Links-Search.jspf"%>
        <title>Search</title>
  <style>
.datagrid{ width: 20%; margin-left: 5px;}html, body {font-family: Arial, sans-serif;}#form-wrapper {width: 60%;height: 40px;}.nav-list {padding: 8px 15px 5px 2px;
           position: relative;float: left; border: 1px solid #ACACAC;border-radius: 4px;
/* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#1e5799+0,2989d8+50,207cca+100,7db9e8+100,207cca+101 */
background: #1e5799; /* Old browsers */
background: -moz-linear-gradient(top,  #1e5799 0%, #2989d8 50%, #207cca 100%, #7db9e8 100%, #207cca 101%); /* FF3.6-15 */
background: -webkit-linear-gradient(top,  #1e5799 0%,#2989d8 50%,#207cca 100%,#7db9e8 100%,#207cca 101%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom,  #1e5799 0%,#2989d8 50%,#207cca 100%,#7db9e8 100%,#207cca 101%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1e5799', endColorstr='#207cca',GradientType=0 ); /* IE6-9 */
&:hover { background-color: darken(#DDD, 10%);}}

#dropdown {

  /* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#d7dee3+23,dee5e5+78 */
background: rgb(215,222,227); /* Old browsers */
background: -moz-linear-gradient(top,  rgba(215,222,227,1) 23%, rgba(222,229,229,1) 78%); /* FF3.6-15 */
background: -webkit-linear-gradient(top,  rgba(215,222,227,1) 23%,rgba(222,229,229,1) 78%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom,  rgba(215,222,227,1) 23%,rgba(222,229,229,1) 78%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#d7dee3', endColorstr='#dee5e5',GradientType=0 ); /* IE6-9 */
visibility: visible;opacity: 0;cursor: pointer;position: absolute;left: 0;top: 0; }.arrow {
border-style: solid;border-width: 4px 4px 0px; border-color: rgb(160, 160, 160) transparent transparent;border-top: 4px solid rgb(160, 160, 160);width: 0px;height: 0px;font-size: 0px;
line-height: 0;position: absolute;right: 8px;top: 14px;}
.current-selection {display: inline-block;font-size: 14px;}
.in-wrap{overflow: hidden;height: 100%;}
#search-box {width: 50%;height: 42px;border: 1px solid #ACACAC;border-left: none;border-right: none;line-height: 25px;font-size: 18px;padding-left: 10px;}.light-table-filter{width: 100%;}

  </style>
     
  
  <script type="text/javascript">
        
  $(function(){
  var $dropdown = $('#dropdown'),
      $currentSelection = $('.current-selection');
  
  // set top value of dropdown to vertically center
  $dropdown.css('top',($currentSelection.parent().outerHeight() - $dropdown.outerHeight())/2);
  
  // set the initial selection text
  $currentSelection.text( $dropdown.find('option:selected').text());
  
  // change the selection text to match dropdown selected item
  $('#dropdown').change(function(){
   $currentSelection.text(
     $(this)
     .find('option:selected')
       .text());
  });
});

     $(document).ready(function(){                          
        var consulta;                                                                    
         //hacemos focus al campo de búsqueda
        $("#busqueda").focus();
                                                                                                    
        //comprobamos si se pulsa una tecla
        $("#busqueda").keyup(function(e){
           
              //obtenemos el texto introducido en el campo de búsqueda
              consulta = $("#busqueda").val();
              //alert(consulta);                                                             
              //hace la búsqueda
            var combo = $("#dropdown").val();
             if(combo==1){
               
             $.ajax({
                    type: "POST",
                    url: "SVLE",
                    data: "busqueda="+consulta,
                    dataType: "html",
                    beforeSend: function(){
                          //imagen de carga
                          $("#resultado").html("<p align='center'><img src='/img/gif-carga.gif'> </p>");
                    },
                    error: function(){
                          alert("error petición ajax");
                    },
                    success: function(data){                                                    
                          $("#resultado").empty();
                          $("#resultado").append(data);
                                                             
                    }
              });  
              }else if (combo==2){
                     $.ajax({
                    type: "POST",
                    url: "SVLP" ,
                    data: "busqueda="+consulta,
                    dataType: "html",
                    beforeSend: function(){
                          //imagen de carga
                          $("#resultado").html("<p align='center'><img src='/img/gif-carga.gif'/></p>");
                    },
                    error: function(){
                          alert("error petición ajax");
                    },
                    success: function(data){                                                    
                          $("#resultado").empty();
                          $("#resultado").append(data);
                                                             
                    }
              });
                }
              
              //$('#thisdiv').load(document.URL +  ' #thisdiv');
        });  
        
        $("#dropdown").change(function(){
            $("#busqueda").keyup();
        });

         
    });
    
 
</script>
    </head>
    <body>
 
     
<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Buscador</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
       
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
       <div id="form-wrapper">

<span class="nav-list">
  <span class="current-selection">
  </span>
  <span class="arrow"></span>
    <select id="dropdown" class="form-control">
    <option value="1">Equipo</option>
    <option value="2">Personas</option>
    <!--<option value="3">Fecha</option>
    <option value="4">Otro</option>-->
 
  </select>
</span>
   <form>
  <div class="in-wrap">
   <input type="search" class="light-table-filter form-control" name="busqueda"  id="busqueda" onkeyup="autocompletado()" placeholder="Search">
   
  </div>
       <!--<div id="resultado" class="datagrid"></div>-->
   </form>
</div>
      </div>
 
        <div class="modal-body" id="resultado" >
           
         </div>
  
 
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
      </div>

    </div>

  </div>
</div>
 
   
   
  
    </body>
</html>
