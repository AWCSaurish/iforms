<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<script>
function onSubmit()
{ window.open('','newWin','location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,left=100,top=20,width=600,height=600'); }
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script><script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script><script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script></head>
<body>
<form style="width: 13rem ; " class="m-2 col-6" id="webAPiFormRequest" method="POST" onsubmit="onSubmit()"  action="http://10.131.24.151:8080/omnidocs/WebApiRequestRedirection" target="newWin" >
<input type="hidden" name="Application" value="Warranty1">
<input type="hidden" name="cabinetName" value="gmmco">
<input type="hidden" name="sessionIndexSet" value="false">
<input type="hidden" name="DataClassName" value="APProcess">FiscalYear<br><input type="text" class="form-control form-control-sm" name="DC.FiscalYear" value=""><br>SapDocument<br><input type="text" class="form-control form-control-sm" name="DC.SapDocument" value=""><br><input type="hidden" name="sessionIndexSet" value="false"><br><input type="hidden" name="enableDCInfo" value="true"/><input type="hidden" name="S" value="S" /><input class="btn btn-default btn-sm theme-background-color theme-background-color-6-7 theme-border-color theme-white-color1 color-white" type="submit" value=Search onclick="onSubmit();"><br></form>
</body>
</html>
